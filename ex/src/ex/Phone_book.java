package ex;


public class Phone_book {

	

	
	public static boolean solution(String[] phone_book) {
		
		boolean answer = true;
		
		for(int i = 0 ; i<phone_book.length;i++) {
			
			for(int j = i+1 ; j<phone_book.length;j++) {
				if(phone_book[i].contains(phone_book[j]) || phone_book[j].contains(phone_book[i])) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
	
	
}
