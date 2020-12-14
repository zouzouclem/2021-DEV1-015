package com.assesment.ticTacToe.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board = new Board();

    void fullBoard(){
        for (int rowIndex = 0; rowIndex < Board.ROWS_LENGTH; rowIndex++ ) {
            for (int columnIndex = 0; columnIndex < Board.ROWS_LENGTH; columnIndex++ ) {
                board.getCell(rowIndex, columnIndex).setValue(Pawn.X);
            }
        }
    }



    @Test
    void initialize(){
        assertNotNull(board.getCells());
        assertEquals(3, board.getCells().length);
        assertEquals(3, board.getCells()[0].length);
    }

    @Test
    void isWinnerBoard() {
        //empty
        assertFalse(board.isWinnerBoard(new Cell(0,0), Pawn.X));
        assertFalse(board.isWinnerBoard(new Cell(0,0), Pawn.O));

        //full X
        fullBoard();
        assertTrue(board.isWinnerBoard(new Cell(0,0), Pawn.X));
        assertFalse(board.isWinnerBoard(new Cell(0,0), Pawn.O));
        assertThrows(IllegalArgumentException.class, () -> {
            board.isWinnerBoard(new Cell(0,0), Pawn.EMPTY);
        });

        //line
        board= new Board();
        board.getCell(0,0).setValue(Pawn.O);
        board.getCell(1,0).setValue(Pawn.O);
        board.getCell(2,0).setValue(Pawn.O);
        assertTrue(board.isWinnerBoard(new Cell(0,0), Pawn.O));


        assertFalse(board.isWinnerBoard(new Cell(0,0), Pawn.X));
        assertFalse(board.isWinnerBoard(new Cell(1,2), Pawn.O));

        //col
        board= new Board();
        board.getCell(0,0).setValue(Pawn.O);
        board.getCell(0,1).setValue(Pawn.O);
        board.getCell(0,2).setValue(Pawn.O);
        assertTrue(board.isWinnerBoard(new Cell(0,1), Pawn.O));

        //diag
        board= new Board();
        board.getCell(0,0).setValue(Pawn.O);
        board.getCell(1,1).setValue(Pawn.O);
        board.getCell(2,2).setValue(Pawn.O);

        assertTrue(board.isWinnerBoard(new Cell(2,2), Pawn.O));

        //rdiag
        board= new Board();
        board.getCell(0,2).setValue(Pawn.O);
        board.getCell(1,1).setValue(Pawn.O);
        board.getCell(2,0).setValue(Pawn.O);
        assertTrue(board.isWinnerBoard(new Cell(0,2), Pawn.O));

    }

    @Test
    void testIsFull() {
        //board empty
        assertFalse(board.isFull());
        //board full
        fullBoard();
        assertTrue(board.isFull());
        //1 free
        board.getCell(0,0).setValue(Pawn.EMPTY);
        assertFalse(board.isFull());
    }
}
