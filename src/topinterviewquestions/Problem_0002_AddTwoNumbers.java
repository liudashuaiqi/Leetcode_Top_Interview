package topinterviewquestions;
//ac
//注意一些边界条件，链表为空的时候，取值为1，且不再跳下一个节点
//每次都要加上上一次的进位，还得算出当前的进位
public class Problem_0002_AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value) {
            this.val = value;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int n1 = 0;
        int n2 = 0;
        int n;
        int ca = 0;
        ListNode pre = null;
        ListNode node = null;
        ListNode c1 = head1;
        ListNode c2 = head2;
        while(c1!=null||c2!=null){
            n1 = c1==null? 0:c1.val;
            n2 = c2==null? 0:c2.val;
            n = n1+n2+ca;
            pre = node;
            node = new ListNode(n%10);
            node.next = pre;
            ca = n/10;
            c1 = c1==null? null:c1.next;
            c2 = c2==null? null:c2.next;
        }
        if(ca == 1){
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return reverseList(node);
    }
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
