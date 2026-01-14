package lld.easy.tictactoe.entities;

import lld.easy.tictactoe.enums.Symbol;
import lld.easy.tictactoe.exceptions.InvalidMoveException;

public class Board {
    private final int size;
    private int movesCount;
    private final Cell[][] board;

    public Board(int size){
        this.size = size;
        this.board = new Cell[size][size];
        movesCount = 0;
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i =0 ; i < size; i++){
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public int getSize(){
        return this.size;
    }

    public boolean isFull(){
        return movesCount == size * size;
    }

    public Cell getCell(int row, int col){
        if (row <0 || row >= size || col <0 || col >= size) {
            return null;
        }
        return board[row][col];
    }

    public boolean placeSymbol(int row, int col, Symbol symbol){
        if (row <0 || row >= size || col <0 || col >= size ){
            throw new InvalidMoveException("Invalid position : out of bound");
        }

        if (board[row][col].getSymbol() != Symbol.EMPTY){
            throw new InvalidMoveException("Invalid position: cell is already occupied");
        }

        board[row][col].setSymbol(symbol);
        movesCount++;
        return true;
    }

    public void printBoard(){
        IO.println("-------------------------");
        for(int i = 0; i <size; i++) {
            IO.print("|");
            for (int j = 0; j < size; j++){
                Symbol symbol = board[i][j].getSymbol();
                IO.print(symbol.getChar()+" | ");
            }
            IO.println("\n-------------------");
        }
    }
}
