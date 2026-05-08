package com.packages.arrays;

public class Triqui 
{
    private String playerOneName;
    private String playerTwoName;
    private char playerOneSymbol;
    private char playerTwoSymbol;
    private char board[][] = new char[3][3];
    private boolean usersCreated;
    private boolean gameStarted;
    private boolean gamePaused;
    private boolean gameCanceled;
    private boolean gameFinished;
    private int turn;
    private int movements;

    public Triqui()
    {
        playerOneName = "";
        playerTwoName = "";
        playerOneSymbol = 'X';
        playerTwoSymbol = 'O';
        usersCreated = false;
        gameStarted = false;
        gamePaused = false;
        gameCanceled = false;
        gameFinished = false;
        turn = 0;
        movements = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public String getPlayerOneName() 
    {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) 
    {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() 
    {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) 
    {
        this.playerTwoName = playerTwoName;
    }

    public char getPlayerOneSymbol() 
    {
        return playerOneSymbol;
    }

    public void setPlayerOneSymbol(char playerOneSymbol) 
    {
        this.playerOneSymbol = playerOneSymbol;
    }

    public char getPlayerTwoSymbol() 
    {
        return playerTwoSymbol;
    }

    public void setPlayerTwoSymbol(char playerTwoSymbol) 
    {
        this.playerTwoSymbol = playerTwoSymbol;
    }

    public char[][] getBoard() 
    {
        return board;
    }

    public boolean getUsersCreated() 
    {
        return usersCreated;
    }

    public void setUsersCreated(boolean usersCreated) 
    {
        this.usersCreated = usersCreated;
    }

    public boolean getGameStarted() 
    {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) 
    {
        this.gameStarted = gameStarted;
    }

    public boolean getGamePaused() 
    {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused) 
    {
        this.gamePaused = gamePaused;
    }

    public boolean getGameCanceled() 
    {
        return gameCanceled;
    }

    public void setGameCanceled(boolean gameCanceled) 
    {
        this.gameCanceled = gameCanceled;
    }

    public boolean getGameFinished() 
    {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) 
    {
        this.gameFinished = gameFinished;
    }

    public int getTurn() 
    {
        return turn;
    }

    public void setTurn(int turn) 
    {
        this.turn = turn;
    }

    public int getMovements() 
    {
        return movements;
    }

    public void setMovements(int movements) 
    {
        this.movements = movements;
    }
}
