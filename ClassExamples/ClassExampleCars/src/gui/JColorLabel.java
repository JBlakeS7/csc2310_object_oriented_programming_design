package gui;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;

public class JColorLabel extends JLabel
{
    public JColorLabel(String text)
    {
        this(Color.WHITE, text);
    }
    
    public JColorLabel(Color c)
    {
        super();
        setup(c);
    }
    
    public JColorLabel(Color c, Icon image)
    {
        super(image);
        setup(c);
    }
    
    public JColorLabel(Color c, Icon image, int horizontalAlignment)
    {
        super(image, horizontalAlignment);
        setup(c);
    }
    
    public JColorLabel(Color c, String text)
    {
        super(text);
        setup(c);
    }
    
    public JColorLabel(Color c, String text, int horizontalAlignment)
    {
        super(text, horizontalAlignment);
        setup(c);
    }
    
    public JColorLabel(Color c, String text, Icon image, int horizontalAlignment)
    {
        super(text, image, horizontalAlignment);
        setup(c);
    }
    
    private void setup(Color c)
    {
        setOpaque(true);
        setBackground(c);
    }
}