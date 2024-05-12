package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board);
}
