package TicTacToe.Controller;

import TicTacToe.Exceptions.DuplicateSymbolForPlayer;
import TicTacToe.Exceptions.MoreThanOneBotException;
import TicTacToe.Exceptions.PlayerAndBoardCountMismatch;
import TicTacToe.Models.Game;
import TicTacToe.Models.Player;
import TicTacToe.Strategy.WinningStrategy;

import java.util.List;

public class GameController {
   public Game CreateGame(List<Player> playerList, int dimension, List<WinningStrategy> winningStrategies) throws PlayerAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {
       return Game.getBuilder()
               .setDimension(dimension)
               .setPalyers(playerList)
               .setWinningStrategy(winningStrategies)
               .Build();

   }
   public void makeMove(Game game)
   {
       game.makeMove();
   }
   public void printBoard(Game game)
   {
       game.printBoard();
   }

    public void undo(Game game) {
       game.undo();
    }
}
