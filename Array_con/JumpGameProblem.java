package Array_con;

public class JumpGameProblem {

    public static int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // No need to jump after reaching the last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump's range,
            // we must make another jump.
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1, 2, 1, 1, 1};
        int[] nums4 = {1};
        int[] nums5 = {5, 4, 3, 2, 1, 0};

        System.out.println(jump(nums1)); // 2
        System.out.println(jump(nums2)); // 2
        System.out.println(jump(nums3)); // 3
        System.out.println(jump(nums4)); // 0
        System.out.println(jump(nums5)); // 1
    }
}
