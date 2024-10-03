package leetcode;

import java.util.ArrayList;
import java.util.List;

//
public class Subsets_78 {
	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1, 2, 3}));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		ArrayList<List<Integer>> resultList = new ArrayList<>();
		backtracking(0, new ArrayList<>(), resultList, nums);

		return resultList;
	}

	static void backtracking(int startIdx, List<Integer> curList, List<List<Integer>> answer, int[] nums) {
		answer.add(new ArrayList<>(curList));
		System.out.println("answer " + answer);
		for (int i = startIdx; i < nums.length; i++) {
			curList.add(nums[i]);
			backtracking(i + 1, curList, answer, nums);
			curList.remove(curList.size() - 1);
		}
	}
}
