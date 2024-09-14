CompletableFuture API. It provides a way to 
perform asynchronous programming in Java.
In the context of CompletableFuture, callback functions are represented by methods like thenApply, thenAccept, thenRun.
*************************************************************************************************
CompletableFuture provides a more flexible and powerful API for working with asynchronous computations than Future. It offers non-blocking methods, composition methods, better
exception handling, and explicit completion methods, which makes it easier to write robust and scalable concurrent code.
**************
  using Asynchronous programing we can write non blocking code.where concurrently you can run n no of task in seprate thread 
  without blocking main thread.
  when the task completed it will notify main thread whether the task is completed or failed.
  **********
  we can asynchronous programming throgh Future, ExecutreService, callBack Interface, ThreadPool.
  **************************************
Its is not practically possible to combine two asynchronous tasks when these two tasks are independent or the result of second task depends on the first.

*************************************************************************
final CompletableFuture<Optional<JourneyChecklist>> digitalLeadDetailsFuture =
            CompletableFuture.supplyAsync(
                () -> digitalLeadServiceClient.getDigitalPlRecord(leadId, xCode));
        final Optional<JourneyChecklist> digitalLeadDetails =
            getDigitalLeadDetails(digitalLeadDetailsFuture);
private Optional<JourneyChecklist> getDigitalLeadDetails(
      final CompletableFuture<Optional<JourneyChecklist>> digitalLeadDetailsFuture) {
    try {
      return digitalLeadDetailsFuture.get();
    } catch (final InterruptedException | ExecutionException | FeignException e) {
      log.error("Exception occurred in digital-loan-service api - {} ", e.getMessage());
    }
    return Optional.empty();
  }
**********************************************************************************************************************
 if (!leadResponseListOfCrossSell.isEmpty()) {
      // Fetch All leads from cross-sell asynchronously
      final List<CompletableFuture<LeadResponse>> futures =
          leadResponseListOfCrossSell.stream()
              .map(
                  leadResponse ->
                      CompletableFuture.supplyAsync(() -> isActiveCrossSellRecord(leadResponse))
                          .exceptionally(
                              ex -> {
                                log.error(
                                    "Exception while trying to fetch from cross-sell service for leadId - {}, exception - {}",
                                    leadResponse.getLeadId(),
                                    ex.getMessage());
                                return null;
                              }))
              .toList();

      // Blocker to wait for getting all responses
      final Optional<LeadResponse> processedLeadResponses =
          futures.stream().map(CompletableFuture::join).filter(Objects::nonNull).findFirst();
****************************************************************************************************************************


  Given Example
   is blocking  Main thread.
  ExecutorService executorService=Executors.newFixedThreadPool(10);
		 Future<List<Integer>> future=executorService.submit(()->{
			 System.out.println(Thread.currentThread().getName());
			 Thread.sleep(5000);
			 return Arrays.asList(1,3,11,4,9);
		 });
		 List<Integer> l1 = null;
		try {
			l1 = future.get();
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		 System.out.println(l1);
		 System.out.println("aaaaaaaaa");
************************************************
  We can not combine Multiple future together.
  ***********************
  ExecutorService executorService=Executors.newFixedThreadPool(10);
		 Future<List<Integer>> future=executorService.submit(()->{
			 System.out.println(Thread.currentThread().getName());
			 Thread.sleep(5000);
			 return Arrays.asList(1,3,11,4,9);
		 });
		 Future<List<Integer>> future2=executorService.submit(()->{
			 System.out.println(Thread.currentThread().getName());
			 Thread.sleep(5000);
			 return Arrays.asList(50,70);
		 });
		 List<Integer> l1 = null;
		 List<Integer> l2 = null;
		try {
			l1 = future.get();
			
			l2 = future2.get();
			
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		
		 System.out.println(l1);
		 System.out.println(l2);
		 System.out.println("aaaaaaaaa");
			
//		 ); 
	    }
*************************
    No Proper Exception Handling
****************************************
   ExecutorService executorService=Executors.newFixedThreadPool(10);
		 Future<List<Integer>> future=executorService.submit(()->{
			 System.out.println(Thread.currentThread().getName());
			 System.out.println(10/0);
			 Thread.sleep(5000);
			 return Arrays.asList(1,3,11,4,9);
		 });
		
		 List<Integer> l1 = null;
		 List<Integer> l2 = null;
		try {
			l1 = future.get();
			
			
			
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		
		 System.out.println(l1);
		
		 System.out.println("aaaaaaaaa");
****************************************************************************************************
                                  CompletableFuture.runAsync()
****************************************************************************************************
   public static void main(String args[]) throws InterruptedException, ExecutionException {

		 	ExecutorService executorService=Executors.newFixedThreadPool(5);
		 	CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
		 		System.out.println("Task started asynchronously..."+Thread.currentThread().getName());
	            try {
	                Thread.sleep(5000); // Simulate a time-consuming task
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("Task completed."+Thread.currentThread().getName());
		 	},executorService);
		 	

		 	System.out.println("*****************"+Thread.currentThread().getName());
		 	
		 
		 
	    }
************************************************************
  public class Main {

	public void first() throws InterruptedException, ExecutionException {
		
		ExecutorService executorService=Executors.newFixedThreadPool(5);
	 	CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
	 		System.out.println("Task started asynchronously..."+Thread.currentThread().getName());
            try {
                Thread.sleep(5000); // Simulate a time-consuming task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed..........."+Thread.currentThread().getName());
	 	},executorService);
	 	future.get();
	}
    public void Second() throws InterruptedException, ExecutionException {
		
		ExecutorService executorService=Executors.newFixedThreadPool(5);
	 	CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
	 		System.out.println("Second Task started asynchronously..."+Thread.currentThread().getName());
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second Task completed..........."+Thread.currentThread().getName());
	 	},executorService);
	 	
	}
	
	 public static void main(String args[]) throws InterruptedException, ExecutionException {

		 Main  m=new Main();
		 m.first();
		 m.Second();
		System.out.println("*****************"+Thread.currentThread().getName());
		 	
		 
		 
	    }

}
output:
Task started asynchronously...pool-1-thread-1
Task completed...........pool-1-thread-1
*****************main
Second Task started asynchronously...pool-2-thread-1
Second Task completed...........pool-2-thread-1

  
***************************************************************************************
  thenApply()      |  thenApply(), thenAccept()
