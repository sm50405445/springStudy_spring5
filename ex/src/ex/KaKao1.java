package ex;

public class KaKao1 {

	public static void main(String[] args) {
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		//["#####","# # #", "### #", "# ##", "#####"]
		
		String[] result = new String[n];
		
		for(int i = 0; i<n; i++) {
			int arr = arr1[i] | arr2[i];
			String temp = Integer.toBinaryString(arr);
			System.out.println(temp);
		}
		
		
		for(int i = 0 ; i<n ; i++) {
			String resultString = "";
			int arr = arr1[i] | arr2[i];
			int targetBit = 1;
			for(int j = 0;j<n;j++) {
				resultString = ((arr & targetBit)>0?"#":" ")+resultString;
				targetBit = targetBit<<1;
			}
			result[i] = resultString;
			System.out.println(result[i]);
		}
	}
}
