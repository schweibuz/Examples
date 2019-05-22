package com.questions.work.collections;

/**
 * Created by iMac on 30/10/2017.
 */
class MyLinkedList<T> {
    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList();
//        for (char i = 'A'; i <= 'Z'; i++)
//            myList.insert(i);
        for (char i = 'A'; i <= 'Z'; i++)
            myList.append(i);
//        for (char i = 'A'; i <= 'Z'; i++)
//            myList.remove(myList.list);
        System.out.println(myList.printRec(myList.list));

        int[] mas = myList.generateArray(30);
        myList.bubbleSort(mas);
        myList.printArray(mas);

        mas[1] = 0;
        System.out.println("\n" + myList.getInsertedIf(mas));

        System.out.println("Selected element: " + myList.get(myList.list, 1));
        System.out.println("Offseted element: " + myList.search(myList.list, 0));
    }

    String getInsertedIf(int[] mas) {
        return mas[1] == 0 ? "Nol'" : mas[1] == 2 ? "NeNol'" : "VasheInache";
    }

    T get(Node node, int n) {
        if (node == null || n <= 0) {
            return null;
        } else {
            int length = 0;
            Node lastNode = node;
            while (lastNode.next != null) {
                length++;
                lastNode = lastNode.next;
            }
            System.out.println(length);
            for (int i = length; i >= n; i--)
                node = node.next;
            return (T) node.value;
        }
    }

    T search(Node node, int n) {
        Node offsetedNode = node;
        do {
            if (n == 0) {
                offsetedNode = offsetedNode.next;
            } else {
                n--;
            }
            node = node.next;
        } while (node.next != null);
        return (T) offsetedNode.value;
    }

    int[] generateArray(int size) {
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            int rnd = (int) (Math.random() * 99);
            mas[i] += rnd;
        }
        return mas;
    }

    void bubbleSort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length - i; j++) {
                if (mas[j] < mas[j - 1]) {
                    int tmp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j - 1] = tmp;
                }
            }
        }
    }

    void printArray(int[] mas) {
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i] + " ");
    }

    //LINKEDLIST
    Node list = null;

    void insert(T value) {
        Node inserted = new Node(value);
        if (list == null) {
            list = inserted;
        } else {
            inserted.next = list;
            list.prev = inserted;
            list = inserted;
        }
    }

    void append(T value) {
        Node inserted = new Node(value);
        if (list == null) {
            list = inserted;
        } else {
            Node lastNode = list;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = inserted;
            lastNode.prev = list;
        }
    }

    void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        if (prev == null)
            node.next = next;
        if (next == null)
            node.prev = prev;
        if (node == list)
            list = next;
    }

    String printRec(Node node) {
        if (node == null) {
            return "null";
        } else {
            return node.value + ", " + printRec(node.next);
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }
}