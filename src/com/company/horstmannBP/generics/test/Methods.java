package com.company.horstmannBP.generics.test;

class Methods<T> {
    private T element;
    private T element2;

    public Methods() {
        element = null;
    }
    public Methods(T element) {
        this.element = element;
    }
    public Methods(T element, T element2) {
        this.element = element;
        this.element2 = element2;
    }
    public T getElement() {
        return element;
    }
    public T getElement2() {
        return element2;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public void setElement2(T element2) {
        this.element2 = element2;
    }

    @Override
    public String toString() {
        return "Methods " +
                "element = " + element + " element2 = " + element2;
    }
}
