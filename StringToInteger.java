public class StringToInteger {
    
    public static void main(String[] args) {
        String s = "-12a34";
        String numStr = s.trim();
        int num = 0;
        int i = 0;
        char a = ' ';

        int sign = 1;
        if(numStr.isEmpty()){
            System.out.println(0);
            
        }else{

        if (numStr.charAt(i) == '+') {
            i++;
        } else if (numStr.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        


        for( ; i < numStr.length(); i++){
            a = numStr.charAt(i);

            if(a < '0' || a > '9') break;

            if (a >= '0' && a <= '9') {

                    if (num > Integer.MAX_VALUE / 10 ||
                        ( num == Integer.MAX_VALUE / 10 
                        && a - '0' >= (sign == 1 ? 7 : 8))) {

                        System.out.println(sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                        
                    }
                num = num * 10 + a - '0';
                
                
            }
            
        }
    }

    if (num == Integer.MIN_VALUE || num == Integer.MAX_VALUE) {
        
        num = num * sign;
        System.out.println(num);
    }
    }
}
