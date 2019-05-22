package com.questions.tasks.test;

class LinkedListTest<E> {
    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        MyLinkedList list = new MyLinkedList();
        MyLinkedList.Node head = list.getHead();
        list.add(new MyLinkedList.Node("Hello"));
        list.add(new MyLinkedList.Node("Medved"));
        list.add(new MyLinkedList.Node("Robocop"));
        System.out.println(linkedListTest.print(head));
        linkedListTest.middleElement(head);
        System.out.println(linkedListTest.checkLoop(head));
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
        System.out.println("LENGTH: " + length);
        System.out.println("MIDDLE: " + middle.value);
    }

    String print(MyLinkedList.Node node) {
        if (node == null) {
            return "NULL->";
        } else {
            return node.value + ", " + print(node.next);
        }
    }

    boolean checkLoop(MyLinkedList.Node node) {
        MyLinkedList.Node agentA = node;
        MyLinkedList.Node agentB = node.next;
        if (agentA == null)
            return false;
        while (true) {
            if (agentA == agentB) {
                return true;
            } else if (agentA == null || agentB == null || agentB.next == null) {
                return false;
            }
            agentA = agentA.next;
            agentB = agentB.next.next;
        }
    }
}

class MyLinkedList<E> {
    private Node head;
    private Node tail;

    MyLinkedList() {
        this.head = new Node("<-HEAD");
        tail = head;
    }

    void add(Node node) {
        tail.next = node;
        tail = node;
    }

    Node getHead() {
        return head;
    }

    static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value) {
            this.value = value;
        }
    }
}
