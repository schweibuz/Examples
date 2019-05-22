package com.questions.tasks.tproger;

/**
 * Created by iMac on 30/11/2017.
 */
class Xor {
    public static void main(String[] args) {
        String string = "HELLO";
        System.out.println(Xor.reverseWithXOR(string));
        System.out.println(Xor.encode(string, "hi"));
        System.out.println(Xor.decode(string.getBytes(), "hi"));

        XORShift xorShift = new XORShift(10000000);
        System.out.println(xorShift.getRandom());
        System.out.println(xorShift.getRandom());
    }

    public static final String reverseWithXOR(String string) {
        char[] array = string.toCharArray();
        int length = array.length;
        int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            System.out.println(array[length - i - 1]);
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }
        return String.valueOf(array);
    }

    public static byte[] encode(String pText, String pKey) {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }

    public static String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }
}

//Генератор случайных чисел
class XORShift {
    private long rnd;

    public XORShift(long rnd) {
        this.rnd = rnd;
    }

    public long getRandom() {
        this.rnd ^= (this.rnd << 21);
        this.rnd ^= (this.rnd >>> 35);
        this.rnd ^= (this.rnd << 4);
        return this.rnd;
    }
}

