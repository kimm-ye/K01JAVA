package ex09package;

import ex09package.kosmo.buyer.FruitBuyer3;
import ex09package.kosmo.seller.FruitSeller3;

/*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 구분하여 정상 실행되도록 변경하시오.

FruitSeller3 클래스 -> ex09package.kosmo.seller 패키지에 묶는다
FruitBuyer3 클래스 -> ex09package.kosmo.buyer 패키지에 묶는다

두 클래스를 적절히 import하여 정상동작 할 수 있도록 FruitSalesMain3 클래스를 구성하시오
 */


//프로그램의 출발점이 되는 메인클래스
public class FruitSalesMain4 {

	public static void main(String[] args) {

		//판매자1 : 사과 100개, 단가 1000원 
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000); 
		
		//판매자2 : 사과 80개, 단가 50원
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500); 
		
		//구매자: 보유금액 10000원
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		System.out.println("구매행위가 일어나지 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//판매자1, 판매자2에게 각가  5000원을 지불하고 사과를 구매
		 
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}
}
