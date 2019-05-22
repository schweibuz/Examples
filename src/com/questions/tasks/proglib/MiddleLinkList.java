package com.questions.tasks.proglib;

class MiddleLinkList<E> {
    public static void main(String[] args) {
        MiddleLinkList test = new MiddleLinkList();
        MyLinkedList list = new MyLinkedList();
        MyLinkedList.Node node = list.getHead();

        for (char i = 'A'; i <= 'Z'; i++)
            list.add(new MyLinkedList.Node(i));

        test.print(node);
        test.middleElement(node);
    }

    void middleElement(MyLinkedList.Node node) {
        MyLinkedList.Node current = node;
        MyLinkedList.Node middle = node;
        int length = 0;
        while (current.next != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next;
            }
            current = current.next;
        }
        if (length % 2 == 1) {
            middle = middle.next;
        }
        System.out.println("Length of LinkedList: " + length);
        try {
            System.out.println("Middle element of LinkedList :" + middle.value);
        } catch (NullPointerException e) {
            System.out.println("MyLinkedList is Null");
        }
    }

    void print(MyLinkedList.Node node) {
        String str = "";
        while (node.next != null) {
            str += node.value + " ";
            node = node.next;
        }
        System.out.println(str);
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;

    MyLinkedList() {
        this.head = new Node("null");
        this.tail = head;
    }

    void add(MyLinkedList.Node node) {
        tail.next = node;
        tail = node;
    }

    Node getHead() {
        return this.head;
    }

    static class Node<E> {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }
    }
}