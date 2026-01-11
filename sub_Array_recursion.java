import java.util.ArrayList;
import java.util.List;

public class sub_Array_recursion{
    public static void main(String [] aurg){
        ArrayList <Integer> list1 = new ArrayList<>(List.of( 1,2,3,4,5,6));
        sub_Array_fhnc(list1, 0,0);
    }



    public static void sub_Array_fhnc(ArrayList<Integer> list1, int i,int k){
        if (i == list1.size()){
            return;
        }

        if (k == list1.size()) {
    sub_Array_fhnc(list1, i+1, i+1);
            return ;
        }

        System.out.print("[");
        for (int j = i; j <= k; j++) {
            System.out.print(list1.get(j));

        }
        System.out.print("]    ");

        
        sub_Array_fhnc(list1, i, k+1);

        return;


    }
}



// track

// import java.util.ArrayList;
// import java.util.List;

// public class sub_Array_recursion{
//     public static void main(String [] aurg){
//         ArrayList <Integer> list1 = new ArrayList<>(List.of( 1,2,3,4,5,6));
//         int count=0;
//         sub_Array_fhnc(list1, 0,0 , count);
//     }

//     // sub string function

//     public static void sub_Array_fhnc(ArrayList<Integer> list1, int i,int k, int count){
//         // System.out.println(k);
//         if (k == list1.size()) {

//             return ;
//         }
//         // System.out.println(k);
//         // System.out.print("[");
//         for (int j = i; j <= k; j++) {
//             // System.out.print(list1.get(j));
//             System.out.println("times recursion happends: " + count);
//             count++;

//         }
//         // System.out.print("]    ");
//         // System.out.println("val "+ k);
        
//         sub_Array_fhnc(list1, i, k+1, count);
//         if(k == i){

//             sub_Array_fhnc(list1, i+1, k+1, count );
//             return;
//         }
//         return;


//     }
// }
