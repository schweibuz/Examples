package com.questions.tasks.a1;

/**
 * Created by iMac on 16/12/2017.
 */
class MyLinkedList<E> {
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
        return head;
    }

    static class Node<E> {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }
    }
}

class LinkedTest<E> {
    public static void main(String[] args) {
        LinkedTest test = new LinkedTest();
        MyLinkedList linked = new MyLinkedList();
        MyLinkedList.Node node = linked.getHead();

        for (char i = 'A'; i <= 'Z'; i++)
            linked.add(new MyLinkedList.Node(i));

        test.print(linked.getHead());
        System.out.println("\n");
        test.middleElement(linked.getHead());

    }

    void middleElement(MyLinkedList.Node node) {
        MyLinkedList.Node current = node;
        MyLinkedList.Node middle = node;
        int length = 0;
        while (current != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next;
            }
            current = current.next;
        }
//        if (length % 2 == 1) {
//            middle = middle.next;
//        }
        System.out.println("length: " + length);
        System.out.println("middle: " + middle.value);
        int length2 = 0;
        while (middle != null) {
            length2++;
            System.out.print("(" + middle.value + " " + length2 + ") ");
            middle = middle.next;
        }
    }

    void print(MyLinkedList.Node node) {
        String str = "";
        while (node != null) {
            str += node.value + " ";
            node = node.next;
        }
        System.out.print(str);
    }
}
