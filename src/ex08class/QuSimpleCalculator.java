package ex08class;
/*
문제1) 파일명 : QuSimpleCalculator.java (난이도:하)
기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스를 정의해보자.
아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 해당 수치는 임의로 바꿔도 된다.
init() 멤버메소드에서는 계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.

메인메소드 샘플코드]
public static void main(String[] args)
{
	CalculatorEx cal = new CalculatorEx();
	cal.init();
	System.out.println("1 + 2 = " + cal.add(1 , 2));
	System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
	System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
	System.out.println("100 / 25 = " + cal.div(100 , 25));
	System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
	cal.showOpCount();
}	


실행결과]
1 + 2 = 3.0
10.5 - 5.5 = 5.0
4.0 * 5.0 = 20.0
100 / 25 = 4.0
10.0 * 3.0 = 30.0
덧셈횟수 : 1
뺄셈횟수 : 1
곱셈횟수 : 2
나눗셈횟수 : 1


 */
//class CalculatorEx {
//	
//	int addCnt, minCnt, mulCnt, divCnt;
//	
//	public void init() {
//		addCnt = 0;
//		minCnt = 0;
//		mulCnt = 0;
//		divCnt = 0;
//	}
//	
//	public double add(double a, double b) {
//		addCnt++;
//		double num = a+b;
//		return num;
//	}
//	public double min(double a, double b) {
//		minCnt++;
//		double num = a-b;
//		return num;
//	}
//	public double mul(double a, double b) {
//		mulCnt++;
//		double num = a*b;
//		return num;
//	}
//	public double div(double a, double b) {
//		divCnt++;
//		double num = a/b;
//		return num;
//	}
//	
//	public void showOpCount() {
//	System.out.println("덧셈횟수:" + addCnt);
//	System.out.println("뺄셈횟수:" + minCnt);
//	System.out.println("곱셈횟수:" + mulCnt);
//	System.out.println("나눗셈횟수:" + divCnt);
//	}
//}
//
//public class QuSimpleCalculator {
//
//	public static void main(String[] args) {
//		CalculatorEx cal = new CalculatorEx();
//		cal.init();
//		System.out.println("1 + 2 = " + cal.add(1 , 2));
//		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
//		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
//		System.out.println("100 / 25 = " + cal.div(100 , 25));
//		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
//		cal.showOpCount();
//	}
//}



//메소드를 호출하는 위치에 따라 반환값이 있는지 없는지 판단해야함
//프린트 문에서는 출력하는 경우 반환값이 잇어야 오류가 안남
//좌측항에 변수가 있거나 출력해야하거나 하는 경우 무조건 반환타입 있음
//호출만한 경우에는 반환값이 없어도 됨


//넉넉히 큰 쪽으로 만들어 놓기
class CalculatorEx {
	//계산의 횟수 카운트를 위한 멤버변수
	int addNum;
	int minNum;
	int mulNum;
	int divNum;
	//위에 멤버변수 초기화메서드
	void init() {
		addNum=0;
		minNum=0;
		mulNum=0;
		divNum=0;
	}
	//사칙연산 수행
	double add(double num1, double num2) {
		addNum++;
		return num1+num2;
	}
	double min(double num1, double num2) {
		minNum++;
		return num1-num2;
	}
	double mul(double num1, double num2) {
		mulNum++;
		return num1*num2;
	}
	double div(double num1, double num2) {
		divNum++;
		return num1/num2;
	}
	//연산의 횟수 출력
	void showOpCount() {
		System.out.println("덧셈횟수 :"+addNum);
		System.out.println("뺄셈횟수 :"+minNum);
		System.out.println("곱셈횟수 :"+mulNum);
		System.out.println("나눗셈횟수 :"+divNum);
	}
	
}
public class QuSimpleCalculator {
	
	public static void main(String[] args) {
		CalculatorEx cal = new CalculatorEx();
		cal.init();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCount();
	}
}
