package lld.easy.tictactoe.entities;

import lld.easy.tictactoe.enums.Symbol;

public class Cell {
    private Symbol symbol;

    public Cell(){
        this.symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }
}
