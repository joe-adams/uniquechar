package com.github.joeadams;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    String alphabet="abcedfghijklmnopqrstuvwxyz";
    String alphabets(int i){
        List<String> strings=Collections.nCopies(i,alphabet);
        return String.join("",strings);
    }

    char needle ='1';
    char falseNeedle='2';

    @Test
    public void testWorksWhenPresent(){
        String string=alphabets(10000)+needle+alphabets(1000000);
        PositionAndChar result= FindFirstUniqueChar.find(string).get();
        assertEquals(result,new PositionAndChar(260000,needle));

    }

    @Test
    public void testWorksWhenAbsent(){
        String string=alphabets(1000);
        Optional<PositionAndChar> result= FindFirstUniqueChar.find(string);
        assertEquals(result,Optional.empty());

    }

    @Test
    public void testWorksWhenMoreUniquesPresent(){
        String string=alphabets(10000)+needle+alphabets(10000)+falseNeedle+alphabets(1000000);
        PositionAndChar result= FindFirstUniqueChar.find(string).get();
        assertEquals(result,new PositionAndChar(260000,needle));

    }




}
