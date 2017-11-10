import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
 /**
  * This class represents a flower with a certain number of petals. 
  * A flower has a position corresponding to the upper left hand corner 
  * of the enclosing rectangle: it has a width and a height, and it has a color. 
  * The width and the height are of the  enclosing rectangle (bounding box) 
  * anchored by its upper left hand  corner. 
  * @author Gladys Monagan
  * @version October 19, 2017
  */
public abstract class Flower{
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
   public static final Color DEFAULT_COLOR = Color.RED;
   
   /*
   * The bounding rectangle for flower 
   */
   Rectangle rect ;
   /**
   * Sets the flower's bounding rectangle's sides to the
   * <code><a href="Flower.html#DEFAULT_FLOWER_SIDE">DEFAULT_FLOWER_SIDE</a></code>,
   * the flowers'color to 
   * <code><a href="Flower.html#DEFAULT_COLOR">DEFAULT_COLOR</a></code>,
   * and the upper left hand corner of the bounding rectangle to the origin.
   */
   public Flower()
   {
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
   public Flower(int n, Color c, int x, int y, int w, int h)
   {
      petals = n;
      color = c;
      upperX = x;
      upperY = y;
      width = w;
      height = h;
      rect = new Rectangle ( upperX, upperY, width, height);
   }
   /**
   * This method returns the rectangle that bounds the flower.
   *@return Returns the bounding rectangle for flower
   */
   public Rectangle getRect(){
      return rect;
      }
   /**
   * Draws the flower onto the graphics context using the 
   * currently set colour and position of the enclosing rectangle.
   * @param g2 the graphics context
   */
   public abstract void draw(Graphics2D g2);

   /**
   * Sets the position of the flower by setting the upper left hand corner 
   * of the bounding box of the flower to be the point (x,y).
   * @param x This is the upper left x-coordinate of the rectangle 
   * @param y This is the upper left y-coordinate of the rectangle
   */
   public void setPosition( int x, int y){
	   upperX = x;
	   upperY = y;
   }
   
   /**
   * This returns the upper left x-coordiante of the rectangle surrounding flower  
   * @return the x coordinate of the enclosing rectangle's upper left hand corner
   */
   public int getXUpLeft(){
     return upperX;
   }
   
   /**
   * This returns the upper left x-coordiante of the rectangle surrounding flower 
   * @return the y coordinate of the enclosing rectangle's upper left hand corner
   */
   public int getYUpLeft(){
      return upperY;
   }  
   /**
   * This returns the width of the rectangle surrounding flower 
   * @return the width of the bounding box of the flower.
   */
   public int getFlowerWidth(){
      return width;
   }

   /**
   * This returns the height of the rectangle surrounding flower 
   * @return the height of the bounding box of the flower.
   */
   public int getFlowerHeight(){
      return height;
   }

   /**
   * Sets the colour of the flower.
   * @param c a specified Color
   */
   public void setColor(Color c){
        color = c;
   }
   
   /**
   * This returns the colour of the flower 
   * @return the colour of the flower.
   */
   public Color getColor(){
      return color;
   }
   
   /**
   * @return the string consisting of the upper left hand corner of the 
   * enclosing rectangle, its color, and the dimensions of the enclosing rectangle
   */
   @ Override
   public String toString(){
      String str = getClass().getName();
      str += "\n upper left hand corner( " + upperX + "," + upperY + ")";
      str += "\n color = " + color;
      str += "\n height = " + height;
      str += "\n width = " + width;
      str += "\n petals = " + petals;
      return str;
   }
   /**
   *This method returns the number of petals of the flower
   *@return number of petals
   *
   */
   public int getPetals(){
      return petals;
      }
   /**
   * Determines if two flowers are equal.
   * @return true if obj is equal to this object based on the flower's number of petals,
   * its position (the position is defined by the upper left hand corner of the 
   * enclosing rectangle), the dimensions of the enclosing rectangle, 
   * and by the flower's color
   */
   @Override 
   public boolean equals(Object obj){
      if ( obj == null )//object passed is null 
    	  return false;
      if ( getClass().getName() != obj.getClass().getName() ) //they are not of the same class
    	  return false;
      //now we know that object is not null and its of the same class
      //so now we can compare these 2 objects based on their instance variables
      Flower temp = ( Flower ) obj;
      return ( ( petals == temp.petals ) && ( upperX == temp.upperX ) && ( upperY == temp.upperY ) &&
    		   ( height == temp.height ) && ( width == temp.width ) && ( color.equals(temp.color)) 
    		  );
    		 
      
   }
  
}
