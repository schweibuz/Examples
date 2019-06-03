package com.spring2019.interviewQuestions.core.collections.chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class LinkList<E> {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        System.out.println(list.toString());

        ArrayList<String> array = new ArrayList<>(10);
        array.add("FOURTH");
        array.addAll(list);
        System.out.println(array.size());
        array.remove(1);
        array.remove("Second");
        System.out.println(array.size());
        array.trimToSize();
        Iterator iterator = array.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        LinkList linkList = new LinkList();
        linkList.insert("First");
        linkList.insert("Second");
        linkList.insert("Third");
        linkList.insert("Fourth");
        linkList.append("append");
        System.out.println(linkList.print(linkList.list));
        linkList.remove();
        System.out.println(linkList.list.prev.item);
        System.out.println(linkList.list.next.item);
        linkList.insert(1);
        linkList.append("append");
        System.out.println(linkList.print(linkList.list));

    }

    Node list = null;

    void insert(E value) {
        Node node = new Node(value);
        if (list == null) {
            list = node;
        } else {
            node.next = list;
            list.prev = node;
            list = node;
        }
    }

    void append(E value) {
        Node node = new Node(value);
        if (list == null) {
            list = node;
        } else {
            Node lastNode = list;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
            lastNode.prev = list;
        }
    }

    void remove() {
        if (list != null) {
                list = list.next;
        }
    }

    String print(Node node) {
        if (node == null) {
            return "null";
        } else {
            return node.item + ", " + print(node.next);
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }
    }
}
