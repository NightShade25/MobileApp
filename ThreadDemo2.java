import java.util.concurrent.atomic.*; //or  java.util.concurrent.atomic.AtomicInteger

public class ThreadDemo2{

	static int i = 0;
	static int si = 0;
	static AtomicInteger ai;


	public static synchronized void add(){
		si++;
	}

	public static void main(String[]args){

		ai = new AtomicInteger(0);			//bc atomic integer is special, cant just use things like ++.

		for(int j = 0; j < 200; j++){
			new MyThread().start();
		}
		try{
			Thread.sleep(3000);
		}catch(Exception e){
		//error
		}
		System.out.println("value of i : " + i);
		System.out.println("value of si : " + si);
		System.out.println("value of ai : " + ai);
	}

	public static class MyThread extends Thread{
		public void run(){
			try{
				Thread.sleep(2);
			}catch(Exception e){
			//error
			}
			i++;
			add();
			ai.getAndAdd(1);
		}
	}
}