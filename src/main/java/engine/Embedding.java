package engine;

import utils.Config;

import javax.swing.*;

public class Embedding {
    public static void create(int size) {

        JFrame frame = new JFrame();
        frame.setSize((int) (size * Config.ASPECT_RATIO), size);
        frame.setTitle("Ping by ah1m1/pong | angelsflyinhell.dev");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GameEnvironment gameEnvironment = new GameEnvironment(frame.getWidth(), frame.getHeight(), Config.FRAMES);
        frame.add(gameEnvironment);

        frame.setVisible(true);
    }
}
