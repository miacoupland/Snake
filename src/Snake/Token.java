package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Token {
    private int x, y, score;
    private Snake snake;

    //instantiate it once with a random position
    public Token(Snake s) {
        x = (int)(Math.random() * 395);
        y = (int) (Math.random() * 395);
        snake = s;
    }

    public void changePosition() {
        x = (int)(Math.random() * 395);
        y = (int) (Math.random() * 395);
    }

    public int getScore() {
        return score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 6, 6);
    }

    public Boolean snakeCollision() {
        //returns positions of the first rectangles
        //we want to know the centre of the rectangle, so we have to add
        //to both of these
        int snakeX = snake.getX() + 2;
        int snakeY = snake.getY() + 2;
        //compare with token to see if collision
        //if there is any overlap, it counts as hitting the token
        if (snakeX >= x - 1 && snakeX <= (x + 7)) {
            if (snakeY >= y - 1 && snakeY <= (y + 7)) {
                changePosition();
                score++;
                snake.setElongate(true);
                return true;
            }
        }
        return false;
    }
}
