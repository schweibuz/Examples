package com.company.classRelationship;

/**
 * Created by iMac on 18.08.17.
 * Polymorphism
 */
class StaticInitialization {
    public static void main(String[] args) {
        StaticInitialization ion = new StaticInitialization();

        Automobile sport = new Toyota("Supra",  450000, 2002);
        ion.useCar(sport);
        ion.newPrice(sport, 5);

        Reno homeCar = new Reno("Logan", 300000,2010);
        ion.useCar(homeCar);
        ion.newPrice(homeCar, 10);

        Automobile lada = new Lada("Sedan", 310000, 2015);
        ion.useCar(lada);
        ion.newPrice(lada, 30);

    }

    void useCar(Automobile automobile) {
        System.out.println(getClassName(automobile) + " " + automobile);
    }
    void newPrice(Automobile automobile, int discount) {
        automobile.discountFor(discount);
        System.out.println(automobile.getModel() + " sold for new price: "
                + automobile.getDiscount());
    }
    String getClassName(Automobile automobile) {
        return automobile.getClass().getSimpleName();
    }
}
//---------------------------------------------------------------------------
class Automobile {
    private String model;
    private int doors;
    private int price;
    private int year;
    private int discount;

    public void discountFor(int discount) {
        this.discount = discount;
    }

    String getModel() {
        return model;
    }

    int getDiscount() {
        return price - (price * discount) / 100;
    }

    Automobile(String model, int price, int year) {
        if (model.isEmpty() || price < 500)
            try {
                throw new Exception("name or price is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        this.model = model;
        if (price > 400000)
            this.doors = 2;
        else
            this.doors = 4;
        this.price = price;
        this.year = year;
    }


    @Override
    public String toString() {
        return getModel() + ", doors=" + doors + ", price=" + price + ", year=" + year;
    }
}
//---------------------------------------------------------------------------
class Toyota extends Automobile {
    public Toyota(String model, int price, int year) {
        super(model, price, year);
    }

    @Override
    public void discountFor(int discount) {
        super.discountFor(discount);
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }
}
//---------------------------------------------------------------------------
class Lada extends Automobile {
    public Lada(String model, int price, int year) {
        super(model, price, year);
    }

    @Override
    public void discountFor(int discount) {
        super.discountFor(discount);
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }
}
//---------------------------------------------------------------------------
class Reno extends Automobile {
    public Reno(String model, int price, int year) {
        super(model, price, year);
    }

    @Override
    public void discountFor(int discount) {
        super.discountFor(discount);
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }
}