package testfunction;

public class RotateArray {

	static char[][] array = new char[][]{{'a','b','c','d'},{'e','f','g','h'}, {'i','j','k','l'},{'m','n','o','p'}};
	public static void main(String[] args) {
		
		printArray();
		
		for (int i = 0 ;i < array.length/2; i++){
			for (int j = i; j < array[i].length-i; j++)
				rotate90(i,j);
		}
		printArray();

	}
	
	private static void rotate90(int i, int j){
		
		char leftTop = array[i][j];
		char rightTop = array[i+j][array.length-1-i];
		char rightBot = array[array.length-1-i][i+j];
		char leftBot = array[i+j][i];
		array[i][j] = leftBot;
		array[i+j][array.length-1-i] = leftTop;
		array[array.length-1-i][array.length-1-j] = rightTop;
		array[array.length-1-i][i+j] = rightBot;
		
		System.out.println(array[i][j]+"/"+array[i][array.length-1-j]+
				"/"+array[array.length-1-i][array.length-1-j]+"/"+array[array.length-1-i][j]);
		printArray();
		
	}
	
	
	private static void printArray(){
		for (int i = 0; i < array.length; i++)
			System.out.println(new String(array[i]));
		
		System.out.println("^^^^^^^^^^^^");
	}

}
