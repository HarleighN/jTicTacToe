package com.company;

public class Player {
    char piece;

    public Player(char piece) {
        this.piece = piece;
    }

    public  boolean place(Game board, int position) {
        return board.place(this, position);
    }
}

