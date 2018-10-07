package com.ubs.assessment;


public enum StringCalculatorTestCase {
    EMPTY_STRING("", 0),
    ONE_NUMBER("1", 1),
    TWO_NUMBERS("1,2", 3),
    UNKNOWN_AMOUNT_NUMBERS("3,2,1,20,150,99,50,1000", 1325),
    NEW_LINE_DELIMITER("1\n2,3", 6),
    ADJACENT_DELIMITERS("1,\n", NumberFormatException.class),
    NEGATIVE_NUMBERS_EXCEPTION_1("1,2,-3,4", IllegalArgumentException.class, "negatives not allowed [-3]"),
    NEGATIVE_NUMBERS_EXCEPTION_2("1,-2,-3,-4", IllegalArgumentException.class, "negatives not allowed [-2, -3, -4]"),
    EXCLUDE_BIG_NUMBER("999,1000,1001,2000", 1999),
    DIFF_DELIMITER_EMPTY_STRING("//;\n", 0),
    DIFF_DELIMITER_ONE_NUMBER("//;\n1", 1),
    DIFF_DELIMITER_TWO_NUMBERS("//;\n1;2", 3),
    DIFF_DELIMITER_UNKNOWN_AMOUNT_NUMBERS("//;\n3;2;1;20;150;99;50;1000", 1325),
    DIFF_DELIMITER_NEW_LINE_DELIMITER("//;\n1\n2;3", 6),
    DIFF_DELIMITER_ADJACENT_DELIMITERS("//;\n1,\n", NumberFormatException.class),
    DIFF_DELIMITER_NEGATIVE_NUMBERS_EXCEPTION_1("//;\n1;2;-3;4", IllegalArgumentException.class, "negatives not allowed [-3]"),
    DIFF_DELIMITER_NEGATIVE_NUMBERS_EXCEPTION_2("//;\n1;-2;-3;-4", IllegalArgumentException.class, "negatives not allowed [-2, -3, -4]"),
    DIFF_DELIMITER_EXCLUDE_BIG_NUMBER("//;\n999;1000;1001;2000", 1999),
    DELIMITER_ANY_LENGTH_EMPTY_STRING("//***\n", 0),
    DELIMITER_ANY_LENGTH_ONE_NUMBER("//***\n1", 1),
    DELIMITER_ANY_LENGTH_TWO_NUMBERS("//***\n1***2", 3),
    DELIMITER_ANY_LENGTH_UNKNOWN_AMOUNT_NUMBERS("//***\n3***2***1***20***150***99***50***1000", 1325),
    DELIMITER_ANY_LENGTH_WITH_NEW_LINE_DELIMITER("//***\n1\n2***3", 6),
    DELIMITER_ANY_LENGTH_WITH_ADJACENT_DELIMITERS("//***\n1***\n", NumberFormatException.class),
    DELIMITER_ANY_NEGATIVE_NUMBERS_EXCEPTION_1("//***\n1***2***-3***4", IllegalArgumentException.class, "negatives not allowed [-3]"),
    DELIMITER_ANY_NEGATIVE_NUMBERS_EXCEPTION_2("//***\n1***-2***-3***-4", IllegalArgumentException.class, "negatives not allowed [-2, -3, -4]"),
    DELIMITER_ANY_EXCLUDE_BIG_NUMBER("//***\n999***1000***1001***2000", 1999),
    MULTI_DELIMITERS_EMPTY_STRING("//*|%\n", 0),
    MULTI_DELIMITERS_ONE_NUMBER("//*|%\n1", 1),
    MULTI_DELIMITERS_TWO_NUMBERS_1("//*|%\n1*2", 3),
    MULTI_DELIMITERS_TWO_NUMBERS_2("//*|%\n1%2", 3),
    MULTI_DELIMITERS_UNKNOWN_AMOUNT_NUMBERS("//*|%\n3*2%1%20%150*99%50*1000*1001*2000", 1325),
    MULTI_DELIMITERS_NEW_LINE_DELIMITER_1("//*|%\n1\n2*3", 6),
    MULTI_DELIMITERS_NEW_LINE_DELIMITER_2("//*|%\n1\n2%3", 6),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_1("//*|%\n1*\n", NumberFormatException.class),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_2("//*|%\n1%\n", NumberFormatException.class),
    MULTI_DELIMITERS_ADJACENT_DELIMITERS_3("//*|%\n1*%", NumberFormatException.class),
    MULTI_DELIMITERS_NEGATIVE_NUMBERS_EXCEPTION_1("//*|%\n1%2*-3*4", IllegalArgumentException.class, "negatives not allowed [-3]"),
    MULTI_DELIMITERS_NEGATIVE_NUMBERS_EXCEPTION_2("//*|%\n1*-2%-3*-4", IllegalArgumentException.class, "negatives not allowed [-2, -3, -4]"),
    MULTI_DELIMITERS_EXCLUDE_BIG_NUMBER("//*|%\n999*1000%1001%2000", 1999),
    MULTI_DELIMITERS_ANY_LENGTH_EMPTY_STRING("//..|????\n", 0),
    MULTI_DELIMITERS_ANY_LENGTH_ONE_NUMBER("//..|????\n1", 1),
    MULTI_DELIMITERS_ANY_LENGTH_TWO_NUMBERS_1("//..|????\n1..2", 3),
    MULTI_DELIMITERS_ANY_LENGTH_TWO_NUMBERS_2("//..|????\n1????2", 3),
    MULTI_DELIMITERS_ANY_LENGTH_UNKNOWN_AMOUNT_NUMBERS("//..|????\n3..2????1????20????150..99????50..1000", 1325),
    MULTI_DELIMITERS_ANY_LENGTH_NEW_LINE_DELIMITER_1("//..|????\n1\n2..3", 6),
    MULTI_DELIMITERS_ANY_LENGTH_NEW_LINE_DELIMITER_2("//..|????\n1\n2????3", 6),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_1("//..|????\n1..\n", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_2("//..|????\n1????\n", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_ADJACENT_DELIMITERS_3("//..|????\n1..????", NumberFormatException.class),
    MULTI_DELIMITERS_ANY_LENGTH_NEGATIVE_NUMBERS_EXCEPTION_1("//..|????\n1????2..-3..4", IllegalArgumentException.class, "negatives not allowed [-3]"),
    MULTI_DELIMITERS_ANY_LENGTH_NEGATIVE_NUMBERS_EXCEPTION_2("//..|????\n1..-2????-3..-4", IllegalArgumentException.class, "negatives not allowed [-2, -3, -4]"),
    MULTI_DELIMITERS_ANY_LENGTH_EXCLUDE_BIG_NUMBER("//..|????\n999..1000..1001????2000", 1999);

    private final String input;
    private final Integer expectedOutput;
    private final Class<? extends Throwable> expectedThrowableClass;
    private final String expectedThrowableMessage;

    StringCalculatorTestCase(String input, Integer expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.expectedThrowableClass = null;
        this.expectedThrowableMessage = null;
    }

    StringCalculatorTestCase(String input, Class<? extends Throwable> expectedThrowableClass) {
        this.input = input;
        this.expectedOutput = null;
        this.expectedThrowableClass = expectedThrowableClass;
        this.expectedThrowableMessage = null;
    }

    StringCalculatorTestCase(String input, Class<? extends Throwable> expectedThrowableClass, String expectedThrowableMessage) {
        this.input = input;
        this.expectedOutput = null;
        this.expectedThrowableClass = expectedThrowableClass;
        this.expectedThrowableMessage = expectedThrowableMessage;
    }

    public String getInput() {
        return input;
    }

    public Integer getExpectedOutput() {
        return expectedOutput;
    }

    public Class<? extends Throwable> getExpectedThrowableClass() {
        return expectedThrowableClass;
    }

    public String getExpectedThrowableMessage() {
        return expectedThrowableMessage;
    }
}
