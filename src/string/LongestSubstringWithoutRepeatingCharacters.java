package string;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * @author janeroad
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // 记录要求的字符串所有字符count 以及 滑动窗口window中 字符与个数的映射关系
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // 双指针
        int left = 0;
        int right = 0;
        int count = 0;


        while (right < s.length()) {
            //curChar 进入窗口的当前字符
            char curChar = s.charAt(right);
            //扩大窗口
            right++;
            windowMap.put(curChar, windowMap.getOrDefault(curChar, 0) + 1);

            // 出现重复字符
            while (windowMap.getOrDefault(curChar, 0) > 1) {
                // removeChar 是将移出窗口的字符
                char removeChar = s.charAt(left);
                // 缩小窗口
                left++;
                windowMap.put(removeChar, windowMap.get(removeChar) - 1);
            }
            // 在这里更新答案
            count = Math.max(count, right - left);
        }
        return count;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l  = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }

}
