import gui.CenterFrame;
import gui.SimpleDialogs;
import gui.JColorLabel;
import util.FileIOException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import java.io.File;

public class CarGUIDriver extends CenterFrame
{
    private CarAddPanel pnlCarAdd;
    private CarInfoPanel pnlCarInfo;
    private CarVisitorPanel pnlCarVisitor;
    private CarCollection car_collection;
    private JTextArea txtStatus;
    private JRadioButton btnSimulate;
    private JRadioButton btnDiagnostic;
    private JRadioButton btnFix;
    private JFileChooser file_chooser;
   
    public CarGUIDriver()
    {
        super(900, 300, "Car GUI Driver");
        car_collection = new CarCollection();
        setLayout(new GridLayout(1, 2));
        pnlCarAdd = new CarAddPanel();
        add(pnlCarAdd);
        pnlCarVisitor = new CarVisitorPanel();
        add(pnlCarVisitor);
        setResizable(false);
    }

    private class CarAddPanel extends JPanel
    {
        private CarInfoPanel pnlCarInfo;
        private JButton btnAdd;
        private JButton btnAddFromFile;
        private JButton btnWriteToFile;
        
        public CarAddPanel()
        {
            setLayout(new BorderLayout());
            file_chooser = new JFileChooser("."); // start in current directory
            add(pnlCarInfo = new CarInfoPanel(), BorderLayout.CENTER);
            JPanel pnlButtons = new JPanel();
            pnlButtons.setOpaque(true);
            pnlButtons.setBackground(Color.WHITE);
            pnlButtons.add(btnAdd = new JButton("Add Car")); // used assignment operator to save a line of code
            pnlButtons.add(btnAddFromFile = new JButton("Add Car(s) from File"));
            pnlButtons.add(btnWriteToFile = new JButton("Write Car(s) to File"));
            add(pnlButtons, BorderLayout.SOUTH);
            btnAdd.addActionListener(pnlCarInfo); // registering to respond to button clicks
            btnAddFromFile.addActionListener(new AddFromFileListener());
            btnWriteToFile.addActionListener(new WriteToFileListener());
        }
    }
    
    private class AddFromFileListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            // txtStatus.append("Entering AddFromFileListener actionPerformed.\n");
            int result = file_chooser.showOpenDialog(CarGUIDriver.this); // current instance of the outer class
            int size_before = car_collection.size();
            String file_name = "";
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = file_chooser.getSelectedFile();
                file_name = file.getAbsolutePath(); // in case directory has been changed
                try
                {
                    car_collection.addCarsFromFile(file_name);
                }
                catch (FileIOException fioe)
                {
                    txtStatus.append(fioe.getMessage() + ": " + file_name + "\n");
                }
            }
            else
            {
                txtStatus.append("File open cancelled.\n");
                return;
            }
            int size_after = car_collection.size();
            int diff = size_after - size_before;
            if (diff > 0)
            {
                txtStatus.append(diff + " car(s) added from file " + file_name + ".\n");
            }
            else
            {
                txtStatus.append("No cars added from file " + file_name + ".\n");
            }
            // txtStatus.append("Leaving AddFromFileListener actionPerformed.\n");
        }
    }
    
    private class WriteToFileListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
//            txtStatus.append("Entering WriteToFileListener actionPerformed.\n");
            int result = file_chooser.showSaveDialog(CarGUIDriver.this);
            String file_name = "";
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = file_chooser.getSelectedFile();
                file_name = file.getAbsolutePath();
                try
                {
                    int size = car_collection.size();
                    car_collection.writeCarsToFile(file_name);
                    if (size > 0)
                    {
                        txtStatus.append(size + " car(s) written to file " + file_name + ".\n");
                    }
                    else
                    {
                        txtStatus.append("No cars written to file " + file_name + ".\n");
                    }
                }
                catch (FileIOException fioe)
                {
                    txtStatus.append(fioe.getMessage() + ": " + file_name);
                }
            }
            else
            {
                txtStatus.append("File save cancelled.\n");
                return;
            }
            
