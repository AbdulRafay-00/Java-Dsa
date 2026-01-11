package Class_Concept;
// class Shape

import java.util.ArrayList;
import java.util.List;

class Shapes {
    String Color ;
    int sides;
    ArrayList <Integer> arr = new ArrayList<>(List.of(1,2,3,4,5));

    String shape_func(){

        for (int i = 0; i < arr.size(); i++) {
            
            System.out.println(arr.get(i));
        }
        return arr.toString();
    }

    @Override
    public String toString() {
        return "Shapes [Color=" + Color +
               ", sides=" + sides +
               ", arr=" + shape_func() + "]";
    }
 
}




public class class_obj {
    public static void main(String[] aurg){
            ArrayList <Shapes> arrr = new ArrayList<>();
            Shapes sha2 =new Shapes();
            arrr.add( sha2 );
        // System.out.println("hi i am here");
        Shapes sha =new Shapes();
        arrr.add(sha);

    System.out.println(arrr.get(0));

    }
}
