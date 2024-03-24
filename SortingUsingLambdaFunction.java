*************************************************SortingUsingLambdaFunction***********************************************************************************
public static void main(String[]args) {
		List<Integer>l1=new ArrayList<>(Arrays.asList(2,1,9,4));
        List<Integer>l2=new ArrayList<>(Arrays.asList(12,10,16,4));
        
        l1.sort((i1,i2)->i1.compareTo(i2));

        System.out.println(l1);
        Collections.sort(l1,(a,b)->b.compareTo(a));
         System.out.println(l1);
        //  l2.stream().sorted((a,b)->(a-b)).forEach(System.out::println); 
        l2.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); 
	}
