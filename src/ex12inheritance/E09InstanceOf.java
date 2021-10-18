package ex12inheritance;

/*
instanceof 연산자
	: 인스턴스 변수가 어떤 타입의 변수인지를 판단하는 연산자로
	형변환(즉 상속관계가 있으면)이 가능하면 true, 아니면 false를 반환한다.
	-객체간의 형변환이 되려면 반드시 두 클래스 간에 상속관계가 있어야 한다.
	-부모클래스의 참조변수로 자식객체를 잠조할 수 있으므로,
	매개변수로 전달된 인자가 어떤 타입인지 확인할 때 주로 사용된다.
 */
class Box{
	public void boxWarp(){
		System.out.println("Box로 포장합니다");
	}
}

class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다");
	}
}

class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다");
	}
}

public class E09InstanceOf {
	/*
	원래는
	static void wrapBox(Box b){} 등으로 받았어야 했는데 다운캐스팅, 업캐스팅 사용해서 안써도 됨
	 */

	/*
	-여기서 instanceof연산자를 통해 형변환 가능 여부를 판단하는 이유는
	전달된 매개변수를 최상위 클래스인 Box타입으로 받고 있기 때문이다.
	-Box타입으로 인자를 받게 되면 자동으로 업캐스팅(자동형변환)이 되기
	때문에 자식클래스의 멤버메서드를 호출할 수 없게 된다.
	-이때 자식의 멤버메소드를 호출하기 위해서 다운캐스팅(강제형변환)이 필요하다.
	-따라서 전달된 인자의 각각의 타입으로 형변환이 가능한지 판단한 후 
	다운캐스팅을 진행하고 각 클래스의 멤버메서드를 호출 할 수 있게 된다.
	 */
	static void wrapBox(Box b) { //Box인지 ParaerBox인지 GoldPaperBox인지
//		int num1 = (int)1.0;
//		double num2 = 1;
		
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox)b).goldWrap(); //자식방으로 들어가려면 자식으로 변환해야함
		}
		else if(b instanceof PaperBox) {
			((PaperBox)b).paperWrap();
		}
		else if(b instanceof Box) {
			b.boxWarp(); //원래 그 상태였으니까 형변환X
		}
	}
	
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3); //각 타입의 인자를 부모타입인 Box로 한번에 받을 수 있다.
		
		String str = new String("나는 누구?");
		//wrapBox(str); //String객체와는 상속관계가 없으므로 호출불가능
	}
}
