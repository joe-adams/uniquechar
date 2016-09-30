package com.github.joeadams;

import java.util.BitSet;

public class UniqueInts {
    BitSet unique;
    BitSet dupes;

    public UniqueInts(){
        this(new BitSet(),new BitSet());
    }
    public UniqueInts(BitSet unique, BitSet dupes) {
        this.unique = unique;
        this.dupes = dupes;
    }

    public BitSet getUnique() {
        return unique;
    }

    public BitSet getDupes() {
        return dupes;
    }

    public void setUnique(BitSet unique) {
        this.unique = unique;
    }

    public void setDupes(BitSet dupes) {
        this.dupes = dupes;
    }

    public void accept(int i){
        if (dupes.get(i)){
            return;
        }

        if (unique.get(i)){
            unique.clear(i);
            dupes.set(i);
            return;
        }
        unique.set(i);
    }


    public void acceptOther(UniqueInts other){
        BitSet newDupes=new BitSet();
        newDupes.or(getUnique());
        newDupes.and(other.getUnique());

        getUnique().xor(other.getUnique());
        getUnique().andNot(newDupes);

        getDupes().or(newDupes);
        getDupes().or(other.getDupes());
    }

    public static UniqueInts combine (UniqueInts first, UniqueInts second){
        first.acceptOther(second);
        return first;
    }
}
