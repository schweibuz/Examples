package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 20/11/2017.
 */
class LinkedTest<E> {
    public static void main(String[] args) {
        LinkedTest test = new LinkedTest();
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList.Node head = myLinkedList.getHead();
        for (int i = 10; i < 16; i++)
        myLinkedList.add(new MyLinkedList.Node(i));

        System.out.println(test.print(head));
        test.middleElement(head);
//        System.out.println(test.get(head, 5));
//        System.out.println(head.prev.prev.value);
        System.out.println(test.get(head, 0));
    }

    E get(MyLinkedList.Node node, int n) {
        MyLinkedList.Node offset = node;
        do {
            if (n == 0) {
                offset = offset.next;
            } else {
                n--;
            }
            node = node.next;
        } while (node.next != null);
        return (E) offset.value;
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
        System.out.println("Length: " + length);
        System.out.println("Middle: " + middle.value);
    }

    String print(MyLinkedList.Node node) {
        if (node == null) {
            return "null";
        } else {
            return node.value + ", " + print(node.next);
        }
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;

    MyLinkedList() {
        this.head = new Node("HEAD");
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