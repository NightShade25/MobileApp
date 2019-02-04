import java.io.FileNotFoundException;

public class ExceptionDemo{

	public static void m1(){

		int x = 4;
		int y = 0;
		int z = x/y;

		System.out.println(z);

	}

	public static void m2(){
		try{
			int x = 4;
			int y = 0;
			int z = x/y;

			System.out.println(z);
		}catch(Exception e){
			System.out.println("Error");
		}
	}

	public static void m3(){
		try{
			int x = 4;
			int y = 0;
			int z = x/y;

			System.out.println(z);
		}catch(ArithmeticException e){
			System.out.println("Error");
		}finally{
			System.out.println("DONE");
		}
	}
	public static void m4() throws ArithmeticException{


	}
	public static void m5() throws FileNotFoundException{


	}


	public static void main(String[]args){
		try{
			m5();
		}catch(FileNotFoundException e){
		}
	}



}