package engine;


import logic.Logic;
import logic.Scoreboard;
import utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameEnvironment extends JPanel implements Runnable {

    Thread gameCycle;
    long targetFrames;

    Logic logic;
    Scoreboard sc;
    KeyListener keyListener;

    public GameEnvironment(int width, int height, int targetFrames, KeyListener keyListener) {
        this.targetFrames = targetFrames;
        this.keyListener = keyListener;

        // set up scoreboard
        sc = new Scoreboard(width, height, 0, 100);

        this.logic = new Logic(width, height, sc);

        // set up display
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);

        // set up game cycle thread
        gameCycle = new Thread(this);



        setVisible(true);
        gameCycle.start();
        // starting game cycle after visible to prevent the game of running without player ctrl
    }

    @Override
    public void run() {
        // render targetFrames per second
        double drawInterval = 1_000_000_000 / targetFrames;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameCycle != null) {
            repaint();

            double remainingTime = (nextDrawTime - System.nanoTime()) / 1_000_000;

            if (remainingTime < 0) {
                System.out.println("Lag Frame " + Math.sqrt(Math.pow(remainingTime, 2)) + "ms.");
                remainingTime = 0;
            }

            try {
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        logic.handleControls(keyListener.isKeyUp(), keyListener.isKeyDown(), keyListener.isArrowUp(), keyListener.isArrowDown());
        sc.drawScoreboard(g2);

        // set all components x, y or call game engine
        logic.update(g2);

        g2.dispose();
    }
}
