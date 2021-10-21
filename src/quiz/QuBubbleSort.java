package quiz;

import java.util.Arrays;
import java.util.Random;


//public class QuBubbleSort {
//
//	public static void main(String[] args) {
		
//		Random random = new Random();
//		int[] array = new int[10];
//		
//		for(int i=0; i<array.length; i++) {
//			array[i] = random.nextInt(1000) % 99 +1;  //이렇게 작성하니 중복이 나오네 while로 묶어줘야한다.
//		}
//		for(int i=0; i<array.length; i++) {
//			for(int j=i+1; j<array.length; j++) {
//				if(j==array.length) j=0;
//				if(array[i] == array[j]) {
//					break;
//				}
//			}
//			System.out.print(array[i]+ " ");
//		}
//		System.out.println();
//		bubbleSort(array);
//		
//		System.out.println("[메인메소드] -Swap이후 출력");
//		for(int i=0; i<array.length; i++) {
//			System.out.print(array[i]+ " ");
//		}
//	}
//		
//	static void bubbleSort(int[] ref) {
//		int temp;
//		System.out.println("bubbleSort --------");
//		for(int i=0; i<ref.length; i++) {	
//			for(int j=0; j<(ref.length-i-1); j++) { //다음 탐색부터는 마지막 요소는 하지 않아도 되니까
//				if(ref[j] > ref[j+1]) { //j+1을 하는 이유: i를 넣게되면 0 vs 0~9까지 비교 -> 1 vs 0~9까지 비교가 되니까 앞뒤로 하나씩 비교하려면 j, j+1이랑 비교해야함
//					temp = ref[j+1];
//					ref[j+1] = ref[j];
//					ref[j] = temp;
//				}
//			}
//			System.out.println(Arrays.toString(ref)); //배열의 내용을 출력하려면 Arrays.toString을 사용해야 한다. 아니면 주소값만 나옴
//		}
//	}
//}					
					
public class QuBubbleSort {

	public static void main(String[] args) {					
					
		//중복되지 않는 난수를 생성
		Random random = new Random();
		int[] arr = new int[10];
		
		while(true) {
			//난수 10개를 생성
			for(int i=0; i<arr.length; i++) {
				arr[i] = random.nextInt(100) +1;
			}
			
			//중복체크를 위한 변수
			boolean rndFlag = false; //if에서 바로 나올수가 없으니까
			//중복되는지 확인
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i] == arr[j] && i!=j) {  /*i=0, j=0 이면 값이 똑같다고 나오니까 */
						rndFlag = true; //중복된 값이 발견되면 true로 변경
					}
				}
			}
			//중복된 값이 없다면 break로 while루프 탈출
			if(rndFlag == false) break;
			System.out.println("난수생성시도"); //난수를 몇번만에 만드는지 확인 가능ㄴ
			
		}
		
		//생성된 난수를 출력
		//난수확인
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
				
		//버블정렬
		//for(int i=0; i<10-1; i++)
		int temp;
		/*
		크기가 10인 배열이므로 스캔은 9번만 반복하면 도니다.
		즉, i의 증가치는 0~8까지 변하게 된다. 
		*/
		for(int i=0; i<arr.length-1; i++) { //10-1 요소는 10개지만 비교할수 있는건 마지막 제외한 9개니까
			/*
			실제 요소값에 대한 비교를 진행하여 큰 숫자를 뒤로 보내준다.
			즉, 요소1과 2를 비교하여 요소1이 크다면 두 요소를 교환(swqp)한다.
			한번 스캔을 완료하면 가장 큰 숫자가 제일 뒤로 밀리게 되므로
			비교의 구간을 하나 줄여주기 위해 i를 차감한다.
			 */
			for(int j=0; j<(arr.length-1)-i; j++) { //i를 빼는 이유 : 가장 큰 숫자가 제일 뒤에 있을거기 때문에 그 앞까지만 비교하면 되기 때문에
				//앞의 숫자가 더 크다면 뒤의 숫자와 교환한다.
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =temp;
				}
			}
			
			for(int k=0; k<arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}

		//정렬된 난수를 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
					
					
