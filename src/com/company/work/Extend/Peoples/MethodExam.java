package com.company.work.Extend.Peoples;

/**
 * Created by iMac on 09/01/17.
 */
class MethodExam {   //перегрузка мтеода

    public String get() {
        return "Hello";
    }

    public String get(String s) {
        return s;
    }

    public String get(int n) {
        return "Number " + n;
    }
}
