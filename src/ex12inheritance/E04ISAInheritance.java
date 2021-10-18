package ex12inheritance;

/*
Is-A 관계
	:X is a Y => X는 Y의 일종이다로 표현가능
	-노트북은 컴퓨터의 일종이다.
	-휴대폰은 전화기의 일종이다.
	이와같이 Is-A 관계가 성립하는 개체를 상속으로 표현하기에 적합하다.
 */

//컴퓨터 : 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산한다.
class Computer{
	
	String owner; //컴퓨터 소유주 이름
	
	//public Computer() {}
	/*
	생성자를 개발자가 추가하면 디폴트 생성자는 생성되지 않는다.
	 */
	public Computer(String name) {
		owner = name;
	}
	/*
	private 접근지정자로 선언된 멤버메서드는 외부클래스 혹은 상속받은 클래스에서
	접근이 불가능하므로 public 으로 선언된 메서드를 통해 
	간접 호출해야 한다.
	상속관계라면 protected로 선언된 메서드로 호출할 수도 있다.
	 */
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다. ");
	}
	//일정의 캡슐화 형태로 하나로 묶어놓은 형태임(순서)
	public void calculateFunc() {
		keyboardTouch();
		calculate();
	}
}

/*
컴퓨터를 상속한 노트북 컴퓨터
	: 컴퓨터가 가지고 있는 기본기능에 휴대이용 부분을 확장하여 정의한다.
	휴대이용을 위해 배터리 멤버변수가 추가된다.
 */
class NotebookComputer extends Computer{
	//자식클래스에서 확장한 변수
	int battary; //배터리 충전량
	
	/*
	부모생성자 호출을 위해 사용하는 super()는 생략이 가능하지만
	앞에 다른 문장이 먼저 오면 오류가 발생되므로 주의해야 한다.
	여기서는 부모의 인자생성자를 호출하고 있다.
	 */
	public NotebookComputer(String name, int initCharge) {
		/*
		여기서 아래super문장을 삭제하면 에러가 밣생한다.
		부모클래스에서 인자생성자를 정의하였으므로 디폴트 생성자는 만들어지지 않기 때문이다.
		 */
		//battary = initCharge; => 이게 위로 오면 에러 /부모님이 있어야 자식이 있기 때문에
		super(name); //생성자를 개발자가 추가하면 디폴트 생성자가 생성되지 않기 때문에 기재해야함
		battary = initCharge;
	}
	//배터리 충전을 표현한 메서드
	public void charging() {
		battary += 5;
	}
	//휴대하면서 컴퓨팅을 하는 것을 표현한 메서드
	public void movigCal() {
		//배터리 잔량 확인
		if(battary <1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		System.out.print("이동하면서 ");
		
		//private으로 선언된 멤버메서드이므로 직접 호출할 수 없다.
		//keyboardTouch(); //에러발생 private 사용해서
		//calculate(); //에러발생 private 사용해서
		calculateFunc();
		
		battary -= 1; //배터리 차감
	}
}
/*
태블릿 노트북 : 컴퓨터의 기본인 계산기능, 휴대이용 기능, 여기에 
	펜으로 드로잉 할 수 있는 기능까지 추가된 컴퓨터
 */
class TabletNotebook extends NotebookComputer{
	
	String registPencil; //태블릿을 사용하기 위한 펜슬
	//생성자
	public TabletNotebook(String name, int initCharge, String pen) {
		super(name, initCharge);
		registPencil =pen;
	}
	//태블릿 사용을 위해 배터리양 체크 및 등록된 펜인지 확인
	public void write(String penInfo) {
		if(battary <1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		/*
		A.compareTo(B)
			: 문자열 A와 B를 비교하여 0이 반환되면 같은 문자열로 판단하고,
			-1이나 1이 반환되면 서로 다른 문자열로 판단하는 
			String 클래스에 정의된 메서드
		 */
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary -= 1;
	}
}


public class E04ISAInheritance {

	public static void main(String[] args) {
		
		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		TabletNotebook tablet = new TabletNotebook("이동욱", 5, "ISE-1234");
		
		System.out.println("==노트북컴퓨터사용==");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		
		System.out.println("==ISE-1234 펜으로 테블릿사용==");
		tablet.write("ISE-1234"); //정상사용
		
		System.out.println("==XYZ-9876 펜으로 테블릿사용==");
		tablet.write("XYZ-9876"); //사용불가
	}
}
