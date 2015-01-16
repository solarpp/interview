package peng.practice.interview;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class LeetCode {

	/**
	 * https://oj.leetcode.com/problems/zigzag-conversion/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		String convertedString = null;
		if (s == null || nRows < 1) {
			convertedString = null;
		} else if (s.length() <= nRows || nRows == 1) {
			convertedString = s;
		} else {
			StringBuilder convertedStringBuilder = new StringBuilder();
			int inputStringLength = s.length();
			int zigzagCount = nRows + nRows - 2;
			int fulllineCount = inputStringLength / zigzagCount + 1;
			for (int rowIndex = 0; rowIndex < nRows; rowIndex++) {
				for (int lineIndex = 0; lineIndex < fulllineCount; lineIndex++) {
					int index1 = lineIndex * zigzagCount + rowIndex;
					int index2 = lineIndex * zigzagCount + zigzagCount
							- rowIndex;
					if (index1 < inputStringLength)
						convertedStringBuilder.append(s.charAt(index1));
					if (index2 != index1 && index2 != index1 + zigzagCount
							&& index2 < inputStringLength)
						convertedStringBuilder.append(s.charAt(index2));
				}
			}
			convertedString = convertedStringBuilder.toString();
		}
		return convertedString;
	}

	/**
	 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
	 * 
	 * ACCEPTED
	 * 
	 * find the maximum depth of input binary tree
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		int maximunDepth = -1;
		if (root == null) {
			maximunDepth = 0;
		} else {
			int maxLeftsonDepth = maxDepth(root.left);
			int maxRightsonDepth = maxDepth(root.right);
			maximunDepth = maxLeftsonDepth > maxRightsonDepth ? maxLeftsonDepth + 1
					: maxRightsonDepth + 1;
		}
		return maximunDepth;
	}

	/**
	 * https://oj.leetcode.com/problems/climbing-stairs/
	 * 
	 * Time Limit Exceeded
	 * 
	 * how many climb ways for climbing n stairs with either 1 or 2 stairs each
	 * time
	 * 
	 * @param n
	 * @return
	 */
	public static int climbStairsRecursive(int n) {
		int climbWaysCount = -1; // initial climb ways count
		if (n < 1) {
			climbWaysCount = 0;
		} else if (n == 1) {
			climbWaysCount = 1;
		} else if (n == 2) {
			climbWaysCount = 2;
		} else {
			climbWaysCount = climbStairsRecursive(n - 1)
					+ climbStairsRecursive(n - 2);
		}
		return climbWaysCount;
	}

	/**
	 * https://oj.leetcode.com/problems/climbing-stairs/
	 * 
	 * ACCEPTED
	 * 
	 * how many climb ways for climbing n stairs with either 1 or 2 stairs each
	 * time
	 * 
	 * @param n
	 * @return
	 */
	public static int climbStairsNonRecursive(int n) {
		int climbWaysCount = -1; // initial climb ways count
		if (n < 1) {
			climbWaysCount = 0;
		} else if (n == 1) {
			climbWaysCount = 1;
		} else if (n == 2) {
			climbWaysCount = 2;
		} else {
			int[] climbWaysCountArray = new int[n + 1];
			climbWaysCountArray[0] = 0;
			climbWaysCountArray[1] = 1;
			climbWaysCountArray[2] = 2;
			for (int i = 3; i <= n; i++) {
				climbWaysCountArray[i] = climbWaysCountArray[i - 1]
						+ climbWaysCountArray[i - 2];
			}
			climbWaysCount = climbWaysCountArray[n];
		}
		return climbWaysCount;
	}

	/**
	 * https://oj.leetcode.com/problems/permutations/
	 * 
	 * ACCEPTED
	 * 
	 * List all permutation of input numbers
	 * 
	 * @param numbers
	 * @return permutation list
	 */
	public static List<List<Integer>> permute(int[] numbers) {
		List<List<Integer>> permutedList = new ArrayList<List<Integer>>();

		// no number in input
		if (numbers.length == 0)
			return null;

		// only one number in input
		if (numbers.length == 1) {
			List<Integer> currentPermutation = new ArrayList<Integer>();
			currentPermutation.add(numbers[0]);
			permutedList.add(currentPermutation);
			return permutedList;
		}

		// from index 0 do permute
		doPermute(permutedList, numbers, 0);
		return permutedList;
	}

	/**
	 * https://oj.leetcode.com/problems/insertion-sort-list/
	 * 
	 * ACCEPTED
	 * 
	 * Do insertion sort on a linked list
	 * 
	 * @param head
	 * @return sorted linked list head
	 */
	public static Node insertionSortList(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		Node sortedHead = head; // sorted list head
		Node sortedTail = head; // sorted list tail
		Node unSortedHead = head.next; // unsorted list head
		while (unSortedHead != null) {
			if (sortedHead.value > unSortedHead.value) {
				// replace sortedHead with unSortedHead since sortedHead has
				// bigger value
				sortedTail.next = unSortedHead.next;
				unSortedHead.next = sortedHead;
				sortedHead = unSortedHead;
			} else {
				// find if has node in sorted list which value is bigger than
				// unSortedHead by downTraveler
				Node upTraveler = sortedHead; // traveler start from sorted list
												// head which next is
												// downTraveler
				Node downTraveler = sortedHead; // traveler start form sorted
												// list head
				while (downTraveler.value <= unSortedHead.value
						&& downTraveler != unSortedHead) {
					upTraveler = downTraveler;
					downTraveler = downTraveler.next;
				}
				if (downTraveler == unSortedHead)
					// No such node in sorted list which value is bigger than
					// unSortedHead
					sortedTail = sortedTail.next;
				else {
					// find such node in sorted list which value is bigger than
					// unSortedHead
					// so insert unSortedHead between up and down traveler
					sortedTail.next = unSortedHead.next;
					unSortedHead.next = downTraveler;
					upTraveler.next = unSortedHead;
				}
			}
			// unSortedHead should always be sorted tail's next
			unSortedHead = sortedTail.next;
		}
		return sortedHead;
	}

	// / private methods
	/**
	 * Recursive call
	 * 
	 * @param permutedList
	 * @param num
	 * @param start
	 */
	private static void doPermute(List<List<Integer>> permutedList,
			int[] numbers, int startIndex) {
		int inputNumbersLength = numbers.length;
		if (startIndex == inputNumbersLength) {
			// return when reach input numbers length, means got one kind of
			// permutation
			List<Integer> currentPermutation = new ArrayList<Integer>();
			for (int number : numbers)
				currentPermutation.add(number);
			permutedList.add(currentPermutation);
			return;
		} else {
			// recursive call when not reach input numbers length
			for (int i = startIndex; i < inputNumbersLength; i++) {
				// swap startIndex with i
				swap(numbers, startIndex, i);

				// do recursive call from startIndex + 1
				doPermute(permutedList, numbers, startIndex + 1);

				// swap back
				swap(numbers, startIndex, i);
			}
		}
	}

	private static void swap(int[] num, int a, int b) {
		int c;
		c = num[a];
		num[a] = num[b];
		num[b] = c;
	}

}
