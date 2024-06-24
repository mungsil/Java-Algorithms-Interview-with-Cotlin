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
            System.out.print(reverseHead.data +" ");
            reverseHead = reverseHead.next;
        }
    }
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next; }
    }

    static class SinglyLinkedList{
        private Node head;

        // 노드 추가
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public Node getFirstNode() {
            return head;
        }

    }
}
