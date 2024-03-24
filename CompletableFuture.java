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
  ***********************
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
  
