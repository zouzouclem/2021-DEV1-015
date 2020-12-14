package com.assesment.ticTacToe.models;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    private Player current;
    private boolean isAWinner;
    private boolean isGameOver;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.players.add(new Player(Pawn.X));
        this.players.add(new Player(Pawn.O));
        this.current= this.players.get(0);
        this.isGameOver= false;
        this.isAWinner=false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Player getCurrent() {
        return current;
    }

    public void setCurrent() {
      this.current = this.current.equals(this.players.get(0))? this.players.get(1): this.players.get(0);
    }

    public boolean isAWinner() {
        return isAWinner;
    }

    public void setAWinner(boolean AWinner) {
        isAWinner = AWinner;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public boolean isWinner(Cell cell){
        isAWinner = this.getBoard().isWinnerBoard(cell, getCurrent().getPawn());
        return isAWinner;
    }

    public boolean isGameOver(){
        isGameOver = this.getBoard().isFull() && !isAWinner;
        return isGameOver;
    }

    public boolean moveAvailable(Cell cell){
        return !isGameOver && !isAWinner && this.getBoard().getCell(cell).isEmpty();
    }

}
