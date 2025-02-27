package com.example.burget_joel;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class SpriteSheet {
    private Image sheet;
    
    public SpriteSheet(String path){
        sheet = new Image(getClass().getResourceAsStream(path));
    }

    public Image getSprite(int x, int y, int width, int height){
        PixelReader reader = sheet.getPixelReader();
        if (reader != null){
            return new WritableImage(reader, x, y, width, height);
        }
        return null;
    }
}
