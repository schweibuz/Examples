package com.questions.tasks.quizful;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GetSet {
    public static void main(String[] args) {
        GetSet superClass = new GetSet();
        GetSet subClass = new SubGetSet();
        superClass.setId(1);
        superClass.setName("Johnny");
        subClass.id = 2;
        subClass.name = "Tony";
        System.out.println(superClass.getId() + " " + superClass.getName());
        System.out.println(subClass.getId() + " " + subClass.getName());

        int i, n = 10;
        for (i = 0; -i < n; i--) {
            System.out.println("*");
        }

        List array = new ArrayList();
        List list = new LinkedList();
        for (int j = 0; j < 1000000; j++) {
            array.add(j);
            list.add(j);
        }

        //При вставке в середину в LinkedList выполнится медленнее чем в ArrayList , так как нам для вставки в
        // LinkedList нам нужно добраться до середины делая все время next next next… и потом вставить элемент
        // что незатратно исходя из реализации LinkedList-а , а с другой стороны для ArrayList он быстро по индексу
        // добирается до середины , но чтоб ему добавить элемент нужно сдвинуть правую половину на одну позицию.
        // ArrayList сделает это быстрее , все потому, что метод System.arrayCopy работает быстрее чем next next next ,
        // так как System.arrayCopy native метод !!!
        System.out.println(array.size() + " " + list.size());
        long time = System.nanoTime();
        array.add(array.size() / 2, "Hello");
        System.out.println(time = System.nanoTime() - time);
        long time2 = System.nanoTime();
        list.add(list.size() / 2, "World");
        System.out.println(time2 = System.nanoTime() - time2);
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SubGetSet extends GetSet {

}

class Afield {
    private String field = "I'm private field";
}

//Для доступа к private полю вам понадобится Class.getDeclaredField(String name) или Class.getDeclaredFields() метод.
// Методы Class.getField(String name) и Class.getFields() возвращают только public поля, так что они не сработают.
class Bfield {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Afield afield = new Afield();
        Field field = Afield.class.getDeclaredField("field");
        field.setAccessible(true);
        String str = (String) field.get(afield);
        System.out.println(str);
    }
}
