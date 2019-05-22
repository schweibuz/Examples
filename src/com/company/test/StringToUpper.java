package com.company.test;

/**
 * Created by iMac on 23.06.17.
 */
class StringToUpper {
    public static void main(String[] args) {
        String str;
        str = "Вход на Дворцовую площадь для просмотра праздничного концерта будет доступен только для лиц, имеющих пригласительные билеты!";
        char [] chaStr = str.toCharArray(); //преобразует строку в массив
        for (char ch : chaStr) {
            if (Character.isLowerCase(ch))
                ch = Character.toUpperCase(ch);
//            else
//                ch = Character.toLowerCase(ch);
            str += ch;
        }
        System.out.println(str);
    }
}
