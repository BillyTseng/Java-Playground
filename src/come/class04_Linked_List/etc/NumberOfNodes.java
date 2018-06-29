package come.class04_Linked_List.etc;

public class NumberOfNodes {
    public int numberOfNodes(ListNode head) {
        if (head == null) {
            return 0;
        }
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}
