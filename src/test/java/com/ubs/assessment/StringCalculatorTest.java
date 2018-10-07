package com.ubs.assessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void runTestCases() {
        StringCalculator calculator = new StringCalculator();

        for (StringCalculatorTestCase testCase : StringCalculatorTestCase.values()) {
            if (testCase.getExpectedThrowableClass() == null) {
                Assertions.assertEquals(testCase.getExpectedOutput(), Integer.valueOf(calculator.add(testCase.getInput())), testCase.name());

            } else {
                if(testCase.getExpectedThrowableMessage() == null) {
                    Assertions.assertThrows(testCase.getExpectedThrowableClass(), () -> calculator.add(testCase.getInput()), testCase.name());

                } else {
                    try {
                        calculator.add(testCase.getInput());
                    } catch (Exception ex) {
                        Assertions.assertEquals(testCase.getExpectedThrowableClass(), ex.getClass(), testCase.name());
                        Assertions.assertEquals(testCase.getExpectedThrowableMessage(), ex.getMessage(), testCase.name());
                    }
                }
            }
        }
    }
}
