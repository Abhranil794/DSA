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
    
    static Node reverseRecursive(Node head) {
        if(head == null || head.next == null) return head;
        Node newHead = reverseRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    
    public static void main(String[] args) {
        int[] a = {4,5,3,24,8};
        Node head = convertToLL(a);
        print(head);
        head = reverseRecursive(head);
        print(head);
    }
}