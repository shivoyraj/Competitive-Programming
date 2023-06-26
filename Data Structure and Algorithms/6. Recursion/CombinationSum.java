// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void combinationSum(int[] nums, int i, int target, List<Integer> current, 		                                    List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (i == nums.length || target < 0 || nums[i] > target)
            return;

        current.add(nums[i]);
        combinationSum(nums, i, target - nums[i], current, res);
        current.remove(current.size() - 1);
        combinationSum(nums, i + 1, target, current, res);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(nums, 0, target, new ArrayList<>(), res);
        return res;
    }
}
