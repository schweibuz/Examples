package com.company.reflection.youTube;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

//REFLECTION

/**
 * @author Andrey Matcera
 * @version 1.0
 * @since 0.1
 * This class will creates for <Strong>Java code testing</Strong>.
 */
class EducationOnline {
    /**
     *
     * @param className EducationOnline.
     * @return return new instance of Annotation methods. As a map value.
     * @throws ClassNotFoundException   if something goes wrong this exception will be throw.
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    static Map<?, ?> loadService(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        int i = 0;
        Class service = Class.forName(className);

        Map<Integer, Object> map = new HashMap<Integer, Object>();

        Method[] methods = service.getMethods();

        /**
         * This cycle creates will be find my annotation.
         */
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotaion.class)) {
                map.put(i++, service.newInstance());
            }
        }
        Class cla = Class.forName("com.company.reflection.youTube.EducationOnline");
        map.put(i, cla.newInstance());

        return map;
    }

    /**
     * Here start point of the program.
     * @param args
     * @throws ClassNotFoundException will be thrown exception.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //getClass
        Class classic = Class.forName("com.company.reflection.youTube.Test");

        //getSchedule
        System.out.println(classic.getMethod("method", null).
                invoke(classic.newInstance(), null));

        //getConstructor
        Constructor[] cnstr = classic.getConstructors();
        for (int i = 0; i < cnstr.length; i++)
            System.out.println(cnstr[i]);

        //getInterface
        Class[] infc = classic.getInterfaces();
        for (int i = 0; i < infc.length; i++)
            System.out.println(infc[i]);

        //getModifiers
        if (Modifier.isFinal(classic.getModifiers()))
            System.out.println("is Final.");
        if (Modifier.isPublic(classic.getModifiers()))
            System.out.println("is Public.");

        //getFields
        Field[] fields = classic.getFields();   //только открытые члены класса
        for (int i = 0; i < fields.length; i++)
            System.out.println(fields[i]);

//        Class classs = classic.getClass();
//        Field setField = classs.getField("java.lang.String");
//        String nameValue = (String) setField.get(classic);
//        setField.set(classic, "new Name");

        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println("Name: " + fieldType.getName());
            System.out.println("Type: " + fieldType.getTypeName());
        }

        System.out.println("------------------------------");

        //getMethods
        Method[] methods = classic.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if (methods[i].getAnnotation(MyAnnotaion.class) == null)
                System.out.println("NO");
            else {
                System.out.println("YES");
            }
        }

        System.out.println("------------------------");
        Map obj = loadService("com.company.reflection.youTube.Integrate");
        for (int i = 0; i < obj.size(); i++) {
            System.out.println(obj.get(i));
        }

        String str;
        Class name = Class.forName("com.company.reflection.youTube.Test");
        Method getMethod = name.getMethod("method", null);
        try {
            str = (String)getMethod.invoke(name, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(str);
    }
}

/**
 * backup Class.
 * @see com.company.reflection.youTube.Tusa
 * @see com.company.reflection.youTube.Test
 */
class Test implements Tusa {
    public int a = 13;
    public String b = "Rome";
    private int c = 7;

    public Test() {
    }

    /**
     *
     * @param a is int value.
     */
    public Test(int a) {
        this.a = a;
    }

    /**
     *
     * @param b is String value.
     */
    public Test(String b) {
        this.b = b;
    }

    @MyAnnotaion
    public static String method() {
        return "This is work!";
    }

    @Override
    public int Djusa() {
        return a;
    }

    @MyAnnotaion
    @Override
    public String toString() {
        return "Integrate{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}

interface Tusa {
    int Djusa();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotaion {
}