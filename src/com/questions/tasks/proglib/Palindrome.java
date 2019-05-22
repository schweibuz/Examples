package com.questions.tasks.proglib;

/**
 * Created by iMac on 29/11/2017.
 */
class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String string = "Anna";
        System.out.println("Palindrome: " + palindrome.isPalindrome(string));

    }

    boolean isPalindrome(String str) {
        if (myEquals(str))
            return false;

        char[] strChars = str.toCharArray();
        String result = "";

        for (int i = strChars.length; i > 0; i--)
            result += strChars[i - 1];

        System.out.println("String reverse: " + result);
        return result.equalsIgnoreCase(str);
    }


    boolean myEquals(String str) {
        char[] chars = new char[62];
        int j = 0;
        for (char i = 'A'; i <= 'Z'; i++, j++)
            chars[j] = i;
        for (char i = 'a'; i <= 'z'; i++, j++)
            chars[j] = i;
        for (char i = '0'; i <= '9'; i++, j++)
            chars[j] = i;
        for (int i = 0; i < chars.length; i++)
            System.out.print(chars[i]);
        System.out.println();

        char[] strChars = str.toCharArray();
        for (int t = 0; t < chars.length; t++) {
            char compare = chars[t];
            for (int i = 0; i < strChars.length; i++) {
                if (!(compare == strChars[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
