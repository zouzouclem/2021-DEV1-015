package com.assesment.ticTacToe.models;

public class Board {
    public static final int ROWS_LENGTH = 3;
    private Cell[][] cells;

    public Board() {
        cells = new Cell[ROWS_LENGTH][ROWS_LENGTH];

        for (int rowIndex = 0; rowIndex < ROWS_LENGTH; rowIndex++ ) {
            for (int columnIndex = 0; columnIndex < ROWS_LENGTH; columnIndex++ ) {
                cells[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex);
            }
        }
    }

    public Cell getCell(Cell cell){
        return cells[cell.getRowIndex()][cell.getColumnIndex()];
    }

    public Cell getCell(int rowIndex, int columnIndex){
        return cells[rowIndex][columnIndex];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean isWinnerBoard(Cell cell, Pawn pawn){
        if(pawn.equals(Pawn.EMPTY)){
            throw new IllegalArgumentException("Pawn can't be empty");
        }
        int col = 0, row = 0, diag = 0, rdiag = 0;
        boolean winner = false;
        for(int i = 0; i< ROWS_LENGTH; i++){
            if(cells[cell.getRowIndex()][i].getValue().equals(pawn)) col++;
            if(cells[i][cell.getColumnIndex()].getValue().equals(pawn)) row++;
            if(cells[i][i].getValue().equals(pawn)) diag++;
            if(cells[i][ROWS_LENGTH -(i+1)].getValue().equals(pawn)) rdiag++;
        }
        if(row== ROWS_LENGTH || col== ROWS_LENGTH || diag== ROWS_LENGTH || rdiag== ROWS_LENGTH){
            winner = true;
        }
        return winner;
    }

    public boolean isFull() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
}
