package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class ShapesFunctions {
    private Random random;
    private GraphicsContext gc;
    protected int x;
    protected int y;
    protected int step = 5;

    public ShapesFunctions(GraphicsContext gc) {
        this.gc = gc;
        random = new Random();
        x = random.nextInt((int) gc.getCanvas().getWidth() - Constant.shapeSize);
        y = random.nextInt((int) gc.getCanvas().getHeight() - Constant.shapeSize);

    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void moveUp() {

        if (y < 0) {

        } else {

            y -= step;

        }

    }

    public void moveDown() {
        if (y > gc.getCanvas().getHeight() - Constant.shapeSize) {

        } else {

            y += step;

        }

    }

    public void moveLeft() {
        if (x < 0) {

        } else {

            x -= step;

        }

    }

    public void moveRight() {
        if (x > gc.getCanvas().getWidth() - Constant.shapeSize) {

        } else {

        x += step;

       }

    }

    public abstract void draw();

    public abstract void changeColor(Color color);


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract boolean isTouched(double clickX, double clickY);
}
