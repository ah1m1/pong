package engine;

import utils.Config;

import javax.swing.*;
import java.awt.*;

public class Embedding {
    public static void create(int size) {

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(size, size));
        frame.setTitle("Ping by ah1m1/pong | angelsflyinhell.dev");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GameEnvironment gameEnvironment = new GameEnvironment(frame.getWidth(), frame.getHeight(), Config.FRAMES);

        JPanel panel = new JPanel();
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.GRAY);
        frame.add(gameEnvironment);
        frame.add(panel);
        frame.setVisible(true);
    }
}
