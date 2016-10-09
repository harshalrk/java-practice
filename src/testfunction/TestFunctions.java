package testfunction;

public class TestFunctions {

	
	
	public static void main(String[] args){
		
		//mystery();
		
		pesky();
	}
	
	private static void mystery(){
		int r = 0;
		int n = 5;
		for (int i = 0; i <= n-1;i++){
			
			for (int j = i + 1; j <=n; j++){
				
				for (int k = 1; k <= j; k++){
					
					r++;
				}
				
			}
		}
		System.out.println("R =>"+r);
	}
	
	private static void pesky(){
		int r = 0;
		int n = 5;
		for (int i = 1; i <= n-1;i++){
			System.out.print("i =>"+i);
			for (int j = 1; j <=i; j++){
				System.out.print("j =>"+j);	
				for (int k = j; k <= i+j; k++){
					System.out.println("k =>"+k);	
					r++;
				}
				
			}
		}
		System.out.println("R =>"+r);
		
	}
	
}
