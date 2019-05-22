package com.company.filter;
import java.util.*;

public class Util {
    public static <T> void filter(Collection<T> collection, Filter<T> filter){
        // todo
        Iterator<T> iterator = collection.iterator();

        while(iterator.hasNext()){
            T t = iterator.next();

            if(!filter.check(t))
            System.out.println(t);
        }
    }

    public static void main(String[] strings){
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(10);
        integers.add(100);

        filter(integers, new Filter<Integer>() {
            public boolean check(Integer integer) {
                if(integer > 50)
                    return true;

                return false;
            }
        });

        for(Object o : integers) {
            System.out.println(o);
        }
    }
}
