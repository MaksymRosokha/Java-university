package com.rosokha.task1;

public class StringUtils {
    public boolean isPalindrome(String line) {
        boolean isPal = true;
        char[] trimLine = line.trim().toCharArray();
        for (int i = 0, j = trimLine.length - 1; i < trimLine.length && j >= 0; i++, j--) {
            if (trimLine[i] != trimLine[j]) {
                isPal = false;
                break;
            }
        }
        return isPal;
    }

    public String reverse(String line) {
        if (line == null || line.isEmpty()){
            return null;
        }
        StringBuilder newLine = new StringBuilder();
        char[] charsLine = line.trim().toCharArray();
        for (int i = charsLine.length - 1; i >= 0; i--) {
            newLine.append(charsLine[i]);
        }
        return newLine.toString();
    }
}
