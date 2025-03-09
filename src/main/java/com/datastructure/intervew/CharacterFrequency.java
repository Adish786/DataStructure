package com.datastructure.intervew;
public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "AACCCEEA";
        String result = getCompressedString(str);
        System.out.println(result); // Expected output: 2A3C2E1A
    }

    public static String getCompressedString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        // Iterate through the string
        for (int i = 1; i <= str.length(); i++) {
            // If the current character is the same as the previous one, increment the count
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                // Append the count and character to the result
                sb.append(count).append(str.charAt(i - 1));
                count = 1; // Reset count
            }
        }
        return sb.toString();
    }
}
