package ex05method;

import java.util.Scanner;

/*
원의 반지름을 파라메타로 전달하면 원의넓이와 둘레를 계산하여 반환하는 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.
메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
-넓이공식 : 3.14 * 반지름 * 반지름
-둘레공식 : 2 * 3.14 * 반지름


실행결과]
원의 둘레(5.5) : 34.54
원의 넓이(5.5) : 94.985


 */
public class QuCircleCalculator {

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("반지름 입력: ");
//		double radi = scanner.nextDouble();
//		System.out.println("원의둘레(" + radi +") : " + circleRound(radi));
//		System.out.println("원의넓이(" + radi +") : " + circleArea(radi));
//	}
//	final static double PI = 3.14;
//	static double circleArea(double radi) { //원의넓이
//		double area = PI * radi * radi;
//		return area;
//	}
//	
//	static double circleRound(double radi) { //원의둘레
// 		double round = 2 * PI * radi;
//		return round;
//	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("반지름 입력: ");
		double rad = scanner.nextDouble();
		
		circleArea(rad);
		//반환값이 있는 메서드이므로 print문 안에서 호출한다.
		System.out.println("원의둘레(" + rad +") : " + circleRound(rad));
	}
	//반환값이 없으므로 매개변수를 받은 후 결과를 즉시 출력한다.
	static void  circleArea(double radian) { //원의넓이
		double result = 3.14 * radian * radian;
		System.out.println("원의넓이(" + result +") : " + result);
	}
	
	static double circleRound(double radian) { //원의둘레
 		//방법1 : 깔끔히 한줄에 출력
		return (2*3.14*radian);
		//방법2 : 변수 담아서 출력
		/*double round = 2 * 3.14 * radian;
		  return round;
		*/
	}
	
	
	
}
