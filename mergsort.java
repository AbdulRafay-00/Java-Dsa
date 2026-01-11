// import java.util.ArrayList;
// import java.util.List;
// public class Main{
//     public static void main(String args[] ){
//         System.out.println("goal");
//         ArrayList list1 = new ArrayList<>(List.of(1,2,3,4,5,5));
//         // list1.add(10);
// ArrayList list2 = new ArrayList<>();
// ArrayList list3 = new ArrayList<>();
//         mergSort(list1, list2, list3);

//     System.out.println(list1);
        

//     }
//     public static ArrayList mergSort( ArrayList list1, ArrayList list2, ArrayList list3 ){
//         if(list2.size() == 1 && list3.size()==1 ){
//             return conquer_Array(list1, list2, list3);
//         }else{
//             int middle_Arr = list1.size()/2;
//             for (int i = 0; i == middle_Arr ; i++) {
//                 list2.add(i);
//             }
//             for (int i = middle_Arr+1; i < list1.size() ; i++) {
//                 list2.add(i);
//             }
//         }

//         return mergSort(list1, list2, list3);
//     }

//     // new merg

//     public static ArrayList conquer_Array(ArrayList list1 ,ArrayList<Integer> list2, ArrayList<Integer> list3 ){
//         int rightSide = list2.size();
//         int leftSide = list3.size();
//         int i = 0, j = 0, k = 0 ;

//         while (rightSide < 0 && leftSide < 0) {
//             rightSide--;
//             leftSide--;
//             if (list2.get(i) < list3.get(j)) {
//                 list1.set(k, list2.get(i));
//                 i++;
//                 k++;
//             }else{
//                 list1.set(k, list3.get(i));
//                 j++;
//                 k++;

//             }
//         }
//         return list1;


//     }



// }



import java.util.ArrayList;
import java.util.List;

public class mergsort {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 7, 5));

        ArrayList<Integer> sorted = mergSort(list1);

        System.out.println(sorted);
    }

    // merge sort
    public static ArrayList<Integer> mergSort(ArrayList<Integer> list) {

        // ✅ base case
        if (list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;

        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // ✅ correct splitting (values, not indexes)
        for (int i = 0; i < middle; i++) {
            list2.add(list.get(i));
        }

        for (int i = middle; i < list.size(); i++) {
            list3.add(list.get(i));
        }

        // recursive calls
        list2 = mergSort(list2);
        list3 = mergSort(list3);

        // merge
        return conquer_Array(list2, list3);
    }

    // merge two sorted lists
    public static ArrayList<Integer> conquer_Array(
            ArrayList<Integer> list2,
            ArrayList<Integer> list3) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        // ✅ correct while condition
        while (i < list2.size() && j < list3.size()) {
            if (list2.get(i) <= list3.get(j)) {
                result.add(list2.get(i));
                i++;
            } else {
                result.add(list3.get(j));
                j++;
            }
        }

        // remaining elements
        while (i < list2.size()) {
            result.add(list2.get(i));
            i++;
        }

        while (j < list3.size()) {
            result.add(list3.get(j));
            j++;
        }

        return result;
    }
}
