package peng.practice.interview;

public class Stack {
	Node top = null;

	public void push(Node n) {
		if (n != null) {
			n.next = top;
			top = n;
		}
	}

	public Node pop() {
		if (top == null)
			return null;
		else {
			Node result = top;
			top = top.next;
			return result;
		}
	}

	public Node peek() {
		return top;
	}
}
