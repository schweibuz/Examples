package com.from4.junit;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}
