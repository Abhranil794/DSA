class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class HelloWorld {
    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node convert(int[] a) {
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++) {
            Node newNode = new Node(a[i]);
            mover.next = newNode;
            mover = mover.next;
        }
        return head;
    }
    static Node merge(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
        Node dNode = new Node(-1);
        Node temp = dNode;
        while(t1 != null && t2 != null) {
            if(t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null) temp.next = t1;
        if(t2 != null) temp.next = t2;
        return dNode.next;
    }
    public static void main(String[] args) {
        int[] a = {2,4,8,10};
        int[] b = {1,3,3,6,11,14};
        Node head1 = convert(a);
        Node head2 = convert(b);
        // print(head1);
        // print(head2);
        Node head = merge(head1, head2);
        print(head);
    }
}