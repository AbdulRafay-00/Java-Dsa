package binary_search;

public class BinarySearchInRotatedArrayWithDuplicates {
    public boolean search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid;

        while (left <= right){
            mid = left + ((right - left) / 2);
            if (target == nums[mid])return true;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                right --;
                left ++;
            }
            else{
                if(nums[left] == nums[mid]){
                    left ++;
                    continue;
                }
                if(nums[right] == nums[mid]){
                    right --;
                    continue;
                }
                if (nums[left] < nums[mid]){
                    if(nums[mid] > target && nums[left] <= target){
                        right = mid - 1;
                    } else{
                        left = mid + 1;
                    }
                }else{
                    if(nums[mid] < target && nums[right] >= target){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
        }

        return false;
    }

}
