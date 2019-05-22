//package com.company.serialization;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.reflect.TypeToken;
//
//import javax.swing.*;
//import java.io.*;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.EmptyStackException;
//import java.util.List;
//
///**
// * Created by iMac on 14.08.17.
// */
//class Main {
//    private static List<NewTest> clients = new ArrayList<>();
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        System.out.println(clients.size());
//        clients = (List<NewTest>) deserData("/Users/iMac/Desktop/Stopi/text.ser");
//
//        //json сериализация и десериализация(ниже)
//        String jsonStr = new Gson().toJson(clients);
//        System.out.println(jsonStr);
//        //записать json в файл
//        try {
//            FileWriter writer = new FileWriter("/Users/iMac/Desktop/Stopi/JsonClientsList");
//            writer.write(jsonStr);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //распарсить Json обратно в array
//        Type listType = new TypeToken<List<NewTest>>() {
//        }.getType();
//        List<NewTest> result = new Gson().fromJson(jsonStr, listType);
//        for (NewTest list : result)
//            System.out.println(list);
//
//        //красивенький json с отступами
//        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
//        String jsonPretty = gsonPretty.toJson(clients);
//        System.out.println(jsonPretty);
//
////        NewTest profile = new NewTest();
////        profile.setModel(JOptionPane.showInputDialog(null,"Enter your name"));
////        profile.setLastName(JOptionPane.showInputDialog(null, "Enter your last name"));
////        clients.add(profile);
////
////
////        serData("/Users/iMac/Desktop/Stopi/text.ser", clients);
////        for (NewTest client : clients) {
////            System.out.println(client.getModel() + " " + client.getLastName());
////        }
//
//        System.out.println(clients.size());
//
//        Stack stack = new Stack(13);
//        for (NewTest newTest : clients) {
//            if (!stack.isFull())
//                stack.addElement(newTest);
//        }
//        System.out.println(stack);
//        System.out.println(stack.readTop());
//    }
//
//    //два метода сериализация и десериализация
//    public static void serData(String file_name, Object obj) {
//        try {
//            FileOutputStream fileOut = new FileOutputStream(file_name);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(obj);
//            fileOut.close();
//            out.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//            System.exit(1);
//        } catch (IOException e) {
//            System.out.println("Output / Input error.");
//            System.exit(2);
//        }
//    }
//
//    public static Object deserData(String file_name) {
//        Object retObj = null;
//        try {
//            FileInputStream fileIn = new FileInputStream(file_name);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            retObj = in.readObject();
//            fileIn.close();
//            in.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//            System.exit(1);
//        } catch (IOException e) {
//            System.out.println("Output/Input error.");
//            System.exit(2);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Class not found.");
//            System.exit(3);
//        }
//        return retObj;
//    }
//}
//
//class NewTest implements Serializable {
//    private String name;
//    private String lastName;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return name + " " + lastName + " ";
//    }
//}
//
//
//class Stack<E> {
//    private int mSize;
//    private E[] stackArray;
//    private int top;
//
//    @SuppressWarnings("unchecked")
//    public Stack(int m) {
//        this.mSize = m;
//        stackArray = (E[]) new Object[mSize];
//        top = -1;
//    }
//
//    public void addElement(E element) {
//        stackArray[++top] = element;
//    }
//
//    public E deleteElement() {
//        return stackArray[top--];
//    }
//
//    public E readTop() {
//        return stackArray[top];
//    }
//
//    public boolean isEmpty() {
//        return (top == -1);
//    }
//
//    public boolean isFull() {
//        return (top == mSize - 1);
//    }
//
//    @Override
//    public String toString() {
//        return "Stack{" +
//                "mSize=" + mSize +
//                ", stackArray=" + Arrays.toString(stackArray) +
//                ", top=" + top +
//                '}';
//    }
//}