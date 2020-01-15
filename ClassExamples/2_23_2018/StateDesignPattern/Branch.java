import java.awt.Color;
import java.awt.Graphics;
import matrix.*;

public class Branch extends Trunk
{

   private double degrees;  //the rotation (about the end) of the rectangle

   public Branch(int centerX, int baseY, int width, int height, int degrees)
   {
      super(centerX, baseY, width, height);
      this.degrees = degrees;
   }

   public void draw(Graphics g)
   {
      int[] x = new int[4];
      int[] y = new int[4];

      double cos = Math.cos(degrees*3.14/180);
      double sin = Math.sin(degrees*3.14/180);

      int centerX = getCenterX();
      int centerY = getCenterY();
      int width = getWidth();
      int height = getHeight();
      int baseY = centerY + height/2;

      //the coordinates of the four corners of the branch
      x[0] = centerX - width/2;
      y[0] = baseY;
      x[1] = centerX - width/2;
      y[1] = baseY - height;
      x[2] = centerX + width/2;
      y[2] = baseY - height;
      x[3] = centerX + width/2;
      y[3] = baseY;

      //need to translate, rotate, and translate back
      Vertex vertex1 = new Vertex(x[0], y[0], 0);
      Vertex vertex2 = new Vertex(x[1], y[1], 0);
      Vertex vertex3 = new Vertex(x[2], y[2], 0);
      Vertex vertex4 = new Vertex(x[3], y[3], 0);

      MatrixOperationsInterface translate = AffineTransforms.translate(-1*centerX, -1*centerY - height/2, 0);  //translate to the origin
      MatrixOperationsInterface rotate = AffineTransforms.rotateZ(degrees);
      MatrixOperationsInterface translate2 = AffineTransforms.translate(centerX, centerY + height/2, 0);  //translate back

      MatrixOperationsInterface transform = rotate.multiply(translate);
      transform = translate2.multiply(transform);
      vertex1 = vertex1.multiply(transform);
      vertex2 = vertex2.multiply(transform);
      vertex3 = vertex3.multiply(transform);
      vertex4 = vertex4.multiply(transform);

      //the transformed coordinates
      x[0] = (int) vertex1.getX();
      y[0] = (int) vertex1.getY();
      x[1] = (int) vertex2.getX();
      y[1] = (int) vertex2.getY();
      x[2] = (int) vertex3.getX();
      y[2] = (int) vertex3.getY();
      x[3] = (int) vertex4.getX();
      y[3] = (int) vertex4.getY();

      g.setColor(getColor());
      g.fillPolygon(x, y, 4);
   }

}

