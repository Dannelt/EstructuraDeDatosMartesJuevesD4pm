package com.packages.arrays;

public class TriquiMethods 
{
    private Triqui triqui;

    public TriquiMethods(Triqui triqui)
    {
        this.triqui = triqui;
    }

    public void createUsers(String nameOne, char symbolOne, String nameTwo, char symbolTwo)
    {
        triqui.setPlayerOneName(nameOne);
        triqui.setPlayerOneSymbol(symbolOne);
        triqui.setPlayerTwoName(nameTwo);
        triqui.setPlayerTwoSymbol(symbolTwo);
        triqui.setUsersCreated(true);
        cleanBoard();
        triqui.setGameStarted(false);
    }

    public void cleanBoard()
    {
        char board[][] = triqui.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        triqui.setMovements(0);
        triqui.setGamePaused(false);
        triqui.setGameCanceled(false);
        triqui.setGameFinished(false);
    }

    public void drawStart()
    {
        cleanBoard();
        triqui.setTurn((int)(Math.random() * 2) + 1);
        triqui.setGameStarted(true);
    }

    public String currentPlayerName()
    {
        String name;

        if (triqui.getTurn() == 1) {
            name = triqui.getPlayerOneName();
        } else {
            name = triqui.getPlayerTwoName();
        }

        return name;
    }

    public char currentPlayerSymbol()
    {
        char symbol;

        if (triqui.getTurn() == 1) {
            symbol = triqui.getPlayerOneSymbol();
        } else {
            symbol = triqui.getPlayerTwoSymbol();
        }

        return symbol;
    }

    public boolean validPosition(int row, int col)
    {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3;
    }

    public boolean emptyPosition(int row, int col)
    {
        return triqui.getBoard()[row - 1][col - 1] == ' ';
    }

    public void playTurn(int row, int col)
    {
        triqui.getBoard()[row - 1][col - 1] = currentPlayerSymbol();
        triqui.setMovements(triqui.getMovements() + 1);
    }

    public void changeTurn()
    {
        if (triqui.getTurn() == 1) {
            triqui.setTurn(2);
        } else {
            triqui.setTurn(1);
        }
    }

    public boolean winner()
    {
        char board[][] = triqui.getBoard();
        char symbol = currentPlayerSymbol();
        boolean sw = false;

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                sw = true;
            }

            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                sw = true;
            }
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            sw = true;
        }

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            sw = true;
        }

        return sw;
    }

    public boolean fullBoard()
    {
        return triqui.getMovements() == 9;
    }

    public void finishGame()
    {
        triqui.setGameFinished(true);
        triqui.setGameStarted(false);
    }

    public void pauseGame()
    {
        triqui.setGamePaused(true);
    }

    public void continueGame()
    {
        triqui.setGamePaused(false);
    }

    public void cancelGame()
    {
        triqui.setGameCanceled(true);
        triqui.setGameStarted(false);
        triqui.setGamePaused(false);
        triqui.setGameFinished(true);
    }

    public void updateName(int player, String name)
    {
        if (player == 1) {
            triqui.setPlayerOneName(name);
        } else {
            triqui.setPlayerTwoName(name);
        }
    }

    public boolean updateSymbol(int player, char newSymbol)
    {
        char oldSymbol;
        boolean sw = true;

        if (player == 1) {
            if (newSymbol == triqui.getPlayerTwoSymbol()) {
                sw = false;
            } else {
                oldSymbol = triqui.getPlayerOneSymbol();
                triqui.setPlayerOneSymbol(newSymbol);
                changeBoardSymbol(oldSymbol, newSymbol);
            }
        } else {
            if (newSymbol == triqui.getPlayerOneSymbol()) {
                sw = false;
            } else {
                oldSymbol = triqui.getPlayerTwoSymbol();
                triqui.setPlayerTwoSymbol(newSymbol);
                changeBoardSymbol(oldSymbol, newSymbol);
            }
        }

        return sw;
    }

    public void changeBoardSymbol(char oldSymbol, char newSymbol)
    {
        char board[][] = triqui.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == oldSymbol) {
                    board[i][j] = newSymbol;
                }
            }
        }
    }

    public void showBoard()
    {
        char board[][] = triqui.getBoard();

        System.out.println("\n    1   2   3");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "   ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);

                if (j < 2) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("   ---+---+---");
            }
        }
    }

    public void showInformation()
    {
        System.out.println("Jugador 1: " + triqui.getPlayerOneName() + " - Simbolo: " + triqui.getPlayerOneSymbol());
        System.out.println("Jugador 2: " + triqui.getPlayerTwoName() + " - Simbolo: " + triqui.getPlayerTwoSymbol());

        if (triqui.getGameStarted() && !triqui.getGamePaused()) {
            System.out.println("Turno actual: " + currentPlayerName() + " - Simbolo: " + currentPlayerSymbol());
        }

        if (triqui.getGamePaused()) {
            System.out.println("Partida pausada");
        }

        if (triqui.getGameCanceled()) {
            System.out.println("Partida cancelada");
        }
    }

    public void showBigTriqui(char symbol)
    {
        printPattern("XXXXX  XXXXX    XXXXX    XXXXX  XX   XX  XXXXX", symbol);
        printPattern("  X    XX  XX     X     XX  XX  XX   XX    X  ", symbol);
        printPattern("  X    XXXXX      X     XX  XX  XX   XX    X  ", symbol);
        printPattern("  X    XX XX      X     XX  XX  XX   XX    X  ", symbol);
        printPattern("  X    XX  XX   XXXXX    XXXXX   XXXXX   XXXXX", symbol);
    }

    public void printPattern(String pattern, char symbol)
    {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'X') {
                System.out.print(symbol);
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
