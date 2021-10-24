package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuSelectionSortFunc {

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//난수생성
		int[] arr = new int[10];
		createRnd(arr);
		showArray(arr, "난수생성");
		
		//오름차순, 내림차순 선택
		int orderNumber = menuSelect();
		selectSort(arr, orderNumber);
		
		//선택정렬
		showArray(arr, "선택정럴 이후 배열출력");
	}
	
	public static void createRnd (int[] arrParam) {
		
		while(true) {
			for(int i=0; i<arrParam.length; i++) {
				arrParam[i] = random.nextInt(100)+1;
			}
			boolean reTry = true;
			for(int i=0; i<arrParam.length; i++) {
				for(int j=0; j<arrParam.length; j++) {
					if(arrParam[i]==arrParam[j] && i!=j) {
						reTry = false;
					}
				}
			}
			if(reTry==true) break;
		}
	}
	
	public static void showArray(int[] arr, String message) {
		
		System.out.println(message);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int menuSelect() {

		System.out.println("정렬할 방법을 선택하세요");
		System.out.println("1.오름차순, 2.내림차순");
		return scanner.nextInt();
	}
		
	public static void selectSort(int[] arr, int orderNum) {
		
		int temp;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(orderNum==1) {
					if(arr[i]>arr[j]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
				else if(orderNum==2) {
					if(arr[i]<arr[j]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
