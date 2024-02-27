class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class HelloWorld {
    static Node convert(int[] a) {
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++) {
            Node newNode = new Node(a[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }
    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node reverse(Node head) {
        Node prev = null, temp = head;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    static Node addOneIterative(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null) {
            temp.data += carry;
            if(temp.data < 10) {
                carry = 0;
                break;
            } else {
                carry = 1;
                temp.data = 0;
            }
            temp = temp.next;
        }
        if(carry == 1) {
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }
        head = reverse(head);
        return head;
    }
    static int helper(Node temp) {
        if(temp == null) return 1;
        int carry = helper(temp.next);
        temp.data += carry;
        if(temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }
    static Node addOneBackTracking(Node head) {
        int carry = helper(head);
        if(carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] a = {9,9,9};
        Node head = convert(a);
        // print(head);
        head = addOneBackTracking(head);
        print(head);
    }
}