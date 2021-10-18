package ex05method;

import java.util.Scanner;

/*
섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와 화씨를 입력받아서 
섭씨로 변환하여 리턴하는 함수를 만들어라.
공식]
화씨 = 1.8 * 섭씨 + 32
섭씨 = (화씨 - 32) / 1.8


 */
public class QuTemperature {

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("화씨 : ");
//		double f = scanner.nextDouble();
//		System.out.print("섭씨 : ");
//		double c = scanner.nextDouble();
//		
//		System.out.println("섭씨 : " + fahrenheit(f)); //화씨를 받아야 하니까 f 
//		System.out.println("화씨 : " + celsius(c) ); //섭씨를 받아야 하니까 c
//	}
//	//화씨 -> 섭씨
//	static double fahrenheit(double fah) { //화씨를 받아서
//		double cel = (fah - 32) / 1.8;
//		return cel; //섭씨로 리턴
//	}
//	//섭씨 -> 화씨
//	static double celsius (double cel) { //섭씨를 받아서
//		double fah = (1.8 * cel) + 32;
//		return fah; //화씨로 리턴
//	}
	
	
	
	public static void main(String[] args) {
		System.out.println("섭씨 23도 => 화씨 =" + celsiusToFahrenheit(23) ); 
		System.out.println("화씨98도 => 섭씨=" + fahrenheitToCelsius(98.3));
	}
	//화씨 -> 섭씨
	static double fahrenheitToCelsius (double fah) { //앞 대문자는 클래스이므로 소문자로 바꿔야한다
		return (fah - 32) / 1.8;
	}
	//섭씨 -> 화씨
	static double celsiusToFahrenheit (double cel) {
		double fah = (1.8 * cel) + 32;
		return fah;
		
	}
}
