package com.github.joeadams;

public class PositionAndChar {
    final private int position;
    final private char thechar;

    public PositionAndChar(int position, char thechar) {
        this.position = position;
        this.thechar = thechar;
    }

    public int getPosition() {
        return position;
    }

    public char getTheChar() {
        return thechar;
    }

    @Override
    public boolean equals(Object o){
        if (o==null || !(o instanceof PositionAndChar)){
            return false;
        }
        PositionAndChar that=(PositionAndChar) o;
        return this.getPosition()==that.getPosition()&&this.getTheChar()==that.getTheChar();
    }

    @Override
    public String toString(){
        return getPosition()+" : "+getTheChar();
    }
}
