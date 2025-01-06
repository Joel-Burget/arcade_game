package com.example.burget_joel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Rectangle shape;
    private double speed = 5;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane pane = new GridPane();

        shape = new Rectangle(100, 50, 100, 50);
        shape.setStroke(Color.RED);
        shape.setFill(Color.GREEN);
        pane.add(shape, 0, 0);
        
        
        Scene scene = new Scene(pane, 1250, 750);
        scene.setOnKeyPressed(this::handleKeyPressed);

        stage.setTitle("Untitled Corgi Game");
        stage.setScene(scene);
        stage.show();
    }

    private void handleKeyPressed(KeyEvent event){
        switch (event.getCode()) {
            case UP:
                shape.setY(shape.getY() - speed);
                break;
            case DOWN:
                shape.setY(shape.getY() + speed);
                break;

            case LEFT:
                shape.setX(shape.getX() - speed);
                break;
            case RIGHT:
                shape.setX(shape.getX() + speed);
            default:
                break;
        }
        System.out.println(event.getCode());
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}