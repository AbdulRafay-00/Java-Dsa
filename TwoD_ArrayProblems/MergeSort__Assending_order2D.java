package TwoD_ArrayProblems;

import java.util.Arrays;
import java.util.List;

public class MergeSort__Assending_order2D {

/** this code is for sorting 2D array in descending order using merge sort algorithm
    where keeping the inner array as it is and sorting the outer array based on the first element of each inner array */
    public static void main(String aurg []){
        // List list[][]= {[]};
        int arr[][] = {{1, 2}, {5, 6}, {7, 8}, {3, 4}, {9, 10}};

        int start = 0;
        int end = arr.length-1;

        System.out.println("start: "+start+" end: "+end);
        System.out.println("Before sorting: ");
        int [][] sorted = mergeSort(arr);
        System.out.println("After sorting: ");
        System.out.println("Sorted array: ");
        for(int i = 0; i < sorted.length; i++){

            System.out.println(Arrays.toString(sorted[i]));
        }

    }

// merge function
    public static  int[][] mergeSort (int [][] list1){
        int n = list1.length;
        int m = 0;
        if(n <= 1){
            return list1;
        }
        int mid = m + ((n - m) / 2);
        int [][] list4 = new int[mid][list1[0].length];
        int [][] list5 = new int[n - mid][list1[0].length];
        for(int i = 0; i < n/2; i++){
            list4[i] = list1[i];
        }
        for(int i = n/2; i < n; i++){
            list5[i - n/2] = list1[i];
        }

        // int mid = start + (end - start) / 2;

        int [][] list2 = mergeSort(list4);
        int [][] list3 = mergeSort(list5);
        
        return conquer(list2, list3);
    }


//merge function
// Assending order compare the first element of each 2D array
    public static int[][] conquer( int [][] list1, int [][] list2){
        int i =0 ;
        int j = 0;
        int count = 0;
        int [][] ressult = new int[list1.length + list2.length][list1[0].length];
        while(i < list1.length && j < list2.length){
            if(list1[i][0] > list2[j][0]){
                ressult[count] = list1[i];
                count++;
                i++;
            }else{
                ressult[count] = list2[j];
                count++;
                j++;
        }
    }
// copy remaining elements from list 1
    while(i < list1.length){
        ressult[count] = list1[i];
        i++;
        count++;
    }

// copy remaining elements from list 2
    while(j < list2.length){
        ressult[count] = list2[j];
        j++;
        count++;
    }


        return ressult;
    }
}

