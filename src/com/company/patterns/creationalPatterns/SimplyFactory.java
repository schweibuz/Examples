package com.company.patterns.creationalPatterns;

class SimplyFactory {
    public static void main(String[] args) {
        Wheel wheelFactory = WheelFactory.makeWheel(18, 255);
        System.out.println(wheelFactory.getDiametr());
        System.out.println(wheelFactory.getWidth());
    }
}

interface Wheel {
    float getDiametr();
    float getWidth();
}

class CreateWheel implements Wheel {
    private float diametr;
    private float width;

    public CreateWheel(float diametr, float width) {
        this.diametr = diametr;
        this.width = width;
    }

    @Override
    public float getDiametr() {
        return diametr;
    }

    @Override
    public float getWidth() {
        return width;
    }
}

class WheelFactory {
    public static Wheel makeWheel(float diametr, float width) {
        return new CreateWheel(diametr, width);
    }
}