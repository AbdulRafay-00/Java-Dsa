package binary_search;

public class MinimunInRotatedTree {
      
    public int findMin(int[] nums) {
        int st = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (st < end) {

            mid = st + (end - st) / 2;          

            if (nums[st] > nums[mid] && nums[end] < nums[mid]) {
                st = mid + 1;                 
                continue;
            }
            else if (nums[st] < nums[mid] && nums[end] > nums[mid]) {
                end = mid - 1;                  
                continue;
            }
            else if (nums[st] >= nums[mid] && nums[end] >= nums[mid]) {
                if (mid > 0 && mid < nums.length - 1) {
                    if (nums[mid] < nums[mid - 1] &&
                        nums[mid] < nums[mid + 1]) {
                        return nums[mid];
                    }
                }
                end = mid - 1;                  
                continue;
            }
            else if (nums[st] <= nums[mid] && nums[end] <= nums[mid]) {
                st = mid + 1;                 
                continue;
            }

        }

        return nums[st];
    }

}
