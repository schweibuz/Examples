package com.from4.junit.tf;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JUnitTwoTest.class,
        JUnitOneTest.class,
        MessageUtilTest.class
})
public class JUnitTestSuite {

}
