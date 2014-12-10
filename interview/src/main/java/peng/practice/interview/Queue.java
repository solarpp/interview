package peng.practice.interview;

public class Queue {
	Node first = null;
	Node last = null;

	public void enQueue(Node n) {
		if (first == null) {
			first = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
	}

	public Node deQueue() {
		if (first == null)
			return null;
		else {
			Node result = first;
			first = first.next;
			return result;
		}
	}
}