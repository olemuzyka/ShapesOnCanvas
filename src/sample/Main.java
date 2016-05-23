package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    private Scene scene;
    private static GraphicsContext gc;
    private Oval oval;
    private Triangle triangle;
    private Square square;
    private ZShapes zShapes;
    private ClockShapes clockShapes;
    private Button btn;
    private ArrayList<ShapesFunctions> list;
    private HBox btnHelp;
    private HBox btnClean;

    private int index = -1;

    /**
     * Method setOnMousePressed for detection of click of mouse and selection of shapes to addition in group
     */
    private EventHandler<MouseEvent> mouseClick = event -> {
        Group group1 = new Group(gc);
        double clickX = event.getSceneX();
        double clickY = event.getSceneY();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isTouched(clickX, clickY)) {
                ShapesFunctions selected = list.get(i);
                if (group1.isExist(selected)) {
                    return;
                } else if (list.size() > 1) {
                    ShapesFunctions penultimateShape = list.get(list.size() - 2);
                    if (penultimateShape.equals(selected)) {
                        return;
                    } else {
                        group1.addToGroup(selected);
                        group1.addToGroup(penultimateShape);
                        list.remove(selected);
                        list.remove(penultimateShape);
                        list.add(group1);
                        index = list.size() - 1;
                        drawAllShapesAfterAnyAction();
                        return;
                    }
                }
            }
        }
    };


    private EventHandler<KeyEvent> keyboardListener = event -> {


        switch (event.getCode()) {
            case DIGIT1:
                //Add Oval
                list.add(new Oval(gc));
                drawAllShapesAfterAnyAction();
                index++;
                break;
            case DIGIT2:
                //Add Triangle
                list.add(new Triangle(gc));
                drawAllShapesAfterAnyAction();
                index++;
                break;
            case DIGIT3:
                //Add Square
                list.add(new Square(gc));
                drawAllShapesAfterAnyAction();
                index++;
                break;
            case DIGIT4:
                //Add zShapes
                list.add(new ZShapes(gc));
                drawAllShapesAfterAnyAction();
                index++;
                break;
            case DIGIT5:
                //Add ClockShapes
                list.add(new ClockShapes(gc));
                drawAllShapesAfterAnyAction();
                index++;
                break;
            case TAB:
                //Add Random shape
                randomShapes();
                break;
            case A:
                //Switch forward between shapes
                index--;
                if (index < 0) {
                    index = 0;
                }
                break;
            case D:
                //Switch backward between shapes
                index++;
                if (index > list.size() - 1) {
                    index = list.size() - 1;
                }
        }


        //Move shapes(any shapes group)
        switch (event.getCode()) {
            case UP:
                list.get(index).moveUp();
                break;
            case DOWN:
                list.get(index).moveDown();
                break;
            case LEFT:
                list.get(index).moveLeft();
                break;
            case RIGHT:
                list.get(index).moveRight();
        }
        drawAllShapesAfterAnyAction();
    };

    /**
     * method randomly selects a number from 1 to 5. Each number corresponds to figure shape
     */

    private void randomShapes() {
        Random randomShape = new Random();
        int shapeNumber = randomShape.nextInt(5) + 1;
        switch (shapeNumber) {
            case Constant.addOval:
                list.add(new Oval(gc));
                index++;
                break;
            case Constant.addTriangle:
                list.add(new Triangle(gc));
                index++;
                break;
            case Constant.addSquare:
                list.add(new Square(gc));
                index++;
                break;
            case Constant.addZShapes:
                list.add(new ZShapes(gc));
                index++;
                break;
            case Constant.addClockShapes:
                list.add(new ClockShapes(gc));
                index++;
                break;
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("-=Shapes=-");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(Constant.CANVAS_X, Constant.CANVAS_Y);
        GridPane grid = createGrid();
        addButtonClean(grid);
        addButtonHelp(grid);
        grid.add(group, Constant.columnIndex, Constant.rowIndexGrid);
        scene = new Scene(grid);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        list = new ArrayList<>();
        setOnKeyPressed();
        setOnMousePressed();
    }

    /**
     * Add button clean
     */
    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));
        return grid;
    }

    private void addButtonClean(GridPane grid) {
        btn = new Button("CLEAN CANVAS");
        btnClean = new HBox(Constant.columnIndex);
        btnClean.setAlignment(Pos.BOTTOM_CENTER);
        btnClean.getChildren().add(btn);
        grid.add(btnClean, Constant.columnIndex, Constant.rowIndexGridForButtonClean);
        btn.setOnAction(event -> {
            actionCanvas();

        });
    }


    /**
     * Add button help
     */

    private void addButtonHelp(GridPane grid) {
        btn = new Button("HELP");
        btnHelp = new HBox(Constant.heightBox);
        btnHelp.setAlignment(Pos.BOTTOM_CENTER);
        btnHelp.getChildren().add(btn);
        grid.add(btnHelp, Constant.columnIndex, Constant.rowIndexGridForButtonHelp);
        btn.setOnAction(event -> {
            new HTMLTableHelp();
        });
    }


    public void setOnKeyPressed() {
        scene.setOnKeyPressed(keyboardListener);
    }

    public void setOnMousePressed() {
        scene.setOnMousePressed(mouseClick);
    }

    /**
     * Method clean Canvas
     */

    public void cleanCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    /**
     * Method clean canvas and list
     */
    private void actionCanvas() {
        list.clear();
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    /**
     * Method draws all shapes after any action
     */
    private void drawAllShapesAfterAnyAction() {
        cleanCanvas();
        for (ShapesFunctions aList : list) {
            aList.draw();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
