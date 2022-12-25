package slidingWindow;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * @author janeroad
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        // 记录要求的字符串所有字符count 以及 滑动窗口window中 字符与个数的映射关系
        HashMap<Character, Integer> windowMap = new HashMap<>();
        HashMap<Character, Integer> needMap = new HashMap<>();
        //把要求的字符串所有字符记下来
        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            needMap.put(c1, needMap.getOrDefault(c1, 0) + 1);
        }
        // 双指针
        int left, right, count;
        left = right = count = 0;

        while (right < s2.length()) {
            //curChar 进入窗口的当前字符
            char curChar = s2.charAt(right);
            //扩大窗口
            right++;
            // 如果进入窗口的字符是所需要的字符，进行窗口内的字符更新
            if (needMap.containsKey(curChar)) {
                windowMap.put(curChar, windowMap.getOrDefault(curChar, 0) + 1);
                if (windowMap.get(curChar).equals(needMap.get(curChar))) {
                    count++;
                }
            }

            // 判断左侧窗口是否要收缩 收缩window的长度
            while (right - left == s1.length()) {

                
                if (count == needMap.size()){
                    return true;
                }

                // removeChar 是将移出窗口的字符
                char removeChar = s2.charAt(left);
                // 缩小窗口
                left++;
                // 如果移出窗口的字符是所需要的字符，进行窗口内的字符更新
                if (needMap.containsKey(removeChar)) {
                    if (windowMap.get(removeChar).equals(needMap.get(removeChar))) {
                        count--;
                    }
                    windowMap.put(removeChar, windowMap.getOrDefault(removeChar, 0) - 1);
                }
            }
        }
        return false;
    }
}
