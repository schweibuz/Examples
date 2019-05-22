package com.company.horstmannBP.List;

class List implements ListIntfc {
    private Node first;

    public void add(String s) {
        if (first == null) {
            first = new Node();
            first.setValue(s);
        } else {
            Node last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }

            Node newNode = new Node();
            newNode.setValue(s);
            last.setNext(newNode);
        }
    }


    public boolean contains(String s) {
        Node last = first;

        if (s.equals(first.getValue())) {
            return true;
        }
        while (last.getNext() != null) {
            last = last.getNext();
            if (s.equals(last.getValue())) {
                return true;
            }
        }
        return false;
    }
}