package com.company.work.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Palindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader inputStream = new BufferedReader((new InputStreamReader(System.in)));

        try {
            System.out.print("Sample input: ");
            String input = inputStream.readLine();
            if (input.length() > 5) {
                System.err.println(" Length > 5");
            }
            System.out.print("Sample output: ");
            System.out.print(isPalindrome(input));
        } catch (IOException exception) {
            System.err.print("Input error");
        }
    }

    public static Boolean isPalindrome(String s) {
        return s.equalsIgnoreCase((new StringBuilder(s)).reverse().toString());
    }
}
