package logic;

public class Ball {
    private int positionX;
    private int positionY;
    private float velocity;

    public Ball(int positionX, int positionY, float velocity) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocity = velocity;
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

    public float getVelocity() {
        return velocity;
    }
}
