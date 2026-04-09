public class IntegerReverse {
    static void main(String[] args) {
        int a = 21;
        String s = Integer.toString(a);
        String rev = "";

        for(int i = s.length() -1; i >= 0; i--){
            rev += s.charAt(i);
        }
//result
        int finalRev = Integer.parseInt(rev);
        System.out.println(finalRev);
      
        
    }
}
