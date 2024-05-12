package TicTacToe.Models;

import TicTacToe.Factories.BotPlayingStrategyFactory;
import TicTacToe.Strategy.BotPlayingStrategy;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Character symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        //Based on the difficulty level we need to set the Botplaying Strategy
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Bot is Playing");
        Cell cell=botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
