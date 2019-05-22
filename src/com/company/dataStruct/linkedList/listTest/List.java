package com.company.dataStruct.linkedList.listTest;

class List {
    public static void main(String[] args) {
        Node tail = null;
        for (int i = 0; i < 24; i++) {
            tail = new Node(i, tail);
        }

//        tail = add(43, tail);
//        tail = remove(tail);
        tail = addCustom(tail, 3, 55);
        tail = add(5, tail);
        tail = addCustom(tail, 5, 44);
        System.out.println(toStringRec(tail));
        System.out.println(toStringRec(generateIter1(10)));
        System.out.println(toStringRec(generateIter2()));
        System.out.println(toStringRec(generateRec(10)));

        System.out.println("\nsize: " + size(tail));
        System.out.println("sum: " + sum(tail));
        System.out.println("max: " + max(tail));
    }

    public static Node addCustom(Node node, int place, int value) {
        int[] str = new int[place];
        for (int i = 0; i < place; i++) {
            int element = node.next.value;
            str[i] += element;
            node = node.next;
        }
        str = sortArray(str);
        node = node.next;
        node.value = value;
        for (int i = 0; i < str.length; i++) {
            node = new Node(str[i], node);
        }
        return node;
    }



    public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    public static Node add(int value, Node node) {
        node = new Node(value, node);
        return node;
    }

    public static Node remove(Node node) {
        node = node.next;
        return node;
    }

    public static int max(Node node) {
        int max = 0;
        int[] elements = new int[size(node)];
        while (node != null) {
            for (int i = 0; i < size(node); i++) {
                elements[i] = node.value;
            }
            node = node.next;
        }
        for (int i = 0; i < elements.length; i++) {
            max = elements[i];
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] > max)
                    max = elements[j];
            }
        }
        return max;
    }

    public static int sum(Node node) {
        int sum = 0;
        String result = "";
        while (node.next != null) {
            sum += node.value;
            node = node.next;
        }
        return sum;
    }

    public static int size(Node node) {
        int size = 0;
        String result = "";
        while (node.next != null) {
            result += node.value + " ";
            node = node.next;
        }
        String[] s = result.split(" ");
        return size = s.length;
    }

    public static String toStringRec(Node tail) {
        if (tail == null)
            return "null";
        else
            return "(" + tail.value + ")->" + toStringRec(tail.next);
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

    public static Node generateIter2() {
        Node tail = null;
        for (int i = 0; i < 10; i++) {
            tail = new Node(i, tail);
        }
        return tail;
    }

    public static Node generateRec(int value) {
        if (value >= 0)
            return new Node(value, generateRec(value - 1));
        else
            return null;
    }
}

class Node {
    int value;
    Node next;


    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

//    public Node(int value, Node next, Node prev) {
//        this.value = value;
//        this.next = next;
//        this.prev = prev;
//    }

    @Override
    public String toString() {
        return "value=" + value +
                ", next=" + next;
    }
}
