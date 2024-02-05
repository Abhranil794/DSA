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

    public static boolean checkIfPresent(Node head, int val) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }
    
    public static int lengthOfLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    
    public static void traversalLL(Node head) {
        Node temp = head;
        while(temp != null) {
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
    
    public static void main(String[] args) {
        int[] a = {4,5,3,24,8};
        Node head = convertToLL(a);
        System.out.print(checkIfPresent(head, 10)); //false
        // traversalLL(head);
        // System.out.print(lengthOfLL(head));
    }
}