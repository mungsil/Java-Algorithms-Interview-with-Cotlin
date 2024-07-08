package Linear.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐를 이용한 스택 구현
 * push, pop, top, empty를 구현하라.
 */
public class ImplementStackUsingQueues {
    // 큐의 구현체로 LinkedList 선택
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