// txtStatus.append("Leaving WriteToFileListener actionPerformed.\n");
        }
    }
    
    private class CarInfoPanel extends JPanel implements ActionListener
    {
        private JTextField txtMake;
        private JTextField txtModel;
        private JTextField txtYear;
        private JTextField txtVIN;
        private JTextField txtValue;
        private JTextField txtOilLevel;
        private JTextField txtRadiatorLevel;
        private JTextField txtTirePressure;
        
        public CarInfoPanel()
        {
            setLayout(new GridLayout(8, 2));
            add(new JColorLabel("Make"));
            add(txtMake = new JTextField());
            add(new JColorLabel("Model"));
            add(txtModel = new JTextField());
            add(new JColorLabel("Year"));
            add(txtYear = new JTextField());
            add(new JColorLabel("VIN"));
            add(txtVIN = new JTextField());
            add(new JColorLabel("Value"));
            add(txtValue = new JTextField());
            add(new JColorLabel("Oil Level"));
            add(txtOilLevel = new JTextField());
            add(new JColorLabel("Radiator Level"));
            add(txtRadiatorLevel = new JTextField());
            add(new JColorLabel("Tire Pressure"));
            add(txtTirePressure = new JTextField());
        }
        
        public void clearAllTextFields()
        {
            txtMake.setText("");
            txtModel.setText("");
            txtYear.setText("");
            txtVIN.setText("");
            txtValue.setText("");
            txtOilLevel.setText("");
            txtRadiatorLevel.setText("");
            txtTirePressure.setText("");
        }
        
        public void actionPerformed(ActionEvent ae)
        {
//            System.out.println("Car add event handler starting.");
            String make = txtMake.getText();
            String model = txtModel.getText();
            int year = 0;
            try
            {
                year = Integer.parseInt(txtYear.getText());
            }
            catch (NumberFormatException nfe)
            {
                SimpleDialogs.normalOutput("Year must be an integer.", "Invalid Year Entry");
                txtYear.setText("");
                return;
            }
            String VIN = txtVIN.getText();
            double value = -1;
            try
            {
                value = Double.parseDouble(txtValue.getText());
            }
            catch (NumberFormatException nfe)
            {
                SimpleDialogs.normalOutput("Value must be a double.", "Invalid Value Entry");
                return;
            }
            double oil = -1;
            try
            {
                oil = Double.parseDouble(txtOilLevel.getText());
            }
            catch (NumberFormatException nfe)
            {
                SimpleDialogs.normalOutput("Oil Level must be a double.", "Invalid Oil Level Entry");
                return;
            }
            double radiator = -1;
            try
            {
                radiator = Double.parseDouble(txtRadiatorLevel.getText());
            }
            catch (NumberFormatException nfe)
            {
                SimpleDialogs.normalOutput("Radiator Level must be a double.", "Invalid Radiator Level Entry");
                return;
            }
            double tire_pressure = 0;
            try
            {
                tire_pressure = Double.parseDouble(txtTirePressure.getText());
            }
            catch (NumberFormatException nfe)
            {
                SimpleDialogs.normalOutput("Tire Pressure must be an integer.", "Invalid Tire Pressure Entry");
                return;
            }
            try
            {
                Car car = new Car(make, model, year, VIN, value, oil, radiator, tire_pressure);
                car_collection.add(car);
                txtStatus.setEditable(true);
                txtStatus.append("\nAdded car\n" + car + "\n");
                txtStatus.setEditable(false);
            }
            catch (CarPartException cpe)
            {
                SimpleDialogs.normalOutput(cpe.getMessage(), "Invalid Car Feature");
                return;
            }
            clearAllTextFields();
  //          System.out.println("Car Add event handler ending.");
        }
    }
    
    private class CarVisitorPanel extends JPanel
    {
        /* private JTextArea txtStatus; */ // moved to outer class so other event handlers can access
        private JButton btnVisit;
        /* private JRadioButton btnSimulate;
        private JRadioButton btnDiagnostic;
        private JRadioButton btnFix; */
        private ButtonGroup btnGroup;
        private JButton btnClear;
        
        public CarVisitorPanel()
        {
            setLayout(new BorderLayout());
            JScrollPane scroller = new JScrollPane(txtStatus = new JTextArea());
            add(scroller, BorderLayout.CENTER);
            txtStatus.setEditable(false);
            JPanel pnlButtons = new JPanel(); // default layout manager is FlowLayout
            pnlButtons.setOpaque(true);
            pnlButtons.setBackground(Color.WHITE);
            pnlButtons.add(btnVisit = new JButton("Visit"));
            btnSimulate = new JRadioButton("Simulate Car Trouble");
            btnDiagnostic = new JRadioButton("Diagnose Cars");
            btnFix = new JRadioButton("Fix Cars");
            btnDiagnostic.setSelected(true);
            btnGroup = new ButtonGroup();
            btnGroup.add(btnSimulate);
            btnGroup.add(btnDiagnostic);
            btnGroup.add(btnFix);
            pnlButtons.add(btnSimulate);
            pnlButtons.add(btnDiagnostic);
            pnlButtons.add(btnFix);
            pnlButtons.add(btnClear = new JButton("Clear"));
            btnClear.addActionListener(new ClearListener());
            btnVisit.addActionListener(new VisitListener());
            add(pnlButtons, BorderLayout.SOUTH);
        }            
    }
    
    private class ClearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            txtStatus.setText("");
        }
    }
    
    private class VisitListener implements ActionListener
    {
        private SimulateCarTroubleVisitor trouble;
        private CarDiagnosticVisitor checkup;
        private CarFixVisitor fix;
        
        public VisitListener()
        {
            trouble = new SimulateCarTroubleVisitor();
            checkup = new CarDiagnosticVisitor(20);
            fix = new CarFixVisitor();
        }
       
        public void actionPerformed(ActionEvent ae)
        {
            // System.out.println("Visit event handler starting.");
            CarPartVisitorWithReport visitor;
            if (btnDiagnostic.isSelected())
            {
                visitor = checkup;
            }
            else if (btnSimulate.isSelected())
            {
                visitor = trouble;
            }
            else
            {
                visitor = fix;
            }
            car_collection.accept(visitor);
            txtStatus.setEditable(true);
            txtStatus.append("\n" + visitor.getReport());
            txtStatus.setEditable(false);
            visitor.resetReport();            
            // System.out.println("Visit event handler ending.");
        }
    }
    
    public static void main(String[] args)
    {
        CarGUIDriver gui = new CarGUIDriver();
        gui.setVisible(true);
    }
}