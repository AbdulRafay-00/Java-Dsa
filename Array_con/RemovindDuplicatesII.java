package Array_con;

public class RemovindDuplicatesII {

    public static int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int write = 2;

        for (int read = 2; read < nums.length; read++) {

            if (nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int length = removeDuplicates(nums);

        System.out.println("Length: " + length);

        System.out.print("Array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}