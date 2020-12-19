package Snake;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<Point> snakePoints;
    int xDir, yDir;
    Boolean isMoving, elongate;
    final int SIZE = 20, STARTX = 150, STARTY = 150;

    public Snake() {
        snakePoints = new ArrayList<>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(STARTX, STARTY));
        for (int i = 1; i < SIZE; i++) {
            snakePoints.add(new Point(STARTX - i * 4, STARTY));
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for(Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }

    public void move() {
        if (isMoving) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size() - 1);
            //represents new starting point for the snake
            //rectangles are 4 by 4 so we add or subtract 4 or do nothing
            Point newStart = new Point(temp.getX() + xDir * 4,
                    temp.getY() + yDir * 4);
            //iterating backwards through the snake
            for (int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }
            //update original head of snake
            snakePoints.set(0, newStart);
            if (elongate) {
                snakePoints.add(last);
                elongate = false;
            }
        }
    }

    public Boolean snakeCollision() {
        int x = this.getX();
        int y = this.getY();
        for (int i = 1; i < snakePoints.size(); i++) {
            if (snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public Boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(Boolean b) {
        isMoving = b;
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int x) {
        xDir = x;
    }

    public void setYDir(int y) {
        yDir = y;
    }

    //this will always be the head of the snake
    public int getX() {
        return snakePoints.get(0).getX();
    }

    public int getY() {
        return snakePoints.get(0).getY();
    }

    public void setElongate(Boolean b) {
        elongate = b;
    }
}
