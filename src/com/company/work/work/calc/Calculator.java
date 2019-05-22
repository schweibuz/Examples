package com.company.work.work.calc;

/**
 * Created by iMac on 25.08.17.
 */
class Calculator {
    public static void main(String[] args) {
        MultyplyOperate multyply = new MultyplyOperate();
        AddOperate add = new AddOperate();
        SubtractOperate subtract = new SubtractOperate();
        DivideOperate divide = new DivideOperate();
        Calculator calculator = new Calculator();

        System.out.println(calculator.getOp1() + multyply.getOperName() + calculator.getOp2() + " = " + multyply.sum(calculator));
        System.out.println(calculator.getOp1() + add.getOperName() + calculator.getOp2() + " = " + add.sum(calculator));
        System.out.println(calculator.getOp1() + subtract.getOperName() + calculator.getOp2() + " = " + subtract.sum(calculator));
        System.out.println(calculator.getOp1() + divide.getOperName() + calculator.getOp2() + " = " + divide.sum(calculator));
    }
    private int op1;
    private int op2;

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public Calculator() {
        setOp1(555);
        setOp2(44);
    }
}
