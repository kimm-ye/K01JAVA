package ex12inheritance;
/*
상속관계에 놓여있는 클래스의 생성자 정의 및 호출방식을 기본으로 
다음 클래스의 적절한 생성자를 삽입해보자. 
그리고 이의 확인을 위한 main 메소드도 적절히 정의해보자.

샘플코드]
class Car
{
       	int gasoline;
}
class HybridCar extends Car
{
       	int electric;
}
class HybridWaterCar extends HybridCar
{
       	int water;
 
       	public void showNowGauge()
       	{
                 	System.out.println("남은가솔린:"+gasoline);
                 	System.out.println("남은전기량:"+electric);
                 	System.out.println("남은워터량:"+water);
       	}
}
public class QuConstructorAndSuper {

	public static void main(String[] args)
	{
		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
		hcar.showNowGauge();
	}
}

실행결과]
남은가솔린:10
남은전기량:20
남은워터량:30


 */
//class Car{
//       	int gasoline;
//}
//class HybridCar extends Car{
//       	int electric;
//}
//class HybridWaterCar extends HybridCar{
//       	int water;
//       	
//   	public HybridWaterCar(int gasoline, int electric, int water) { //생성자는 무조건 public 
//		this.gasoline = gasoline;
//		this.electric = electric;
//		this.water = water;
//	}
//   	
//	public void showNowGauge(){
//        System.out.println("남은가솔린:"+gasoline);
//        System.out.println("남은전기량:"+electric);
//        System.out.println("남은워터량:"+water);
//   	}
//}
//
//public class QuConstructorAndSuper {
//
//	public static void main(String[] args) {
//		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
//		hcar.showNowGauge();
//	}
//}


class Car{
   	int gasoline;
   	
   	public Car(int g) {
		gasoline = g;
		System.out.println("Car생성자호출");
	}
}
class HybridCar extends Car{
   	int electric;
   	
   	//생성자는 클래스명과 동일하고 반환타입이 없다.
   	//접근지정자는 큰 이유가 없다면 무조건 public으로 지정한다.
   	public HybridCar(int g, int e) {
   		super(g);
   		electric = e;
   		System.out.println("HybridCar생성자호출");
   	}
}
class HybridWaterCar extends HybridCar{
   	int water;
   	
	public HybridWaterCar(int g, int e, int w) {
	//부모클래스의 인자 생성자 호출
	super(g,e);
	water = w;
	System.out.println("HybridWaterCar생성자호출");
}
	
public void showNowGauge(){
    System.out.println("남은가솔린:"+gasoline);
    System.out.println("남은전기량:"+electric);
    System.out.println("남은워터량:"+water);
	}
}

public class QuConstructorAndSuper {

	public static void main(String[] args) {
	HybridWaterCar hcar = new HybridWaterCar(10,20,30);
	hcar.showNowGauge();
	}
}
