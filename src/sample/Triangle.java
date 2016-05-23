package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends ShapesFunctions {

    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.GREEN);
        getGc().fillPolygon(new double[]{getX(), getX() + Constant.shapeSize, getX() + Constant.shapeSize / 2},
                new double[]{getY(), getY(), getY() - Constant.shapeSize}, Constant.numberPointsForTriangle);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillPolygon(new double[]{getX(), getX() + Constant.shapeSize, getX() + Constant.shapeSize / 2},
                new double[]{getY(), getY(), getY() - Constant.shapeSize}, Constant.numberPointsForTriangle);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Constant.shapeSize) && (clickX >= getX()) && (clickY <= getY())) {
            return true;
        }
        return false;
    }
}
