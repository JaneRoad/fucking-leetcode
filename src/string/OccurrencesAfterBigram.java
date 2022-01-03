package string;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    /**
     * @Author JaneRoad
     * @Description 1078. Bigram 分词
     * @Date 12:45 2021/12/26
     * @Param
     * @param text
     * @param a
     * @param b
     * @return
     * @return java.lang.String[]
     **/
    public String[] findOcurrences(String text, String a, String b) {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {
            if (ss[i].equals(a) && ss[i + 1].equals(b)) list.add(ss[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}
