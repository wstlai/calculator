package com.ubs.assessment;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This is a parser utility class to parse the String Calculator inputs, and return a list of Integers which appeared
 * in the input string.
 */
public class InputParser {
    private static final String DELIMITER_SEPARATOR = "|";
    private static final String DEFAULT_DELIMITER = ",";
    private static final Set<String> FIXED_DELIMITER_SET = Sets.newHashSet("\n");
    private static final String INPUT_STRING_REGEX = "^(//(.*?)\n)?(.*)$";
    private static final Pattern INPUT_PATTERN = Pattern.compile(INPUT_STRING_REGEX, Pattern.DOTALL);

    /**
     * Parsing the specified input string
     * @param inputString calculator input string
     * @return a list of Integers which appeared in the input string
     */
    public static List<Integer> parse(String inputString) {
        Matcher matcher = INPUT_PATTERN.matcher(inputString);

        if (matcher.find()) {
            String numbersStr = matcher.group(3);
            if (numbersStr.equals("")) {
                return Lists.newArrayList(0);
            }

            String delimitersStr = matcher.group(2);
            Set<String> delimiterSet = getDelimiterSet(delimitersStr);

            return parseNumbersString(numbersStr, delimiterSet);
        } else {
            throw new IllegalArgumentException(String.format("Invalid input - %s", inputString));
        }
    }

    private static Set<String> getDelimiterSet(String delimitersStr) {
        HashSet<String> delimiterSet = (delimitersStr == null) ?
                Sets.newHashSet(DEFAULT_DELIMITER) :
                Sets.newHashSet(StringUtils.split(delimitersStr, DELIMITER_SEPARATOR));

        delimiterSet.addAll(FIXED_DELIMITER_SET);
        return delimiterSet;
    }

    private static List<Integer> parseNumbersString(String targetStr, Set<String> delimiterSet) {
        List<String> splittedResultList = splitString(targetStr, delimiterSet);
        return splittedResultList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    }

    private static List<String> splitString(String str, Set<String> delimiterSet) {
        String pattern = delimiterSet.stream().map(Pattern::quote).collect(Collectors.joining("|"));
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(pattern);

        ArrayList<String> resultList = Lists.newArrayList();
        while (scanner.hasNext()) {
            resultList.add(scanner.next());
        }
        return resultList;
    }
}
