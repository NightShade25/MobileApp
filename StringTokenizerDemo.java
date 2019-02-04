import java.util.StringTokenizer;

public class StringTokenizerDemo{

	public static void m1(){
		String test = "use the force";
		StringTokenizer tokenizer = new StringTokenizer(test);
		while(tokenizer.hasMoreTokens()){
			String currentToken = tokenizer.nextToken();
			System.out.println(currentToken);
		}
	}
	public static void m2(){
		String test = "use the force";
		StringTokenizer tokenizer = new StringTokenizer(test, "e", false);
		while(tokenizer.hasMoreTokens()){
			String currentToken = tokenizer.nextToken();
			System.out.println(currentToken);
		}
	}
	public static void m3(){
		String test = "use the force";
		StringTokenizer tokenizer = new StringTokenizer(test, "e", true);
		while(tokenizer.hasMoreTokens()){
			String currentToken = tokenizer.nextToken();
			System.out.println(currentToken);
		}
	}

	public static void main(String[]args){

		m1();
			System.out.println();
		m2();
			System.out.println();
		m3();
	}

}