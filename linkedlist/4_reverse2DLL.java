static Node reverse2DLL(Node head) {
    if(head == null || head.next == null) return head;
    Node prev = null;
    Node cur = head;
    while(cur != null) {
        prev = cur.prev;
        cur.prev = cur.next;
        cur.next = prev;
        cur = cur.prev;
    }
    return prev.prev;
}