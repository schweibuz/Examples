package com.company.exception;

/**
 * Created by iMac on 05/12/2017.
 */
public class DelenieNaNol extends NullPointerException {
    public DelenieNaNol(String s) {
        System.out.println(s);
    }
}
