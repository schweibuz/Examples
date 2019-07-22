package com.from4.interviewQuestions.core.relationship.chapter3;

import java.util.Arrays;
import java.util.List;

class Exceptions {
    public static void main(String[] args) {

        RegistrationService service = new RegistrationService();
        try {
            System.out.println("Try");
            service.validateEmail("abc@gmail.com");
        } catch (Exception e) {
            System.out.println("Catch ex");
        } finally {
            service.validateEmail("abc@gmail.com");
            System.out.println("Finally");
        }

    }
}

class RegistrationService {
    List<String> registrationEmails = Arrays.asList("abc@gmail.com", "xyz@gmail.com");

    public void validateEmail(String email) throws MyUncheckedException {
        if (registrationEmails.contains(email)) {
            throw new MyUncheckedException("Email already registered");
        }
    }
}

class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(String message) {
        super(message);
    }
}