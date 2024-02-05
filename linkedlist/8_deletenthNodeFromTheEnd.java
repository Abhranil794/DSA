class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class HelloWorld {
    
    public static void print(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    
    public static Node convertToLL(int[] a) {
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    
    static Node deleteKFromEnd (Node head, int k) {
        Node fast = head, slow = head;
        for(int i=0;i<k;i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        int[] a = {4,5,3,24,8};
        Node head = convertToLL(a);
        print(head);
        head = deleteKFromEnd(head, 5);
        print(head);
    }
}