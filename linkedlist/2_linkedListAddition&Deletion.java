class Node {
    int data;
    Node next;
    Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class HelloWorld {
    
    static Node convert2LL (int[] a) {
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    static void printLL (Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    static Node deleteHead (Node head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }
    static Node deleteTail (Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    static Node deleteK (Node head, int k) {
        if (head == null) return head;
        if(k == 1) return head.next;
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while(temp != null) {
            cnt++;
            if(cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    static Node deleteEl (Node head, int el) {
        if(head == null) return head;
        if(head.data == el) return head.next;
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(temp.data == el) {
                prev.next = prev.next.next;
            }
            prev =  temp;
            temp = temp.next;
        }
        return head;
    }
    static Node insertHead (Node head, int el) {
        return new Node(el,head);
    }
    static Node insertLast (Node head, int el) {
        if(head == null) return new Node(el);
        Node temp = head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        Node newNode = new Node(el);
        temp.next = newNode;
        return head;
    }
    static Node insertK (Node head, int el, int k) {
        if(head == null) return new Node(el);
        if(k == 1) return new Node(el, head);
        Node temp = head;
        int cnt = 0;
        while(temp!=null) {
            cnt++;
            if(cnt == k-1) {
                Node newNode = new Node(el);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] a = {6,4,3,9,5,7};
        Node head = convert2LL(a);
        head = insertK(head, 100, 4);
        printLL(head);
    }
}