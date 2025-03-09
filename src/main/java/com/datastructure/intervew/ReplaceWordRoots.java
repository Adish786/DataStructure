package com.datastructure.intervew;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWordRoots {
    public static String replaceWords(List<String> dictionary, String sentence) {
        // Create a HashSet to store the roots for quick lookup
        Set<String> roots = new HashSet<>(dictionary);
        // Split the sentence into words
        String[] words = sentence.split(" ");
        // StringBuilder to build the modified sentence
        StringBuilder replacedSentence = new StringBuilder();
        // Iterate over each word in the sentence
        for (String word : words) {
            String replacement = word;
            // Check each prefix of the word to see if it is a root
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (roots.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            // Add the replacement word to the sentence
            if (replacedSentence.length() > 0) {
                replacedSentence.append(" ");
            }
            replacedSentence.append(replacement);
        }

        return replacedSentence.toString();
    }

    public static void main(String[] args) {
        // Example 1
        List<String> dictionary1 = Arrays.asList("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary1, sentence1));
        // Example 2
        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary2, sentence2));
    }
}
