package logic;

import utils.Config;

import java.awt.*;

public class Logic {
    private int height;
    private int width;
    private int higherVelocity;
    private Ball ball;
    private Player player1;
    private Player player2;
    private Scoreboard sb;

    private int movement;
    private boolean up = false;

    public Logic(int width, int height, Scoreboard sb) {
        this.height = height;
        this.width = width;
        this.ball = new Ball(width/2, height/2, 2);
        this.player1 = new Player(0, 0);
        this.player2 = new Player(0, 0);
        this.player1.setPosition(50, 20);
        this.player2.setPosition(width - 75, 20);
        this.higherVelocity = 0;
        this.sb = sb;
        this.movement = 0;
    }

    public void update(Graphics2D g2) {
        //draw environment
        drawField(g2, width, height);
        g2.setColor(Color.WHITE);

        ball.setPositionX(ball.getPositionX() - ball.getFlightDirection()[0] * ball.getVelocity());
        ball.setPositionY(ball.getPositionY() - ball.getFlightDirection()[1] * ball.getVelocity());

        handleBallCollisions();

        g2.fillRect(ball.getPositionX(), ball.getPositionY(), ball.getSize(), ball.getSize());
        g2.fillRect(player1.getPositionX(), player1.getPositionY(), player1.getWidth(), player1.getHeight());
        g2.fillRect(player2.getPositionX(), player2.getPositionY(), player2.getWidth(), player2.getHeight());
    }

    private void handleBallCollisions() {
        if (ball.getPositionX() <= 0) {
            sb.addPoint(2);
            if (sb.getPoint(2) == 15) {
                System.exit(1);
            }
            ball.reset();
        }

        if (ball.getPositionX() >= width - ball.getSize()) {
            sb.addPoint(1);
            if (sb.getPoint(1) == 15) {
                System.exit(1);
            }
            ball.reset();
        }
        
        if(ball.getPositionY() <= 0 || ball.getPositionY() >= height - ball.getSize()) {
            ball.setFlightDirection(ball.getFlightDirection()[1] * (-1), 1);
            higherVelocity += 1;
            if (higherVelocity == 5) {
                ball.setVelocity(ball.getVelocity() + 1);
                higherVelocity = 0;
            }
        }
        if(ball.getPositionX() <= player1.getPositionX() + player1.getWidth()
                && player1.getPositionY() <= ball.getPositionY()
                && ball.getPositionY() <= player1.getPositionY() + player1.getHeight()
                || player2.getPositionX() - player2.getWidth() <= ball.getPositionX()
                && player1.getPositionY() <= ball.getPositionY()
                && ball.getPositionY() <= player2.getPositionY() + player2.getHeight()) {
            ball.setFlightDirection(ball.getFlightDirection()[0] * (-1), 0);
            higherVelocity += 1;
            if (higherVelocity == 5) {
                ball.setVelocity(ball.getVelocity() + 1);
                higherVelocity = 0;
            }

        }

    }

    public void handleControls(boolean keyUp, boolean keyDown, boolean arrowUp, boolean arrowDown) {
        int move = 4;
        if(keyUp)
            player1.setPositionY(player1.getPositionY() - move);
        if(keyDown)
            player1.setPositionY(player1.getPositionY() + move);
        if(arrowUp)
            player2.setPositionY(player2.getPositionY() - move);
        if(arrowDown)
            player2.setPositionY(player2.getPositionY() + move);
    }

    private void drawField(Graphics2D g2, int width, int height) {
        g2.setColor(Color.GRAY);
        g2.drawLine(width / 2, 0, width / 2, height);
    }

}
