package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 19/11/2017.
 */
class EqHash {
    public static void main(String[] args) {
        EqHash eqHash = new EqHash(12, 13);
        EqHash eqHash2 = new EqHash(12,13);
        EqHash eqHash3 = new EqHash(13, 13);

        Some some = new Some(12, 13);

        System.out.println(eqHash.equals(eqHash2));
        System.out.println(eqHash2.equals(eqHash));
        System.out.println(eqHash.equals(eqHash3));
        System.out.println(eqHash2.equals(eqHash3));
        System.out.println(eqHash.equals(eqHash));
        System.out.println("some class: " + eqHash.equals(some));
        System.out.println("null: " + eqHash.equals(null));
    }

    private double x;
    private double y;

    EqHash(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EqHash)) {
            return false;
        }

        EqHash eqHash = (EqHash) o;
        return eqHash.x == x && eqHash.y == y;
    }

    @Override
    public int hashCode() {
        return (int) (31 * this.x + this.y);
    }

}

class Some {
    private double x;
    private double y;

    Some(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
