package com.example.snake_and_ladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    //ArrayList<Pair<INT INT>
    SnakeLadder snakeLadder=new SnakeLadder();
    ArrayList<Pair<Integer,Integer>> co_ordinates;

    ArrayList<Integer>snakeorLadder;

    //constructor crete array intialize
    public Board(){
        co_ordinates=new ArrayList<>();
        populate();
        snakeandladder();
    }
    // private populate functiom for get exact location of each cord
    private void populate(){
        co_ordinates.add(new Pair<>(0,0));
        for (int i = 0; i <snakeLadder.height; i++) {
            for (int j = 0; j < snakeLadder.width; j++) {
                int x=0;
                if(i%2==0){
                    x=j* snakeLadder.tileSize+ snakeLadder.tileSize/2;
                }else{
                  x=  snakeLadder.tileSize* snakeLadder.height-(j* snakeLadder.tileSize)- snakeLadder.tileSize/2;
                }
            int y=snakeLadder.tileSize* snakeLadder.height-(i* snakeLadder.tileSize)- snakeLadder.tileSize/2;
            co_ordinates.add(new Pair<>(x,y));
            }
        }

    }

    //for snake and ladder
    void snakeandladder(){
        snakeorLadder=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeorLadder.add(i);
        }
        snakeorLadder.set(4,25);
        snakeorLadder.set(13,46);
        snakeorLadder.set(27,5);
        snakeorLadder.set(33,49);
        snakeorLadder.set(40,3);
        snakeorLadder.set(42,63);
        snakeorLadder.set(43,18);
        snakeorLadder.set(50,69);
        snakeorLadder.set(54,31);
        snakeorLadder.set(62,81);
        snakeorLadder.set(66,45);
        snakeorLadder.set(76,58);
        snakeorLadder.set(74,92);
        snakeorLadder.set(89,53);
        snakeorLadder.set(99,41);

    }

    //
    public int getnewpos(int curr){
        if(curr>0&&curr<=100){
            return snakeorLadder.get(curr);
        }
        return -1;
    }

    //method for getting x and y co ordinates
    int getXCoordinate(int val){
        if(val>=1&&val<=100)return co_ordinates.get(val).getKey();
        return -1;
    }

    int getYCoordinate(int val){
        if(val>=1&&val<=100)return co_ordinates.get(val).getValue();
        return -1;
    }


    //main methods for checkingh its correcft or not
//    public static void main(String[] args) {
//   // Board board=new Board();
////    int i=0;
////        for (Pair x: board.co_ordinates
////             ) {
////            System.out.println(i+" "+x.getKey()+" "+x.getValue());
////            i++;
////        }
//    }
}
