package peng.practice.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

	// https://oj.leetcode.com/problems/permutations/
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		doPermute(result, num, 0);
		return result;
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
