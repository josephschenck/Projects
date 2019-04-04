package tictactoe.model;


public class Field {
    private Symbol owner;


    private Field(Symbol symbol) {
        owner = symbol;
    }

   
    public static Field getDefault() {
        return new Field(Symbol.NONE);
    }


    public Symbol getOwner() {
        return owner;
    }


    public void setOwner(Symbol owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return owner.toString();
    }

    
    public enum Symbol {
        X, O, NONE
    }
}