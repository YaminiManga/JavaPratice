package TicTacToe.Factories;

import TicTacToe.Models.DifficultyLevel;
import TicTacToe.Strategy.BotPlayingStrategy;
import TicTacToe.Strategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        return new EasyBotPlayingStrategy();

    }
}
