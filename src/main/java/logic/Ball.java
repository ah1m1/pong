package logic;

import utils.Config;

import java.util.Random;

public class Ball {
    private int positionX;
    private int positionY;
    private int velocity;
    private int size;
    private int[] flightDirection = new int[2];

    // update:
    //x += flightDirection[0]
    //y += flightDirection[1]

    public Ball(int positionX, int positionY, int velocity) {
        this.size = 26;
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocity = velocity;
        this.flightDirection = new int[]{-1, 1};
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int[] getFlightDirection() {
        return flightDirection;
    }

    public void setFlightDirection(int number, int i) {
        this.flightDirection[i] = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void reset() {
        this.positionX = (int) (Config.RESOLUTION * Config.ASPECT_RATIO) / 2;
        this.positionY = Config.RESOLUTION / 2;
        this.velocity = 2;
        
        for (int i = 0; i < flightDirection.length; i++) {
            int n = new Random().nextInt( 2);
            flightDirection[i] = (n == 0) ? -1 : n;
        }
    }
}
