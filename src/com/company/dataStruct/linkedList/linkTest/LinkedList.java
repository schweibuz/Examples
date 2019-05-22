package com.company.dataStruct.linkedList.linkTest;

/**
 * Created by iMac on 06/11/2017.
 */
class LinkedList<E> {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert("Anya-21");
        linkedList.insert("Nastya-27");
        linkedList.insert("Nastya-36");
        linkedList.insert("Polina-21");
        linkedList.append("FutureTits");
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

    void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        if (node.next != null)
            node.prev = prev;
        if (node.prev != null)
            node.next = next;
        if (node == list)
            list = node.next;
    }

    String print(Node node) {
        if (node == null) {
            return "null";
        } else {
            return node.value + ", " + print(node.next);
        }
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value) {
            this.value = value;
        }
    }
}