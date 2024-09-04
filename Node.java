public class Node {
    Node next = null;
    boolean visited = false;
    int data;
    public Node[] children;
    public Node(int m){//m for magnitude
        data = m;
    }
    public String toString(){ //so I can use System.out.println() on a node and it prints the value
        return Integer.toString(data);
    }
}
