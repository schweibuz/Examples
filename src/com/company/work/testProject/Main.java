package com.company.work.testProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iMac on 23.08.17.
 */
class Main {
    public static void main(String[] args) {
        Work work = new Work();
        Home home = new Home();
        List<Employee> collection = new ArrayList<>();
        collection.add(work.meow);
        collection.add(home.homeow);
        for (Employee e : collection)
            System.out.println(e);
        work.coffee();
        work.speak();
        work.walk();
        int[] mas = new int[]{1, 3, 2, 23, 1, 3, 5, 9, 3, 4, 5};
        work.bubbleSort(mas);
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i]);

        Stack stack = new Stack();
        int j = 21;
        int[] array = new int[j];
        for (int i = 1; i < j; i++) {
            array[i - 1] = i;
        }
        for (int i : array)
            stack.push(i);
        System.out.println(stack);
        while (stack.getCounter() > -1)
            stack.pop();
        System.out.println(stack);

    }
}
