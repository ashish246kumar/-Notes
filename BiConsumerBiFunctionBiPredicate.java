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
		map.forEach((k,v)->System.out.println(k+":"+v));
//		Map<String,Integer>m1=new HashMap<>();
		
		
	}
}
***************************************************
