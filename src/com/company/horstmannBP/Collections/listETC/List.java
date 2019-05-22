package com.company.horstmannBP.Collections.listETC;

class List {
    public static void main(String[] args) {
        List item = new List();
        item.insert(12);
        item.insert(24);
        item.append(48);
        item.insertAfter(item.list, 24);

        System.out.println();
    }

    Item list = null;   // указатель на список

    /* Добавить в начало */
    void insert(int value) {
        Item insertion = new Item(value);
        if (list == null) {
            list = insertion;
        } else {
            insertion.next = list;
            list.prev = insertion;
            list = insertion;
        }
    }

    /* Добавить в конец */
    void append(int value) {
        Item insertion = new Item(value);
        if (list == null) {
            list = insertion;
        } else {
            Item lastNode = list;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = insertion;
            insertion.prev = lastNode;
        }
    }

    /* Вставить после заданного узла */
    void insertAfter(Item node, int value) {
        Item insertion = new Item(value);
        Item next = node.next;

        /* Устанавливаем прямые связи */
        node.next = insertion;
        insertion.next = next;

        /* Устанавливаем обратные связи */
        insertion.prev = node;
        if (next != null)   // node может быть концом списка!
            next.prev = insertion;
    }

    /* Вставить перед заданным узлом */
    void insertBefore(Item node, int value) {
        Item insertion = new Item(value);
        Item prev = node.prev;

        /* Устанавливаем прямые связи */
        if (prev != null) {
            prev.next = insertion;
        } else {    // node может быть началом списка!
            list = insertion;
            insertion.next = node;
        }

        /* Устанавливаем обратные связи */
        insertion.prev = prev;
        node.prev = insertion;

    }

    /* Вставить узел */
    void remove(Item node) {
        Item prev = node.prev;
        Item next = node.next;

         /* Обновляем связи */
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        if (node == list)
            list = next;
    }
}

/* Класс узла */
class Item {
    int value;
    Item next;
    Item prev;

    Item(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value +
                ", next=" + next +
                ", prev=" + prev;
    }
}
