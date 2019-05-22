package com.company.horstmannBP.List;

class Main {
    public static void main(String[] args) {
        ListIntfc list = new List();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println(list.contains("1"));
        System.out.println(list.contains("2"));
        System.out.println(list.contains("3"));
        System.out.println(list.contains("4"));
        System.out.println(list.contains("5"));
    }
}

