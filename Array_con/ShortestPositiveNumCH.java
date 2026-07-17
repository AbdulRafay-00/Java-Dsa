package Array_con;

public class ShortestPositiveNumCH {

    public static int firstMissingPositive(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correct = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= nums.length &&
                nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1)); // 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2)); // 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3)); // 1

        int[] nums4 = {1, 2, 3};
        System.out.println(firstMissingPositive(nums4)); // 4

        int[] nums5 = {2, 1};
        System.out.println(firstMissingPositive(nums5)); // 3

        int[] nums6 = {1, 1};
        System.out.println(firstMissingPositive(nums6)); // 2

        int[] nums7 = {2, 2};
        System.out.println(firstMissingPositive(nums7)); // 1

        int[] nums8 = {-1, -2, -3};
        System.out.println(firstMissingPositive(nums8)); // 1

        int[] nums9 = {1, 1000};
        System.out.println(firstMissingPositive(nums9)); // 2

        int[] nums10 = {2, 3, 4};
        System.out.println(firstMissingPositive(nums10)); // 1
    }
}