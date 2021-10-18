package ex12inheritance;

class Account{
	/*
	멤버변수가 상속관계에 있다 하더라도 private으로 선언되면
	클래스 내부에서만 접근할 수 있다. 
	즉 상속받은 하위클래스에서는 직접 접근이 불가능하다.
	 */
	private int money; //잔고
	
	public Account(int init) {
		money = init;
	}
	/*
	입금처리 : protected로 선언되었으므로 상속관계에서 접근가능
	 */
	protected void depositMoney(int _money) {
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가합니다.");
			return;
		}
		System.out.println(money + "원 만큼 입급되었습니다.");
		money += _money;
	}
	//private으로 선언된 멤버변수를 외부로 반환할때 사용한다. 이런 녀석들을 getter메서드라고 한다
	//protected는 상속받는 클래스 커버 가능
	protected int getAccMoney() {
		return money;
	}
}

class SavingAccount extends Account{
	
	//생성자에서 super하고 있음
	/*
	인자생성자에서 부모의 생성자 메서드를 호출하기 위한 super()를 사용한다.
	이때 인자가 하나인 부모클래스의 생성자를 호출한다.
	 */
	public SavingAccount(int initVal) {
		super(initVal);
	}
	/*
	부모클래스의 protected로 선언된 멤버메서드를 각각 호출한다.
	 */
	public void saveMoeny(int money) {
		depositMoney(money);
	}
	public void showAccountMoney() {
		/*
		private 멤버변수인 money는 자식쪽으로 직접 접근할 수 없으므로
		접근 가능한 멤버메서드를 통해 간접적으로 접근한다.
		 */
		System.out.println("지금까지의 누적금액:" + getAccMoney());
		//원래는 부모니까 money로 쓸 수 있는데 private로 되어 있어서 간접적으로 받아야함
	}
}


public class E02PrivateInheritanceMain {

	public static void main(String[] args) {
		
		//자식클래스를 통해 객체생성
		SavingAccount sa = new SavingAccount(10000);
		
		/*
		private 멤버이므로 상속받은 하위클래스의 참조변수를 통해서는 접근할 수 없다.
		은닉된 정보이므로 'not visible'이라는 에러메세지를 볼 수 있다.
		 */
		//sa.money = 100000; //접근불가. 에러발생. private로 선언되어 있으니까 클래스내에서만 사용가능
		sa.saveMoeny(5000);
		sa.showAccountMoney();
		
		sa.saveMoeny(-1000);
		sa.showAccountMoney();
		
		/*
		부모클래스의 참조변수를 통해서도 private멤버는 접근할 수 없다.
		현재 접근하려는 위치가 Account 클래스 외부이기 때문이다.
		 */
		Account account = new Account(1000);
		//account.money = 1000; //접근불가. 에러발생. private로 선언되어 있으니까 클래스내에서만 사용가능
	}
}
