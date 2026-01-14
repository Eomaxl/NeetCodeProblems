package lld.easy.tictactoe.strategy;

import lld.easy.tictactoe.entities.Board;
import lld.easy.tictactoe.entities.Player;

interface WinningStrategy {
    public boolean checkWinners(Board board, Player player);
}
