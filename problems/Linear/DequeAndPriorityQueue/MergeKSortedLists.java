package Linear.DequeAndPriorityQueue;

import Linear.linkedList.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * K개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라.
 * 입력: lists = [[1,4,5],[1,3,4],[2,6]]
 *
 * 3
 * 1 4 5
 * 1 3 4
 * 2 6
 *
 * 출력: [1,1,2,3,4,4,5,6]
 */
public class MergeKSortedLists {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        Node[] lists = new Node[n];
        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Node root = new Node(0);
            Node tail = root;
            for (int j : array) {
                tail.next = new Node(j);
                tail = tail.next;
            }
            lists[i] = root.next;
        }

        Node mergedList = solution(lists);
        printList(mergedList);
    }
    private static Node solution(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.value == o2.value) {
                return 0;
            } else if (o1.value > o2.value) {
                return 1;
            } else {
                return -1;
            }
        });

        Node root = new Node(0);
        Node tail = root;

        for (Node list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (pq.peek() != null) { //혹은 !pq.isEmpty()
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null){
                pq.add(tail.next);
            }
        }

        return root.next;
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
