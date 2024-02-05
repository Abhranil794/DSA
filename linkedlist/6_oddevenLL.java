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
    
    public static void printLL(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
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

    static Node oddEvenLL (Node head) {
        if(head == null || head.next == null) return head;
        Node odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    
    public static void main(String[] args) {
        int[] a = {4,5,3,24,8};
        Node head = convertToLL(a);
        head = oddEvenLL(head);
        printLL(head);
    }
}