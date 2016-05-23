package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ShapesFunctions {

    public Square(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.RED);
        getGc().fillRoundRect(getX(), getY(), Constant.shapeSize, Constant.shapeSize, 0, 0);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillRoundRect(getX(), getY(), Constant.shapeSize, Constant.shapeSize, 0, 0);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + Constant.shapeSize) && (clickX >= x) && (clickY <= y + Constant.shapeSize) && (clickY >= y)) {
            return true;
        }
        return false;
    }
}
