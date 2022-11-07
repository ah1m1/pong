package engine;

import javax.swing.*;

public class Embedding {
    public static void create(int size) {

        JFrame frame = new JFrame();
        frame.setSize((int) (size * 1.77777777778), size);
        frame.setTitle("Ping by ah1m1/pong | angelsflyinhell.dev");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // add objects here

        frame.setVisible(true);
    }
}
