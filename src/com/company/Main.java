package com.company;

import java.util.*;

//Assuming 2 humans players
//Player 1 and Player 2

//Problems needing addressed
/*
- placing pieces over a position that already has be used, the counter then would be off
- showing which player won or if there's a draw
 */

public class Main {
    public static void main(String[] args) {
        char[] board = new char[9];
        Random r = new Random();

        int counter = 0;
        Player Player1 = new Player(1, 'x');
        Player Player2 = new Player(2, 'o');

        Scanner sc = new Scanner(System.in);
        print(board);

        while (!end(board) && counter < 9) {
            System.out.println("Player 1's Turn: ");

            while (!place(board, Player1, sc.nextInt())) {
                System.out.println("There's already a piece there. Please try again.");
            }
            print(board);

            if(end(board)) break; //Ends the game if Player1 already won

            System.out.println("Player 2's Turn: ");
            while (!place(board, Player2, r.nextInt(1, 10))) {
                System.out.println("There's already a piece there. Please try again.");
            }
            print(board);
            counter++;
        }
    }

    public static void print(char[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.print(array[i - 1] + " ");

            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static boolean place(char[] array, Player player, int position) {

        if (array[position - 1] == '\0') {
            array[position - 1] = player.piece;
            return true; //Successfully placed piece
        }
        return false; //Did not place
    }


    //There are 9 end conditions, 8 wins or a draw.
    public static boolean end(char[] array) {
        if ((array[0] != '\0') && array[0] == array[1] && array[1] == array[2]) return true;
        if ((array[3] != '\0') && array[3] == array[4] && array[4] == array[5]) return true;
        if ((array[6] != '\0') && array[6] == array[7] && array[7] == array[8]) return true;

        if ((array[0] != '\0') && array[0] == array[3] && array[3] == array[6]) return true;
        if ((array[1] != '\0') && array[1] == array[4] && array[4] == array[7]) return true;
        if ((array[2] != '\0') && array[2] == array[5] && array[5] == array[8]) return true;

        if ((array[0] != '\0') && array[0] == array[4] && array[4] == array[8]) return true;
        if ((array[2] != '\0') && array[2] == array[4] && array[4] == array[6]) return true;

        return false;
    }

}

//Can't use Pairs so lol
class Player {
    int num;
    char piece;

    Player(int num, char piece) {
        this.num = num;
        this.piece = piece;
    }
}

