package org.example.game;

import javax.swing.JFrame;

public class GameWindow {
    private final JFrame jFrame;

    public GameWindow(GamePanel gamePanel){
        jFrame = new JFrame();
        jFrame.add(gamePanel);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null); // center the window
        jFrame.setResizable(false);
        jFrame.pack(); // resize the window to fit the content
        jFrame.setVisible(true);

    }

}
