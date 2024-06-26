package Linear.linkedList;

import java.util.*;
/**
 * 연결 리스트를 입력 받아 페어 단위로 스왑하라
 * 입력 1-> 2-> 3-> 4-> 5-> 6
 * 출력 2-> 1-> 4-> 3-> 6-> 5
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        for (String value : inputArr) {
            list.add(Integer.parseInt(value));
        }

        Node swapNode = solution3(list.getFirstNode());
        while (swapNode != null) {
            System.out.print(swapNode.value + " ");
            swapNode = swapNode.next;
        }
    }

    // 값만 스왑하기 (약간 야매)
    public static Node solution1(Node listNode) {
        Node head = listNode;
        while (listNode != null && listNode.next != null) {
            int next = listNode.next.value;
            listNode.next.value = listNode.value;
            listNode.value = next;
            listNode = listNode.next.next;
        }
        return head;
    }

    // 반복을 이용해서 진짜로 스왑하기
    public static Node solution2(Node listNode) {
        //임시노드 선언
        Node node = new Node(0);
        Node swapNode = node;
        node.next = listNode;
        while (node != null && node.next!= null && node.next.next != null) {
            node.next = node.next.next;
            Node tempNode = node.next.next;
            node.next.next = listNode;
            listNode.next = tempNode;
            node = node.next.next;
            listNode = listNode.next;
        }
        return swapNode.next;
    }

    // 재귀 구조로 스왑하기
    public static Node solution3(Node node) {
        if (node != null && node.next != null) {
            Node p = node.next;
            node.next = solution3(p.next);
            p.next = node;
            return p;
        }
        return node;
    }

}
