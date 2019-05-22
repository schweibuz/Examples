package com.company.dataStruct.linkedList.newList;

class Link {
    public String bookName;
    public int millionsSold;

    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println(bookName + ": " + millionsSold + ",000,000");
    }

    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {
        LinkList theLionkedList = new LinkList();

        theLionkedList.insertFirstLink("Main book", 500);
        theLionkedList.insertFirstLink("A tale of two cities", 300);
        theLionkedList.insertFirstLink("The lord of the rings", 200);
        theLionkedList.insertFirstLink("Harry Potter and the Sorcer", 250);

        theLionkedList.display();

        theLionkedList.removeFirst();
        theLionkedList.display();
        System.out.println(theLionkedList.find("The lord of the rings").bookName + "Was Found");

        theLionkedList.removeLink("The lord of the rings");
        theLionkedList.display();
    }
}

class LinkList {
    public Link firstLink;

    LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return (firstLink == null);
    }

    public void insertFirstLink(String bookName, int millionSold) {
        Link newLink = new Link(bookName, millionSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirst() {
        Link linkReference = firstLink;

        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList");
        }
        return linkReference;
    }

    public void display() {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName) {
        Link theLink = firstLink;
        if(!isEmpty()) {
            while (theLink.bookName != bookName) {
                if(theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }

    public Link removeLink(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        while(currentLink.bookName != bookName) {
            if(currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if(currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }

        return currentLink;
    }
}
