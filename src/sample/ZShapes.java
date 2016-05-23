package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ZShapes extends ShapesFunctions {

    public ZShapes(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().strokePolyline(new double[]{getX(), getX() + Constant.shapeSize, getX(), getX() + Constant.shapeSize},
                new double[]{getY(), getY(), getY() + Constant.shapeSize, getY() + Constant.shapeSize}, Constant.numberPointsForZShapes);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setStroke(color);
        getGc().strokePolyline(new double[]{getX(), getX() + Constant.shapeSize, getX(), getX() + Constant.shapeSize},
                new double[]{getY(), getY(), getY() + Constant.shapeSize, getY() + Constant.shapeSize}, Constant.numberPointsForZShapes);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Constant.shapeSize) && (clickX >= getX()) && (clickY <= getY() + Constant.shapeSize) && (clickY >= getY())) {
            return true;
        }
        return false;
    }
}
