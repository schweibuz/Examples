package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 21/11/2017.
 */
class LinkedList2<E> {
    public static void main(String[] args) {
        LinkedList2 linkedList2 = new LinkedList2();
        for (int i = 0; i < 20; i++)
            linkedList2.insert(i);
        for (int i = 0; i < 5; i++) {
            linkedList2.append(i);
            linkedList2.remove(linkedList2.list);
        }
        System.out.println(linkedList2.print(linkedList2.list));
    }

    Node list = null;

    void insert(E value) {
        Node inserted = new Node(value);
        if (list == null) {
            list = inserted;
        } else {
            inserted.next = list;
            list.prev = inserted;
            list = inserted;
        }
    }

    void append(E value) {
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
        if (next == null)
            node.prev = prev;
        if (prev == null)
            node.next = next;
        if (node == list)
            list = next;

    }

    String print(Node node) {
        if (node == null)
            return "null";
        else
            return node.value + ", " + print(node.next);
    }

    static class Node<E> {
        E value;
        Node next;
        Node prev;

        Node(E value) {
            this.value = value;
        }
    }
}
