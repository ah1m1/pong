package logic;

public class Scoreboard {
    private int positionX;
    private int positionY;
    private int[] points;
    private int fontsize;

    public Scoreboard(int positionX, int positionY, int[] points) {
        this.fontsize = 0;
        this.positionX = positionX;
        this.positionY = positionY;
        this.points = points;
    }
}
