package Linear.linkedList;

import java.util.*;

/**
 * 연결리스트가 팰린드롬 구조인지 판별하라
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        for (String value : inputArray) {
            list.add(Integer.parseInt(value));
        }
        boolean answer = solution(list.getFirstNode());
        System.out.println(answer);
    }

    public static boolean solution(Node head) {
        Node fast = head;
        Node slow = head;

        // 런너 기법을 활용하여 중간 지점 찾기
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 노드 개수가 홀수인 경우
        if (fast != null) {
            slow = slow.next;
        }

        // slow가 가리키는 노드부터 마지막 노드를 역순으로 뒤집기
        Node rev = null;
        while (slow != null) {
            Node nextNode = slow.next;
            slow.next = rev;
            rev = slow;
            slow = nextNode;
        }

        // 팰린드롬 판별
        while (rev != null) {
            if (rev.value != head.value) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;
    }

}
