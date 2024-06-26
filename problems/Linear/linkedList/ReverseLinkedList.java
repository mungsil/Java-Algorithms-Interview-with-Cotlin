package Linear.linkedList;

import java.util.*;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        for (String value : inputArr) {
            list.add(Integer.parseInt(value));
        }

        Node reverseList = solution2(list.getFirstNode());
        printAnswer(reverseList);
    }

    // 반복을 이용한 풀이
    public static Node solution1(Node listNode) {
        Node rHead = null;
        while (listNode != null) {
            Node next = listNode.next;
            listNode.next = rHead;
            rHead = listNode;
            listNode = next;
        }
        return rHead;
    }

    // 재귀를 이용한 풀이
    public static Node solution2(Node listNode) {
        return reverse(listNode, null);
    }

    public static Node reverse(Node listNode, Node prev) {
        if (listNode == null) {
            return prev;
        }
        Node next = listNode.next;
        listNode.next = prev;
//        prev = listNode;
//        listNode = next;
        return reverse(next, listNode);
    }

    private static void printAnswer(Node reverseHead) {
        while (reverseHead != null) {
            System.out.print(reverseHead.value +" ");
            reverseHead = reverseHead.next;
        }
    }
}
