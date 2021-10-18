package ex13interface;

/*
인터페이스(Interface)
-클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할 수 있다.
-자바는 단일 상속을 원칙으로 하나 인터페이스를 통해 다중상속을 할 수 있다.
-추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서
	반드시 오버라이딩 해야한다.
-멤버로는 추상메서드와 상수로만 구성된다.
	메서드 : public abstract
	상수: public static final
-인터페이스는 생성자가 없다. //객체를 만들어서 써먹을 일이 없기 때문에
 */
interface MyInterface1{
	
	//생성자는 사용할 수 없다.
	//public MyInterface1() {} //->에러발생
	
	//변수를 선언하면 무조건 상수로 선언된다. 따라서 대문자로 기술한다.
	public static final int MAX_INT = 210000000;
	double MAX_DBL = 1.99999999;
	
	//메서드는 무조건 추상메서드로 선언된다.
	public abstract void absFunc1();
	void absFunc2(); //이름이 동일한 경우 하나만
}

class SimpleCalss{
	int simple = 1;
	void mySimple() {
		System.out.println("simple=" + simple);
	}
}

interface MyInterface2{
	void absFunc2();
}

/*
인터페이스는 콤마를 이용해서 여러개를 동시에 '구현'할 수 있다.
또한 '상속'과 '구현'을 동시에 사용할 수도 있다.
 */
class MyClass extends SimpleCalss implements MyInterface1, MyInterface2{
	
	/*
	인터페이스에 동일한 이름의 추상메서드가 존재하는 경우
	하나만 오버라이딩 하면 된다.
	 */
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
}

public class E03InterfaceBasic {

	public static void main(String[] args) {
		
		//구현한 인터페이스를 통해 참조변수를 생성할 수 있다.
		MyInterface1 my1 = new MyClass(); //생성자로는 쓸수없지만 참조변수로는 만들 수 있다. 즉 MyInterface1 my1 = new MyInterface1();는 안됨
		
		my1.absFunc1();
		my1.absFunc2();
		
		//자식쪽 멤버에 접근하기 위해 다운캐스팅 후 호출한다.
		((SimpleCalss)my1).mySimple();
	}
}
