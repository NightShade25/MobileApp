
 public class Threads{

	public static void main(String[]args){

		Thread t1 = new Thread("Thread 1"){
			public void run(){
				for(int i = 1; i < 10; i++)
					System.out.println(getName()+ " "+ i);
			}//run
		};//t1

		Thread t2 = new Thread("Thread 2"){
			public void run(){
				for(int i = 1; i < 10; i++)
					System.out.println(getName()+ " "+ i);
			}//run
		};//t2

		t1.start();
		t2.start();
	try{
		t1.join();
	}catch(Exception e){}
			for(int i = 1; i < 10; i++)
				System.out.println("Main Thread "+ i);


	 }//main
 }//class