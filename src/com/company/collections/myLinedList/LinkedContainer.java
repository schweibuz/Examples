package com.company.collections.myLinedList;

import java.util.Iterator;

class LinkedContainer<E> implements Linked<E>, Iterable<E>, DescendingIterator<E>{
    public static void main(String[] args) {
        LinkedContainer<String> stringLinked = new LinkedContainer<>();
        stringLinked.addLast("a");
        stringLinked.addLast("b");
        stringLinked.addLast("c");
        stringLinked.addLast("abc");
        stringLinked.addFirst("abcd");
        stringLinked.addFirst("a");
        stringLinked.addFirst("b");
        stringLinked.addFirst("c");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(0));

        for (String s : stringLinked) {
            System.out.println(s);
        }
        Iterator iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public LinkedContainer() {
        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }
    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<E>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
    }
    @Override
    public void addFirst(E e) {
        Node<E> next = fstNode;
        next.setCurrentElement(e);
        fstNode = new Node<E>(null, null, next);
        next.setPrevElement(fstNode);
        size++;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public E getElementByIndex(int counter) {   //most complicated!!!
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }
    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }
            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }
    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int coutnter = size -1;
            @Override
            public boolean hasNext() {
                return coutnter >= 0;
            }
            @Override
            public E next() {
                return getElementByIndex(coutnter--);
            }
        };
    }
    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }
        public E getCurrentElement() {
            return currentElement;
        }
        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }
        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
        public Node<E> getNextElement() {
            return nextElement;
        }
        public Node<E> getPrevElement() {
            return prevElement;
        }
    }
}
