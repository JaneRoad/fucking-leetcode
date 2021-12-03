package hashTable;

public class RansomNote {
    /**
     * @Author JaneRoad
     * @Description 383. 赎金信
     * @Date 01:18 2021/12/4
     * @Param
     * @param ransomNote
     * @param magazine
     * @return
     * @return boolean
     **/
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
