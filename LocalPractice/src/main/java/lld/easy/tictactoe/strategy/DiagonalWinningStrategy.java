package lld.easy.tictactoe.strategy;

import lld.easy.tictactoe.entities.Board;
import lld.easy.tictactoe.entities.Player;

class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinners(Board board, Player player){
        // Main Daigonal
        boolean mainDiagWin = true;
        for (int i = 0;  i <board.getSize(); i++){
            if( board.getCell(i,i).getSymbol() != player.getSymbol()){
                mainDiagWin = false;
                break;
            }
        }
        if (mainDiagWin) return true;

        // AntiDiagonal
        boolean antiDiagWin = true;
        for( int i = 0; i< board.getSize(); i++){
            if(board.getCell(i, board.getSize() - i - 1).getSymbol() != player.getSymbol()){
                antiDiagWin = false;
                break;
            }
        }
        return antiDiagWin;
    }

}
