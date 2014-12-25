package peng.practice.interview;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AskedTest {

	@Test
	public void findTopTenWords() {
		String[] words = { "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "uwx", "yz", 
						   "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "uwx", "yz", 
						   "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "uwx", 
						   "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", 
						   "abc", "def", "ghi", "jkl", "mno", "pqr", 
						   "abc", "def", "ghi", "jkl", "mno", 
						   "abc", "def", "ghi", "jkl", 
						   "abc", "def", "ghi", 
						   "abc", "def", 
						   "abc", 
						   "123", "456", "789", "123", "123", "123", "123" };
		List<String> expected = new ArrayList<String>();
		expected.add("abc");
		expected.add("def");
		expected.add("ghi");
		expected.add("jkl");
		expected.add("mno");
		expected.add("pqr");
		expected.add("123");
		expected.add("stu");
		expected.add("uwx");
		expected.add("yz");
		List<String> actual = Asked.findTopTenWords(words);
		for (String s : actual)
			System.out.println(s);
		assertEquals(actual, expected);
	}
}
