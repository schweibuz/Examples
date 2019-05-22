package com.questions.tasks.a1;

/**
 * Created by iMac on 23/12/2017.
 */
class List<E> {
    public static void main(String[] args) {
        List linkedList = new List();
        for (int i = 0; i < 10; i++)
            linkedList.insert(i);
        for (int i = 0; i < 10; i++)
            linkedList.append(i);
        for (int i = 0; i < 5; i++)
            linkedList.remove();
        System.out.println(linkedList.print(linkedList.list));
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
            lastNode.prev = lastNode;
        }
    }

    void remove() {
        Node next = list.next;
        list = next;
    }

    String print(Node node) {
        if (node == null)
            return "null";
        else
            return node.value + " " + print(node.next);
    }

    class Node {
        E value;
        Node next;
        Node prev;

        Node(E value) {
            this.value = value;
        }
    }
}
