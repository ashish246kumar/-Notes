import java.util.Map;
import java.util.function.BiConsumer;
import java.util.*;
public class BiConsumerExample {

	
	public static void main(String[]args) {
		BiConsumer<String,Integer> biConsumer2=new BiConsumer<String,Integer>(){

			@Override
			public void accept(String t, Integer u) {
				System.out.println(t+":"+u);
				
			}
			
		};
		
		BiConsumer<String,Integer> biConsumer=(i1,i2)->System.out.println(i1+":"+i2);
		biConsumer.accept("one", 1);
		biConsumer2.accept("two",2);
		Map<String, Integer> map=new HashMap<>();
		map.put("three",3);
		map.put("four",4);
		map.forEach((k,v)->System.out.println(k+":"+v));---->ACCEPTING Bi consumer funtion forEach Method 
//		Map<String,Integer>m1=new HashMap<>();
		
		
	}
}
***************************************************
public class BiFunction {

	
	public static void main(String[]args) {
		List<Integer> l1=Stream.of(3,6,-8,2).collect(Collectors.toList());  //given list of integers
        List<Integer> l2=Stream.of(3,-8,1,2).collect(Collectors.toList());
        BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction1=new BiFunction<List<Integer>,List<Integer>,List<Integer>>(){
            
            @Override
            public List<Integer>  apply(List<Integer> t1, List<Integer> t2){   
                return Stream.of(t1,t2).flatMap(List::stream).distinct().collect(Collectors.toList());

            }
        };
         BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction2=(t1,t2)->{
            
            
                return Stream.of(t1,t2).flatMap(List::stream).distinct().collect(Collectors.toList());

            
        };
        System.out.println(biFunction1.apply(l1,l2)); 
        System.out.println(biFunction2.apply(l1,l2)); 
          //
		Map<String, Integer> map=new HashMap<>();
		map.put("three",3);
		map.put("four",4);
        map.replaceAll((k,v)->v+200);
        System.out.println(map);
		
		
		
	}
}
**************************************************************************************
	
