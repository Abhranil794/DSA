static Node AddTwo(Node l1, Node l2) {
    Node dummy = new Node(-1);
    Node cur = dummy;
    Node temp1 = l1;
    Node temp2 = l2;
    int carry = 0;
    while(temp1 != null || temp2 != null) {
        int sum = carry;
        if(temp1 != null) sum += temp1.data;
        if(temp2 != null) sum += temp2.data;
        Node newNode = new Node(sum % 10);
        carry = sum / 10;
        cur.next = newNode;
        cur = newNode;
        if (temp1 != null) temp1 = temp1.next;
        if (temp2 != null) temp2 = temp2.next;
    }
    if (carry != 0) {
        Node newNode = new Node(carry);
        cur.next = newNode;
    }
    return dummy.next;
}