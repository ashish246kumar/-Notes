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
	public class BiPredicate {

	
	public static void main(String[]args) {
		BiPredicate<String,String> isEqual= (x,y)-> x.equals(y);
        BiPredicate<String,String> islengthEqual=(x,y)->x.length()==y.length();
		System.out.println(isEqual.test("Hello","World")); 
		System.out.println(islengthEqual.test("Hello","World"));
        
	}
}
*************************************
	
public static void main(String[] args) {

      Map<String,Integer> map = new HashMap<>();
        map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
    List<Entry<String,Integer>> l=new ArrayList<>(map.entrySet());
    Collections.sort(l,(a,b)->a.getKey().compareTo(b.getKey()));
   l.forEach(e -> System.out.println(e.getKey() + "   " + e.getValue()));
    map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    }
***********************************
	Consumer represents an operation that takes a single input and returns no result.
	Consumer<String> printer = message -> System.out.println("Message: " + message);
printer.accept("Hello, world!"); // Output: Message: Hello, world!
***************
	It does not accept any arguments but produces a value.
	Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);
int randomNumber = randomNumberSupplier.get();
System.out.println("Random number: " + randomNumber);
***********************
	Function represents a function that accepts one argument and produces a result.
	Function<Integer, String> toStringFunction = number -> "Number: " + number;
String result = toStringFunction.apply(42);
System.out.println(result); // Output: Number: 42



