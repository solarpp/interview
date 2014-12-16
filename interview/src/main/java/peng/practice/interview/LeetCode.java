package peng.practice.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

	// https://oj.leetcode.com/problems/permutations/
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return null;
		if (num.length == 1) {
			List<Integer> current = new ArrayList<Integer>();
			current.add(num[0]);
			result.add(current);
			return result;
		}
		doPermute(result, num, 0);
		return result;
	}

	// https://oj.leetcode.com/problems/insertion-sort-list/
	public static Node insertionSortList(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		Node h = head;
		Node t = head;
		Node up = head;
		Node down = head;
		Node now = head.next;
		while (now != null) {
			if (h.value > now.value) {
				t.next = now.next;
				now.next = h;
				h = now;
			} else {
				up = h;
				down = h;
				while (down.value < now.value && down != now) {
					up = down;
					down = down.next;
				}
				if (down == now)
					t = t.next;
				else {
					t.next = now.next;
					now.next = down;
					up.next = now;
				}
			}
			now = t.next;
		}
		return h;
	}

	// private methods
	// for problem permutations
	private static void doPermute(List<List<Integer>> result, int[] num,
			int start) {
		int l = num.length;
		if (start == l) {
			List<Integer> current = new ArrayList<Integer>();
			for (int a : num)
				current.add(a);
			// if (current.get(0) < 3 && current.get(3) > 2)
			result.add(current);
			return;
		} else {
			for (int i = start; i < l; i++) {
				swap(num, start, i);
				doPermute(result, num, start + 1);
				swap(num, start, i);
			}
		}
	}

	private static void swap(int[] num, int a, int b) {
		int c;
		c = num[a];
		num[a] = num[b];
		num[b] = c;
	}
	// end - for problem permutations

}
