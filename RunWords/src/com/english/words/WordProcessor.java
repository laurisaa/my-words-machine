package com.english.words;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordProcessor {

    public static void main(String args[]){
        System.out.println(new WordProcessor().process("WORKING"));
    }

    public Set<String> process(String input) {
        char[] characters = input.toCharArray();
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int s = 0;
        for (char letter : characters) {
            s = result.size();
            for (int i = 0; i < s; i++) {
                List<Character> set = new ArrayList<>(result.get(i));
                set.add(letter);
                result.add(set);
            }
        }
        System.out.println();
        return findEnglishWords(findPermutation(result));
    }
    public Set<String> findEnglishWords(Set<String> finalList) {
        Set<String> output = new HashSet<>();
        for(String processingWord: finalList){
            if (!processingWord.equals("") && processingWord.length() > 1) {
                if (Dictionary.isEnglishWord(processingWord)) {
                    output.add(processingWord);
                }
            }
        }
        return output;
    }

    public static Set<String> findPermutation(List<List<Character>> words){
        Set<String> finalList = new HashSet<>();
        for(List<Character> word : words){
            String processingWord = "";
            for (Character str : word) {
                processingWord = processingWord.concat(str.toString());
            }
            finalList.addAll(permutationCalculator (processingWord));
        }
        return finalList;
    }

    public static Set<String> permutationCalculator(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationCalculator(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

}
