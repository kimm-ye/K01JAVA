package ex04controlstatement;

import java.io.IOException;

/*
하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 삼항연산자를 이용하여 구현하시오.	
(System.in.read()를 사용하세요)
 */
public class Qu_04_01 {

	public static void main(String[] args) throws IOException {
		
//		System.out.println("하나의 문자를 입력하세요:"); //입력받을때는 print문이 더 좋다
//		int a = System.in.read();
//		String a_Result = (a>='0' && a<='9') ? "숫자입니다": "숫자가아닙니다";
//		System.out.println(a_Result);
		
		System.out.print("하나의 문자를 입력하세요:");
		int ascii = System.in.read();
		
		
		/*
		삼항연산자 형식
			변수 = (조건식) ? "참일때" : "거짓일때" ; 
		 */
		//아스키코드를 알고 있을때 (숫자는 47 ~ 58사이)
		String result =(ascii >=47 && ascii <=58) ? "숫자입니다" : "숫자가아닙니다" ;
		System.out.println((char)ascii + " 는 " + result);
		
		
		//아스키코드를 모를때
		result =(ascii >='0' && ascii <='9') ? "숫자입니다" : "숫자가아닙니다" ;
		System.out.println((char)ascii + " 는 " + result);
		
		
	}	
}
