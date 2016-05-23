package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends ShapesFunctions {

    public Oval(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.BLUE);
        getGc().fillOval(getX(), getY(), Constant.shapeSize, Constant.shapeSize);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillOval(getX(), getY(), Constant.shapeSize, Constant.shapeSize);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Constant.shapeSize) && (clickX >= getX()) && (clickY <= getY() + Constant.shapeSize) && (clickY >= getY())) {
            return true;
        }
        return false;
    }
}
