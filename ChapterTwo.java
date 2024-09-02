public class ChapterTwo {
    public static void main(String[] args){
        Node head1 = new Node(1);
        Node int1 = new Node(2);
        Node int12 = new Node(3);
        head1.next = int1;
        int1.next = int12;
        Node head2 = new Node(5);
        Node int2 = new Node(3);
        Node int21 = new Node(4);
        head2.next = int2;
        int2.next = int21;
        //System.out.println(sumLists(head1, head2));

    }
    public static void removeDups(Node head){
        Node lag = head; //pointer which lags behind the main pointer (to find duplicate values)
        Node pointer = head;
        if(head.next != null){
            pointer = head.next;
            while(pointer!=null){
                if(lag.data == pointer.data){ 
                    lag.next = pointer.next; //skip over the pointer to remove it; e.g. 1 2 2 3 would become 1 2 3 because the second 2 would be skipped
                    pointer = pointer.next; //only move pointer because otherwise pointer and lag become the same
                }
                else{
                    pointer = pointer.next; //otherwise just move both
                    lag = lag.next;
                }
            }
        }

    }
    public static void printLinkedList(Node head){
        Node pointer = head;
        while(pointer!=null){
            System.out.println(pointer);
            pointer = pointer.next;
        }
    }
    public static Node returnKthtoLast(Node head, int K){ //singly linked list
        Node ans = null; //because I don't have a length, I don't see an alternative to traversing through the list to find the length, and then finding the Kth to last that way... O(2N) --> O(N)
        int length = 0;
        Node pointer = head;
        while(pointer!=null){
            length++;
            pointer = pointer.next;
        }
        if(K <= length){ //second to last = last -1; = (length-K+1)th element
            pointer = head;
            for(int i = 0; i < length-K; i++){ //e.g. 2 elements, K = 2, should return element at index 0
                pointer = pointer.next;
            }
            ans = pointer;
        }

        return ans;
    }
    public static void deleteMiddleNode(Node head){ //delete any node that isn't the first and last...?
    //just find a node whose next isn't null and who isn't the head
    Node pointer = head;
    Node lag = head;
    if(pointer.next != null){ //checks if it isn't a one element list
        pointer = pointer.next;
        if(pointer.next!=null){ //checks if it isn't a two element list
            lag.next = pointer.next; //deletes second element by making the first element's next element the third element
        }
    }
    }
    public static Node partition(Node head, int x){ //separate the values greater than or equal to x and those less than x, order doesn't matter
    //e.g. 3 5 8 5 10 2 1 partition = 5 can end up like 3 2 1   5 10 5 8 
    //send all values greater than x to the end, and just keep the lower values the same
    //scratch that, send stuff to the front to avoid looping when traversing forwards
    Node newHead = head;
    Node pointer = head;
    Node lag = head;
    if(head.next!=null){
        pointer = pointer.next;
    }
    else{
        return head;
    }
    while(pointer!=null){
        if(pointer.data < x){
            if(pointer!=head){
            Node temp = new Node(pointer.data); //make a clone; otherwise, a "head = pointer" line would completely screw everything up because they are treated as identical so the head is constantly changing when you don't want it to (I think?)
            temp.next = newHead;
            newHead = temp;
            lag.next = pointer.next;
            pointer = pointer.next;
                }
        }
        else{
            pointer = pointer.next;
            lag = lag.next;
        }
    }
    return newHead;
}
    public static int sumLists(Node head1, Node head2){
        int tens = 0;
        int ans = 0;
        Node pointer1 = head1;
        Node pointer2 = head2;
        while(pointer1!=null){
            ans += (int) pointer1.data * Math.pow(10, tens);
            pointer1 = pointer1.next;
            tens++;
        }
        tens = 0;
        while(pointer2 !=null){
            ans += (int) pointer2.data * Math.pow(10, tens);
            pointer2 = pointer2.next;
            tens++;
        }
        return ans;
    }
}
 