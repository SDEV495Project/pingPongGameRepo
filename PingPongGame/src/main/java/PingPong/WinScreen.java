/**
 * File: WinScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Win/Lose Screen
 */

package PingPong;

import java.awt.*;
import javax.swing.*;

public class WinScreen extends JPanel{

    private final JLabel winStatus = new JLabel("Player 1 Won!");
    private final JButton restartGame = new JButton("Restart Game");
    private final JButton returnToTitle = new JButton("Return To Title");
    private final Main main;
    
    WinScreen(Main main)
    {
        this.main = main;
        winStatus.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(winStatus);
        this.add(restartGame);
        this.add(returnToTitle);
    }
}
