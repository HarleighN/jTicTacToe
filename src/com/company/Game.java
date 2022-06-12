package com.company;

public class Game {
    char[] board;

    public Game() {
        board = new char[9];
    }

    public void print() {
        for (int i = 1; i < board.length + 1; i++) {
            System.out.print(board[i - 1] + " ");

            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }

    public boolean place(Player player, int position) {
        if(board[position - 1] == '\0') {
            board[position-1] = player.piece;
            return true; //Piece was placed
        }
        return false; // Piece was not placed
    }

    //There are 9 end conditions, 8 wins or a draw.
    public char end() {
        if ((board[0] != '\0') && board[0] == board[1] && board[1] == board[2]) return board[0];
        if ((board[3] != '\0') && board[3] == board[4] && board[4] == board[5]) return board[3];
        if ((board[6] != '\0') && board[6] == board[7] && board[7] == board[8]) return board[6];

        if ((board[0] != '\0') && board[0] == board[3] && board[3] == board[6]) return board[0];
        if ((board[1] != '\0') && board[1] == board[4] && board[4] == board[7]) return board[1];
        if ((board[2] != '\0') && board[2] == board[5] && board[5] == board[8]) return board[2];

        if ((board[0] != '\0') && board[0] == board[4] && board[4] == board[8]) return board[0];
        if ((board[2] != '\0') && board[2] == board[4] && board[4] == board[6]) return board[2];

        return '\0'; //Maybe a draw? Or the game just isn't over.
    }
}

