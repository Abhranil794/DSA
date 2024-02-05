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
    static Node convert2LL(int[] a) {
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
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    static Node reverse(Node head) {
        Node temp = head, prev = null;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    static boolean checkPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node revHead = reverse(slow.next);
        Node first = head, second = revHead;
        while(second != null) {
            if(first.data != second.data) {
                // it is recommended to reverse the linked list back
                reverse(revHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        // it is recommended to reverse the linked list back
        reverse(revHead);
        return true;
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Node head = convert2LL(a);
        print(head);
        System.out.print(checkPalindrome(head));
    }
}