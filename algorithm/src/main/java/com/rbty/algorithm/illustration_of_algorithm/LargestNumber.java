package com.rbty.algorithm.illustration_of_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 179. 最大数
 * @date 2021/4/12 9:25
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        return Arrays.stream(nums).boxed().map(Objects::toString)
                .sorted((a, b) -> {return (a+b).compareTo(b+a);})
                .reduce(String::concat)
                .filter(s -> !s.startsWith("0"))
                .orElse("0");
    }
}
