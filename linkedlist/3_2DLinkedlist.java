class Node {
    int data;
    Node next;
    Node prev;
    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class HelloWorld {
    static void print2DLL(Node head) {
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    static Node convert2DLL(int[] a) {
        Node head = new Node(a[0]);
        Node back = head;
        for(int i=1;i<a.length;i++) {
            Node temp = new Node(a[i],null,back);
            back.next = temp;
            back = back.next;
        }
        return head;
    }
    static Node deleteHead (Node head) {
        if(head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }
    static Node deleteTail (Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        return head;
    }
    static Node deleteK (Node head, int k) {
        if(head == null) return null;
        if(k == 1) {
            head = head.next;
            head.prev = null;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        while(temp != null) {
            cnt++;
            if(cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node back = temp.prev;
        Node front = temp.next;
        if(back == null && front == null) return null;
        else if(back == null) {
            return deleteHead(head);
        }
        else if(front == null) {
            return deleteTail(head);
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
        return head;
    }
    static void deleteNode(Node temp) {
        Node front = temp.next;
        Node back = temp.prev;
        if(front == null) {
            back.next = null;
            temp.prev = null;
            temp.next = null;
            return;
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
    }
    static Node insertBeforeHead (Node head, int val) {
        if (head == null) return new Node(val);
        Node newHead = new Node(val,head,null);
        head.prev = newHead;
        return newHead;
    }
    static Node insertBeforeTail (Node head, int val) {
        if (head == null || head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        Node newNode = new Node(val, tail, tail.prev);
        tail.prev.next = newNode;
        tail.prev = newNode;
        return head;
    }
    static Node insertBeforeK (Node head, int val, int k) {
        if (k == 1) return insertBeforeHead(head,val);
        Node temp = head;
        int cnt = 0;
        while(temp != null) {
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node back = temp.prev;
        Node newNode = new Node(val, temp, back);
        back.next = newNode;
        temp.prev = newNode;
        return head;
    }
    static void insertBeforeNode (Node temp, int val) {
        Node back = temp.prev;
        Node newNode = new Node(val,temp,back);
        back.next = newNode;
        temp.prev = newNode;
    }
    public static void main(String[] args) {
        int[] a = {6,4,9,743,2};
        Node head = convert2DLL(a);
        // head = deleteHead(head);
        // head = deleteK(head, 4);
        // deleteNode(head.next.next.next.next);
        // head = insertBeforeK(head,10,5);
        insertBeforeNode(head.next.next.next.next, 1000);
        print2DLL(head);
    }
}