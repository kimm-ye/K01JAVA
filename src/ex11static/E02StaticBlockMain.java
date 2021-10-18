package ex11static;

/*
static 블럭
	: 동일 클래스 안의 main메서드보다 먼저 실행되는 블럭으로
	main 메서드의 실행코드가 없어도 먼저 실행된다.
	또한 생성자 메서드보다 static 블럭이 먼저 실행된다.
 */
public class E02StaticBlockMain {
	
	//인스턴스형 멤버변수 및 메서드
	int instanceVar;
	void instanceMethod() {}
	
	//정적 멤버변수 및 메서드
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	
	//static 블럭
	static {
		//블럭내에서 정적멤버에 접근 가능
		staticVar = 1000;
		
		/*
		블럭내에서만 사용할 수 있는 변수로써, 블럭내에서는 일반적인
		변수를 생성할 수 있다.
		
		블럭내에서만 만들고, 값을 받고 출력하고 가능함.
		 */
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+ localVar); //사용가능
		
		/*
		static 블럭내에서는 인스턴스형 멤버에 접근할 수 없다.
		 */
		//System.out.println("instanceVar=" + instanceVar); //에러발생
		//instanceMethod(); //에러발생
		
		/*
		정적멤버에는 접근할 수 있다.
		 */
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		System.out.println("===static block 끝===");
	}
	
	//생성자메소드 : 클래스명이랑 동일하고 반환타입 없으니까 생성자
	/*
	
	 */
	public E02StaticBlockMain() {
		staticVar = -1;
		System.out.println("===StaticBlock의 생성자==");
	}
	
	public static void main(String[] args) {
		System.out.println("==메인메소드==");
		/*
		static블럭내에서 선언된 지역변수이므로 main메서드에서는 사용할 수 없다
		 */
		//System.out.println("localVar="+ localVar); //static 안에서만 쓸 수 있기 때문에 에러발생
	}
}// 출력결과를 보면 메인메소드보다 먼저 실행됨(static 블럭라인)
