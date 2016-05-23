package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Group extends ShapesFunctions {
    private ArrayList<ShapesFunctions> list;
    private Color colorForGroup;

    public Group(GraphicsContext gc) {
        super(gc);
        list = new ArrayList<>();
        colorForGroup = generateColorForGroup();
    }

    /**
     * Change color shapes for group
     */
    private Color generateColorForGroup() {
        // Java 'Color' class takes 3 floats, from 0 to 1.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b, 1);
    }

    @Override
    public void draw() {
        for (ShapesFunctions s : list) {
            s.changeColor(colorForGroup);
        }
    }

    @Override
    public void changeColor(Color color) {
        draw();
    }

    public void moveUp() {
        for (ShapesFunctions s : list) {
            s.moveUp();
        }
    }

    public void moveDown() {
        for (ShapesFunctions s : list) {
            s.moveDown();
        }
    }

    public void moveRight() {
        for (ShapesFunctions s : list) {
            s.moveRight();
        }
    }

    public void moveLeft() {
        for (ShapesFunctions s : list) {
            s.moveLeft();
        }
    }

    public void addToGroup(ShapesFunctions ShapesFunctions) {
        list.add(ShapesFunctions);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        for (ShapesFunctions s : list) {
            if (s.isTouched(clickX, clickY)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExist(ShapesFunctions shape) {
        return list.contains(shape);
    }
}
