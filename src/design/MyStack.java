package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/3/3 15:46
 */
public class MyStack {
    /**
     * 队列
     */
    Queue<Integer> queue = new LinkedList<>();
    int topElem = 0;

    /**
     * 添加元素到栈顶
     */
    public void push(int x) {
        // x 是队列的队尾，是栈的栈顶
        queue.offer(x);
        topElem = x;
    }

    /**
     * 返回栈顶元素
     */
    public int top() {
        return topElem;
    }

    /**
     * 删除栈顶的元素并返回
     * 栈遵循 "last in, first out"（LIFO）原则，而队列遵循 "first in, first out"（FIFO）原则。所以，我们需要一些额外的步骤来模拟栈的行为。
     * pop()方法要求从栈顶删除元素并返回。在队列中，我们没有直接访问队尾元素的操作，所以我们可以通过以下方法来实现：我们通过不断将队列头部元素出队并马上重新入队（利用queue.offer(queue.poll())操作），使得队尾元素向队列头部方式移动。
     * 初始队列状态是： [1, 2, 3, 4] （1在队头，4在队尾）
     * 当size > 2时，我们去除队头元素并添加到队尾，循环结束后队列变为 [3, 4, 1, 2]
     * 我们记下当前队头元素3为栈顶元素（因为3是最近添加到队列的元素），然后将3从队头移除并添加到队尾，此时队列变为 [4, 1, 2, 3]
     * 最后，我们移除并返回当前队列的队头元素4，这样我们就删除并返回了原队尾元素4（也就是栈顶元素）。
     * 经过这样的操作，我们保证了栈 "last in, first out"（LIFO）的行为特性。
     */
    public int pop() {
        int size = queue.size();
        // 留下队尾 2 个元素
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        // 记录新的队尾元素
        topElem = queue.peek();
        queue.offer(queue.poll());
        // 删除之前的队尾元素
        return queue.poll();
    }

    /**
     * 判断栈是否为空
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
    }
}
