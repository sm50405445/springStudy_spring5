package ex;

public class guguDan {

	public static void main(String[] args) {
		
		int num = 100;
		
		int count = calcul(100);
		
		for(int i = 1;i<=num;i++) {
			
			System.out.print(i+" ");
			
			if(count==0) {
				
				System.out.println();
				continue;
			}
			
			for(int j = 0; j<count ;j++) {
				
				System.out.print("짝");
			}
			
			System.out.println();
		}
		
	}
	
	public static int calcul(int num) {
		
		return 0;
	}
	
}

	
