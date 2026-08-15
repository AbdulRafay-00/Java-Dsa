package Array_con;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ele = m + n;
        int it1 = m - 1;
        int it2 = n - 1;

        while (it2 >= 0) {
            if (it1 >= 0) {
                if (nums1[it1] >= nums2[it2]) {
                    nums1[ele - 1] = nums1[it1];
                    ele--;
                    it1--;
                } else {
                    nums1[ele - 1] = nums2[it2];
                    ele--;
                    it2--;
                }
            } else {
                nums1[ele - 1] = nums2[it2];
                ele--;
                it2--;
            }
        }
    }
}