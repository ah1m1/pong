package engine;

import javax.swing.*;
import java.awt.*;

public class GameEnvironment extends JPanel implements Runnable {

    Thread gameCycle;
    int resolution;
    long targetFrames;

    public GameEnvironment(int resolution, int targetFrames) {
        this.targetFrames = targetFrames;

        // set up display
        setSize(resolution, resolution);
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

        // set all components x, y

        g2.dispose();
    }
}
