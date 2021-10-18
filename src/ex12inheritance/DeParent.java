package ex12inheritance;

//부모클래스
public class DeParent {
	
	private String name;
	private int age;
	
	public DeParent(){}
	public DeParent(String name, int age) {
		//super(); //모든 클래스는 Object를 상속한다. 그래서 Deparent가 처음이어도 super생김 
		this.name = name;
		this.age = age;
	}
	//getter()메서드 : private 멤버를 클래스 외부로 반환할때 사용
	public String getName() {
		return name;
	}
	
	/*
	멤버메서드 -> 4가지 접근지정자를 통해 정의함.
	 */
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep() { //defalut 타입이라 생략
		System.out.println("부모님이 주무신다");
		return null; //반환타입 받았으니 return 으로 반환해야함
	}
	protected void walk() {
		System.out.println("부모님이 산책하신다");
	}
	public void excecise() {
		System.out.println("부모님이 운동하신다");
	}
	
	//정보출력용 메소드
	public void printParent() {
		System.out.printf("성함:%s, 연세:%d", name, age);
	}
	
	//정적메소드 정의
	public static void staticMethod() {
		System.out.println("부모님의 정적메소드");
	}
}
