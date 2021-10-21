package practice;

import java.util.Arrays;
import java.util.Random;

public class N {

	public static void main(String[] args) {


		Random random = new Random();
		int[] array = new int[10];
		int temp;
		
//		for(int i=0; i<array.length; i++) {
//			array[i] = random.nextInt(1000) %99 +1;
//		}
		for(int i=0; i<array.length; i++) {
			array[i] = random.nextInt(10) %99 +1;
			for(int j=i+1; j<array.length; j++) {
				if(j==array.length) j=0;
				if(array[i] == array[j]) break;
			}
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<(array.length-1); j++) {
				if(array[j] > array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}System.out.println(Arrays.toString(array));
		}
	}
}
