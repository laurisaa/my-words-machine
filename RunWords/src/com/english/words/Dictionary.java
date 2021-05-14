package com.english.words;

import java.util.Arrays;
import java.util.List;

public class Dictionary {

    public static List<String> listOfWords = Arrays.asList("WORK", "ROW", "KING", "RING", 
    		"KNOW" ,"NOW", "WON");

    public static boolean isEnglishWord(String word) {
        return word != null && word.length() > 1 && listOfWords.contains(word);
    }
}
