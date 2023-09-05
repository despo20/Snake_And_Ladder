package com.example.snake_and_ladder;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {


    public final  int tileSize=40,width=10,height=10;

    public final int  intialsize=height*tileSize+50,labelsize=intialsize-30;

    boolean gameStarted=false,playerOneTurn=false,playerTwoTurn=false;

    Dice dice=new Dice();

    Player playerOne,playerTwo;
    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+100);

        //creating small react with 40 size;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile=new Tile(tileSize);
                tile.setTranslateX(tileSize*j);
                tile.setTranslateY(tileSize*i);
                root.getChildren().add(tile);
            }
        }

       //Image img=new Image("C:\\Users\\shripad\\Downloads\\sh.jpg\\");
        /*
        * link for image
        * https://media.istockphoto.com/id/531466314/vector/snakes-and-ladders.jpg?s=612x612&w=0&k=20&c=YYRwkxtVxAXrYV7kFCHKW4h0SHFS4sSSoaj-s9OeHF4=*/
        Image img = new Image("https://media.istockphoto.com/id/531466314/vector/snakes-and-ladders.jpg?s=612x612&w=0&k=20&c=YYRwkxtVxAXrYV7kFCHKW4h0SHFS4sSSoaj-s9OeHF4=");
       ImageView board=new ImageView();
       board.setImage(img);
       board.setFitHeight(tileSize*height);
       board.setFitWidth(tileSize*width);

       //buttons and ppositioning
        Button playerOneButton=new Button("Player 1");
        Button playerTwoButton=new Button("Player 2");
        Button Start=new Button("Start Game");

        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(intialsize);
        playerOneButton.setDisable(true);
        playerTwoButton.setTranslateX(320);
        playerTwoButton.setTranslateY(intialsize);
        playerTwoButton.setDisable(true);
        Start.setTranslateX(172);
        Start.setTranslateY(intialsize);


        //lables and postioning
        Label playerOneLabel=new Label();
        Label playerTwoLabel=new Label();
        Label start=new Label("Start the game");

        playerOneLabel.setTranslateY(labelsize);
        playerOneLabel.setTranslateX(20);
        playerTwoLabel.setTranslateY(labelsize);
        playerTwoLabel.setTranslateX(320);
       start.setTranslateY(labelsize);
        start.setTranslateX(156);


        //craeting player
        playerOne=new Player(tileSize, Color.WHITE,"SHRIPAD");
        playerTwo=new Player(tileSize-5,Color.BLACK,"GUDDU");

       // event handler for buttons

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerOneTurn){
                        int diceval= dice.getRolledDice();
                        start.setText("Dice:"+diceval);
                        playerOne.movePlayer(diceval);

                        if(playerOne.isWinner()) {
                            start.setText("Winner is:" + playerOne.getName());
                            playerOneTurn = false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn = false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");

                            Start.setDisable(false);
                            Start.setText("RESTART GAME !!!!");
                            gameStarted=false;
                        }else{
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn=true;
                            playerTwoButton.setDisable(false);
                            playerTwoLabel.setText("Your turn"+playerTwo.getName());
                        }




                    }
                }

            }
        });

        Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                start.setText("Game started");

                Start.setDisable(true);
                playerOneTurn=true;
                playerOneLabel.setText("your turn "+playerOne.getName());
                playerOneButton.setDisable(false);
                playerOne.startinPosition();

                playerTwoTurn=false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
                playerTwo.startinPosition();
            }
        });


        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerTwoTurn){
                        int diceval= dice.getRolledDice();
                        start.setText("Dice:"+diceval);
                        playerTwo.movePlayer(diceval);
                     //winning condition
                        if(playerTwo.isWinner()){
                            start.setText("Winner is:"+playerTwo.getName());
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn=false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");

                            Start.setDisable(false);
                            Start.setText("RESTART GAME !!!!");
                            //
                            gameStarted=false;
                            //
                        }else{
                            playerOneTurn=true;
                            playerOneButton.setDisable(false);
                            playerOneLabel.setText("Your turn"+playerOne.getName());

                            playerTwoTurn=false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                        }

                    }
                }
            }
        });


        //adding all ui components
       root.getChildren().addAll(board,playerOneButton,playerTwoButton,Start,
               playerOneLabel,playerTwoLabel,start,
               playerOne.getCoin(),playerTwo.getCoin()
       );

        return root;
    }


    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Shripad territory !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}