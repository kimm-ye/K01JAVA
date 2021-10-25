package bokang;

public class R02for {

	public static void main(String[] args) {
		
		/*
		while문 : 방복의 횟수가 명확하지 않을때 주로 사용하는 반복문
		형식] 
			반복을 위한 변수 : 
			while(반복조건){
				실행문;
				탈출을 위한 증감식;
			}
		 */
		//시나리오] 1~10까지의 합을 구하는 while문을 작성하시오.
		int a=1;
		int total = 0;
		while(a<=10) {
			total += a;
			a++; 
		}
		System.out.println("1~10까지의합:" + total);
		
		
		/*
		do~while문 : while문과 다르게 일단 한번 실행한 후
			탈출을 위한 조건을 체크한다.
		형식]
			반복을 위한 초기값;
			do{
				실행문; <== 해당 실행문은 무조건 1번은 실행된다.
				증감식;
			}while(조건식);
		 */
		//시나리오] 위에서 만든 수열문제를 do~while문으로 변경하시오
		int b=1;
		int sum=0;
		do {
			sum += b;
			b++; 
		}while(b<=10) ;
		System.out.println("1~10까지의합:" + sum);
		

		/*
		for문 : 반복의 횟수가 명확할때 사용하는 반복문
		형식]
		 	for(초기값; 조건식; 증감식){
		 		실행문장;
		 	}
		 	
		확장for문은 배열에서 사용
		 */
		//시나리오] 앞에서 만든 수열문제를 for문으로 변경하시오.
		int hap=0;
		for(int i=1; i<=10; i++) {
			hap += i;
		}
		System.out.println("hap =" + hap);
		
		
		/*
		연습문제] 두개의 주사위를 던졌을때 눈의 합이 6이되는 경우를
		모두 출력하는 프로그램을 for문과 if문을 이용하여 작성하시오.
		실행결과]
			1+5=6
			2+4=6
			.......
			5+1=6
		 */
		System.out.println("for문으로 주사위문제 구현하기");
		//주사위1(1~6까지)
		for(int i=1; i<=6; i++) {
			//주사위2(1~6까지)
			for(int j=1; j<=6; j++) {
				//두 주사위의 합이 6이 될때만 출력하기
				if(i+j==6) {
					//System.out.println(i +"+" +j + "=" +(i+j));
					System.out.printf("%d+%d=%d\n", i, j, (i+j));
				}
			}
		}
		
		/*
		연습문제] 앞의 문제를 while문으로 변경하시오.
		 */
		System.out.println("while문으로 주사위문제 구현하기");
		int i=1;
		//주사위1은 i를 통해 반복
		while(i<=6) {
			int j=1;
			//주사위2는 j를 통해 반복
			while(j<=6) {
				if(i+j==6) {
					System.out.printf("%d+%d=%d%n" , i, j, (i + j));
				}
				j++;
			}
			i++;
		}
		
		/*
		연습문제] 앞의 문제를 do~while문으로 변경하시오.
		 */
		System.out.println("do~while문으로 주사위문제 구현하기");
//		int m=1;
//		int n=1;
//		do {
//			if(m+n==6) {
//				System.out.printf("%d+%d=%d%n" , m, n, (m + n));
//				m++;
//			}
//			n++;
//		}while(m<6 || n<6);
		
		
		/*
		시나리오] 방정식 2x+4y=12를 만족하는 모든 x,y값을 구하시오.
		단, x,y의 범위는 0~10사이의 정수이고 while문을 통해 구현하시오.
		실행결과]
			x=0, y=3
			x=2, y=2
			.......
		 */
		System.out.println("방정식을 만족하는 x,y를 while문으로 찾기");
		//1.x와 y를 통해 각각 0~10까지 반복하는 while문을 중첩해서 만든다.
		int x=0;
		while(x<=10) {
			int y=0;
			while(y<=10) {
				//2.문제의 방정식을 아래와 같은 조건식으로 변경한다.
				if((2*x)+(4*y)==12) {
					//3.조건에 만족하는 x,y를 출력한다.
					System.out.printf("2x+4y=12를 만족하는 x,y :%d, %d%n" , x, y);
				}
				y++;
			}
			x++;
		}
		
		
		/*
		연습문제] 앞의 방정식 문제를 for문으로 변경하시오.
		 */
		System.out.println("방정식을 만족하는 x,y를 for문으로 찾기");
		for(int n=0; n<=10; n++) {
			for(int m=0; m<=10; m++) {
				if((2*n)+(4*m)==12) {
					//3.조건에 만족하는 x,y를 출력한다.
					//System.out.printf("2x+4y=12를 만족하는 x,y :%d, %d%n" , n, m);
					System.out.println("2x+4y=12를 만족하는 x,y :" +n+ ","+ m);
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
