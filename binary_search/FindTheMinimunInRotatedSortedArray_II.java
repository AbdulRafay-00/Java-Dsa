package binary_search;

public class FindTheMinimunInRotatedSortedArray_II {
class Solution {
    
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
                if((nums[left] >= target) && ( target < nums[mid])){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}

}
