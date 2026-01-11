/*  
 important stream it dose tnot change the value of the orignal list 
 it is not the data structure
 create copy of data and work with it 
 coppied data can only be used once
*/
// stream           vs                 parallel stream

//1) when data is small and need single thread                  when data is big and need multiple threads
//2) when data sequence isimportanr                             when data sequence is not important

package Class_Concept.Streams_Annotation_lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsApi {
    public static void main(String[] args) {
        ArrayList <Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6));
        Stream <Integer> str =  arr.stream();

// once stream id used it cannot be re used
        // System.out.println(str.toList());

// here it will give error becaue the stream is alredy been use once above
        // System.out.println(str.toList());

//. every dot notation  will create a new stream  so, it will filter the list and give us the even number as condition
        // str.filter(x -> x % 2 ==0);
        
        // error becatue the strteam str is already used in filter functon now the filter functon will give the next stream could be used by  dot notation
        // System.out.println(str.toList());
        
        // or
        // str.filter(x -> {
            //     return x % 2 ==0;
            
            // });
            
            // or 
            
        // str.filter(x -> x % 2 ==0).forEach(x -> System.out.println(x));


// .map()  is not same as the Map, hashmap
// what it dose it take one input and process it and give one ontput no key value pair
// first .filter then perforn req operration on filtered data

      str.filter(x -> x % 2 == 0).map(x -> x*2).forEach( x -> System.out.println(x)); // all even number will be doubled
 
    }
}
