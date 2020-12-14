package com.assesment.ticTacToe.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game= new Game();

    void fullBoard(){
        for (int rowIndex = 0; rowIndex < Board.ROWS_LENGTH; rowIndex++ ) {
            for (int columnIndex = 0; columnIndex < Board.ROWS_LENGTH; columnIndex++ ) {
                game.getBoard().getCell(rowIndex, columnIndex).setValue(Pawn.X);
            }
        }
    }

    @Test
    void initialize(){
        assertNotNull(game.getBoard());
        assertNotNull(game.getPlayers());
        assertNotNull(game.getCurrent());
        assertEquals(2, game.getPlayers().size());
        assertEquals(Pawn.X, game.getCurrent().getPawn());
    }

    @Test
    void setCurrent() {
        game.setCurrent();
        assertEquals(Pawn.O, game.getCurrent().getPawn());
        assertEquals(game.getCurrent(), game.getPlayers().get(1));
        game.setCurrent();
        assertEquals(game.getCurrent(), game.getPlayers().get(0));
    }

    @Test
    void isWinner() {
        assertEquals(false, game.isAWinner());
    }

    @Test
    void isGameOver() {
        assertEquals(false, game.isGameOver());
    }

    @Test
    void moveAvailable() {
        assertEquals(true, game.moveAvailable(new Cell(0,0)));
        game.getBoard().getCell(0,0).setValue(Pawn.O);
        assertEquals(false, game.moveAvailable(new Cell(0,0)));
        assertEquals(true, game.moveAvailable(new Cell(0,1)));

        game.setAWinner(true);
        assertEquals(false, game.moveAvailable(new Cell(0,1)));

        game.setAWinner(false);
        game.setGameOver(true);
        assertEquals(false, game.moveAvailable(new Cell(0,2)));

        fullBoard();
        assertEquals(false, game.moveAvailable(new Cell(2,2)));

    }
}
