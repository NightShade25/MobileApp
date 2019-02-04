import java.io.FileNotFoundException;
import java.util.StringTokenizer;


public class ExceptionAndStringTokenizerExamples{


	public static void Token(){
		int counter = -1;

		String s = "A stately pleasure-dome decree: Where Alph, the sacred river, ran Through caverns measureless to man Down to a sunless sea. ";
		StringTokenizer st = new StringTokenizer(s, ",.:");
		while(st.hasMoreTokens()){
			String currentToken = st.nextToken();
			System.out.println(currentToken);
			counter++;
		}
		System.out.println(counter);
	}


	public static void Exception1(){

	}

	public static void main(String[]args){
		Token();

	}




}