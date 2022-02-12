package twoPointers;

public class ReversePrefixOfWord {
    /**
     * @Author JaneRoad
     * @Description 2000. 反转单词前缀
     * @Date 00:34 2022/2/4
     * @Param
     * @param word
     * @param ch
     * @return
     * @return java.lang.String
     **/
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index >= 0) {
            char[] arr = word.toCharArray();
            int left = 0, right = index;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            word = new String(arr);
        }
        return word;
    }
}
