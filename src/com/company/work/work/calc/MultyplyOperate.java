package com.company.work.work.calc;

/**
 * Created by iMac on 25.08.17.
 */
class MultyplyOperate implements ChOperate {
    @Override
    public String getOperName() {
        return " * ";
    }

    @Override
    public int sum(Calculator calculator) {
        return calculator.getOp1() * calculator.getOp2();
    }
}
