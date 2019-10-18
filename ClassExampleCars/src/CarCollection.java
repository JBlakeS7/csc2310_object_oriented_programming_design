import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import util.Execute;
import util.Command;
import util.FileIOException;
import util.ReadTextFile;
import util.StringTokens;
import util.WriteTextFile;

public class CarCollection implements Execute<Car>, CarPartAccept
{
    private ArrayList<Car> cars;
    
    public CarCollection()
    {
        cars = new ArrayList<Car>();
    }
    
    public int size()
    {
        return cars.size();
    }
    
    public void add(Car car)
    {
        if (car != null)
        {
            cars.add(car);
        }
    }
    
    public void addCarsFromFile(String file_name) throws FileIOException                                                         
    {
       ReadTextFile read_file = new ReadTextFile(file_name);
       StringTokens tokenizer = new StringTokens(",");
       String line = read_file.readLine();
       while (!read_file.EOF())
       {
           Iterator<String> tokens = tokenizer.getTokens(line);
           Car the_car = null;
           try
           {
               String make = tokens.next().trim();
               String model = tokens.next().trim();
               int year = Integer.parseInt(tokens.next().trim());
               String VIN = tokens.next().trim();
               double value = Double.parseDouble(tokens.next().trim());
               double oil_level = Double.parseDouble(tokens.next().trim());
               double radiator_level = Double.parseDouble(tokens.next().trim());
               double tire_pressure = Double.parseDouble(tokens.next().trim());
               the_car = new Car(make, model, year, VIN, value, oil_level,
                            radiator_level, tire_pressure);
               add(the_car);             
           }
           catch (NoSuchElementException | NumberFormatException | CarPartException exc)
           {
               System.err.println(exc + " when processing " + line +
                                    " in file " + file_name);
               System.err.println(the_car + " not created ");
           }
           line = read_file.readLine();           
        }
    }
    
    public void writeCarsToFile(String file_name) throws FileIOException
    {
        WriteTextFile file_writer = new WriteTextFile(file_name);
        for (Car c: cars)
        {
            file_writer.writeLine(c.toLine());
        }
        file_writer.close();
    }
    
    public void execute(Command<Car> cmd)
    {
        for (Car c : cars)
        {
            cmd.execute(c);
        }
    }
    
    public void accept(CarPartVisitor visitor)
    {
        for (Car c : cars)
        {
            c.accept(visitor);
        }
    }
}