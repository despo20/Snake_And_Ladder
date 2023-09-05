package com.example.snake_and_ladder;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int tilesize){
        setHeight(tilesize);
        setWidth(tilesize);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);


    }
}
