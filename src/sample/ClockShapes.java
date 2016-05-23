package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class ClockShapes extends  ShapesFunctions{
    public ClockShapes(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.BLACK);
        getGc().fillPolygon(new double[]{getX(), getX() + Constant.shapeSize, getX(), getX() + Constant.shapeSize},
                new double[]{getY(), getY(), getY() + Constant.shapeSize, getY() + Constant.shapeSize}, Constant.numberPointsForClockShapes);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillPolygon(new double[]{getX(), getX() + Constant.shapeSize, getX(), getX() + Constant.shapeSize},
                new double[]{getY(), getY(), getY() + Constant.shapeSize, getY() + Constant.shapeSize}, Constant.numberPointsForClockShapes);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Constant.shapeSize) && (clickX >= getX()) && (clickY <= getY() + Constant.shapeSize) && (clickY >= getY())) {
            return true;
        }
        return false;
    }
}
