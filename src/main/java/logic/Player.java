package logic;

public class Player {
    private int positionX;
    private int positionY;
    private int height;
    private int width;

    public Player(int positionX, int positionY) {
        this.height = 100;
        this.width = 10;
        this.positionX = positionX;
        this.positionY = positionY;
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

}
