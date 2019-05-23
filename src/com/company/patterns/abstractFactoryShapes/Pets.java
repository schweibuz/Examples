package com.company.patterns.abstractFactoryShapes;

class Pets {

    public static void main(String[] args) {
        PetAbstractFactory pet = new PetFactoryProducer().getFactory("pet");
        Pet cat = pet.getPet("cat");
        cat.species();
        Pet dog = pet.getPet("dog");
        dog.species();
        PetAbstractFactory feed = new PetFactoryProducer().getFactory("feed");
        Feed wet = feed.getFeed("wet");
        wet.type();
        Feed dry = feed.getFeed("dry");
        dry.type();

    }
}

class PetFactoryProducer {
    PetAbstractFactory getFactory(String str) {
        if(str == null) {
            return null;
        }

        if(str.equalsIgnoreCase("pet")){
            return new PetFactory();
        }else if(str.equalsIgnoreCase("Feed")){
            return new FeedFactory();
        }

        return null;
    }
}

interface PetAbstractFactory {
    Pet getPet(String pet);
    Feed getFeed(String feed);
}

class PetFactory implements PetAbstractFactory {
    @Override
    public Pet getPet(String pet) {

        if(pet == null){
            return null;
        }

        if(pet.equalsIgnoreCase("dog")){
            return new Dog();
        } else if(pet.equalsIgnoreCase("cat")){
            return new Cat();
        }

        return null;
    }

    @Override
    public Feed getFeed(String feed) {
        return null;
    }
}

class FeedFactory implements PetAbstractFactory {
    @Override
    public Pet getPet(String pet) {
        return null;
    }

    @Override
    public Feed getFeed(String feed) {

        if(feed == null) {
            return null;
        }

        if(feed.equalsIgnoreCase("dry")){
            return new DryFeed();
        } else if(feed.equalsIgnoreCase("wet")){
            return new WetFeed();
        }

        return null;
    }
}

interface Pet {
    void species();
}

class Dog implements Pet {
    @Override
    public void species() {
        System.out.println("Bow-bow");
    }
}

class Cat implements Pet {
    @Override
    public void species() {
        System.out.println("Meow-meow");
    }
}

interface Feed {
    void type();
}

class DryFeed implements Feed {
    @Override
    public void type() {
        System.out.println("I need water.");
    }
}

class WetFeed implements Feed {
    @Override
    public void type() {
        System.out.println("I want check dry feed.");
    }
}