package peng.practice.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

	/** https://oj.leetcode.com/problems/permutations/
	 * List all permutation of input numbers
	 * @param numbers
	 * @return permutation list
	 */
	public static List<List<Integer>> permute(int[] numbers) {
		List<List<Integer>> permutedList = new ArrayList<List<Integer>>();
		
		//no number in input
		if (numbers.length == 0)
			return null;
		
		//only one number in input 
		if (numbers.length == 1) {
			List<Integer> currentPermutation = new ArrayList<Integer>();
			currentPermutation.add(numbers[0]);
			permutedList.add(currentPermutation);
			return permutedList;
		}
		
		//from index 0 do permute
		doPermute(permutedList, numbers, 0);
		return permutedList;
	}

	/** https://oj.leetcode.com/problems/insertion-sort-list/
	 * Do insertion sort on a linked list
	 * @param head
	 * @return sorted linked list head
	 */
	public static Node insertionSortList(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		Node sortedHead = head;	//sorted list head
		Node sortedTail = head; //sorted list tail
		Node unSortedHead = head.next; //unsorted list head
		while (unSortedHead != null) {
			if (sortedHead.value > unSortedHead.value) {
				//replace sortedHead with unSortedHead since sortedHead has bigger value
				sortedTail.next = unSortedHead.next;
				unSortedHead.next = sortedHead;
				sortedHead = unSortedHead;
			} else {
				//find if has node in sorted list which value is bigger than unSortedHead by downTraveler
				Node upTraveler = sortedHead; //traveler start from sorted list head which next is downTraveler
				Node downTraveler = sortedHead; //traveler start form sorted list head
				while (downTraveler.value < unSortedHead.value && downTraveler != unSortedHead) {
					upTraveler = downTraveler;
					downTraveler = downTraveler.next;
				}
				if (downTraveler == unSortedHead)
			        //No such node in sorted list which value is bigger than unSortedHead
					sortedTail = sortedTail.next;
				else {
					//find such node in sorted list which value is bigger than unSortedHead
					//so insert unSortedHead between up and down traveler
					sortedTail.next = unSortedHead.next;
					unSortedHead.next = downTraveler;
					upTraveler.next = unSortedHead;
				}
			}
			//unSortedHead should always be sorted tail's next
			unSortedHead = sortedTail.next;
		}
		return sortedHead;
	}

	/// private methods
	/**
	 * Recursive call
	 * @param permutedList
	 * @param num
	 * @param start
	 */
	private static void doPermute(List<List<Integer>> permutedList, int[] numbers,
			int startIndex) {
		int inputNumbersLength = numbers.length;
		if (startIndex == inputNumbersLength) {
			//return when reach input numbers length, means got one kind of permutation
			List<Integer> currentPermutation = new ArrayList<Integer>();
			for (int number : numbers)
				currentPermutation.add(number);
			permutedList.add(currentPermutation);
			return;
		} else {
			//recursive call when not reach input numbers length
			for (int i = startIndex; i < inputNumbersLength; i++) {
				//swap startIndex with i
				swap(numbers, startIndex, i);
				
				//do recursive call from startIndex + 1
				doPermute(permutedList, numbers, startIndex + 1);
				
				//swap back
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
