package org.example.game;

import input.Input;

import javax.swing.*;
import java.awt.*;


import static org.example.game.GameConstants.GAME_HEIGHT;
import static org.example.game.GameConstants.GAME_WIDTH;


public class GamePanel extends JPanel {

    private final Game game;

    public GamePanel(Game game) {
        super();
        this.game = game;
        this.setFocusable(true);


        addKeyListener(Input.getInstance());
        setPanelSize();
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(dimension);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        game.render(g);


    }



    public Game getGame() {
        return game;
    }
}
