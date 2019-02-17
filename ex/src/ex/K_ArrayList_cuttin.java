package ex;


import java.util.Arrays;

public class K_ArrayList_cuttin {

	public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        
        
        answer = new int[commands.length];
        
        for(int i = 0 ; i<commands.length;i++) {
        	
        	for(int j = 0; j<commands[i][1]-commands[i][0]+1;j++) {
        		
        		int[] copy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        		
        		Arrays.sort(copy);
        		
        		answer[i] = copy[commands[i][2]];
        	}
        	
        }

        
        return answer;
    }
}
