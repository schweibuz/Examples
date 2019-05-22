package com.company.test;

import java.util.HashMap;
import java.util.Map;

class Favorites {
    private Map<Class<?>, Object> favorite = new HashMap<Class<?>, Object>();

    public <T> void putFavorites(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("This is null");
        favorite.put(type, instance);
    }

    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorite.get(type));
    }


    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorites(String.class, "JavaCode");
        f.putFavorites(Integer.class, 28);
        f.putFavorites(Class.class, Favorites.class);

        String stringFavorites = f.getFavorites(String.class);
        int integerFavorites = f.getFavorites(Integer.class);
        Class<?> classFavorites = f.getFavorites(Class.class);
        System.out.printf("%s %x %s%n", stringFavorites, integerFavorites, classFavorites);
    }
}