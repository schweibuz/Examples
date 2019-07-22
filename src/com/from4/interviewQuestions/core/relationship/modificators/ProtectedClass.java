package com.from4.interviewQuestions.core.relationship.modificators;

class ProtectedClass {

    protected String name = "Yan";
    int count = 50;
    private long time = System.currentTimeMillis();
    private String mark;

    public ProtectedClass() {
        this.mark = "Honda";
    }

    public String getMark() {
        return mark;
    }

    private String getName() {
        return name;
    }

    protected int getCount() {
        return count;
    }

    long getTime() {
        return time;
    }

    protected static class ProtectedInnerClass {

        private String s = null;
        private volatile static ProtectedInnerClass protectedInnerClass;
        private static int counter = 0;

        private String getS() {
            return s + counter;
        }

        private ProtectedInnerClass() {
            s = "Inner class private String";
            counter++;
        }

        static public ProtectedInnerClass getProtectedInnerClass() {
            if (protectedInnerClass == null) {
                synchronized (ProtectedInnerClass.class) {
                    if (protectedInnerClass == null) {
                        protectedInnerClass = new ProtectedInnerClass();
                    }
                }
            }
            return protectedInnerClass;
        }
    }
}
