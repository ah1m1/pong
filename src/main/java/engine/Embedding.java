package engine;

import utils.Config;

import javax.swing.*;
import java.awt.*;

public class Embedding {
    public static void create(int size) {
        JFrame frame = new JFrame();
        frame.setTitle("Ping by ah1m1/pong | angelsflyinhell.dev");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameEnvironment gameEnvironment = new GameEnvironment((int) (size * Config.ASPECT_RATIO), size, Config.FRAMES);
        frame.add(gameEnvironment);

        frame.pack();
        frame.setVisible(true);
    }
}
