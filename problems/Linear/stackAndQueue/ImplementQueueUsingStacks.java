package Linear.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 스택을 이용해 다음 연산을 지원하는 큐를 구현하라.
 * push, pop, peek, empty
 */
public class ImplementQueueUsingStacks {
    // 삽입 스택
    Deque<Integer> input = new ArrayDeque<>();
    // 추출 스택
    Deque<Integer> output = new ArrayDeque<>();

    public void push(int x) {
        input.push(x);
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
