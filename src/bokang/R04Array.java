package bokang;

import java.util.Scanner;

public class R04Array {

	public static void main(String[] args) {

		/*
		시나리오] 정수 10개를 저장할 수 있는 배열을 생성한 후
		반복문을 통해 1부터 순차적인 값을 입력하시오.
		 */
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) { //배열이니까 i는 0부터 시작
			arr[i] = i+1; //1부터 값을 채움
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		/*
		시나리오] 정수 5개를 저장할 수 있는 배열을 생성한 후 숫자를
		입력받아 저장한다. 단, 숫자가 짝수일때만 저장할 수 있도록
		프로그램을 작성하시오.
		
		--> 5번 반복
		 */
		Scanner scanner = new Scanner(System.in);
//		int[] arr2 = new int[5];
//		for(int i=0; i<arr2.length; i++) {
//			System.out.print("숫자를 입력하세요 : ");
//			int inputNum = scanner.nextInt();
//			//입력된 정수가 짝수일때만 배열에 삽입
//			if(inputNum%2==0) {
//				arr2[i] = inputNum;
//			}
//		}
//		for(int i=0; i<arr2.length; i++) {
//			System.out.print(arr2[i] + " ");
//		}
		
		/*
		시나리오] 정수 5개를 저장할 수 있는 배열을 생성한 후 숫자를
		입력받아 저장한다. 단 숫자가 짝수일때만 저장해야하고, 
		5개 모두 입력되면 프로그램을 종료한다.
		
		--> 무한루프
		 */
		int[] arr3 = new int[5];
		int index=0; //배열의 인덱스로 사용할 변수 (그래서 0부터 시작)
		boolean reTry=true;
		//반복의 횟수를 알 수 없으므로 while문으로 작성한다.
		while(true) {
			System.out.print("숫자를 입력하세요 : " );
			int input = scanner.nextInt();
			
			if(input%2==0) {
				//후위증가이므로 0번 인덱스에 삽입후 index값이 증가된다.
				arr3[index++] = input;
			}
			/*
			탈출의 조건은 짝수 5개가 입력되었을때 이므로 index가 4일때까지
			배열에 입력된 후 증가되어 5가 되는 순간 무한루프를 탈출한다.
			
			무한루프를 탈출할때는 break 사용
			 */
			if(index==5) break; 
		}
		//베열출력
		for(int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
	}
}
