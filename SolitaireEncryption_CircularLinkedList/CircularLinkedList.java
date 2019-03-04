//Creates a circular linked list that can be used for SolitaireAssignment.java
//author: Tanaya Jadhav


public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;


    public CircularLinkedList() {
        head = null;
        tail = null;
        if (head != null && tail != head) {
            tail.next = head;
        }
        size = 0;
    }

    public boolean add(int item) {
        add(size, item);
        return true;
    }

    public String toString() {
        String output = "[" + head.item;
        Node current = head.next;
        while (current != null && current != head) {
//            System.out.println("1");
            output += ", " + current.item.toString();
            current = current.next;
        }

        return output + "]";
    }

    public void add(int index, int item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node temp = new Node(item);
        //adding first item to list
        if (size == 0) {
            this.head = temp;
            this.tail = temp;
        }

        // adding new head
        else if (index == 0) {
//            System.out.println("adding new head");
            temp.next = head;
            head = temp;
            tail.next = head;
        }

        //adding new tail
        else if (index == size) {
            temp.next = head;
            tail.next = temp;
            tail = temp;
        }

        //everything else
        else {
            Node before = this.getNode(index -1);
            temp.next = before.next;
            before.next = temp;
        }

        size++;
    }

    public Integer remove(int index) {
        Integer removed = null;
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        //removing only element
        if (size == 1) {
            removed = head.item;
            head = null;
            tail = null;
        }
        //removing head
        else if (index == 0){
            removed = head.item;
            tail.next = head.next;
            head = tail.next;
        }
        //removing tail
        else if (index == size -1) {
            removed = tail.item;
            Node before = getNode(index-1);
            before.next = head;
            }

        else {
            Node before = getNode(index-1);
            removed = before.next.item;
            before.next = before.next.next;
        }
        size --;
        return removed;
    }

    public Node find(int item){
        Node current = head;
        Integer element = current.item;
        while (element != item) {
            current = current.next;
            element = current.item;
        }
        return current;
    }

    public int getIndex(int item){
        int index = 0;
        Node current = head;
        Integer element = current.item;
        while (element != item) {
            current = current.next;
            element = current.item;

            index++;
        }
        return index;
    }

    public void swapWithNext(int index) {
        if (index <= size -2) {
            Node prior = getNode(index);
            add(index + 2, prior.item);
            remove(index);
        }
        else if (index == size -1) {
            Node temp = head;
            add(index, temp.item);
            remove(0);
            add(0,tail.item);
            remove(size-1);

        }
    }

    public void insert2Downstream(int index){
        Node ofinterest = getNode(index);
        if (index < size -2) {
            remove(index);
            add(index + 2, ofinterest.item);
        }
        else if (index == size -2) {
            Node temp = head;
            remove(0);
            add(0,ofinterest.item);
            remove(index);
            add(temp.item);
        }
        //if jokerb is tail
        else if (index == size -1){
            Node temp = tail;
            remove(index);
            add(2, temp.item);
            // set last item as tail
            tail = getNode(size-1);

        }
    }

    public void tripleCut(int a, int b){
        if (b<a){
            int c = a;
//            System.out.println(c);
            a = b;
            b = c;
//            System.out.println(a);
//            System.out.println(b);
        }

        //joker a comes before joker b
        if (a<b){
            Node aNode = getNode(a);
            Node bNode = getNode(b);
            if (aNode != head && bNode != tail){
                Node beforea = getNode(a-1);
                Node afterb = getNode(b+1);

                tail.next = aNode;
                bNode.next = head;
                head = afterb;
                beforea.next = head;
                tail = beforea;
            }
            //if a is the head
            else  if (a<b && aNode == head && bNode != tail) {
                Node afterb = getNode(b+1);
                head = afterb;
                tail = bNode;
            }
            //if b is the tail
            else if (a<b && aNode != head && bNode == tail) {
                Node beforea = getNode(a-1);
                head = aNode;
                tail = beforea;
            }
        }

    }


    public void bottomCut(){
        int bottom_num = tail.item;
        for (int i = 0; i < bottom_num; i++) {
            add(size-1, head.item);
            remove(0);
        }
    }

    public int finalItem(){
        int top_num = head.item;
        Node val_node = getNode(top_num);
        int keystream_val = val_node.item;
        return keystream_val;
    }

    public Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return this.size;
    }


    private static class Node {
        Integer item;
        Node next;

        public Node(int item){
            this.item = item;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList l = new CircularLinkedList();
        l.add(0,2);
        l.add(6);
        l.add(1);
        l.add(3);
        l.add(5);
        l.add(4);
        System.out.println(l);
        l.bottomCut();
        System.out.println(l);
        l.finalItem();




//        System.out.println(l.getIndex(3));
//        l.swapWithNext(l.getIndex(3));
//        System.out.println(l);
//        l.swapWithNext(l.getIndex(3));
//        System.out.println(l);



    }

}
