package com.rbty.algorithm.illustration_of_algorithm;

import java.util.HashMap;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 3. 无重复字符的最长子串
 * @date 2021/4/7 16:43
 */
public class longestSubstringWithoutRepeatingCharacters {
    /** 
     * @description: HashMap 记录字符以及位置，滑动窗口
     * @param: [s] 
     * @return: int
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
