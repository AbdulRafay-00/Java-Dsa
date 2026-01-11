package Class_Concept.Stack_question;
import java.util.LinkedList;


class Stack<T> {
    private LinkedList <T> list = new LinkedList<>();
// put func
    public void put(T data){
     list.addFirst(data);
    }

// pop func
    public T  pop(){
        if (list.isEmpty()) {
            
            return null ;
        }
        // System.err.println(list.getFirst());
        return list.removeFirst();

    }


//peek
    
    public T  peek(){
        if (list.isEmpty()) {
            
            return null ;
        }
        // System.err.println(list.getFirst());
        return list.getFirst();

    }


}

public class stack_implementation {
    @SuppressWarnings("unchecked")
public static void main(String[] args) {
    Stack <Integer> sta = new Stack <Integer>();
    sta.put(1);
    sta.put(2);
    sta.put(3);
    sta.put(4);
    // sta.put("dd");
    // System.out.println(sta.pop());
    // System.out.println(sta.pop());
    // System.out.println(sta.pop());
    // System.out.println(sta.pop());
    // System.out.println(sta.pop());
    System.out.println(sta.peek());
}
}
