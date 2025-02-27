package com.example.burget_joel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static final int SPRITE_WIDTH = 30;
    private static final int SPRITE_HEIGHT = 27;
    private static final int FRAME_COUNT = 5; // Number of frames in the sprite sheet
    private int currentFrame = 0;

    @Override
    public void start(Stage primaryStage) {
        SpriteSheet spriteSheet = new SpriteSheet("/com/sprites/Idle_1.png");
        Image sprite = spriteSheet.getSprite(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT);

        ImageView imageView = new ImageView(sprite);
        imageView.setX(50); // Set position
        imageView.setY(50);

        //Starting Animation
        // Create a Timeline to cycle through frames
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            int x = (currentFrame % FRAME_COUNT) * SPRITE_WIDTH; // Move to next sprite frame
            imageView.setImage(spriteSheet.getSprite(x, 0, SPRITE_WIDTH, SPRITE_HEIGHT));

            currentFrame = (currentFrame + 1) % FRAME_COUNT; // Loop back to the first frame
        }));

        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play(); // Start the animation


        Pane root = new Pane(imageView);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Sprite Sheet Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
