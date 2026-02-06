package Class_Concept.Link_List_pack;
import java.util.Iterator;
import java.util.LinkedList;
// reverced array
public class TwoSumProblem {
    
    public static void main(String[] aurg){
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        l1.addFirst(20);
        l1.addFirst(2);
        l1.addFirst(4);
        Iterator<Integer> it= l1.iterator();

        l2.addFirst(9);
        l2.addFirst(7);
        l2.addFirst(1);
        l2.addFirst(2);

        Iterator<Integer> it2= l2.iterator();
        int e1,e2, sum;
        int carry = 0;


        while (it.hasNext() || it2.hasNext()) {
            if (it.hasNext() ) {
                e1 = it.next();
            }else{
                e1 = 0;
            }

            if (it2.hasNext()) {
                e2 = it2.next();
            }else{
                e2 = 0;
            }


            if (carry > 0) {
                sum = e1 + e2 + carry;
            }else{
                sum = e1 + e2;
            }
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }

            if (!it.hasNext() && !it2.hasNext() && carry > 0 ) {
                res.addFirst(carry);
            }

            res.addFirst(sum);
            
        }
        // res.addFirst(e1+e2);
        System.out.println(res);
    }
}
