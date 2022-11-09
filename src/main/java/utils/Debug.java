package utils;

import java.awt.*;

public class Debug {
    public static void debugCoords(Graphics2D g2, int width, int height) {
        for (int x = 0; x < width; x += 50) {
            for (int y = 0; y < height; y += 50) {
                g2.drawString(x + ", " + y, x, y);
            }
        }

        for (int x = 0; x < width; x += 50) {
            for (int y = 0; y < height; y += 50) {
                g2.setColor(Color.RED);
                g2.fillRect(x, 0, 2, 720);
                g2.setColor(Color.GREEN);
                g2.fillRect(0, y, 720, 2);
            }
        }
    }
}
