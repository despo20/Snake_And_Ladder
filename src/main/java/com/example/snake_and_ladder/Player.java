package com.example.snake_and_ladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
   private Board board=new Board();
    SnakeLadder snakeLadder=new SnakeLadder();

     private Circle coin;
   private int currentPosition;
    private String name;


    //constrctor for player


    public Player(int tilesize, Color coincolor, String p ){
    coin=new Circle(tilesize/2);
    coin.setFill(coincolor);
    movePlayer(1);
    currentPosition=0;
    name=p;

    }

    public void movePlayer(int diceValue){
        if(currentPosition+diceValue<=100) {
            currentPosition += diceValue;

            TranslateTransition seconMove=null, firstmove = tranlate_Animation(diceValue);


            int pos = board.getnewpos(currentPosition);
            if (pos != currentPosition && pos != -1) {
                currentPosition = pos;
                seconMove = tranlate_Animation(6);
            }
            if(seconMove==null){
                firstmove.play();
            }else{
                SequentialTransition st=new SequentialTransition(firstmove,new PauseTransition(Duration.millis(300)),seconMove);
                st.play();
            }
//        int x=board.getXCoordinate(currentPosition);
//        int y=board.getYCoordinate(currentPosition);
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);
        }
    }

    public TranslateTransition tranlate_Animation(int dicevalue){

           TranslateTransition tt=new TranslateTransition(Duration.millis(200*dicevalue),coin);
     tt.setToX(board.getXCoordinate(currentPosition));
        tt.setToY(board.getYCoordinate(currentPosition));
      tt.setAutoReverse(false);
        return tt;
    }
//for restarting
    public void startinPosition(){
        currentPosition=0;
        movePlayer(1);
    }
    //for checking wiiner

    public boolean isWinner(){
        if(currentPosition==100){
            return true;
        }
        return false;
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
