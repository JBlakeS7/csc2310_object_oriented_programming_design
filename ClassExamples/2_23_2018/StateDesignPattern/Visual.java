import java.awt.Graphics;

//Composite design pattern
//allows individual objects and collections of objects to be treated identically
//for example, the tree class has many subcomponents, 
//but the tree class simply calls the draw method each of its subcomponents
//further, a forest is a collection of trees
//in fact, anything that has a visual representation can make use of this interface

/**
 *  Objects that implement this interface can be displayed visually.
 */
public interface Visual
{

    /**
     *  The method that creates the visual representation of an object.
     */
    public void draw(Graphics g);

}