package sort;

import java.util.StringTokenizer;
import java.util.Vector;

class InsertionSort {

	public static void main(String[] args) throws Exception{
	
		validateInput(args);
	
		int[] inputNumbers = parseInput(args[0]);
		
		printNumbers(inputNumbers);
		
		sortNumbers(inputNumbers);
		
		printNumbers(inputNumbers);
		
		junk();
	}
	private static void junk() {
		int a=5,i;

		i=++a + ++a + a++; //6 + 7 + 7=20
		i=a++ + ++a + ++a; //8 + 10 + 11=29
		a=++a + ++a + a++; //12 + 13 +13 = 38

		System.out.println(a);
		System.out.println(i);
		
	}
	//10,9,8
	private static void sortNumbers(int[] input){
	int iter=0;
		for (int i = 0; i < input.length; i++){
			iter++;
			int j = i;
			while(j > 0){
				//j=1|j=2
				if (input[j-1] > input[j]){//10 > 9|10 > 8|9 > 8
					int tmp = input[j]; 
					input[j] = input[j-1];
					input[j-1] = tmp; //9,10,8|9,8,10|8,9,10
					j--;//j=0|j=1|j=0
					iter++;	
				}
			}
			
		}
		System.out.println("Iteration:"+iter);
	
	}
	
	private static int[] parseInput(String str){
		StringTokenizer buff = new StringTokenizer(str,",");
		Vector<Integer> v = new Vector<Integer>();
		while(buff.hasMoreTokens()){
			v.add(Integer.parseInt(buff.nextToken()));
		}
		int[] numbers = new int[v.size()];
		int i = 0;
		for (Integer number : v){
			numbers[i++] = number;
		}
		return numbers;
	}
	
	private static void printNumbers(int[] numbers){
		StringBuilder printStr = new StringBuilder();
		for (int i = 0; i < numbers.length; i++){
			if (i > 0)printStr.append(",");
			printStr.append(numbers[i]) ;
		}
		System.out.println("Numbers:"+printStr);
		
	}

	private static void validateInput(String[] arg){
		if (arg.length < 1) 
			throw new RuntimeException("Invalid input");
	}

}