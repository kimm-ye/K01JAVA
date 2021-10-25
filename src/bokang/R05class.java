package bokang;

import bokang.sub.CheckCard1;
import bokang.sub.CheckCard2;
import bokang.sub.CheckCard3;

public class R05class {

	public static void main(String[] args) {
		
		/*
		숫자를 구분할대 구분자로 언더바(언더스코어)를 사용할 수 있다.
		JDK7부터 지원되었으며 숫자사이에 쓰는것만 허용된다.
		잘못된방법]
			3._14159
			123_456_
			_123_456
			위와같이 언더바로 시작하거나 끝날 수 없고, 소수점과
			연결해서도 사용할 수 없다.
		 */
		//체크카드 클래스 Ver01
		CheckCard1 cc1 = new CheckCard1();
		cc1.cardNumber = 1111_2222_3333_4444L; //숫자 중간에 숫자를 구분하는 역할로 사용가능
		cc1.owner ="홍길동";
		cc1.balance = 10000;
		cc1.point = 0;
		
		cc1.payment(5000); //5000원 결제
		cc1.payment(10000); //10000원 결제
		cc1.showState(); //상태를 보면 마이너스 금액이 출력된다. (논리적오류)
		cc1.balance=10000000; //입금처리 없이 잔고의 변경이 가능하다. (논리적오류)
		
		
		//////////////////////////////////////////////////////////////////////////////////
		//체크카드 클래스 Ver02
		CheckCard2 cc2 = new CheckCard2(); //빈객체 생성한 후
		cc2.initMembers(9999_8888_7777_6666L, "유비", 3000, 0); //객체 초기화
		cc2.charge(4000);
		cc2.payment(9000);
		cc2.showState();
		
		//아래와 같은 건 불가능 왜냐하면 private로 묶어놓았기 때문에 함부로 접근할 수 없기때문
		//멤버변수가 private으로 정보은닉 되었으므로 접근불가능 
//		cc2.balance = 1000000; //에러발생
//		cc2.point = 300000; //에러발생
		
		
		/*
		위와 같이 초기화메서드를 사용하면 객체생성, 초기화를 별도로 진행해야하지만
		생성자를 사용하면 초기화까지 동시에 진행할 수 있다.
		즉 객체생성은 생성자를 사용하는게 좋다.
		 */
		CheckCard2 cc2_1 = new CheckCard2(1111_2222_3333_4444L, "제갈량", 10000, 0);
		cc2_1.payment(5000);
		cc2_1.showState();
		
		
		
		/*
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
		 */
		CheckCard3 cc3 = new CheckCard3(1111_3333_5555_7777L, "가", 200000, 1000);
		CheckCard3 cc3_1 = new CheckCard3(2222_4444_6666_8888L, "나", 20000, 0);
		CheckCard3 cc3_2 = new CheckCard3(2222_5555_8888_9999L, "다", 0, 0);
		
		System.out.println();
		cc3.payment(150000);
		cc3.showState();
		
		System.out.println();
		cc3_1.charge(4000);
		cc3_1.showState();
		
		System.out.println();
		cc3_2.payment(1000);
		cc3_2.charge(15000);
		cc3_2.showState();
		
	}

}
