// public class test {
//     public static void main(String[] args) {
//         System.out.println("Hello world");
//         var a = 20;
//         System.out.println(a);
//     }
// }




import java.util.LinkedList;

class Test {
    // link list test case 
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        for (var val : list) {
            System.out.println(val);
        }
    }
}
