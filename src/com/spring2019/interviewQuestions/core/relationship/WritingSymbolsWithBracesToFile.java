package com.spring2019.interviewQuestions.core.relationship;

import com.spring2019.interviewQuestions.core.io.MyFile;

import java.io.*;

class WritingSymbolsWithBracesToFile {

    private static String s = "'0','1','2','3','A','B','C','D','a','b','c','d','!','@','#','$','%','^','&','*','(',')','-','_',' ','+','=','[',']','{','}',';',':','|','`','~',',','.','<','>','/','?'";
    private static int count = 0;

    static String braces() {
        StringBuilder builder = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        int bLength = builder.length();
        while (bLength != count) {
            result.append("(" + builder.substring(count, count + 3) + "),");
            if (count > bLength - 4) {
                count += 3;
                result.delete(result.length() - 1, result.length());
            } else {
                count += 4;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (Writer write = new FileWriter(MyFile.getFileOut2(), true);
             BufferedWriter writer = new BufferedWriter(write)
        ) {
            writer.write(braces());
            System.out.println("Write successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
