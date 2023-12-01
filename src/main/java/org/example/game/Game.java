package org.example.game;
// https://stackoverflow.com/questions/3180077/communication-in-component-based-game-engine
import entities.EntityFactory;
import entities.EntityPool;
import renderer.Renderer;
import entities.player.Player;
import tilemap.TileMap;

import java.awt.*;

import static org.example.game.GameConstants.FPS_SET;

public class Game implements Runnable {
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private Thread gameThread;

    private TileMap tileMap;


    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLooping();
        tileMap = new TileMap();
        Player player = EntityFactory.createEntity(EntityFactory.EntityType.PLAYER);


    }

    private void initClasses() {
    }

    public void startGameLooping() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerTick = 1000000000 / FPS_SET; // 1 second = 1_000_000_000 nanoseconds

        while (true) {
            long startTime = System.nanoTime();
            update();
            gamePanel.repaint();
            Time.update();




//
//            try {
//                Thread.sleep(16);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            long endTime = System.nanoTime();
            long sleepTime = (long) (timePerTick - (endTime - startTime)) / 1_000_000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void update() {
        EntityPool.update();
    }

    public void render(Graphics g) {
        Renderer.render(g);


    }
}
