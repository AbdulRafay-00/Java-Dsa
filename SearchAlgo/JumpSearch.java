public class JumpSearch {

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        // Finding the block where target may be present
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }

        // Linear search in identified block
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }

        if (arr[prev] == target) return prev;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 8, 13, 21, 34, 55, 89};
        int target = 21;

        int result = jumpSearch(arr, target);

        if (result != -1)
            System.out.println("Element " + target + " found at index " + result);
        else
            System.out.println("Element not found.");
    }
}
