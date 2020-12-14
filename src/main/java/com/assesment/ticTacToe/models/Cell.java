package com.assesment.ticTacToe.models;

public class Cell {
    private int rowIndex;
    private int columnIndex;
    private Pawn value;

    public Cell(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = Pawn.EMPTY;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public Pawn getValue() {
        return value;
    }

    public void setValue(Pawn value) {
        this.value = value;
    }

    public boolean isEmpty(){
        return this.value.equals(Pawn.EMPTY);
    }
}
