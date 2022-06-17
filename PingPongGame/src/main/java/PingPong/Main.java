/**
 * File: Main.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 17, 2022
 * Purpose: Main program
 */

package PingPong;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main{
    
    //fields
    private final JFrame window;
    private final GameScreen gameScreen = new GameScreen();
    private final TitleScreen titleScreen = new TitleScreen(this);
    private final WinScreen winScreen = new WinScreen(this);
    private final PauseScreen pauseScreen = new PauseScreen(this);
    private final int WIDTH = 300;
    private final int HEIGHT = 200;
    
    //constructor
    Main()
    {
        window = new JFrame("Ping Pong Game");
        setFrame(WIDTH, HEIGHT); 
        window.setContentPane(titleScreen);
    }
    
    //frame methods
    private void setFrame(int width, int height) {
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void display()
    {
        window.setVisible(true);
    }
    
    public void switchScreen(ScreenEnum panelEnum)
    {
        JPanel panel;
        switch(panelEnum)
        {
            case TITLE:
                panel = titleScreen;
                break;
            case GAME:
                panel = gameScreen;
                break;
            case PAUSE:
                panel = pauseScreen;
                break;
            case WIN:
                panel = winScreen;
                break;
            default:
                panel = titleScreen;
                break;
        }
        window.setContentPane(panel);
        window.repaint();
        window.revalidate();
    }

    //main method
    public static void main(String[] args) {
        Main game = new Main();
        game.display();
    }
}
