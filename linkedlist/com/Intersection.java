package linkedlist.com;

import java.util.HashSet;

public class Intersection {
	public Node getIntersectionNode(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();
        Node l1 = headA;
        while(l1 != null){
            set.add(l1);
            l1 = l1.next;
        }
        Node l2 = headB;
        while(l2 != null){
            if(set.contains(l2)){
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
