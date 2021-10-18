package ex05method;

import java.util.Scanner;

/*
두개의 정수를 입력받아서 사칙연산의 결과를 출력하는 메소드와 main메소드를 작성해보자. 
단 나눗셈은 몫과 나머지를 각각 출력해야 한다.
파라메타로 전달되는 두 숫자는 모두 0 이상의 양의 정수이다.
메소드명 : arithmetic()
실행결과]
덧셈결과 -> 177
뺄셈결과 -> 23
곱셈결과 -> 7700
나눗셈 몫 -> 1
나눗셈 나머지 -> 23



 */
public class QuSimpleOperation {
	
	/*
	 반환값은 없고, 매개변수만 있는 메소드
	 메소드는 항상 반환값이 있어야 한다.
	 단, 문제와 같이 결과를 바로 출력하는 건은 반환값이 없으므로 void를 선언한다.
	 */
	static void arithmetic(int i, int j) {
		System.out.println("덧셈결과 -> " + (i+j) );
		System.out.println("뺄셈결과 -> " + (i-j));
		System.out.println("곱셈결과-> " + (i*j));
		System.out.println("나눗셈 몫-> " + (i/j));
		/*%기호를 콘솔에 출력하기 위해 이스케이프 시퀀스를 사용함.
		System.out.printf("나머지:%d %% %d = %d\n, n1, n2,(n1%n2));
		*/
		System.out.println("나눗셈 나머지-> " + (i%j));
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수:");
		int i = scanner.nextInt();
		System.out.print("두번째 정수:");
		int j = scanner.nextInt();

		arithmetic(i,j);
	}

}
