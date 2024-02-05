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
    
    static Node sort(Node head) {
        if(head == null || head.next == null) return head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead, temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if(temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next!=null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        Node newHead = zeroHead.next;
        return newHead;
    }
    
    public static void main(String[] args) {
        int[] a = {1,0,1,2,0,2,1};
        Node head = convertToLL(a);
        printLL(head);
        System.out.println();
        head = sort(head);
        printLL(head);
    }
}