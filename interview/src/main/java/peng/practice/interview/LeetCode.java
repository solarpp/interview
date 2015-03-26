package peng.practice.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode {

	/**
	 * https://leetcode.com/problems/longest-common-prefix/
	 * 
	 * ACCEPTED
	 * 
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder("");
		if (strs != null && strs.length >= 1) {
			// strs is not null and strs at least has 2 strings.
			String theFirstString = strs[0];
			if (strs.length == 1) {
				// strs only has 1 string
				result.append(strs[0]);
			} else {
				// strs has more than 1 string
				for (int i = 0; i < theFirstString.length(); i++) {
					boolean isSame = true;
					for (String string : strs) {
						if (string.length() <= i
								|| string.charAt(i) != theFirstString.charAt(i))
							// found a string length shorter than theFirstString
							// or
							// found a string is not same with theFirstString at
							// index i
							isSame = false;
					}
					if (isSame) {
						// all strings are same between index 0 to index i;
						result.append(theFirstString.charAt(i));
					} else {
						// all strings are same between index 0 to index i-1
						// but different at index i
						break;
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * https://oj.leetcode.com/problems/length-of-last-word/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int result = 0;
		if (s != null) {
			int length = s.length();
			for (int i = length - 1; i >= 0; i--) {
				if (s.charAt(i) != ' ') {
					result++;
				} else {
					if (result > 0)
						break;
				}
			}
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
	 * 
	 * ACCEPTED
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public Node getIntersectionNode(Node headA, Node headB) {
		Node result = null;
		if (headA != null && headB != null) {
			Node travelerNodeA = headA;
			Node travelerNodeB = headB;
			int lengthA = 1, lengthB = 1;
			while (travelerNodeA.next != null) {
				lengthA++;
				travelerNodeA = travelerNodeA.next;
			}
			while (travelerNodeB.next != null) {
				lengthB++;
				travelerNodeB = travelerNodeB.next;
			}
			travelerNodeA = headA;
			travelerNodeB = headB;
			if (lengthA > lengthB) {
				int lengthDiff = lengthA - lengthB;
				while (lengthDiff > 0) {
					travelerNodeA = travelerNodeA.next;
					lengthDiff--;
				}
			} else if (lengthB > lengthA) {
				int lengthDiff = lengthB - lengthA;
				while (lengthDiff > 0) {
					travelerNodeB = travelerNodeB.next;
					lengthDiff--;
				}
			}
			while (travelerNodeA != travelerNodeB && travelerNodeA != null) {
				travelerNodeA = travelerNodeA.next;
				travelerNodeB = travelerNodeB.next;
			}
			result = travelerNodeA;
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/implement-strstr/
	 * 
	 * ACCEPTED
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		int result = -1;
		if (haystack != null && needle != null
				&& haystack.length() >= needle.length()) {
			if (needle.length() == 0) {
				result = 0;
			} else {
				int startIndexOfHaystack = 0;
				while (startIndexOfHaystack <= haystack.length()
						- needle.length()) {
					int comparedLength = 0;
					while (startIndexOfHaystack + comparedLength < haystack
							.length()
							&& comparedLength < needle.length()
							&& haystack.charAt(startIndexOfHaystack
									+ comparedLength) == needle
									.charAt(comparedLength)) {
						comparedLength++;
						if (comparedLength == needle.length()) {
							result = startIndexOfHaystack;
							break;
						}
					}
					if (result != -1)
						break;
					startIndexOfHaystack++;
				}
			}
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
	 * 
	 * ACCEPTED
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int result = 0;
		if (n >= 5) {
			result += n / 5;
			result += trailingZeroes(n / 5);
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/excel-sheet-column-number/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int result = 0;
		if (s != null) {
			int length = s.length();
			for (int digital = length - 1; digital >= 0; digital--) {
				int digitalBit = 1;
				for (int bit = 1; bit < length - digital; bit++) {
					digitalBit *= 26;
				}
				char currentChar = s.charAt(digital);
				result += (currentChar - 'A' + 1) * digitalBit;
			}
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/excel-sheet-column-title/
	 * 
	 * ACCEPTED
	 * 
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		String result = null;
		if (n > 0) {
			StringBuilder buffer = new StringBuilder();
			int modeValue = n;
			while (n > 26) {
				modeValue = n % 26;
				if (modeValue == 0) {
					buffer.insert(0, Character.toChars(64 + 26));
					n = n / 26 - 1;
				} else {
					buffer.insert(0, Character.toChars(modeValue + 64));
					n /= 26;
				}
			}
			buffer.insert(0, Character.toChars(n + 64));
			result = buffer.toString();
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/valid-palindrome/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		boolean isPalindrome = false;
		if (s != null) {
			int length = s.length();
			if (length == 0 || length == 1) {
				isPalindrome = true;
			} else {
				int fromHeadIndex = 0;
				int fromEndIndex = length - 1;
				char fromHeadChar = '\u0000';
				char fromEndChar = '\u0000';
				while (fromHeadIndex <= fromEndIndex) {
					if (fromHeadChar == '\u0000'
							&& !Character.isLetterOrDigit(s
									.charAt(fromHeadIndex))) {
						fromHeadIndex++;
					} else {
						fromHeadChar = s.charAt(fromHeadIndex);
						if (fromEndChar == '\u0000'
								&& !Character.isLetterOrDigit(s
										.charAt(fromEndIndex))) {
							fromEndIndex--;
						} else {
							fromEndChar = s.charAt(fromEndIndex);
							if (Character.toLowerCase(fromHeadChar) != Character
									.toLowerCase(fromEndChar)) {
								isPalindrome = false;
								break;
							} else {
								fromHeadIndex++;
								fromEndIndex--;
							}
						}
					}
				}
				if (fromHeadIndex > fromEndIndex)
					isPalindrome = true;
			}
		}
		return isPalindrome;
	}

	/**
	 * https://oj.leetcode.com/problems/valid-parentheses/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		boolean isValid = false;
		if (s != null && s.length() % 2 == 0) {
			isValid = true;
			String openBrackets = "({[";
			String closeBrackets = ")}]";
			Stack<Character> stack = new Stack<Character>();
			for (char c : s.toCharArray()) {
				if (openBrackets.indexOf(c) >= 0) {
					stack.push(c);
				} else if (closeBrackets.indexOf(c) >= 0) {
					if (stack.empty()) {
						isValid = false;
						break;
					} else {
						char mappingOpenBracket = stack.pop();
						if (openBrackets.indexOf(mappingOpenBracket) != closeBrackets
								.indexOf(c)) {
							isValid = false;
							break;
						}
					}
				} else {
					isValid = false;
					break;
				}
			}
			if (isValid && !stack.empty())
				isValid = false;
		}
		return isValid;
	}

	/**
	 * https://oj.leetcode.com/problems/valid-sudoku/
	 * 
	 * ACCEPTED
	 * 
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
		boolean isValidRowsAndColumns = doValidateSudokuRowsAndColumns(board);
		boolean isValidBlocks = doValidateSudokuBlocks(board);
		return isValidRowsAndColumns & isValidBlocks;
	}

	/**
	 * https://oj.leetcode.com/problems/count-and-say/
	 * 
	 * ACCEPTED
	 * 
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		String result = null;
		if (n > 0) {
			if (n == 1)
				result = "1";
			else {
				result = doCountAndSay(countAndSay(n - 1));
			}
		}
		return result;
	}

	/**
	 * https://oj.leetcode.com/problems/compare-version-numbers/
	 * 
	 * ACCEPTED
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) {
		int comparationResult = -2;
		int version1Length = version1.length();
		int version2Length = version2.length();
		int beginIndex1 = 0;
		int endIndex1 = 0;
		int beginIndex2 = 0;
		int endIndex2 = 0;
		int version1Number = 0;
		int version2Number = 0;
		while (comparationResult == -2) {
			if (endIndex1 == version1Length)
				version1Number = 0;
			else {
				while (endIndex1 < version1Length
						&& version1.charAt(endIndex1) != '.')
					endIndex1++;
				version1Number = Integer.parseInt(version1.substring(
						beginIndex1, endIndex1));
			}

			if (endIndex2 == version2Length)
				version2Number = 0;
			else {
				while (endIndex2 < version2Length
						&& version2.charAt(endIndex2) != '.')
					endIndex2++;
				version2Number = Integer.parseInt(version2.substring(
						beginIndex2, endIndex2));
			}

			if (version1Number > version2Number) {
				comparationResult = 1;
			} else if (version1Number < version2Number) {
				comparationResult = -1;
			} else {
				if (endIndex1 != version1Length) {
					endIndex1 += 1;
					beginIndex1 = endIndex1;
				}
				if (endIndex2 != version2Length) {
					endIndex2 += 1;
					beginIndex2 = endIndex2;
				}
				if (endIndex1 == version1Length && endIndex2 == version2Length)
					comparationResult = 0;
			}
		}

		return comparationResult;
	}

	/**
	 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * 
	 * ACCEPTED
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> totalLevelOrderList = new ArrayList<List<Integer>>();
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		if (root != null) {
			treeNodeQueue.add(root);
			while (!treeNodeQueue.isEmpty()) {
				List<Integer> currentLevelOrderList = new ArrayList<Integer>();
				int currentlevelNodesCount = treeNodeQueue.size();
				for (int i = 0; i < currentlevelNodesCount; i++) {
					TreeNode currentLevelNode = treeNodeQueue.remove();
					currentLevelOrderList.add(currentLevelNode.value);
					if (currentLevelNode.left != null)
						treeNodeQueue.add(currentLevelNode.left);
					if (currentLevelNode.right != null)
						treeNodeQueue.add(currentLevelNode.right);
				}
				totalLevelOrderList.add(0, currentLevelOrderList);
			}
		}
		return totalLevelOrderList;
	}

	/**
	 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	 * 
	 * ACCEPTED
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> totalLevelOrderList = new ArrayList<List<Integer>>();
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		if (root != null) {
			treeNodeQueue.add(root);
			while (!treeNodeQueue.isEmpty()) {
				List<Integer> currentLevelOrderList = new ArrayList<Integer>();
				int currentlevelNodesCount = treeNodeQueue.size();
				for (int i = 0; i < currentlevelNodesCount; i++) {
					TreeNode currentLevelNode = treeNodeQueue.remove();
					currentLevelOrderList.add(currentLevelNode.value);
					if (currentLevelNode.left != null)
						treeNodeQueue.add(currentLevelNode.left);
					if (currentLevelNode.right != null)
						treeNodeQueue.add(currentLevelNode.right);
				}
				totalLevelOrderList.add(currentLevelOrderList);
			}
		}
		return totalLevelOrderList;
	}

	/**
	 * https://oj.leetcode.com/problems/balanced-binary-tree/
	 * 
	 * ACCEPTED (not the best)
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		boolean isBanlanced = false;
		if (root == null)
			isBanlanced = true;
		else {
			int leftHeight = caculateNodeHeight(root.left);
			int rightHeight = caculateNodeHeight(root.right);
			if ((leftHeight > rightHeight ? leftHeight - rightHeight
					: rightHeight - leftHeight) > 1)
				isBanlanced = false;
			else {
				isBanlanced = isBalanced(root.left) && isBalanced(root.right);
			}
		}
		return isBanlanced;
	}

	/**
	 * https://oj.leetcode.com/problems/zigzag-conversion/
	 * 
	 * ACCEPTED
	 * 
	 * @param s
	 * @param nRows
	 * @return
	 */
	public static String convert(String s, int nRows) {
		String convertedString = null;
		if (s == null || nRows < 1) {
			convertedString = null;
		} else if (s.length() <= nRows || nRows == 1) {
			convertedString = s;
		} else {
			StringBuilder convertedStringBuilder = new StringBuilder();
			int inputStringLength = s.length();
			// char count for each zigzag
			int zigzagCount = nRows + nRows - 2;
			// full char column count for input string
			int fulllineCount = inputStringLength / zigzagCount + 1;
			// for each row
			for (int rowIndex = 0; rowIndex < nRows; rowIndex++) {
				// for each column
				for (int lineIndex = 0; lineIndex < fulllineCount; lineIndex++) {
					// only 2 chars here

					// the first char on the column
					int index1 = lineIndex * zigzagCount + rowIndex;
					// the second char is between columns
					int index2 = lineIndex * zigzagCount + zigzagCount
							- rowIndex;
					// make sure the first char index is smaller than input
					// string length
					if (index1 < inputStringLength)
						convertedStringBuilder.append(s.charAt(index1));
					// make sure the second char is not same with the first char
					// which happens in the last row
					// and make sure the second char index is smaller than input
					// string length
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

	// ///////////////////////////////////////////////////////////////////
	// private methods
	// ///////////////////////////////////////////////////////////////////

	/**
	 * help method for https://oj.leetcode.com/problems/valid-sudoku/
	 * 
	 * @param board
	 * @return
	 */
	private static boolean doValidateSudokuBlocks(char[][] board) {
		boolean isValidBlocks = true;
		int row = 0;
		int column = 0;
		for (int rowId = 0; rowId < 3; rowId++)
			for (int columnId = 0; columnId < 3; columnId++) {
				int currentRowStart = row + rowId * 3;
				int currentColumnStart = column + columnId * 3;
				char[] currentBlock = new char[9];
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++) {
						currentBlock[i * 3 + j] = board[currentRowStart + i][currentColumnStart
								+ j];
					}
				isValidBlocks &= doValidateSudokuWithNineChars(currentBlock);
				if (!isValidBlocks)
					return isValidBlocks;
			}
		return isValidBlocks;
	}

	/**
	 * help method for https://oj.leetcode.com/problems/valid-sudoku/
	 * 
	 * @param board
	 * @return
	 */
	private static boolean doValidateSudokuRowsAndColumns(char[][] board) {
		boolean isValidRowsAndColumns = true;
		for (int i = 0; i < 9; i++) {
			char[] columns = board[i];
			isValidRowsAndColumns &= doValidateSudokuWithNineChars(columns);
		}
		if (!isValidRowsAndColumns)
			return isValidRowsAndColumns;
		else {
			char[][] transposedBoard = new char[board.length][board.length];
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					transposedBoard[i][j] = board[j][i];
			for (int i = 0; i < 9; i++) {
				char[] rows = transposedBoard[i];
				isValidRowsAndColumns &= doValidateSudokuWithNineChars(rows);
			}
			return isValidRowsAndColumns;
		}
	}

	/**
	 * help method for https://oj.leetcode.com/problems/valid-sudoku/
	 * 
	 * @param nineChars
	 * @return
	 */
	private static boolean doValidateSudokuWithNineChars(char[] nineChars) {
		boolean isValidNineChars = true;
		int[] numbers = new int[10];
		for (char c : nineChars) {
			int charDiffWithZero = c - '0';
			if (1 <= charDiffWithZero && charDiffWithZero <= 9) {
				if (numbers[charDiffWithZero] == 0) {
					numbers[charDiffWithZero]++;
				} else {
					isValidNineChars = false;
					break;
				}
			}
		}
		return isValidNineChars;
	}

	/**
	 * help method for https://oj.leetcode.com/problems/count-and-say/
	 * 
	 * @param s
	 * @return
	 */
	private static String doCountAndSay(String s) {
		StringBuilder result = new StringBuilder();
		int count = 0;
		if (s != null) {
			char currentChar = s.charAt(0);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != currentChar) {
					result.append(count);
					result.append(currentChar);
					count = 1;
				} else {
					count++;
				}
				currentChar = s.charAt(i);
			}
			if (count > 0) {
				result.append(count);
				result.append(currentChar);
			}
		}
		return result.toString();
	}

	/**
	 * help method for https://oj.leetcode.com/problems/balanced-binary-tree/
	 * 
	 * Recursive call
	 * 
	 * @param node
	 * @return
	 */
	private static int caculateNodeHeight(TreeNode node) {
		int height = 0;
		if (node == null)
			height = 0;
		else {
			int leftHeight = caculateNodeHeight(node.left);
			int rightHeight = caculateNodeHeight(node.right);
			height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
		}
		return height;
	}

	/**
	 * help method for https://oj.leetcode.com/problems/permutations/
	 * 
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
