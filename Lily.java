import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * This is the subclass for Flower class. It will be used to declare the specific type of a flower.
 * @author Harmanjit Randhawa
 *
 */
public class Lily extends Flower{
	   // the upper left hand corner of the bounding box of the flower
		private int upperX;
		private int upperY;
	   
	   // the color of the flower
	   private Color color;
	   
	   // current height and width of the flower's enclosing rectangle
	   private int height;
	   private int width;

	   // the number of petals of the flower
	   private int petals;
	   
	   // you may change the default values and the default value structure
	   /*
	   * The default value for the width and height of the flower's enclosing 
	   * rectangle: used only in the default constructor
	   */
	   public static final int DEFAULT_FLOWER_SIDE = 50;

	   /*
	   * The default color of the flower.
	   */
	   public static final Color DEFAULT_COLOR = Color.PINK;
	   
	   public Lily(){
		  super();
	      petals = 0;
	      upperX = 0;
	      upperY = 0;
	      color = DEFAULT_COLOR;
	      width = DEFAULT_FLOWER_SIDE;
	      height = DEFAULT_FLOWER_SIDE;
	   }
	   /**
	   * Sets the flower's bounding rectangle to be of dimensions w times h with
	   * (x,y) as upper left hand corner and the flower's colour to c.  
	   * @param n the number of petals
	   * @param c the colour of the flower
	   * @param x the x-coordinate of the enclosing rectangle's upper left hand corner
	   * @param y the y-coordinate of the enclosing rectangle's upper left hand corner 
	   * @param w the width of the enclosing rectangle
	   * @param h the height of the enclosing rectangle
	   */
	   public Lily(int n, Color c, int x, int y, int w, int h){
		  super( n, c, x, y, w, h );
	      petals = n;
	      color = c;
	      upperX = x;
	      upperY = y;
	      width = w;
	      height = h;
	   }
	   /**
	    * Draws the Rose onto the graphics context using the 
	    * currently set colour and position of the enclosing rectangle.
	    * @param g2 the graphics context
	    */
	    public void draw(Graphics2D g2){
	    	//this method will draw the rose onto the frame
	    	g2.setColor(color);
          //ellipse is each petal of this flower
         int widthEllipse = width/5;
         int heightEllipse = height/2; 
         int x = upperX+ width/2 - widthEllipse/2 ;//get the centre of the rectangle - width of ellipse 
         Ellipse2D.Double ellipse = new Ellipse2D.Double( x ,upperY, widthEllipse, heightEllipse );   
         g2.fill(ellipse);       	    	
	    }
	   
}
