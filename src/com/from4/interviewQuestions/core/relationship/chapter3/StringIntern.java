package com.from4.interviewQuestions.core.relationship.chapter3;

class StringIntern {
    public static void main(String[] args) {
        String string = "  String  ";
        System.out.println(string.intern() == string.intern() + "df");
        StringBuilder builder = new StringBuilder(string);
        builder.append("  String  ").reverse();
        System.out.println(builder.toString());
        String s = builder.toString().trim();
        System.out.println(s);

        String s1 = "StringBuffer";
        StringBuffer s2 = new StringBuffer("StringBuffer");
        System.out.println(String.valueOf(s1).intern() == String.valueOf(s2).intern());
        System.out.println(deleteChar(s1, 'r'));
    }

    static String deleteChar(String str, char ch) {
        return str == null ? null : str.replaceAll(Character.toString(ch), "zz");
    }
}
