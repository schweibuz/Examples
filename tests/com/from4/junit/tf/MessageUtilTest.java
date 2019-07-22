package com.from4.junit.tf;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Ignore
public class MessageUtilTest {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    void printMessage() {
        System.out.println("Inside testPrintMessage()");
        assertEquals(message, messageUtil.printMessage());
    }

    @Test
    void salutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi " + "Robert";
        assertEquals(message, messageUtil.salutationMessage());
    }
}