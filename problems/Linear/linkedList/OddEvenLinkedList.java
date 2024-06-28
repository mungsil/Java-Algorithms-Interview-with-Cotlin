package Linear.linkedList;

import java.util.*;
/**
 * 연결 리스트를 홀수 번째 노드 다음에 짝수 번째 노드가 오도록 재구성하라.
 * 공간 복잡도 O(1), 시간 복잡도 O(n)에 풀이하라.
 * 입력 : 1-> 2-> 3-> 4-> 5
 * 출력 : 1->3-> 5-> 2-> 4-> 6
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        String input = scanner.nextLine();
        for (String value : input.split(" ")) {
            list.add(Integer.parseInt(value));
        }
        Node head = solution(list.getFirstNode());
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static Node solution(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

/**
 * even != null: 짝수 번째 노드가 존재하는지 확인하여, 리스트의 길이가 홀수일 때, 마지막 짝수 노드가 null이 되는 상황에서 NPE를 방지.
 * even.next != null: 현재 짝수 노드의 다음 노드(다음 홀수 노드)가 존재하는지 확인하여, 리스트의 길이가 짝수일 때, NPE를 방지.
 */
        while (even != null && even.next != null ) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
