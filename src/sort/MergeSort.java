package sort;

public class MergeSort {

	
	private MergeSort(char[] arr){
		char[] sorted = divide(arr);
		printNumbers(sorted);
	}
	

	
	private char[] divide(char[] arr) {
		if (arr.length == 1) return arr;
		int mid = arr.length/2;
		char[] left = new char[mid];
		char[] right = new char[arr.length - mid];
		
		for (int i = 0;  i < mid; i ++){
			left[i] = arr[i];
		}
		for (int i = mid;  i < arr.length; i ++){
			right[i-mid] = arr[i];
		}
		
		left = divide(left);
		right = divide(right);
		return merge(left, right);
	}



	private char[] merge(char[] left, char[] right) {
		
		MyQ leftQ = new MyQ(left);
		MyQ rightQ = new MyQ(right);
		
		char[] sorted = new char[left.length+right.length];
		int idx = 0;
		while(!(leftQ.isEmpty() || rightQ.isEmpty())){
			if (leftQ.head() < rightQ.head()){
				sorted[idx++] = leftQ.dequeue();
			}else {
				sorted[idx++] = rightQ.dequeue();
			}
		}
		
		while(!leftQ.isEmpty())sorted[idx++] = leftQ.dequeue();
		while(!rightQ.isEmpty())sorted[idx++] = rightQ.dequeue();
		
		return sorted;
	}


	class MyQ{
		char[] q;
		int ptr;
		
		private MyQ(char[] input){
			q = input;
			ptr = 0;
		}
		
		private boolean isEmpty(){
			return ptr == q.length;
		}
		
		private char head(){
			return q[ptr];
		}
		
		private char dequeue(){
			ptr++;
			return q[ptr-1]; 
		}
	}

	public static void main(String[] args){
		
		char[] arr = new char[]{'M','E','R','G','E','S','O','R','T'};
		
		MergeSort heap = new MergeSort(arr);
		System.exit(0);
		
	}
	
	private static void printNumbers(char[] numbers){
		StringBuilder printStr = new StringBuilder();
		for (int i = 0; i < numbers.length; i++){
			if (i > 0)printStr.append(",");
			printStr.append(numbers[i]) ;
		}
		System.out.println("Numbers:"+printStr);
		
	}
	
}
