import java.awt.*;

/**
 *  Abstract class to represent the general idea of a shape.
 */
public abstract class Shape implements Visual
{

    private int centerX;
    private int centerY;
    private int width;
    private int height;
    private Color color;

    /**
     *  Constructor to set the center of the shape, its width and height, and its color.
     */
    public Shape(int centerX, int centerY, int width, int height, Color color)
    {
       this.centerX = centerX;
       this.centerY = centerY;
       this.width = width;
       this.height = height;
       this.color = color;
    }

    /**
     *  Obtain the x coordinate of the shape center.
     */
    public int getCenterX()
    {
       return centerX;
    }

    /**
     *  Obtain the y coordinate of the shape center.
     */
    public int getCenterY()
    {
       return centerY;
    }

    /**
     *  Set the x coordinate of the shape center.  Allows for animation.
     */
    public void setCenterX(int centerX)
    {
       this.centerX = centerX;
    }

    /**
     *  Set the y coordinate of the shape center.  Allows for animation
     */
    public void setCenterY(int centerY)
    {
       this.centerY = centerY;
    }

    protected void setWidth(int width)
    {
       this.width = width;
    }

    protected void setHeight(int height)
    {
       this.height = height;
    }

    /**
     *  Obtain the width of the shape.  
     */
    public int getWidth()
    {
       return width;
    }

    /**
     *  Obtain the height of the shape.
     */
    public int getHeight()
    {
       return height;
    }

    protected void setColor(Color color)
    {
       this.color = color;
    }

    /**
     *  Obtain the color of the shape.
     */
    public Color getColor()
    {
       return color;
    }

    /**
     *  Ensure that all children of this class have the draw method.
     */
    public abstract void draw(Graphics g);

}