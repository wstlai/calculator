package com.ubs.assessment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Calculator to sum up the numbers appeared in a string representation of numbers. For example, "", "1", "1,2", etc.
 *
 * <li>
 *     <ul>Default delimiter of the numbers is ",". This can be override by providing an optional first line with
 *         the format of "//<delimiter>\n<numbers…>".</ul>
 *     <ul>The customized delimiter can be more than one. In such case, the delimiters shall be separated by "|".
 *         The input format should look like "//<delimiter1>|<delimiter2>...\n<numbers...>".</ul>
 *     <ul>The length of the delimiter can be anything greater than or equal to 1.</ul>
 *     <ul>The input numbers must be positives, and cannot be greater than 1000.</ul>
 * </li>
 */
public class StringCalculator {
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 1000;

    /**
     * Adding up the specified string representation of numbers.
     *
     * @param numbers string representations of numbers
     * @return sum of the numbers
     * @throws IllegalArgumentException if the input contains negative integers
     */
    public int add(String numbers) {
        // parsing the numbers
        List<Integer> inputs = InputParser.parse(numbers);

        // check for negatives numbers. if exists, throw exception with the details
        List<Integer> negatives = inputs.stream().filter(i -> i < LOWER_LIMIT).collect(Collectors.toList());
        if(!negatives.isEmpty()) {
            throw new IllegalArgumentException(String.format("negatives not allowed %s", negatives));
        }

        // summing up the integers which are within the upper limit values
        return inputs.stream().filter(i -> i <= UPPER_LIMIT).reduce(0, Integer::sum);
    }
}
