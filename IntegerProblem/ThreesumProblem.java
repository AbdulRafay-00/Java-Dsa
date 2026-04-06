package IntegerProblem;
import java.util.*;

public class ThreesumProblem {

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> arr2 = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int right = nums.length - 1;
            int left = i + 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    arr2.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicate left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return arr2;
    }
}

