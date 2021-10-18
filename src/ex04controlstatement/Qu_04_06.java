package ex04controlstatement;
/*
다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
*
* *
* * *
* * * *
* * * * *

 */
public class Qu_04_06 {

	public static void main(String[] args) {
		
//		int i = 0;
//		while(i<=4) {
//			int j = 0;
//			while(j<=i) {
//				System.out.print("* ");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
//		for(int i2=0; i2<=4; i2++) {
//			for(int j2=0; j2<=i2; j2++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		
		int i=1;
		while(i<=5) {
			int j=1;
			while(j<=i) {
				System.out.print("* ");
				j++;
			}
			System.out.println("");
			i++;
		}
	}
}
