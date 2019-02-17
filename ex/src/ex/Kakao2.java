package ex;

import java.util.StringTokenizer;

public class Kakao2 {

	public int dart(String score) {
		
		StringBuffer result = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(score,"*#",true);
		
		while(st.hasMoreTokens()) {
			
			String data = st.nextToken();
			
			if(data.contains("S")) {
				int sIndex = data.indexOf("S");
				int sScore = Integer.parseInt(data.substring(0,sIndex));
				sScore = sScore*1;
				System.out.println(sScore);
				data = data.substring(sIndex);
				String Score = String.valueOf(sScore);
				data.concat(Score);
				System.out.println(data);
			}else if(data.contains("D")) {
				int dIndex = data.indexOf("D");
				int dScore = Integer.parseInt(data.substring(0,dIndex));
				dScore = dScore*2;
				result.append(dScore);
			}else if(data.contains("T")) {
				int tIndex = data.indexOf("T");
				int tScore = Integer.parseInt(data.substring(0,tIndex));
				result.append(tScore);
			}
			System.out.println(data);
		}
		
		return Integer.parseInt(result.toString());
	}
	
}
