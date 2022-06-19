/**
 * File: GameScreen.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Game Screen panel and draws graphics
 */

package PingPong;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GameScreen extends JPanel{
    
    // Fields
    private final double LEFT = -100;
    private final double RIGHT = 100;
    private final double BOTTOM = -100;
    private final double TOP = 100;
    
    static int translateX = 0;
    static int translateY = 0;
    
    // Draws graphics for GameScreen class
    @Override
    protected void paintComponent(Graphics g) {
        // Graphics context
        Graphics2D g2 = (Graphics2D) g.create();

        // Turn on antialiasing in this graphics context.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill background with black.
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        // Maintains window ratio
        windowToViewportTransformation(g2);
        // Transform identity
        AffineTransform savedTransform = g2.getTransform();
        
        // Draw graphics here and on
        // Set object color
        g2.setPaint(Color.white);
        
        // Draw boundary line
        drawBoundaryLine(g2);
        g2.setTransform(savedTransform);
        
        // Draw Paddle1
        g2.translate(-75, 0);
        drawPaddle(g2);
        g2.setTransform(savedTransform);
        
        // Draw Paddle2
        g2.translate(75, 0);
        drawPaddle(g2);
        g2.setTransform(savedTransform);
        
        // Draw PingPong ball
        g2.translate(0, 0);
        drawPingPong(g2);
        g2.setTransform(savedTransform);
    }//end method
    
    // Draws dotted line
    private void drawBoundaryLine(Graphics2D g2)
    {
        float dash[] = {10.0f};
        BasicStroke dashed = new BasicStroke(5.0f, 
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 
                10.0f, dash, 0.0f);
        g2.setStroke(dashed);
        g2.drawLine(0, -95, 0, 100);
    }
    
    // Draws paddle
    private void drawPaddle(Graphics2D g2)
    {
        //change x,y to Transform variables
        g2.fillRect(-10, -20, 20, 40);
    }
    
    //Draws PingPong
    private void drawPingPong(Graphics2D g2)
    {
        //change x,y to Transform variables
        g2.fillOval(0, 0, 15, 15);
    }
    
    // Transforms window's dimensions to viewport
    private void windowToViewportTransformation(Graphics2D g2) {
        // Pixel width/height of drawing area
        int width = getWidth(); int height = getHeight(); 

        g2.scale(width / (RIGHT - LEFT), height / (BOTTOM - TOP));
        g2.translate(-LEFT, -TOP);
    }
    
}//end class
