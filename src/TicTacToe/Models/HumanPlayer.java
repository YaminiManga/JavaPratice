package TicTacToe.Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public Scanner scanner;
    @Override
    public Cell makeMove(Board board) {

        System.out.println(" Tour turn to make a move  "+this.getName());
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        while(!validateMove(row,col,board))
        {
            System.out.println(" Invalid Move, Please enter again  "+this.getName());
            row=scanner.nextInt();
            col=scanner.nextInt();
        }
        //Valid Move
        Cell cell=board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;

    }

    private boolean validateMove(int row, int col, Board board) {
        if(row>= board.getDimension() || row<0)
        {
            return false;
        }
        if(col>= board.getDimension() || col<0)
        {
            return false;
        }
        if(CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellState()))
        {
            return false;
        }
        return true;
    }

    public HumanPlayer(Character symbol, String name, int id, PlayerType playerType, Scanner scanner) {
        super(symbol, name, id, playerType);
        this.scanner = scanner;
    }
}
