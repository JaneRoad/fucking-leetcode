package array;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, idx = 0;
        while (idx < n - 1) {
            if (bits[idx] == 0) idx++;
            else idx += 2;
        }
        return idx == n - 1;
    }
}
