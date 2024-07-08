package Linear.stackAndQueue;


/**
 * 원형 큐를 디자인하라. 큐가 비어 있다면 -1을 리턴하며, 해당 원형 큐의 사용 예는 다음과 같다.
 * https://leetcode.com/problems/design-circular-queue/description/
 */
public class DesignCircularQueue {

    class MyCircularQueue{
        // 원형 큐를 배열로 구현
        int[] q;
        int len = 0, front = 0, rear = -1 ;
        public MyCircularQueue(int k) {
            this.q = new int[k];
        }

        public boolean enQueue(int value) {
            if (!isFull()) {
                rear = (rear + 1) % q.length;
                q[rear] = value;
                len++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % q.length;
                len--;
                return true;
            }
            return false;
        }

        public int Front() {
            return isEmpty() ? -1 : q[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : q[rear];
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return len == q.length;
        }
    }
}
