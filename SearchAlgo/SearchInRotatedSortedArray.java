package SearchAlgo;

public class SearchInRotatedSortedArray {

    public boolean search(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
            }

            // Left half is sorted
            else if (nums[st] <= nums[mid]) {

                if (target >= nums[st] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }

            }

            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(obj.search(nums1, 0)); // true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(obj.search(nums2, 3)); // false

        int[] nums3 = {1, 1, 1, 3, 1};
        System.out.println(obj.search(nums3, 3)); // true

        int[] nums4 = {1, 0, 1, 1, 1};
        System.out.println(obj.search(nums4, 0)); // true
    }
}