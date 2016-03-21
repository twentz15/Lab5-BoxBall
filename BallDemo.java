import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int BOUNDRY = 10;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    /**
     * The drawCanvas method draws the rectangle box that makes the the balls bounce around a select area
     * the box acts as the boundry
     */
    private void drawCanvas(Canvas canvas) 
    {  
        // get the height and width of the canvas  
        Double height = canvas.getSize().getHeight();  
        Double width = canvas.getSize().getWidth();  
        canvas.setVisible(true);  
        // draw the rectangle using four lines and using the size of the canvas and the BOUNDRY to figure out where to draw the lines  
        canvas.drawLine(BOUNDRY, height.intValue() - BOUNDRY, width.intValue() - BOUNDRY, height.intValue() - BOUNDRY);  
        canvas.drawLine(BOUNDRY, BOUNDRY, width.intValue() - BOUNDRY, BOUNDRY);  
        canvas.drawLine(BOUNDRY, BOUNDRY, BOUNDRY, height.intValue() - BOUNDRY);  
        canvas.drawLine(width.intValue() - BOUNDRY, BOUNDRY, width.intValue() - BOUNDRY, height.intValue() - BOUNDRY);  
    }  
    /**
     * Bounce makes the two balls and makes them "bounce" across the ground
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
   
    /**  
     * Draw a rectangle on the canvas and moves the balls inside of it  
     *  
     * @param numberOfBalls parameter used to determine number of balls  
     *  
     */  
    public void boxBounce(int numberOfBalls) 
    {    
        if (numberOfBalls < 0) 
        {  
            System.out.println("You must enter a Positive Number");  
            return;  
        } 
        int deezBalls = numberOfBalls - 1;
        int x = 0;  
        ArrayList<boxBall> balls = new ArrayList<>();  
        drawCanvas(myCanvas);  
   
        //add balls to an arraylist based on numberOfBalls parameter  
        for (int i = 0; i <= deezBalls; i++) 
        {  
            balls.add(new boxBall(myCanvas, BOUNDRY));  
        }  
   
        //draw balls from the arraylist 
        for (boxBall ball : balls) 
        {  
        ball.draw();  
        }  
   
          
        while (x <= 100) //sets the timer for how long the balls are going to be moving
        {  
            myCanvas.wait(50); // small delay  
            for (boxBall ball : balls) 
            {  
                ball.move();  
            }  
            x++;  
        }
    }
}
