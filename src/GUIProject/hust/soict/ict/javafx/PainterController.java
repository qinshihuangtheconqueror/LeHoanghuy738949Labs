package GUIProject.hust.soict.ict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup toolsButton;
    @FXML
    private RadioButton penOption;
    @FXML
    private RadioButton eraserOption;
    private Color colorOptions;

    public void initialize(){
        penOption.setSelected(true);
        colorOptions = Color.BLACK;

        toolsButton.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == penOption){
                colorOptions = Color.BLACK;
            } else if (newValue == eraserOption) {
                colorOptions = Color.WHITE;
            }
        });
    }

    public void clearButtonPressed(ActionEvent actionEvent) {
        drawingAreaPane.getChildren().clear();
    }

    public void drawingAreaMouseDragged(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= drawingAreaPane.getWidth()
                && mouseEvent.getY() >= 0 && mouseEvent.getY() <= drawingAreaPane.getHeight()) {
            Circle newCircle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, colorOptions);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
