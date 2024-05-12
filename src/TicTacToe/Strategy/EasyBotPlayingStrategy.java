package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell makeMove(Board board) {
       for(List<Cell> row: board.getBoard())
       {
           for(Cell cell: row)
           {
               if(cell.getCellState().equals(CellState.EMPTY))
               {
                   return cell;
               }
           }
       }
       return null;
    }
}
