
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

class Solution {

    static LinkedListNode<Integer> head = new LinkedListNode<>(-1);
    static LinkedListNode<Integer> tail = head;

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

        if (root == null)
            return null;

        constructLinkedList(root.left);

        tail.next = new LinkedListNode<>(root.data);
        tail = tail.next;

        constructLinkedList(root.right);

        return head.next;
    }
}