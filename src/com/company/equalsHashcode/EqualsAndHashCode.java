package com.company.equalsHashcode;

class EqualsAndHashCode {
    String name;
    int id;

    EqualsAndHashCode(String str, int i) {
        this.name = str;
        this.id = i;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id=" + id + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsAndHashCode that = (EqualsAndHashCode) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    public static void main(String[] args) {
        EqualsAndHashCode vasya = new EqualsAndHashCode("Vasya Ivanov", 13);
        EqualsAndHashCode vasya2 = new EqualsAndHashCode("Vasya Ivanov", 13);
        EqualsAndHashCode petya = new EqualsAndHashCode("Petya Smirnov", 16);
        EqualsAndHashCode senya = new EqualsAndHashCode("Arseny Rebrov", 10);

        System.out.println(vasya.toString() + " vasya hashCode: " + vasya.hashCode());
        System.out.println(petya.toString() + " petya hashCode: " + petya.hashCode());
        System.out.println(senya.toString() + " senya hashCode: " + senya.hashCode());
        EqualsAndHashCode vasya3 = vasya;
        System.out.println(vasya.equals(vasya2));
        System.out.println(vasya2.equals(vasya3));

        System.out.println("vasya: " + vasya.hashCode() + " vasya2: " + vasya2.hashCode());

        System.out.println(System.identityHashCode(vasya) + " vasya2: " +
                System.identityHashCode(vasya2) + "\npetya hash: " +
                System.identityHashCode(petya) + " senya hash: " + System.identityHashCode(senya));

    }
}
