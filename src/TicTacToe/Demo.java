package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Exceptions.DuplicateSymbolForPlayer;
import TicTacToe.Exceptions.MoreThanOneBotException;
import TicTacToe.Exceptions.PlayerAndBoardCountMismatch;
import TicTacToe.Models.*;
import TicTacToe.Strategy.ColWinningStrategy;
import TicTacToe.Strategy.DiagonalWinningStrategy;
import TicTacToe.Strategy.RowWinningStrategy;
import TicTacToe.Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws PlayerAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {
       Scanner sc=new Scanner(System.in);
       GameController gameController= new GameController();
       int dimension=3;
       List<Player> players=new ArrayList<>();
       players.add(new HumanPlayer('X',"YAMINI",1, PlayerType.HUMAN,sc));
       players.add(new Bot('O',"YAMINI BOT",2,PlayerType.BOT, DifficultyLevel.EASY));
       List<WinningStrategy> winningStrategies=new ArrayList<>();
       winningStrategies.add(new RowWinningStrategy());
       winningStrategies.add(new ColWinningStrategy());
       winningStrategies.add(new DiagonalWinningStrategy());
       Game game=gameController.CreateGame(players,dimension,winningStrategies);
       while(GameState.IN_PROG.equals(game.getGameState()))
       {
          gameController.printBoard(game);
          //Any one wants to UNDO
          System.out.println("Does anyone wants to do UNDO (Y/N)");
          String undo=sc.next();
          if(undo.equalsIgnoreCase("y"))
          {
             gameController.undo(game);
             continue;
          }
          gameController.makeMove(game);
       }
       if(GameState.COMPLETED.equals(game.getGameState()))
       {
          System.out.println(game.getWinner().getName()+" Has Won the game");

       }
       if(GameState.DRAW.equals(game.getGameState()))
       {
          System.out.println(" Its a Draw");

       }

    }
}
