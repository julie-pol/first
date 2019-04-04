package ru.open.exam.test.helper;

import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static int parseStringToInteger(String regexp, String str) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        matcher.find();
        str = matcher.group().replaceAll("\\D","");
        Integer resultCount = Integer.parseInt(str);
        return resultCount;
    }

    public static void assertNotNull(SoftAssert softAssert, Object...fields) {
        Arrays
                .stream(fields)
                .forEach(
                        field->softAssert.assertNotNull(field, "Not all fields are present in JSON"));
    }
}