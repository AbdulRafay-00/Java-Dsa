package Class_Concept.Link_List_pack;
import java.util.Comparator;
import java.util.LinkedList;

public class Reverse_Link_List {

    // @SuppressWarnings("unchecked")
    // this will remove all the generic type warnings like in link list when you have forgeten to enter <integer>
    // important it will only remove warning not error
    public static void main(String [] aurg){
        LinkedList <Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(8);
        ll.add(5);



        
        // ll.reversed();
        // System.out.println(ll);
        System.out.println(ll.reversed());
        
        
  // Q) what if you want to sore the current link list in to another link list but in reverced
  // Solution


        // LinkedList secLL = new LinkedList<>();
        
        // for (int i = 0; i < ll.size(); i++) {
        //     secLL.addFirst(ll.get(i));   
        // }
        // System.out.println(secLL);

 // Q2) use of .sort() once the Link is sort it will lost it's orignal order for ever


        // System.out.println("before Sort");
        // System.out.println(ll);

        // // natural order lost for ever
        // ll.sort(Comparator.naturalOrder());
        // System.out.println(" After sort");
        // System.out.println(ll);
        
// Q) reverce
         int temp1 ,temp2;
         for (int i = 0; i < ll.size()/2; i++) {
            temp1 = ll.get(i);
            temp2 = ll.get(ll.size() - 1 -i);
            ll.set(i, temp2);
            ll.set(ll.size()-1-i, temp1);
        
            
         }
         System.out.println(ll);


    }
    
}
