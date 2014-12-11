package peng.practice.interview;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StackTest {

	@Test
	public void testPushPopPeek() {
		Stack s = new Stack();
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		s.push(n1);
		s.push(n2);
		System.out.println(s.peek().value);
		Assert.assertEquals(5, s.peek().value);
		s.pop();
		System.out.println(s.peek().value);
		Assert.assertEquals(3, s.peek().value);
	}
}
