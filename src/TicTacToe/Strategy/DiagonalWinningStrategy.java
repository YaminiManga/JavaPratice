package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Character,Integer> leftDiag=new HashMap<>();
    Map<Character,Integer> rightDiag=new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Character symbol=move.getPlayer().getSymbol();
        // check if the move for left diagonal
        if(row==col)
        {
            //check if we are putting this symbol for the first time
            if(!(leftDiag.containsKey(symbol)))
            {
                leftDiag.put(symbol,0);
            }
            leftDiag.put(symbol,leftDiag.get(symbol)+1);
            if(leftDiag.get(symbol).equals(board.getDimension()))
            {
                return true;
            }
        }
        // check if the move for left diagonal
        if(row+col== board.getDimension()-1)
        {
            if(!(rightDiag.containsKey(symbol)))
            {
                rightDiag.put(symbol,0);
            }
            rightDiag.put(symbol,rightDiag.get(symbol)+1);
            if(rightDiag.get(symbol).equals(board.getDimension()))
            {
                return true;
            }

        }

    return false;
    }

    @Override
    public void handleMove(Board board, Move lastMove) {
        Character symbol=lastMove.getPlayer().getSymbol();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();
        if(row==col)
        {
            leftDiag.put(symbol,leftDiag.get(symbol)-1);
        }
        if((row+col)==board.getDimension()-1)
        {
            rightDiag.put(symbol,rightDiag.get(symbol)-1);
        }
    }
}
