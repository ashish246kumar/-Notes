public static void main(String args[]) {
		 
		 List<Integer> nums = Arrays.asList(1,2,4,2,3,4,5,6,8,101);
		 List<String> fruits = Arrays.asList("apple", "banana", "cherry", "coconut", "apple");

		 Integer sums1=nums.stream().reduce(0,(a,b)->a+b);
		 
		 Integer max1=nums.stream().reduce(Integer::max).get();

	        //Given a List of strings, write a program to count the number of strings that start with a specific character using streams.
		 long fruitCount=fruits.stream().filter((s)->s.startsWith("a")).count();

	        //Write a program to convert a List of strings to uppercase using streams.
		 List<String>l4=fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
		 System.out.println(l4);
		 
		 //Write a program to find the average of a List of floating-point numbers using streams.
	        List<Double> numsFloat = Arrays.asList(1.3, 2.4, 3.1, 4.2, 5.4);
	        double d1=numsFloat.stream().reduce((a,b)->(a+b)/2).get();
	        System.out.println(d1);
		 
	        //Given a List of strings, write a program to concatenate all the strings using streams.
	        String concatenatedString =fruits.stream().collect(Collectors.joining());
	        System.out.println(concatenatedString);
	        
	      //Write a program to remove duplicate elements from a List using streams.
	        nums.stream().distinct().forEach(System.out::println);
	        
	      //Write a program to check if all elements in a List satisfy a given condition using streams.
	        List<Integer> numbers = Arrays.asList(12, 4, 6, 8, 10);
	        
	        boolean b1=numbers.stream().allMatch(n->n%2==0);
	        System.out.println(b1);
	      //Sort a list of  in ascending order using streams.
	       numbers.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
	     //Check if a list contains a specific element using streams.
	       
	       boolean exists=numbers.stream().anyMatch(n->n.equals(12));
	       
	       //Find the average length of strings in a list using streams.
	       double d5=fruits.stream().mapToInt(String::length).average().getAsDouble();
	       System.out.println(d5);
	       //Find the longest string in a list using streams.
	       int len=fruits.stream().mapToInt(String::length).max().getAsInt();
	       System.out.println(len);
	       
//	       Group a list of objects based on a specific attribute using streams.
	       
	       List<Employee> sortedEmployees =EmployeeDatabase.getEmployees().stream()
	       .sorted(Comparator.comparing(Employee::getGender).thenComparing(Employee::getSalary))
	       .collect(Collectors.toList());
	       sortedEmployees.forEach(e->System.out.println(e.getGender()+":"+e.getSalary()));
	      
	       //Find the second smallest element in a list of integers using streams.
	       int minnumber=numbers.stream().distinct().sorted().skip(1).findFirst().get();
	       System.out.println(minnumber);
	       
	       
	       //Find the intersection of two lists using streams
	        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
	        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
	        List<Integer> intersection =list1.stream().filter(list2::contains).collect(Collectors.toList());
	        System.out.println(intersection);
	        
	 }
	 ***********************************************************************************************************************
		 				COMPARTOR BASED SORTING QYUESTION

	***********************************************************************************************************************
		  public static void main(String args[]) {
		 
		 List<Integer> nums = Arrays.asList(1,2,4,2,3,4,5,6,8,101);
		 List<String> fruits = Arrays.asList("apple", "banana", "cherry", "coconut", "amla");

//		 Sort the list based on length in asending order
		 fruits.sort(Comparator.comparing(String::length));
	        
	        System.out.println(fruits);
	        
	        
//	        Sort the list of integer in decending order
	        fruits.sort(Comparator.comparing(String::length).reversed());
	        nums.sort(Comparator.reverseOrder());
	        System.out.println(nums);
	        
//	        sort the list of string  
//	        based on the index of the first occurance of "e"  in each string ad print the result
	        fruits.sort(Comparator.comparing(e->e.indexOf("a")));
	        System.out.println("fruits with index position sorting"+fruits);
		 *************************************************************************************************************
     
