package Linear.linkedList;

import java.util.*;

/**
 * 역순으로 저장된 연결 리스트의 숫자를 더하라.
 * 입력 ( 2-> 4-> 3) + (5 -> 6 -> 2)
 * 설명 342 + 265 = 607
 * 출력 7-> 0-> 6
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        
        addElementsToList(input1, list1);
        addElementsToList(input2, list2);

        Node answer = solution(list1.getFirstNode(), list2.getFirstNode());
        while (answer != null) {
            System.out.print(answer.data + " ");
            answer = answer.next;
        }
    }

    /**
     * 전가산기 원리 활용 풀이
     */
    private static Node solution(Node listNode1, Node listNode2) {
        // 자리올림수
        int carry = 0;
        // 나머지
        int remainder;

        // 임시 노드로 아무 값 생성
        Node root = new Node(0);
        Node current = root;

        while (listNode1 != null || listNode2 != null || carry > 0) {
            int sum = 0;

            if (listNode1 != null){
                sum = sum + listNode1.data;
                listNode1 = listNode1.next;
            }

            if (listNode2 != null){
                sum = sum + listNode2.data;
                listNode2 = listNode2.next;

            }

            remainder = (carry + sum) % 10;
            carry = (carry + sum / 10);

            current.next = new Node(remainder);
            current = current.next;
        }

        return root.next;
    }

    private static void addElementsToList(String input, SinglyLinkedList list) {
        String[] inputArray = input.split(" ");
        for (String value : inputArray) {
            list.add(Integer.parseInt(value));
        }
    }
    
    static class Node {
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
