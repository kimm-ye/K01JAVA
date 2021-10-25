package quiz;

import java.util.Arrays;
import java.util.Random;

public class QuSelectionSort {

	
	public static void main(String[] args) {
		
		Random random = new Random();
		int[] arr = new int[10];
		while(true) {
			for(int i=0; i<arr.length; i++) {
				arr[i] = random.nextInt(100)+1;
			}
			boolean reTry = true;
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i]==arr[j] && i!=j) {
						reTry = false;
					}
				}
			}
			if(reTry==true) break;
		}
		System.out.println("난수생성");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("선택정렬");
		int temp;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}

	}
}
