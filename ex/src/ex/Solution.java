package ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Solution {

	public String solution(String[] participant, String[] completion) {
		String answer="";
		Random ranPersonCount = new Random();
		StringBuffer names = new StringBuffer();
		
		int personCount = ranPersonCount.nextInt(100001)+1;
		
		for(int i = 0 ; i<personCount;i++) {
			
			Random nameCollection = new Random();
			names.append((char)((int) nameCollection.nextInt(26)+66));
			
		}
		
		for(int i =0;i<100000;i++) {
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		String[] participant;
		
		
		String answer="";
		Random rnd = new Random();
		
		int personCount = rnd.nextInt(100001)+1;
		participant = new String[personCount];
		
		for(int i = 0 ; i<personCount;i++) {
			
			StringBuffer names = new StringBuffer();
			int nameLength = rnd.nextInt(21)+1;
			for(int j=0 ; j<nameLength ; j++) {
				//랜덤 소문자 가져오기 아스키 코드는 65~90 대문자, 97~122 소문
				names.append((char)((int) rnd.nextInt(26)+97));
			}
			participant[i] = names.toString();
			
		}
		
		ArrayList<String> parti = new ArrayList<String>(Arrays.asList(participant));
		ArrayList<String> completion = (ArrayList<String>) parti.clone();
		int removeIdx = rnd.nextInt(personCount);
		completion.remove(removeIdx);
		
		String notComplement = "";
		
		for(int i = 0; i<completion.size(); i++) {
			
			if(parti.get(i)!=completion.get(i)) {
				notComplement=parti.get(i);	
				break;
			}
			
		}
		
		int cnt = 0;
		for(int i = 0;i<parti.size();i++) {
			if(parti.get(i)==notComplement)
				cnt++;
		}
		
		if(cnt==1)
			answer = notComplement + "는 참여자명단에 있지만, 완주자 명단에 없기 때문에 완주하지 못했습니다.";
		else if(cnt>1)
			answer = notComplement + "는 참여자 명단에"+cnt+"있지만, 완주자 명단에 1명밖에 없기때문에 1명은 완주하지 못했습니다.";
		
		System.out.println(answer);
	}
	
	
}
