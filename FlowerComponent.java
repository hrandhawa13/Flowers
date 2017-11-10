/**
 * This class would be used to draw the components which would be later on added to the frame wit the help of FlowerViewer class.
 * @author Harmanjit Randhawa
 *
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class FlowerComponent extends JComponent {
	//list contains all the flowers
   ArrayList<Flower> list = new ArrayList<Flower> ();
   //constans for different flowers
   public static final int  NUM_ROSE_PETALS = 3;
   public static final int ROSE_HEIGHT = 20;
   public static final int ROSE_WIDTH = 20;
   
   public static final int  NUM_DAISY_PETALS = 8;
   public static final int DAISY_HEIGHT = 40;
   public static final int DAISY_WIDTH = 40;
   
   public static final int  NUM_LILY_PETALS = 6;
   public static final int LILY_HEIGHT = 30;
   public static final int LILY_WIDTH = 30;
   
   public static final int MAX_TRIES = 50;
   
   public static final int MAX_WIDTH = 1320;
   public static final int MAX_HEIGHT = 745;
   public static final int MAX_FLOWER_WIDTH = 50;
   public static final int MAX_FLOWER_HEIGHT = 50;
   //instance of random to be used 
   Random rand = new Random();
   //count of flowers that are already described and drawn. helpful when resizing the frame
   private int count = 0;
   //number of flowers to be drawn 
   private int numFlowers ;
	/**
	 * This is the constructor of the class.
	 * @param n This is the number of flowers to be drawn 
	 */
   public FlowerComponent( int n ){
      numFlowers = n;
      }
   /**
    * This method is used to draw the different components onto the frame
    * @param g paramter used to draw the components
    */
   public void paintComponent( Graphics g ){
	      Graphics2D g2 = (Graphics2D) g;
	      start();
	      drawList(g2);
	   }
   /**
    * This method starts making new instances of different flowers.
    */
   public void start(){
      for ( int j = count; j < numFlowers ; j++ ){
         switch ( j%3 ){
            case 0: {
               for ( int i = 0; i< MAX_TRIES; i++){
                 if ( tryRose() ){// try MAX_TRIES times to make a flower
                     i = MAX_TRIES;
                     count++;
                  }
               }
               break;
            }
            case 1:{
               for ( int i = 0; i< MAX_TRIES; i++){
                  if ( tryDaisy() ){
                     i = MAX_TRIES;
                     count++;
                  }
               }
               break;
            }
            case 2:{
               for ( int i = 0; i< MAX_TRIES; i++){
                  if ( tryLily() ){
                     i = MAX_TRIES;
                     count ++;
                  }
               }
               break;
            }
         }
      }
   }  
   /**
    * This method tries to make an instance of rose. It generates a random x and y coordinate and then 
    * looks if there is any element present or not. It returns true if there is no element at those
    * coordinates and makes an instance of rose at that coordinate
    * @return True if it generates an instance of rose else returns false
    */
   public boolean tryRose( ){
      int xC = rand.nextInt( getWidth() - MAX_FLOWER_WIDTH );
      int yC = rand.nextInt( getHeight() - MAX_FLOWER_HEIGHT );
      if ( checkIntersection( xC, yC, ROSE_WIDTH, ROSE_HEIGHT ) == false ){//there is no existing rectangle
         makeRose( xC, yC );//make a new rose and add it to the array list
         return true;
         }
      return false;
      }
   /**
    * This method tries to make an instance of daisy. It generates a random x and y coordinate and then 
    * looks if there is any element present or not. It returns true if there is no element at those
    * coordinates and makes an instance of daisy at that coordinate
    * @return True if it generates an instance of daisy else returns false
    */ 
   public boolean tryDaisy( ){
      int xC = rand.nextInt( getWidth() - MAX_FLOWER_WIDTH );
      int yC = rand.nextInt( getHeight() - MAX_FLOWER_HEIGHT );
      if ( checkIntersection( xC, yC, DAISY_WIDTH, DAISY_HEIGHT ) == false ){//there is no existing rectangle
         makeDaisy( xC, yC );//make a new daisy and add it to the array list
         return true;
         }
      return false;
      }
   /**
    * This method tries to make an instance of lily. It generates a random x and y coordinate and then 
    * looks if there is any element present or not. It returns true if there is no element at those
    * coordinates and makes an instance of lily at that coordinate
    * @return True if it generates an instance of lily else returns false
    */
   public boolean tryLily( ){
      int xC = rand.nextInt( getWidth() - MAX_FLOWER_WIDTH );
      int yC = rand.nextInt( getHeight() - MAX_FLOWER_HEIGHT );
      if ( checkIntersection( xC, yC, LILY_WIDTH, LILY_HEIGHT ) == false ){//there is no existing rectangle
         makeLily( xC, yC );//make a new lily and add it to the arraylist
         return true;
         }
      return false;
      }
   /**
    * This method draws the flowers in the list to the frame
    * @param g2 Grahics2D used to draw onto the frame
    */
   public void drawList( Graphics2D g2){
      Flower temp ;
      for ( int i =0; i< list.size(); i++){
         temp = list.get(i);
         if ( temp.getClass().getName() == "Rose" ){
            drawRose( g2, (Rose) temp);
         }
           if ( temp.getClass().getName() == "Daisy" ){
            drawDaisy( g2, (Daisy) temp);
         }
         if ( temp.getClass().getName() == "Lily" ){
            drawLily( g2, (Lily) temp);
         }
      }
   }
   /**
    * This method would check whether there is a rectangle existing at the x,y coordiante or not.
   * It returns true if there is an intersection else returns false
    * @param x Upper left X coordinate of the rectangle
    * @param y Upper Left y coordinate of the rectangle
    * @param width Width of the rectangle
    * @param height Height of the rectangle
    * @return True if there is a rectangle at the given coordiantes else returns false
    */
   public boolean checkIntersection ( int x, int y, int width , int height ){
      Rectangle rect = new Rectangle ( x, y, width, height);
      Rectangle temp ;
      int count = 0;
      int size = list.size();
         do {//check
            if ( size == 0 )
               return false;
            temp = ( list.get(count) ).getRect();
            if ( temp.intersects( rect ) ) //that there is a rectangle already 
               return true;
            count ++;
            }
         while ( count < size );
         return false;
            
      }
   /**
    * This method makes a rose at the given x and y coordinates
    * @param x upper left X coordinate of the surrounding rectangle
    * @param y upper left Y coordinate of the surrounding rectangle
    * @return Returns the completed rose
    */
   public Rose makeRose( int x, int y ){
      //random shade of red is assigned
      Color color = new Color( genRandom(155,255), 0,0 ) ;
      Rose rose = new Rose ( NUM_ROSE_PETALS, color, x, y, ROSE_WIDTH, ROSE_HEIGHT);
      list.add(rose);
      return rose;
      }
   /**
    * This method makes a daisy at the given x and y coordinates
    * @param x upper left X coordinate of the surrounding rectangle
    * @param y upper left Y coordinate of the surrounding rectangle
    * @return Returns the completed daisy
    */
   public Daisy makeDaisy( int x, int y ){
      //basic shade is yellow
      Color color = new Color( genRandom(180, 255), genRandom(180, 250), genRandom(5,100) ) ;
      Daisy daisy = new Daisy ( NUM_DAISY_PETALS, color, x, y, DAISY_WIDTH, DAISY_HEIGHT);
      list.add( daisy );
      return daisy;
      }
   /**
    * This method makes a lily at the given x and y coordinates
    * @param x upper left X coordinate of the surrounding rectangle
    * @param y upper left Y coordinate of the surrounding rectangle
    * @return Returns the completed lily
    */
   public Lily makeLily( int x, int y ){
      //basic shade is pink
      Color color = new Color(  255, genRandom(0, 180), genRandom(170,225) ) ;
      Lily lily = new Lily ( NUM_LILY_PETALS, color, x, y, LILY_WIDTH, LILY_HEIGHT);
      list.add( lily );
      return lily;
      }
   
   /**
   *This method draws the rose onto the jframe
   *@param g2 It is used to draw the shapes onto the jframe
   *@param rose This rose is drawn onto the frame
   */
   public void drawRose( Graphics2D g2, Rose rose ){
      Color color = new Color ( rand.nextInt(255), 255, 255 );//for rose 
      g2.setColor( color );
      rose.draw(g2);//petal 1 to be drawn and then rotation is done 
       //rotation should be done around x and y 
      int x = rose.getXUpLeft() + rose.getFlowerWidth()/2 ;
      int y = rose.getYUpLeft() + rose.getFlowerHeight();
      g2.rotate(-30 * Math.PI/180.0, x, y );
      for ( int i = 0; i < NUM_ROSE_PETALS; i++){ 
         rose.draw(g2);
         g2.rotate ( 30 *  Math.PI/180.0, x, y );
      } 
      g2.rotate ( -60 *  Math.PI/180.0, x, y );//restore the rotation  
   }
      /**
   *This method draws the daisy onto the jframe
   *@param g2 It is used to draw the shapes onto the jframe
   *@param daisy This daisy is drawn onto the frame
   */
   public void drawDaisy( Graphics2D g2, Daisy daisy ){
      Color color = Color.YELLOW;//change this to random 
      g2.setColor( color );
      //rotation should be done around x and y 
      int x = daisy.getXUpLeft() + daisy.getFlowerWidth()/2 ;
      int y = daisy.getYUpLeft() + daisy.getFlowerHeight()/2;
      for ( int i = 0; i< NUM_DAISY_PETALS; i++){ 
         daisy.draw(g2);
         g2.rotate ( 45 *  Math.PI/180.0, x, y );
      } 
      g2.rotate ( -360 *  Math.PI/180.0, x, y );//restore the rotation 
   }
   /**
   *This method draws the lily onto the jframe
   *@param g2 It is used to draw the shapes onto the jframe
   *@param lily This lily is drawn onto the frame
   */
   public void drawLily( Graphics2D g2, Lily lily ){
      Color color = Color.PINK;
      g2.setColor( color );
      //rotation should be done around x and y 
      int x = lily.getXUpLeft() + lily.getFlowerWidth()/2 ;
      int y = lily.getYUpLeft() + lily.getFlowerHeight()/2;
      for ( int i = 0; i< NUM_LILY_PETALS; i++){ 
         lily.draw(g2);
         g2.rotate ( 60 *  Math.PI/180.0, x, y );
      } 
      g2.rotate ( -360 *  Math.PI/180.0, x, y );//restore the rotation 
   }
       /**
   *This method generates a random number between the given parameters
   *@param min: this is the lower limit for the random number
   *@param max: this is the higher limit for the random number
   *@return It returns a random number between given limits
   */
   public  int genRandom( int min, int max ){// returns a random int from min-max 
		Random rand = new Random();
		return rand.nextInt( max - min +1 )+ min;		
	}
}