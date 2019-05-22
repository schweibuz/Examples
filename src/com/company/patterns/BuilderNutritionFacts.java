package com.company.patterns;

/**
 * Created by iMac on 11.06.17.
 */
class BuilderNutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    static class Builder {
        private final int servingSize;
        private final int serivngs;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        private Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.serivngs = servings;
        }
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public BuilderNutritionFacts build() {
            return new BuilderNutritionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate;
    }

    private BuilderNutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.serivngs;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        BuilderNutritionFacts cocaCola = new Builder(230, 5)
                .calories(200).fat(10).sodium(35).carbohydrate(23).build();
        System.out.println("CocaCola: " + cocaCola);
    }
}