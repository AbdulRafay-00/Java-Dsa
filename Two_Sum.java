import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Two_Sum {

    public static void main(String [] aurg){
        ArrayList <Integer> arr = new ArrayList<>(List.of(2,3,6,8,9));
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = 11;

        for (int i = 0; i < arr.size(); i++) {
            int rem_sum = target - arr.get(i)  ;

            if (map.containsValue(rem_sum) == true) {
                System.out.println("Your Target Was: " + target);
                System.out.println("Element in the list supporting your sum were");
                System.out.println(arr.get(i) + " and " + rem_sum);
                System.out.println(" having Index" + i +" and " +  arr.indexOf(rem_sum));
                break;

            }else{
                map.put(i, arr.get(i));
            }

        }

    }
}