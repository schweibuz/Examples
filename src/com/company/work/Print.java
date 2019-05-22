package com.company.work;

/**
 * Created by oracle on 23.12.2016.
 */
class Print {
    public static void main(String[] args) {
        int[] ams = new int[]{1, 1, 2, 3, 3, 3, 3, 3, 3, 10, 10};
//        for (int i = 0; i < ams.length; i++){
//            ams[i] = (int)(Math.random() * 100);
//        }

        System.out.println(java.util.Arrays.toString(ams));
        Print print = new Print();
        print.print(ams);
    }

    public void print(int[] mas) {
        int myChain = -1;
        int myChainCount = -1;
        int chainValue = -1;
        int countForLastChain = -1;

        for (int i : mas) {
            if (i != chainValue) {
//                System.out.println(chainValue + " " + countForLastChain);
                if (countForLastChain > myChainCount) {
                    myChainCount = countForLastChain;
                    myChain = chainValue;
                }
                chainValue = i;
                countForLastChain = 1;
            } else {
                countForLastChain++;
            }
        }
        System.out.println(myChain + " - " + myChainCount);
    }
}
