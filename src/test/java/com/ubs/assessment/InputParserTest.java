package com.ubs.assessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    public void runTestCases() {
        for (InputParserTestCase testCase : InputParserTestCase.values()) {
            if (testCase.getExpectedThrowableClass() == null) {
                Assertions.assertIterableEquals(testCase.getExpectedOutput(), InputParser.parse(testCase.getInput()), testCase.name());
            } else {
                Assertions.assertThrows(testCase.getExpectedThrowableClass(), () -> InputParser.parse(testCase.getInput()), testCase.name());
            }
        }
    }
}
