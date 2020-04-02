package tech.xichao.list;

import java.util.Objects;

/**
 * RemoveLastNNode
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author xichao
 * @date 20200402
 */
public class RemoveLastNthNode {

    /**
     * 首先我们将添加一个哑结点作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
     * 我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 nn 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     */
    public <T> ListNode<T> removeLastNthNode(ListNode<T> head, int n) {
        if(Objects.isNull(head)) {
            return null;
        }

        // 定义一个哑结点，来简化某些极端情况
        ListNode<T> dummy = new ListNode<>();
        dummy.next = head;
        ListNode<T> first = dummy;
        ListNode<T> second = dummy;
        //先把 first 指针指到 n+1 的位置，让它与 second 指针相隔 n 个节点
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 同时移动两个指针，直至 first 指针到尾部，此时 second 指针所指向的便是要删除的节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除找到的倒数第 n 个节点
        second.next = second.next.next;
        // 返回链表的第一个元素
        return dummy.next;
    }

    private class ListNode<T> {
        private T data;
        private ListNode<T> next;
    }

}
