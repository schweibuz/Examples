package com.company.dataStruct.linkedList.newList;

class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        //first example
//        Node node0 = next(0, next(1, next(2, next(3, null))));

        //генерим список итеративно. Если видим что кусок имеет самостоятельный смысл, выводим его в метод
        Node tail = null;
        for (int i = 0; i < 10; i++) {
            tail = new Node(i, tail);
        }

        System.out.println(toStringRec(tail));
        System.out.println(toStringIter(tail));

        System.out.println(toStringRec(generateIter0()));
        System.out.println(toStringIter(generateIter1(10)));
        System.out.println(toStringIter(generateRec0(10)));

        Node ref = tail;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }

    public static Node generateIter1(int max) {
        Node tail = new Node(max, null);
        Node head = tail;
        for (int k = max; k > 0; k--) {
            head.next = new Node(k - 1, null);
            head = head.next;
        }
        return tail;
    }

    public static Node generateIter0() {
        Node result = null;
        for (int i = 0; i < 10; i++) {
            result = new Node(i, result);
        }
        return result;
    }

    public static Node generateRec0(int value) {
        if (value >= 0) {
            return new Node(value, generateRec0(value - 1));
        } else {
            return null;
        }
    }

    //в string можно записать максимум 4 гб(2 байта в char, int размер - массив char(String)) "-"-"-
    public static String toStringIter(Node ref) {
        String result = "";
        while (ref != null) {
            result += "(" + ref.value + ")->";
            ref = ref.next;
        }
        result += "null";
        return result;
    }

    //получим Stack...Error при большом количестве элементов
    public static String toStringRec(Node ref) {
        if (ref == null)
            return "null";
        else
            return "(" + ref.value + ")->" + toStringRec(ref.next);
    }

    //factory method (first example)
    static Node node(int value, Node node) {
        return new Node(value, node);
    }
}
