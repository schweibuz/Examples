package com.company.dataStruct.linkedList;

class MyLinkedList<E> {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        for (char i = 'A'; i <= 'Z'; i++)
            linkedList.insert(i);

        linkedList.append("HALLOW");

        System.out.println(linkedList.printList(linkedList.list) + "\n" + linkedList.list.size);

        for (int i = 0; i < 10; i++)
            linkedList.remove(linkedList.list);

        System.out.println(linkedList.printList(linkedList.list) + "\n" + linkedList.list.size);
        System.out.println(linkedList.list.prev);
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
            next.prev = prev;
        if (node.prev != null)
            prev.next = next;
        if (node == list)
            list = next;
        node.size--;
    }

    String printList(Node list) {
        if (list == null)
            return "null";
        else
            return list.value + ", " + printList(list.next);
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
        static int size;

        Node(E value) {
            this.value = value;
            size++;
        }
    }
}

