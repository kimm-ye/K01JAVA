package ex05method;

/*
문제5-4) 파일명 : QuFindPrimeNumber.java  (난이도:상)
전달된 값이 소수인지 아닌지를 판단하여 소수인 경우 true를 아니면 false를 
반환하는 메소드를 정의하고, 
이를 이용해서 1부터 100사이의 소수를 전부 출력하는 main메소드를 정의하자.

메소드명 : isPrimeNumber()
소수란 : 특정 정수를 나눌수 있는것이 1과 자기자신밖에 없는 수.



실행결과]
2
3
5
7
……중략……
97


 */
public class QuFindPrimeNumber {
	
//	static boolean isPrimeNumber(int iNum) { //소수인지 아닌지
//		
//		if(iNum == 1) {
//			return false;
//		}
//		for(int j=2; j<iNum; j++) { //iNum과 j가 같으면 당연히 나누어지니까 '='빠짐 (혹은 <=num-1)
//			if(iNum%j==0) {
//				return false; // iNum%i가 0이 아니면 다시 for문으로 돌아가서 j 값 하나 오름. 그래서 iNum -1 (=n-1)까지 나눠볼수있으므로 2,3,5의 배수인지 체크 가능
//			}
//		}
//		return true;
//	}
//
//	public static void main(String[] args) { //1~100사이의 소수 출력
//		for(int i=1; i<=100; i++) {
//			if(isPrimeNumber(i)) {
//				System.out.println(i);
//			}
//		}
//	}

	public static void main(String[] args) {
		
		//int num = 7; //7이 소수인지 판단하기 위한 테스트
		
		//1~100까지의 정수중 소수인지 판단하는 로직
		for(int num=1; num<=100; num++) {
			boolean result = isPrimeNumber(num);
			if(result == true) {
				System.out.println("소수:"+num);
			}
		}
	}
	
	public static boolean isPrimeNumber(int n) {
		
		//정수 7일때 소수인지 판단하는 로직(2~6까지 나눠보면 됨)-테스트

		//정수1은 소수가 아니므로 무조건 false반환
		if(n == 1) return false;
		
		//정수 n일때는 n-1까지 나눠보면 됨
		//or(int i=2; i<n; i++)
		for(int i=2; i<=(n-1); i++) {
			//만약 1과 자신을 제외한 숫자로 나누어 떨어지면
			//소수가 아닌 것으로 판단한다.
			if(n % i ==0) {
				return false; //return 뒤에 값이 있으면, 반환값 없으면 실행종료 -> 호출했더 지점으로 간다.
			}
		}
		//위의 반복문을 벗어나면 소수로 판단한다
			return true;
	}
}












