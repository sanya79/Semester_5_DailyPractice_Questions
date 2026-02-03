/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        Node current=head;
        while(current != null){
            if(current.child !=null){
                Node next=current.next;
                Node child=current.child;
                current.child=null;
                child.prev=current;
                current.next=child;
                Node tail=child;
                while(tail.next!=null){
                    tail=tail.next;
                }
                tail.next=next;
                if(next!=null) next.prev=tail;
            }
            current=current.next;
        }
        return head;
        
    }
}