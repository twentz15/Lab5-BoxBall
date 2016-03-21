import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * Write a description of class boxBall here.
 * 
 * @author Tom Wentz
 * @version 1.2 3/20/16
 */
public class boxBall
{
   private final Color color;
   private final int diameter;
   private final Canvas myCanvas;
   private final int bounceBox;
   private int xPos;
   private int yPos;
   private int speedX;
   private int speedY;
   
   Random random = new Random();
   
   
    /**
     * Constructor for the bounceing balls canvas that has more than two balls
     * and asks for the number of balls as an Int
     * @param Canvas takes the name of the canvas
     * @param bounceBox asks the user how balls they want in the box
     */
    public boxBall(Canvas myCanvas, int bounceBox)
    {
        this.myCanvas = myCanvas;
        this.bounceBox = bounceBox;
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        diameter = random.nextInt(40) + 10;
        xPos = random.nextInt(myCanvas.getSize().width);
        yPos = random.nextInt(myCanvas.getSize().width);
        speedX = random.nextInt(7) + 1;
        speedY = random.nextInt(7) + 1;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        myCanvas.setForegroundColor(color);
        myCanvas.fillCircle(xPos, yPos, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        myCanvas.eraseCircle(xPos, yPos, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     * Uses if statements to test wether or not the ball is hitting a wall or not
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        xPos += speedX;
        yPos += speedY;
        
        if(xPos <= bounceBox)//for the left wall
        {
            xPos = bounceBox;
            speedX = -speedX;
        }
        if(xPos >= myCanvas.getSize().getWidth() - bounceBox - diameter)//for the rigth wall
        {
            xPos = (int) (myCanvas.getSize().getWidth() - bounceBox - diameter);
            speedX = -speedX;
        }
        if(yPos <= bounceBox)//for the top wall
        {
            yPos = bounceBox;
            speedY = -speedY;
        }
        if(yPos >= myCanvas.getSize().getHeight() - bounceBox - diameter)
        {
            yPos = (int) (myCanvas.getSize().getHeight() - bounceBox - diameter);
            speedY = -speedY;
        }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPos;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPos;
    }
}
