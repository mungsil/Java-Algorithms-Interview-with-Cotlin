package Linear.linkedList;

import java.util.*;

/**
 * 정렬되어 있는 두 연결 리스트를 합쳐라
 * 입력
 * 1-> 2-> 5
 * 1-> 3-> 4
 * 출력
 * 1-> 1-> 2-> 3-> 4-> 5
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        
        String input1 = scanner.nextLine();
        addElementsToList(input1, list1);
        String input2 = scanner.nextLine();
        addElementsToList(input2, list2);

        Node mergedHead = solution2(list1.getFirstNode(), list2.getFirstNode());
        printAnswer(mergedHead);
    }

    private static Node solution1(Node listNode1, Node listNode2) {
        Node dHead = new Node(Integer.MIN_VALUE);
        Node current = dHead;

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.value < listNode2.value) {
                current.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                current.next = listNode2;
                listNode2 = listNode2.next;
            }

            current = current.next;
        }

        if (listNode1 == null) current.next = listNode2;
        if (listNode2 == null) current.next = listNode1;

        return dHead.next;
    }

    //재귀를 이용한 풀이

    private static Node solution2(Node listNode1, Node listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;

        if (listNode1.value < listNode2.value) {
            listNode1.next = solution2(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = solution2(listNode1, listNode2.next);
            return listNode2;
        }
    }


    private static void addElementsToList(String input, SinglyLinkedList list) {
        String[] inputArray = input.split(" ");
        for (String value : inputArray) {
            list.add(Integer.parseInt(value));
        }
    }
    private static void printAnswer(Node mergedHead) {
        while (mergedHead != null) {
            System.out.print(mergedHead.value +" ");
            mergedHead = mergedHead.next;
        }
    }
}
