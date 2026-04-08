package IntegerProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList();
        long rem_sum = 0;

        for(int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i+1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int right = nums.length-1;
                int left = j+1;
                while(left < right){
                    rem_sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(rem_sum == target){
                    arr.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;

                    }else if(rem_sum > target){
                        right--;
                    }else if(rem_sum < target){

                        left++;
                    }

                }
            }
        }
        return arr;
    }
}

