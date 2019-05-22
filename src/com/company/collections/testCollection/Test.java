package com.company.collections.testCollection;

import java.util.ArrayList;
import java.util.List;

class Test<T> {

    public void copy(List<? extends T> src, List<? super T> dst) {
        dst.addAll(src);
    }
    public static void main(String[] args) {
        Test<Number> g = new Test<>();

        List<Integer> src = new ArrayList<>();
        src.add(1);
        src.add(1);
        src.add(1);

        List<Number> dst = new ArrayList<>();
        g.copy(src, dst);
        System.out.println(src.size());
        System.out.println(dst.size());
        System.out.println(dst.get(2) + " " + src.get(1));
    }
}
//джошуа блох маст рид - точно читать (владение понмиание коомон инвишис) замедление по
//spring - осесть
//java core collection ,
//spring, mysql, apache hadup web , framework react js framework
//hibernate - логирование.
//sertificate
//collections - где какую коллецкцию применять
//преобразование типов