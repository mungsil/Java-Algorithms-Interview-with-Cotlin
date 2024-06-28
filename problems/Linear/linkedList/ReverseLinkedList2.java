package Linear.linkedList;

import java.util.*;

/**
 * 위치 left에서 right까지를 역순으로 만들어라. 위치는 1부터 시작한다.
 * 입력: 1-> 2-> 3-> 4-> 5-> 6, left = 2, right = 5
 * 출력: 1-> 5-> 4-> 3-> 2-> 6
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        String input = scanner.nextLine();
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        for (String value : input.split(" ")) {
            list.add(Integer.parseInt(value));
        }
        Node revNode = solution(list.getFirstNode(), left, right);
        while (revNode != null) {
            System.out.print(revNode.value + " ");
            revNode = revNode.next;
        }
    }

    private static Node solution(Node head, int left, int right) {
        // left 직전 노드로, 위치가 변경되는 노드들 이전 노드임.
        Node start = new Node(0);
        start.next = head;
        // 정답 리스트 이전 노드를 가리킴
        Node root = start;
        // 초기에는 left가 가리키는 노드의 위치로 지정, 변경이 필요한 노드 범위 내에서 마지막 순서가 됨.
        Node end = null;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        end = start.next;

        for (int i = 0; i < right - left; i++) {
            Node nextTemp = end.next.next;
            end.next.next = start.next;
            start.next = end.next;
            end.next = nextTemp;
        }
        return root.next;
    }
}
