package logic;

import utils.Config;

import java.awt.*;

public class Logic {
    private int height;
    private int width;
    private Ball ball;
    private Player player1;
    private Player player2;
    private Scoreboard sb;

    private int movement;
    private boolean up = false;

    public Logic(int resolution) {
        this.height = resolution;
        this.width = (int) (resolution * Config.ASPECT_RATIO);
        this.ball = new Ball(width/2, height/2, 5);
        this.movement = 0;
    }

    public void update(Graphics2D g2) {
        g2.setColor(Color.WHITE);

        ball.setPositionX(ball.getPositionX() - ball.getFlightDirection()[0] * ball.getVelocity());
        ball.setPositionY(ball.getPositionY() - ball.getFlightDirection()[1] * ball.getVelocity());

        if(ball.getPositionX() == 0 || ball.getPositionX() + ball.getSize() >= width) {
            ball.setFlightDirection(ball.getFlightDirection()[0] * (-1), 0);
        }
        if(ball.getPositionY() == 0 || ball.getPositionY() + ball.getSize() >= height) {
            ball.setFlightDirection(ball.getFlightDirection()[1] * (-1), 1);
        }


        g2.fillRect(ball.getPositionX(), ball.getPositionY(), ball.getSize(), ball.getSize());
    }
}
