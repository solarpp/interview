package peng.practice.interview;

import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LeetCodeTest {
	
	@Test 
	public void testIsValid() {
		String s = "()";
		assertEquals(LeetCode.isValid(s), true);
	}
	
	@Test
	public void testCompareVersion() {
		String version1 = "1";
		String version2 = "0";
		assertEquals(LeetCode.compareVersion(version1, version2), 1);
	}

	@Test
	public void testPermute() {
		int[] num = { 1, 2, 3, 4 };
		List<List<Integer>> result = LeetCode.permute(num);
		for (List<Integer> list : result) {
			for (int a : list) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		assertEquals(result.size(), 24,
				"should have 4!=4*3*2*1=24 permutations.");
	}

	@Test
	public void testInsertionSortList() {
		// prepare test data
		Node n1 = new Node(2);
		Node n2 = new Node(2); //for nodes have same value scenario
		Node n3 = new Node(4);
		Node n4 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		// verify insertion method
		Node head = LeetCode.insertionSortList(n1);
		assertEquals(head.value, 1);
		assertEquals(head.next.value, 2);
		assertEquals(head.next.next.value, 2);
		assertEquals(head.next.next.next.value, 4);
	}
}
