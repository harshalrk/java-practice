package sort;

public class HeapSort {
	static final int MAX_SIZE = 11;
	int count = 0;
	int[] result = new int[MAX_SIZE];
	
	private HeapSort(int[] arr){
		for (int i = 0;i < arr.length; i++){
			System.out.println("Sorting number=>"+arr[i]);
			insertElement(arr[i]);
		}
		
	}
	
	private void insertElement(int input){
		if (count > result.length){
			System.err.println("Attempting to insert element which doesn't fit!!, skipping");
			return;
		}
		count++;
		result[count] = input;
		bubbleUp(count);
		//printNumbers(result);
	}
	
	
	private void bubbleUp(int elementIdx){
		
	
		int parentIdx= getParentIdx(elementIdx);
		
		if (parentIdx == -1) return;
		
		if (result[parentIdx] > result[elementIdx]){
			swap(parentIdx, elementIdx);
			
			bubbleUp(parentIdx);
			
		}
	}
	
	
	private int extractMin(){
		int ret = result[1];
		result[1] = result[count];
		result[count] = 0;
		count--;
		bubbleDown(1);
		printNumbers(result);
		return ret;
	}
	
	private void bubbleDown(int elementIdx){
		//printNumbers(result);
		if (elementIdx == 0) return;
		
		int childIdx= getChildIdx(elementIdx);
		int minIdx = elementIdx;
		for (int i = 0; i <= 1; i++){
			if (childIdx+i <= count){
				if (result[minIdx] > result[childIdx+i])
					minIdx = childIdx+i;
			}
		}
		
		
		if (minIdx != elementIdx){
			swap(elementIdx, minIdx);
			bubbleDown(minIdx);
		}
	}
	
	
	
	private void swap(int idx1, int idx2){
		int tmp = result[idx1];
		result[idx1] = result[idx2];
		result[idx2] = tmp;
		
	}
	
	private int getParentIdx(int elementIdx){
		if (elementIdx == 1) return -1;
		return elementIdx/2;
		
	}
	
	private int getChildIdx(int elementIdx){
		
		return elementIdx*2;
		
	}
	
	
	
	public static void main(String[] args){
		
		int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};
		
		HeapSort heap = new HeapSort(arr);
		printNumbers(heap.result);
		
		System.out.println("Extracting min^^^^");
		
		for (int i = 1; i < MAX_SIZE; i++)
			System.out.println(heap.extractMin()+",");
			
		
	}
	
	private static void printNumbers(int[] numbers){
		StringBuilder printStr = new StringBuilder();
		for (int i = 0; i < numbers.length; i++){
			if (i > 0)printStr.append(",");
			printStr.append(numbers[i]) ;
		}
		System.out.println("Numbers:"+printStr);
		
	}
	
}
