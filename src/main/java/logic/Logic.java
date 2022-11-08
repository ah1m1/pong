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

    public Logic(int width, int height) {
        this.height = height - 36;
        this.width = width - 11;
        this.ball = new Ball(width/2, height/2, 1);
        this.movement = 0;
    }

    public void update(Graphics2D g2) {
        //draw environment
        drawField(g2, width, height);

        g2.setColor(Color.WHITE);

        ball.setPositionX(ball.getPositionX() - ball.getFlightDirection()[0] * ball.getVelocity());
        ball.setPositionY(ball.getPositionY() - ball.getFlightDirection()[1] * ball.getVelocity());

        ball = handleBallCollisions(ball);

        g2.fillRect(ball.getPositionX(), ball.getPositionY(), ball.getSize(), ball.getSize());
    }

    private Ball handleBallCollisions(Ball ball) {
        if(ball.getPositionX() <= 0 || ball.getPositionX() >= width - ball.getSize()) {
            ball.setFlightDirection(ball.getFlightDirection()[0] * (-1), 0);
        }
        if(ball.getPositionY() <= 0 || ball.getPositionY() >= height - ball.getSize()) {
            ball.setFlightDirection(ball.getFlightDirection()[1] * (-1), 1);
        }
        return ball;
    }

    private void drawField(Graphics2D g2, int width, int height) {
        g2.setColor(Color.GRAY);
        g2.drawLine(width / 2, 0, width / 2, height);
    }
}
