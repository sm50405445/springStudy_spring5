package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cal {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);
		
		ArrayList measure = new ArrayList();
		
		StringBuffer stdout = new StringBuffer();
		
		int stdin = Integer.parseInt(input);
		
		for(int i=1;i<stdin/2;i++){
			
			if(stdin % i==0){
				stdout.append(i+" ");
			}
			
		}
		System.out.print(stdout);
	}
}
