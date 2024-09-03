import java.util.*;
public class ChapterTwo {
    public static void main(String[] args){
        Node head = new Node(2);
        Node loop = new Node(1);
        head.next = loop;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
        System.out.println(loopDetection(head));
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
    public static int sumLists(Node head1, Node head2){ //do this reverse as well... recursively?
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
    public static boolean palindrome(Node head){
        //reverse the linked list?
        //use a stack..? is that inefficient? maybe. Is it what I think makes a bunch of sense? yes. 
        Stack<Node> stack = new Stack<>();
        if(head ==null){return false;}
        Node pointer = head;
        while(pointer!=null){
            stack.push(pointer);
            pointer = pointer.next;
        }
        Node reverseHead = stack.pop();
        Node lag = reverseHead;
        Node quick = reverseHead;
        while(!stack.isEmpty()){
            quick = stack.pop();
            if(reverseHead.equals(lag)){
                reverseHead.next = quick;
            }
            lag.next = new Node(quick.data); //"new" keyword to prevent wack asf problems that I don't fully understand but I think is because of simultaneous variables having the same memory space(aka change together when I don't want them to, I had this problem with a different problem and me no likey also this prevents any pointer issues)
            lag = lag.next;
        }
        Node check_pointer = head;
        Node reverse_check_pointer = reverseHead;
        while(check_pointer != null && reverse_check_pointer != null){//because one pointer can keep going without the other lol
            if(check_pointer.data != reverse_check_pointer.data){
                return false;
            }
            check_pointer = check_pointer.next;
            reverse_check_pointer = reverse_check_pointer.next;
        }
        return true;
    }
    public static boolean intersection(Node head1, Node head2){//same reference(index) w/ same value
        Node p1 = head1;
        Node p2 = head2;
        while(p1 != null && p2 !=null){
            if(p1.data == p2.data){
                return true;
            }
            //increment at same rate
            p1=p1.next;
            p2=p2.next;
        }
        return false;
    }
    public static Node loopDetection(Node head){ //if the same exact node shows up twice(because each node is linked to the next so it creates a loop of however many elements are in the middle of the two duplicates)
        //Floyd's Algorithm isn't working if there is an odd # of elements before the cycle element because then the two nodes will not collide at the cycle element
        //So instead, use a hashmap? (becomes O(N) space instead of O(1) but I don't know how to use Floyd's Algorithm in this case.)
        HashMap<Node, Integer> hash = new HashMap<>();
        Node pointer= head;
        while(pointer!=null){
            if(hash.containsKey(pointer)){
                return pointer;
            }
            hash.put(pointer, pointer.data);
            pointer = pointer.next;
        }
        return null;
    }
} 