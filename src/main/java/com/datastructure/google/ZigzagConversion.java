package com.datastructure.google;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1)); // Output: "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2)); // Output: "PINALSIGYAHRPI"
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

}
