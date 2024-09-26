package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 2306. 公司命名
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/25 07:58
 */
public class NamingACompany {
    public long distinctNames(String[] ideas) {
        // 创建一个数组，每个元素是一个集合，用来存储以不同字母开头的字符串的后缀
        Set<String>[] suffixesByFirstChar = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            suffixesByFirstChar[i] = new HashSet<>();
        }

        // 遍历每个 idea，将首字母作为索引，把后缀存储到对应的集合中
        for (String idea : ideas) {
            char firstChar = idea.charAt(0);  // 获取首字母
            String suffix = idea.substring(1);  // 获取后缀
            suffixesByFirstChar[firstChar - 'a'].add(suffix);  // 存入对应首字母的集合
        }

        long count = 0;

        // 遍历所有不同的首字母对组合 (i, j)，并且只计算 i < j 的组合
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                Set<String> set1 = suffixesByFirstChar[i];  // 第一个集合
                Set<String> set2 = suffixesByFirstChar[j];  // 第二个集合
                long commonCount = 0;

                // 计算两个集合中有多少共同的后缀
                for (String suffix : set1) {
                    if (set2.contains(suffix)) {
                        commonCount++;
                    }
                }

                // 计算当前首字母组合下的唯一配对数，并将其乘以 2（因为 i 和 j 是对称的组合）
                count += (set1.size() - commonCount) * (set2.size() - commonCount) * 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NamingACompany().distinctNames(new String[]{"aaa","baa","caa","bbb","cbb","dbb"}));
    }
}
