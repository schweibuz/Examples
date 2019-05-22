package com.company.patterns;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//работа с концигурацией
class SingletonConf {
    public static void main(String[] args) {
//        Теперь для работы с конфигурацией можно использовать конструкцию вида:
        String propValue = SingletonConf.getSingletonConf().getProperty("key");
        System.out.println(propValue);
    }

    private static SingletonConf singletonConf = null;

    private Properties properties = null;

    private SingletonConf() {
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(new File("props.txt"));
            properties.load(fis);
        } catch (Exception e) {
            // обработайте ошибку чтения конфигурации
            e.printStackTrace();
        }
    }

    public synchronized static SingletonConf getSingletonConf() {
        if (singletonConf == null)
            singletonConf = new SingletonConf();
        return singletonConf;
    }

    // получить значение свойства по имени
    public synchronized String getProperty(String key) {
        String value = null;
        if (properties.containsKey(key))
            value = (String) properties.get(key);
        else {
            System.out.println("Fucking bitch");
        } return value;
    }
}
