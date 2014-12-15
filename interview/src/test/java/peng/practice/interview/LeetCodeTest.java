package peng.practice.interview;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeetCodeTest {

	@Test
	public void permute() {
		int[] num = { 1, 2, 3, 4};
		List<List<Integer>> result = LeetCode.permute(num);
		for (List<Integer> list : result) {
			for (int a : list) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		Assert.assertEquals(result.size(), 24, "should have 4!=4*3*2*1=24 permutations.");
	}
}
