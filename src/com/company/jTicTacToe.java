package com.company;

import java.util.*;

//Assuming 2 humans players
//Player 1 and Player 2

public class jTicTacToe {
    public static void main(String[] args) {
        Random r = new Random();
        Game board = new Game();
        Player PlayerX = new Player('x');
        Player PlayerO = new Player('o');
        Scanner kb = new Scanner(System.in);

        System.out.println("Game Options:");
        System.out.println("(1)\t\t Human v. Human");
        System.out.println("(2)\t\t Human v. AI");
        System.out.println("(3)\t\t AI v. AI");
        System.out.println("(Any)\t Quit");

        switch (kb.nextInt()) {
            case 1 -> twoHumanPlayers(board, PlayerX, PlayerO);
            case 2 -> {
                if(r.nextInt(1,3) == 1) aiFirst(board, PlayerX, PlayerO);
                else aiSecond(board, PlayerX, PlayerO);
            }
            case 3 -> twoAIPlayers(board, PlayerX, PlayerO);
            default -> System.out.println("Game Over."); //idk this is in case they start the game but decide not to play lol
        }
    }

    public static void twoHumanPlayers(Game board, Player Player1, Player Player2) {
        int counter = 0;
        Scanner sc = new Scanner(System.in);

        board.print();
        while (!(board.end() == 'x' || board.end() == 'o') && counter < 9) {

            System.out.println("Player 1's Turn: ");
            while (!(Player1.place(board, sc.nextInt()))) { //!place(board.board, Player1, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;

            if (board.end() == 'x' || board.end() == 'o' || counter == 9)
                break; //Ends the game if Player1 already won or a draw has happened

            System.out.println("Player 2's Turn: ");
            while (!(Player2.place(board, sc.nextInt()))) { //!place(board.board, Player2, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;
        }

        endMessage(board);
    }

    public static void aiFirst(Game board, Player Player1, Player Player2) {
        int counter = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        board.print();
        while (!(board.end() == 'x' || board.end() == 'o') && counter < 9) {

            System.out.println("Player 1's Turn: ");
            while (!(Player1.place(board, r.nextInt(1,10)))) { //!place(board.board, Player1, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;

            if (board.end() == 'x' || board.end() == 'o' || counter == 9)
                break; //Ends the game if Player1 already won or a draw has happened

            System.out.println("Player 2's Turn: ");
            while (!(Player2.place(board, sc.nextInt()))) { //!place(board.board, Player2, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;
        }
        endMessage(board);
    }

    public static void aiSecond(Game board, Player Player1, Player Player2) {
        int counter = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        board.print();
        while (!(board.end() == 'x' || board.end() == 'o') && counter < 9) {

            System.out.println("Player 1's Turn: ");
            while (!(Player1.place(board, sc.nextInt()))) { //!place(board.board, Player1, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;

            if (board.end() == 'x' || board.end() == 'o' || counter == 9)
                break; //Ends the game if Player1 already won or a draw has happened

            System.out.println("Player 2's Turn: ");
            while (!(Player2.place(board, r.nextInt(1, 10)))) { //!place(board.board, Player2, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;
        }
        endMessage(board);
    }

    public static void twoAIPlayers(Game board, Player Player1, Player Player2) {
        int counter = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        board.print();
        while (!(board.end() == 'x' || board.end() == 'o') && counter < 9) {

            System.out.println("Player 1's Turn: ");
            while (!(Player1.place(board, r.nextInt(1, 10)))) { //!place(board.board, Player1, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;

            if (board.end() == 'x' || board.end() == 'o' || counter == 9)
                break; //Ends the game if Player1 already won or a draw has happened

            System.out.println("Player 2's Turn: ");
            while (!(Player2.place(board, r.nextInt(1, 10)))) { //!place(board.board, Player2, sc.nextInt())
                System.out.println("There's already a piece there. Please try again.");
            }
            board.print();
            counter++;
        }
        endMessage(board);
    }

    public static void endMessage(Game board) {
        if (board.end() == 'x') System.out.println("Player 1 wins!");
        else if (board.end() == 'o') System.out.println("Player 2 wins!");
        else System.out.println("Draw.");
    }
}
