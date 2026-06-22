package SpecialProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            result.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Choose
            swap(nums, index, i);

            // Explore
            backtrack(nums, index + 1, result);

            // Undo
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class PossiblePermutation {

    public static void main(String[] args) {

        Solution s = new Solution();
// case1
        int[] nums = {1, 2, 3};
// case2
//        int[] nums = {1, 2, 3, 4};
// case3
        // int[] nums = {1};
        List<List<Integer>> result = s.permute(nums);

        System.out.println(result);
    }
}