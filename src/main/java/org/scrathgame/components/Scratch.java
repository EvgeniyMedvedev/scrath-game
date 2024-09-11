package org.scrathgame.components;


import org.scrathgame.models.CellDistribution;
import org.scrathgame.models.Config;

import java.math.BigDecimal;
import java.util.Random;

import static java.math.BigDecimal.ZERO;

/**
 * This class is responsible for distributing symbols across the board.
 * Reward calculation is delegated to {@link GameBoardAnalyzer}.
 * The implementation is thread-safe, i.e. multiple games can be played in parallel with the same config.
 */
public class Scratch {
    private final Config config;

    public Scratch(Config config) {
        this.config = config;
    }

    public GameBoard scratch(BigDecimal bet) {
        return new GameBoardAnalyzer(config).analyze(distribute(), bet);
    }

    private GameBoard distribute() {
        boolean isBonus = config.probabilities().bonusSymbols() != null;
        String[][] board = new String[config.rows()][config.columns()];
        String bonusSymbol = null;
        for (int i = 0; i < config.columns(); i++) {
            for (int j = 0; j < config.rows(); j++) {
                if (isBonus && new Random().nextBoolean()) {    //once or never (but once is almost guaranteed)
                    bonusSymbol = new Distribution(config.probabilities().bonusSymbols()).next();   //save one look across the board
                    board[i][j] = bonusSymbol;
                    isBonus = false;
                } else {
                    var cellDistribution = config.probabilities().standardSymbols().get(new Random().nextInt(config.probabilities().standardSymbols().size()));
                    board[i][j] = new Distribution(cellDistribution).next();
                }
            }
        }
        return new GameBoard(board, ZERO, null, bonusSymbol);
    }

}
