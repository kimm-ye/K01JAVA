package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class bubble_me {

	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
		int[] arr = new int[10];
		randomCreate(arr);
		
		showArray(arr, "난수생성직후 배열출력");
		
		int orderSelect = menuSelect();
		
		bubbleSort(arr,orderSelect);
		
		showArray(arr, "버블정렬직후 배열출력");

	}
	
	public static void randomCreate(int[] arrParam) {
		boolean rndFlag = true;
		
		while(true) {
			for(int i=0; i<arrParam.length; i++) {
				arrParam[i] = rnd.nextInt(99)+1;
			}
			
			for(int i=0; i<arrParam.length; i++) {
				for(int j=0; j<arrParam.length; j++) {
					if(i!=j && arrParam[i] == arrParam[j]) {
						rndFlag = false; //i와j가 같으면 당연히 같은 값이니까 제외하고, 다른 값인데 같으면 중복발생한거니까 true반환
					}
				}
			}
			if(rndFlag == true) break;
		}
		
	}
	
	public static void showArray(int[] arr, String message) {
		System.out.println(message);
		System.out.print(Arrays.toString(arr) + "\n");
	}
	
	public static int menuSelect() {
		System.out.print("정렬할 방법을 선택하시오. 1.내림차순 2.오름차순");
		return scanner.nextInt();
	}
	
	public static void bubbleSort(int[] arrParam, int orderSelect) {
		int temp;
		int swapCount = 1;
		
		for(int i=0; i<arrParam.length; i++) {
			for(int j=0; j<(arrParam.length-1)-i; j++) {
				if(orderSelect == 1) {
					if(arrParam[j] < arrParam[j+1]) {
						temp = arrParam[j+1];
						arrParam[j+1] = arrParam[j];
						arrParam[j] = temp;
						
						showArray(arrParam, "swap중 - 내림차순 정렬중" + (swapCount++) + "회 교환됨");
					}
				}
				else if(orderSelect==2) {
					if(arrParam[j] > arrParam[j+1]) {
						temp = arrParam[j];
						arrParam[j] = arrParam[j+1];
						arrParam[j+1] = temp;
						
						showArray(arrParam, "swap중 - 오름차순 정렬중" + (swapCount++) + "회 교환됨");
					}
				}
			}
		}
	}
}
