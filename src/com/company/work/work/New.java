package com.company.work.work;

/**
 * Created by iMac on 11.08.17.
 */
class New {
    public static void main(String[] args) {
        New news = new New();
        news.getContinue();
    }

    public void getContinue() {
        int i;
        int sum = 0;
        for (i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.print("\nsum = " + sum);
    }
}
