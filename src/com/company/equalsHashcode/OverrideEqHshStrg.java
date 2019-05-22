package com.company.equalsHashcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by iMac on 15.06.17.
 */
class OverrideEqHshStrg {
    private final int a;
    private final int b;
    private final int c;

    public OverrideEqHshStrg(int a, int b, int c) {
        rangeCheck(a, 999, "first");
        rangeCheck(b, 99, "second");
        rangeCheck(c, 99, "third");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void rangeCheck(int i, int max, String name) {
        if (i < 0 || i > max)
        throw new IllegalArgumentException("Bad value");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OverrideEqHshStrg test = (OverrideEqHshStrg) o;
        return test.a == this.a && test.b == b && test.c == c;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%03d-%02d-%02d)", a, b, c);
    }

    public static void main(String[] args) {

        Map<String, OverrideEqHshStrg> mapa = new HashMap<String, OverrideEqHshStrg>();
        mapa.put("Kiril", new OverrideEqHshStrg(376, 74, 13));
        mapa.put("Andrey", new OverrideEqHshStrg(372, 35, 47));
        System.out.println(mapa.get("Kiril"));
        System.out.println(mapa);
        System.out.println(mapa.get("Kiril").equals(mapa.get("Andrey")));
        System.out.println(mapa.get("Kiril").hashCode() + " and " + mapa.get("Andrey").hashCode());
        mapa.put("Kirill", new OverrideEqHshStrg(376, 74, 13));
        System.out.println(mapa.get("Kirill").equals(mapa.get("Kiril")));
    }
}
