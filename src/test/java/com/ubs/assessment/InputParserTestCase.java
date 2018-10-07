package com.ubs.assessment;

import java.util.Arrays;
import java.util.List;

public enum InputParserTestCase {
    EMPTY_STRING("", Arrays.asList(0)),
    ONE_NUMBER("1", Arrays.asList(1)),
    TWO_NUMBERS("1,2", Arrays.asList(1,2)),
    UNKNOWN_AMOUNT_NUMBERS("3,2,1,20,150,99,50,1000,1001,2000", Arrays.asList(3,2,1,20,150,99,50,1000,1001,2000)),
    NEW_LINE_DELIMITER("1\n2,3", Arrays.asList(1,2,3)),
    ADJACENT_DELIMITERS("1,\n", NumberFormatException.class),
    DIFF_DELIMITER_EMPTY_STRING("//;\n", Arrays.asList(0)),
    DIFF_DELIMITER_ONE_NUMBER("//;\n1", Arrays.asList(1)),
    DIFF_DELIMITER_TWO_NUMBERS("//;\n1;2", Arrays.asList(1,2)),
    DIFF_DELIMITER_UNKNOWN_AMOUNT_NUMBERS("//;\n3;2;1;20;150;99;50;1000;1001;2000", Arrays.asList(3,2,1,20,150,99,50,1000,1001,2000)),
    DIFF_DELIMITER_NEW_LINE_DELIMITER("//;\n1\n2;3", Arrays.asList(1,2,3)),
    DIFF_DELIMITER_ADJACENT_DELIMITERS("//;\n1;\n", NumberFormatException.class),
    DELIMITER_ANY_LENGTH_EMPTY_STRING("//***\n", Arrays.asList(0)),
    DELIMITER_ANY_LENGTH_ONE_NUMBER("//***\n1", Arrays.asList(1)),
    DELIMITER_ANY_LENGTH_TWO_NUMBERS("//***\n1***2", Arrays.asList(1,2)),
    DELIMITER_ANY_LENGTH_UNKNOWN_AMOUNT_NUMBERS("//***\n3***2***1***20***150***99***50***1000***1001***2000", Arrays.asList(3,2,1,20,150,99,50,1000,1001,2000)),
    DELIMITER_ANY_LENGTH_WITH_NEW_LINE_DELIMITER("//***\n1\n2***3", Arrays.asList(1,2,3)),
    DELIMITER_ANY_LENGTH_WITH_ADJACENT_DELIMITERS("//***\n1***\n", NumberFormatException.class),
    MULTI_DELIMITERS_EMPTY_STRING("//*|%\n", Arrays.asList(0)),
    MULTI_DELIMITERS_ONE_NUMBER("//*|%\n1", Arrays.asList(1)),
    MULTI_DELIMITERS_TWO_NUMBERS_1("//*|%\n1*2", Arrays.asList(1,2)),
    MULTI_DELIMITERS_TWO_NUMBERS_2("//*|%\n1%2", Arrays.asList(1,2)),
    MULTI_DELIMITERS_UNKNOWN_AMOUNT_NUMBERS("//*|%\n3*2%1%20%150*99%50*1000*1001*2000", Arrays.asList(3,2,1,20,150,99,50,1000,1001,2000)),
    MULTI_DELIMITERS_NEW_LINE_DELIMITER_1("//*|%\n1\n2*3", Arrays.asList(1,2,3)),
    MULTI_DELIMITERS_NEW_LINE_DELIMITER_2("//*|%\n1\n2%3", Arrays.asList(1,2,3)),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_1("//*|%\n1*\n", NumberFormatException.class),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_2("//*|%\n1%\n", NumberFormatException.class),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_3("//*|%\n1*%", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_EMPTY_STRING("//..|????\n", Arrays.asList(0)),
    MULTI_DELIMITERS_ANY_LENGTH_ONE_NUMBER("//..|????\n1", Arrays.asList(1)),
    MULTI_DELIMITERS_ANY_LENGTH_TWO_NUMBERS_1("//..|????\n1..2", Arrays.asList(1,2)),
    MULTI_DELIMITERS_ANY_LENGTH_TWO_NUMBERS_2("//..|????\n1????2", Arrays.asList(1,2)),
    MULTI_DELIMITERS_ANY_LENGTH_UNKNOWN_AMOUNT_NUMBERS("//..|????\n3..2????1????20????150..99????50..1000..1001..2000", Arrays.asList(3,2,1,20,150,99,50,1000,1001,2000)),
    MULTI_DELIMITERS_ANY_LENGTH_NEW_LINE_DELIMITER_1("//..|????\n1\n2..3", Arrays.asList(1,2,3)),
    MULTI_DELIMITERS_ANY_LENGTH_NEW_LINE_DELIMITER_2("//..|????\n1\n2????3", Arrays.asList(1,2,3)),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_1("//..|????\n1..\n", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_2("//..|????\n1????\n", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_3("//..|????\n1..????", NumberFormatException.class);

    private final String input;
    private final List<Integer> expectedOutput;
    private final Class<? extends Throwable> expectedThrowableClass;

    InputParserTestCase(String input, List<Integer> expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.expectedThrowableClass = null;
    }

    InputParserTestCase(String input, Class<? extends Throwable> expectedThrowableClass) {
        this.input = input;
        this.expectedOutput = null;
        this.expectedThrowableClass = expectedThrowableClass;
    }

    public String getInput() {
        return input;
    }

    public List<Integer> getExpectedOutput() {
        return expectedOutput;
    }

    public Class<? extends Throwable> getExpectedThrowableClass() {
        return expectedThrowableClass;
    }


}
