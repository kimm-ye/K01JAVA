package quiz;

import java.util.Arrays;
import java.util.Random;


public class QuBubbleSort {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] array = new int[10];
		
			for(int i=0; i<array.length; i++) {
				array[i] = random.nextInt(1000) % 99 +1;
			}
			for(int i=0; i<array.length; i++) {
				for(int j=i+1; j<array.length; j++) {
					if(j==array.length) j=0;
					if(array[i] == array[j]) {
						break;
					}
				}
				System.out.print(array[i]+ " ");
			}
			System.out.println();
			bubbleSort(array);
		
		System.out.println("[메인메소드] -Swap이후 출력");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
	}
		
	static void bubbleSort(int[] ref) {
		int temp;
		System.out.println("bubbleSort --------");
		for(int i=0; i<ref.length; i++) {	
			for(int j=0; j<(ref.length-i-1); j++) { //다음 탐색부터는 마지막 요소는 하지 않아도 되니까
				if(ref[j] > ref[j+1]) {
					temp = ref[j+1];
					ref[j+1] = ref[j];
					ref[j] = temp;
				}
			}
			System.out.println(Arrays.toString(ref)); //왜 이렇게 출력하면 잘 나오지???/?
		}
	}
}					
					
					
					
					
					
					
					
