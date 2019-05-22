package com.company.enumeration;

import java.util.*;

enum TEst {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6),
    SEPTET(7), OCTET(8), NONET(9), DECTET(10), DOUBLE_QUARTET(8);

    private final int numberOfMusician;
    TEst(int size) {
        this.numberOfMusician = size;
    }
    public int getMusician(){
        return numberOfMusician;
    }

    public static void main(String[] args) {
        System.out.println(TEst.DOUBLE_QUARTET.getMusician());
        System.out.println(TEst.OCTET.getMusician());

    }
}

class Herb {
    enum Type {
        ANNUAL, PERENNIAL, BIENNIAL
    }
    private final String name;
    private final Type type;
    Herb(String name, Type type) {
        this.type = type;
        this.name = name;
    }
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Herb[] garden = { new Herb("Dill", Type.ANNUAL),
        new Herb("Coriander", Type.ANNUAL),
        new Herb("Parsley", Type.ANNUAL),
        new Herb("Rose", Type.BIENNIAL),
        new Herb("Tulip", Type.PERENNIAL)
        };
        Map<Type, Set<Herb>> kartaTsvetov = new EnumMap<Type, Set<Herb>>(Herb.Type.class);
        for (Type t : Type.values())
            kartaTsvetov.put(t, new HashSet<Herb>());
        for (Herb h : garden)
            kartaTsvetov.get(h.type).add(h);
        System.out.println(kartaTsvetov);
    }
}

enum Phase {
    SOLID, LIQUID, GAS;
    enum Transition {
        BOIL(LIQUID, GAS), MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        SUBLIME(SOLID, GAS), CONDENCE(GAS, LIQUID), DEPOSIT(GAS, SOLID);

        private final Phase src;
        private final Phase dst;
        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }
        private static final Map<Phase, Map<Phase, Transition>> mapa =
                new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);
        static {
            for (Phase p : Phase.values())
                mapa.put(p, new EnumMap<Phase, Transition>(Phase.class));
            for (Transition t : Transition.values())
                mapa.get(t.src).put(t.dst, t);
        }
        public static Transition from(Phase src, Phase dst) {
            return mapa.get(src).get(dst);
        }

        public static void main(String[] args) {
            for (Phase src : Phase.values())
                for (Phase dst : Phase.values())
                    if (src != dst)
                        System.out.printf("%s to %s : %s%n", src, dst, from(src, dst));
        }
    }
}
