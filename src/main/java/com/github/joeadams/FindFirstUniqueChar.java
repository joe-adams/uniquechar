package com.github.joeadams;


import java.util.BitSet;
import java.util.Optional;
import java.util.function.Function;

public class FindFirstUniqueChar {
    public static Optional<PositionAndChar> find(String string) {
        BitSet uniqueInts=getBitSetOfUniqueInts(string);
        if (uniqueInts.cardinality()==0){
            return Optional.empty();
        }
        for (int i=0;i<string.length();i++){
            int c=string.charAt(i);
            if (uniqueInts.get(c)){
                return Optional.of(new PositionAndChar(i,string.charAt(i)));
            }
        }
        return Optional.empty();  //Doesn't happen.
    }

    private static BitSet getBitSetOfUniqueInts(String string){
        UniqueInts uniqueInts=string.chars().parallel().collect(UniqueInts::new,UniqueInts::accept,UniqueInts::combine);
        return uniqueInts.getUnique();
    }
}
