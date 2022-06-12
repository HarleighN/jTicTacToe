package com.company;

import java.util.*;

//Assuming 2 humans players
//Player 1 and Player 2

public class jTicTacToe {
    public static void main(String[] args) {
        Game board = new Game();
        Random r = new Random();

        Player Player1 = new Player( 'x');
        Player Player2 = new Player('o');

        board.print();

        int counter = 0;
        Scanner sc = new Scanner(System.in);
        while (!(board.end() == 'x' || board.end() == 'o') && counter < 9) {

            System.out.println("Player 1's Turn: ");
            while (!(Player1.place(board, sc.nextInt()))) { //!place(board.board, Player1, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;

            if(board.end() == 'x' || board.end() == 'o' || counter == 9) break; //Ends the game if Player1 already won or a draw has happened

            System.out.println("Player 2's Turn: ");
            while (!(Player2.place(board, r.nextInt(1, 10)))) { //!place(board.board, Player2, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;
        }

        if(board.end() == 'x') System.out.println("Player 1 wins!");
        else if(board.end() == 'o') System.out.println("Player 2 wins!");
        else System.out.println("Draw.");
    }
}
