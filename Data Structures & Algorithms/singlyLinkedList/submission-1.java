class LinkedList {

    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }

        Node temp = head;
        int indx = 0;
        while (temp != null) {
            if (indx == index) {
                break;
            }
            temp = temp.next;
            indx++;
        }

        return temp.val;
    }

    public void insertHead(int val) {
        // System.out.println("Inserting at head: " + val);
        Node node = new Node(val);

        if (head != null) {
            node.next = head;
            head = node;
        } else {
            head = tail = node;
        }
        size++;

        // System.out.println(getValues());
    }

    public void insertTail(int val) {
        // System.out.println("Inserting at tail: " + val);
        Node node = new Node(val);

        if (tail != null) {
            tail.next = node;
            tail = tail.next;
        } else {
            tail = head = node;
        }
        size++;

        // System.out.println(getValues());
    }

    public boolean remove(int index) {
        if (index >= size) {
            return false;
        }

        int indx = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            // System.out.println("current indx: " + indx);
            if (indx == index) {
                if (temp == head) {
                    head = head.next;
                } else if (temp == tail) {
                    prev.next = null;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
            indx++;
        }
        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();

        if (size == 0) {
            return list;
        }

        Node temp = head;
        while (temp != null) {
            // System.out.println("Inserting into list: " + temp.val);
            list.add(temp.val);
            temp = temp.next;
        }

        return list;
    }

    private static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this();
            this.val = val;
        }

        public Node(int val, Node next) {
            this(val);
            this.next = next;
        }

        public Node() {
            this.next = null;
        }
    }
}
