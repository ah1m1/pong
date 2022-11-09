package logic;

import java.awt.*;

public class Scoreboard {
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private int[] points;
    private int fontsize;

    public Scoreboard(int width, int height, int positionX, int positionY) {
        this.fontsize = 25;
        this.positionX = positionX;
        this.positionY = positionY;
        this.points = new int[]{0, 0};
        this.width = width;
        this.height = height;
    }

    public void drawScoreboard(Graphics2D g2) {
        g2.setFont(new Font("Consolas", Font.BOLD, 128));

        String scInfo = points[0] + ":" + points[1];
        g2.drawString(scInfo, ((width / 2) - (scInfo.length() * 70 / 2)), positionY);
    }

    public void addPoint(int player) {
        points[player - 1]++;
    }
}
