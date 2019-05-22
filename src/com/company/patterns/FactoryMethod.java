package com.company.patterns;

class FactoryMethod {

    public static void main(String[] args) {

        Market createProducts = new CreateProducts();
        createProducts.createProduct(123);
        createProducts.createProduct(321);
        createProducts.createProduct(234);

    }
}

interface Market {
    Product createProduct(int article);
}

class CreateProducts implements Market {

    private final int tomatoArticle = 123;
    private final int cucumberArticle = 321;
    private final int orangeArticle = 234;
    Product product;

    @Override
    public Product createProduct(int article) {
        if (article > 10 && article < 1000) {
            switch (article) {
                case tomatoArticle:
                    product = new Tomato();
                    break;
                case cucumberArticle:
                    product = new Cucumber();
                    break;
                case orangeArticle:
                    product = new Orange();
                    break;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return product;
    }


    public int getTomatoArticle() {
        return tomatoArticle;
    }

    public int getCucumberArticle() {
        return cucumberArticle;
    }

    public int getOrangeArticle() {
        return orangeArticle;
    }
}

interface Product {
    void getName();
    void getCost();
}

class Tomato implements Product {

    Tomato() {
        getName();
        getCost();
    }

    @Override
    public void getName() {
        System.out.println("Tomato pink from Greece");
    }

    @Override
    public void getCost() {
        System.out.println(220);
    }
}

class Cucumber implements Product {

    Cucumber() {
        getName();
        getCost();
    }

    @Override
    public void getName() {
        System.out.println("Cucumber from Tajikistan");
    }

    @Override
    public void getCost() {
        System.out.println(140);
    }
}

class Orange implements Product {

    Orange() {
        getName();
        getCost();
    }

    @Override
    public void getName() {
        System.out.println("Orange red from Morocco");
    }

    @Override
    public void getCost() {
        System.out.println(330);
    }
}