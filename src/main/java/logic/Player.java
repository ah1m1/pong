package logic;

public class Player {
    private int positionX;
    private int positionY;
    private int height;
    private int width;

    public Player(int positionX, int positionY) {
        this.height = 100;
        this.width = 25;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPosition(int x, int y) {
        setPositionX(x);
        setPositionY(y);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
