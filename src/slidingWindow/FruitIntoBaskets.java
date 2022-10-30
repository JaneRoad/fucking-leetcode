package slidingWindow;

/**
 * 904. 水果成篮
 * @author janeroad
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int[] pickRecords = new int[fruits.length];
        int result = 0, startIndex = 0, diffIndex = 0, pickNums = 0, curFruit = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (pickRecords[fruits[i]] == 0) {
                if (pickNums == 2) {
                    result = Math.max(result, i - startIndex);
                    // 将水果设置为“未被选择”
                    pickRecords[fruits[diffIndex - 1]] = 0;
                    // 记录“窗口”的开始index
                    startIndex = diffIndex;
                    // 已选择的水果种类-1
                    pickNums--;
                }
                // 已选择的水果种类+1
                pickNums++;
                // 将水果设置为“被选择”
                pickRecords[fruits[i]] = 1;
            }
            if (curFruit != fruits[i]) {
                // 当前水果类型
                curFruit = fruits[i];
                // 记录水果类型变换时的index
                diffIndex = i;
            }
        }
        return Math.max(result, fruits.length - startIndex);
    }
}
