package bokang.sub;

/*
체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
	
	3.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	4.포인트 적립율 변경
		10만원 이하결재 : 0.1%적립
		10만원 초과결재 : 0.3%적립
 */


public class CheckCard3 {
	
	private long cardNumber; //카드번호
	private String owner; //소유자
	private int balance; //잔액
	private int point; //포인트
	
	
	//기본생성자 (디폴트생성자) : 클래스명이랑 똑같은 이름의 메서드
	public CheckCard3() {}
	//인자생성자 : 인자생성자만들면 기본생성자는 안생기나 같이 하나 써주는게 좋다.
	public CheckCard3(long cardNumber, String owner, int balance, int point) {
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

//	public void initMembers(long cardNumber, String owner, int balance, int point) { //this가 있기때문에 똑같이 작성해도 됨
//		//멤버변수를 멤버메서드에서 사용할때는 무조건 this를 붙여주면 좋다.
//		this.cardNumber = cardNumber;
//		this.owner = owner;
//		this.balance = balance;
//		this.point = point;
//	}
	
	//멤버메서드
	//충전(입금)
	public void charge(int amount) {
		if(amount>=10000 && amount%10000 ==0) {
			this.balance += amount;
			System.out.printf("%s님 %d원 충전완료\n", owner, amount);
			System.out.printf("[잔고]%d원입니다.\n", balance);
		}
		else {
			System.out.println("충전은 만원단위만 가능");
		}
	}
	
	//결제 
	public void payment(int amount) {
		if(balance >= amount) {
			this.balance -= amount;
			savingPoint(amount);
		}
		else {
			System.out.printf("%s님 잔고가 부족합니다.\n", owner);
		}
	}
	
	//적립
	public void savingPoint(int amount) {
		/*
		좁은 지역에서 생성한 변수는 넓은 지역에서 사용할수 없다.
		넓은 지역에서 생성한 변수는 좁은 지역에서 사용할수 있다.
		지역변수는 해당 지역을 벗어나면 메모리에서 소멸된다.  
		 */
		double plusPoint =0;
		if(amount > 100000) {
			plusPoint = (amount * 0.3);
		}
		else {
			plusPoint = (amount * 0.1);
		}
		this.point += plusPoint; 
	}
	
	//현재상태출력
	public void showState() {
		System.out.println("카드번호 : " + this.cardNumber);
		System.out.println("소유자 : "  + this.owner);
		System.out.println("잔액 : "  + this.balance);
		System.out.println("포인트 : "  + this.point);
	}





}
