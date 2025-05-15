package linkedlist.com;

import java.util.HashSet;

public class CyclePosition {
	public static Node cycleStratPosition(Node head) {
		Node fastNode = head;
		Node slowNode = head;
		while(fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if(slowNode == fastNode) {
				break;
			}
		}
		if(fastNode == null || fastNode.next == null) {
			return null;
		}
		slowNode = head;
		while(slowNode != fastNode){
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}
		return slowNode;
	}
	
	public Node detectCycle2(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node current = head;
        while(current != null){
            if(set.contains(current)){
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
