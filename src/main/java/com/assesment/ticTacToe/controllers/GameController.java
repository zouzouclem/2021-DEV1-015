package com.assesment.ticTacToe.controllers;

import com.assesment.ticTacToe.models.Cell;
import com.assesment.ticTacToe.models.Game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/tictactoe")
public class GameController {

    private Game game;

    @GetMapping("/newGame")
    ResponseEntity<Game> game() {
         game = new Game();
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping("/play")
    ResponseEntity<Game> play(@RequestBody Cell cell) {
        if(game == null){
            game= new Game();
            return new ResponseEntity<>(game, HttpStatus.NOT_FOUND);
        }
        if(game.moveAvailable(cell)){
            game.getBoard().getCell(cell).setValue(game.getCurrent().getPawn());
            if(!game.isWinner(cell) && !game.isGameOver()){
                game.setCurrent();
            }
        }else{
            return new ResponseEntity<>(game, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
