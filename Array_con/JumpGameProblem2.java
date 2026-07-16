package Array_con;

public class JumpGameProblem2 {

    public boolean canJump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd || (i == nums.length - 1 && i < currentEnd)) {
                jumps++;
                currentEnd = farthest;

                if (i == nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGameProblem2 solution = new JumpGameProblem2();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(solution.canJump(nums1)); // true
        System.out.println(solution.canJump(nums2)); // false
    }
}