************************************************************************************************
	
public class Employee {

	 private String employeeId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String gender;
	    private String newJoiner;
	    private String learningPending;
	    private int salary;
	    private int rating;
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getNewJoiner() {
			return newJoiner;
		}
		public void setNewJoiner(String newJoiner) {
			this.newJoiner = newJoiner;
		}
		public String getLearningPending() {
			return learningPending;
		}
		public void setLearningPending(String learningPending) {
			this.learningPending = learningPending;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public Employee(String employeeId, String firstName, String lastName, String email, String gender,
				String newJoiner, String learningPending, int salary, int rating) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.gender = gender;
			this.newJoiner = newJoiner;
			this.learningPending = learningPending;
			this.salary = salary;
			this.rating = rating;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

}
****************
	import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

	 public static List<Employee> getEmployees(){

		return Stream.of( new Employee(
				 "88-017-8770",
			      "Meris",
			     "Foote",
			    "mfoote19@dailymotion.com",
			      "Female",
			     "TRUE",
			     "FALSE",
			       71972,
			       4),
				new Employee(
						"93-205-9935",
					      "Pietrek",
					      "Croxall",
					      "pcroxallu@rambler.ru",
					      "Female",
					      "FALSE",
					      "TRUE",
					      87379,
					      5
						),
			new Employee(
					 "58-726-1029",
					    "Eric",
					    "Gilhoolie",
					    "egilhoolieo@salon.com",
					    "Male",
					    "TRUE",
					    "TRUE",
					    97509,
					    0
					),
			new Employee(
					 "84-183-9334",
					    "Ibrahim",
					    "Leggett",
					    "ileggettq@delicious.com",
					    "Female",
					    "TRUE",
					    "TRUE",
					    197211,
					    1
					)
				 
		 ).collect(Collectors.toList());
	    }
}
***************
	import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {
	public static void sendEmail(String email) {
        System.out.println("sending training reminder email to : " + email);
    }

	public  CompletableFuture<Void> first() throws InterruptedException, ExecutionException {
		Executor executor=Executors.newFixedThreadPool(5);
		  CompletableFuture<Void> voidCompletableFuture =CompletableFuture.supplyAsync(() -> {
			  
			  return EmployeeDatabase.getEmployees();
			},executor).thenApplyAsync((employees)->{
				
				 System.out.println("fetchEmployee : " + Thread.currentThread().getName());
				return employees.stream().filter(employee->employee.getNewJoiner().equals("TRUE"))
				.collect(Collectors.toList());
			},executor).thenApplyAsync((employees)->{
				
			    System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
				return employees.stream().filter(employee->employee.getLearningPending().equals("TRUE"))
				.collect(Collectors.toList());
			},executor).thenApplyAsync((employees)->{
				
	            System.out.println("get emails  : " + Thread.currentThread().getName());

				return employees.stream().map(Employee::getEmail)
				.collect(Collectors.toList());
			},executor)
		   .thenAcceptAsync((emails)->{
			 
			   System.out.println("send email  : " + Thread.currentThread().getName());
				emails.forEach(Main::sendEmail);
			},executor);
		 
		  return voidCompletableFuture;
		
	}
	
   
	
	 public static void main(String args[]) throws InterruptedException, ExecutionException {

		Main m1=new Main();
		CompletableFuture<Void> future = m1.first();
		
        future.get();
	 System.out.println("********************************");
		 
		 
	    }

}
***********************
