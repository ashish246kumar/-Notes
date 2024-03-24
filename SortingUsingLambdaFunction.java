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
**************************
	
public class Employee {

	 private int id;
	    private String name;
	    private String grade;
	    private double salary;

	    public Employee() {
	    }

	    public Employee(int id, String name, String grade, double salary) {
	        this.id = id;
	        this.name = name;
	        this.grade = grade;
	        this.salary = salary;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    public void setGrade(String grade) {
	        this.grade = grade;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

}
***********
	public class DataBase {

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(176, "Roshan", "IT", 600000));
		list.add(new Employee(388, "Bikash", "CIVIL", 900000));
		list.add(new Employee(470, "Bimal", "DEFENCE", 500000));
		list.add(new Employee(624, "Sourav", "CORE", 400000));
		list.add(new Employee(176, "Prakash", "SOCIAL", 1200000));
		return list;
	}
}
************
	public class Main {

	 public static void main(String args[]) {


		 List<Employee> employees = DataBase.getEmployees();
		 Collections.sort(employees, ( o1,  o2) ->(int) (o1.getSalary() - o2.getSalary()));
		 Collections.sort(employees, Comparator.comparing(Employee::getGrade));
		 employees.stream().map(Employee::getGrade).forEach(System.out::println);
		 employees.stream().map(Employee::getSalary).forEach(System.out::println);
		 
******************************************************************
	
