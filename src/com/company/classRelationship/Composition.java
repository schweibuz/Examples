package com.company.classRelationship;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Composition {
    public static void main(String[] args) {
/*        Item iPhone_SE = new Item("iPhone SE black 32gb");
        Order newOrder = new Order("smartphone with 2-core CPU, 2gb RAM and display " +
                "with FullHD resolution", 25000, july, iPhone_SE);*/
        Order newOrder = new Order("smartphone with 2-core CPU, 2gb RAM and display" +
                " with FullHD resolution", 25000);
        System.out.println(newOrder);
        newOrder.setItem(null);
        System.out.println(newOrder);
        newOrder = null;
        System.out.println(newOrder);
//        newOrder.setDelivery(new Delivery(LocalDate.of(2019, 5, 1)));
//        System.out.println(newOrder.getDelivery().toString());
//        System.out.println(newOrder);

    }
}


class Order {
    private String description;
    private int cost;
    private Delivery delivery = new Delivery(LocalDate.of(2018, 7, 1)); //composition
    private Item item = new Item("iPhone SE black 32gb");   //composition

    Order(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return String.format("Order: %s\nitem: %s\ncost: %d\ndesired delivery date: %s\n",
                description, item, cost, String.valueOf(delivery));
    }
}


class Delivery {
    private LocalDate date;

    Delivery(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}


class Item {
    private String description;

    Item(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}