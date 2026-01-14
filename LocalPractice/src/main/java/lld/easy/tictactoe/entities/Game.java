package lld.easy.tictactoe.entities;

import lld.easy.tictactoe.enums.GameStatus;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private GameState gameState;
    private final List<WinningStrategy> winningStrategies;
}
