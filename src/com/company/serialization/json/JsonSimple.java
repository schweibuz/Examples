//package com.company.serialization.json;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//class JsonSimple {
//
//    private static final String FILENAME = "/Users/andmat/Desktop/Stopi/jsonTest";
//
//    public static void main(String[] args) {
//
//        JsonObject object = new JsonObject();
//        object.addProperty("name", "j4web");
//        object.addProperty("site", "http://j4web.ru");
//        object.addProperty("age", 2);
//        JsonArray messages = new JsonArray();
//        messages.add("Message 1");
//        messages.add("Message 2");
//        messages.add("Message 3");
//        messages.add("JSON");
//        object.add("messages", messages);
//        try (FileWriter writer = new FileWriter(FILENAME)) {
//            writer.write(object.toString());
//            writer.flush();
//            writer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(JsonSimple.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
//}
//
//
//class JsonSimpleReader {
//    private static final String FILENAME = "/Users/andmat/Desktop/Stopi/jsonTest";
//
//    public static void main(String[] args) {
//        JsonParser parser = new JsonParser();
//        try {
//            JsonObject object = (JsonObject) parser.parse(
//                    new FileReader(FILENAME));
//            // Получаем имя
//            String name = String.valueOf(object.get("name"));
//            System.out.println("Name: " + name);
//            // Получаем сайт
//            String site = String.valueOf(object.get("site"));
//            System.out.println("Site: " + site);
//            // Получаем возраст
//            Long age = Long.valueOf(String.valueOf(object.get("age")));
//            System.out.println("Name: " + age);
//            // Получаем сообщения
//            JsonArray messages = (JsonArray) object.get("messages");
//            System.out.println("Messages:");
//            Iterator<JsonElement> iterator = messages.iterator();
//            while (iterator.hasNext()) {
//                System.out.println("> " + iterator.next());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(JsonSimpleReader.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
//}