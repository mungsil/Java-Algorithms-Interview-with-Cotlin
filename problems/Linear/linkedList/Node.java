package Linear.linkedList;

public class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next; }
}
