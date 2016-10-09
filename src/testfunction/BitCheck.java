package testfunction;

public class BitCheck {

	
	 public static void main(String[] args){
		 String sample = "abca";
		 char ff = '2';
		 int checker = 0;
		 for (int i = 0; i < sample.length(); i++){
			 char c = sample.charAt(i);
			 
			 int val = c - 'a';
			 System.out.println("c:"+c+"/val:"+(c-'a')+"/check:"+(1 << val)+"/cond:"+(checker & (1 << val)));	 
			 if ((checker & (1 << val)) > 0){
				 System.out.println("No unique");
				return;
			 }
			 checker |= 1 << val;
		 }
		 System.out.println("Unique");
		 
	 }
}
