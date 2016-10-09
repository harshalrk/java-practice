package testfunction;

public class ReplaceString {

	public static void main(String[] args){
		
		String sample = "This is a string         ";
		int length = 16;
		
		for (int i = 0; i < sample.length(); i++){
			char c = sample.charAt(i);
			if (c == ' '){
				moveFurther(sample, i+3, sample.substring(i));
			}
			
		}
		
	}

	public static void moveFurther(String sample, int index, String s){
		
	}
}
