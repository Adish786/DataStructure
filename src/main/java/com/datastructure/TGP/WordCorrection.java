package com.datastructure.TGP;

public class WordCorrection {
    public static String caseCorrection(String word) {
        int upperCount = 0;
        int lowerCount = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            }
        }
        if (upperCount > lowerCount) {
            return word.toUpperCase();
        } else {
            return word.toLowerCase();
        }
    }
    public static String replaceCharacters(String word, char oldChar, char newChar) {
        return word.replace(oldChar, newChar);
    }
    public static void main(String[] args) {
        //TODO first method Example
        String str = "HoUse";
        System.out.println(caseCorrection(str));
        //TODO second method example
        String replacedWord = replaceCharacters(str, 'e', '3');
        System.out.println("After Character Replacement: " + replacedWord);

    }
}
