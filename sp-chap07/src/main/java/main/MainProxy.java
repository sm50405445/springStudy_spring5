package main;

import chap07.ExeTimeCalculaotor;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class MainProxy {

	public static void main(String[] args) {
		
		ExeTimeCalculaotor ttcal1 = new ExeTimeCalculaotor(new ImpeCalculator());
		System.out.println(ttcal1.factorial(20));
		
		ExeTimeCalculaotor ttcal2 = new ExeTimeCalculaotor(new RecCalculator());
		System.out.println(ttcal2.factorial(20));
	}
}
