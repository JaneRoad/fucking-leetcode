package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 769. 最多能完成排序的块
 * @author janeroad
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque = new ArrayDeque();
        for (int item : arr) {
            //如果堆栈为空，则直接入栈
            if (deque.isEmpty()) {
                deque.addLast(item);
            }
            //如果item指定的元素大于top元素，则将其执行入栈操作
            if (deque.peekLast() < item) {
                deque.addLast(item);
            //除了栈顶top之外，如果item指定的元素小于堆栈中的元素，则将堆栈中的那个元素“踢出”堆栈
            } else {
                int top = deque.removeLast();
                while (!deque.isEmpty()) {
                    if (deque.peekLast() < item) {
                        break;
                    }
                    deque.removeLast();
                }
                deque.addLast(top);
            }
        }
        return deque.size();
    }
}
