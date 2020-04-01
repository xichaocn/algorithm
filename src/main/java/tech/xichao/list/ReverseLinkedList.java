package tech.xichao.list;

import java.util.Objects;

/**
 * 链表翻转
 *
 * @author xichao
 * @date 20200328
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        node.data = 1;
        node.next = new Node<>();
        node.next.data = 2;
        node.next.next = new Node<>();
        node.next.next.data = 3;
        node.next.next.next = new Node<>();
        node.next.next.next.data = 4;
        node.next.next.next.next = new Node<>();
        node.next.next.next.next.data = 5;
        toString(node);
        toString(reverse(node));

    }

    private static <T> void toString(Node<T> head) {
        if (Objects.isNull(head)) {
            return;
        }

        while (Objects.nonNull(head)) {
            System.out.print(head.data);
            System.out.print(",");
            head = head.next;
        }
        System.out.println();
    }

    private static <T> Node<T> reverse(Node<T> head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        Node<T> preNode = null;
        Node<T> nextNode = null;
        while (Objects.nonNull(head)) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }

        return preNode;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }

    }

}
