package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

    void handleMove(Board board, Move lastMove);
}
