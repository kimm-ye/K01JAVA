package ex12inheritance;

import java.util.Scanner;

/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 
Friend클래스로 객체생성은 하지 않을 것이다.
상속의 목적으로만 정의된 클래스이다.
 */

class Friend{
	//멤버변수
	String name;  //이름
	String phone; //전화번호
	String addr;  //주소
	//생성자
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버변수 전체정보 출력용 멤버메서드
	public void showAllData() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phone);
		System.out.println("주소:" + addr);
	}
	
	/*
	간략정보를 출력하는 용도의 멤버메서드로 실행부가 없는 상태로 정의한다.
	해당 프로그램에서는 오버라이딩의 목적으로만 사용된다.
	 */
	public void showBasicInfo() {} //오버라이딩의 목적으로 메소드 이름만 정의
}
//고딩친구
class HighFriend extends Friend{
	//확장한 멤버변수
	String nickname; //별명

	public HighFriend(String name, String phone, String addr, String nickname) {
		//부모클래스의 생성자 호출
		super(name, phone, addr);
		//자신의 멤버변수 초기화
		this.nickname = nickname;
	}
	
	/*
	고딩친구의 전체정보를 출력하기 위해 부모에서 정의된 메서드를
	super를 통해 호출하고, 자식에서 확장한 변수를 별도의 print문을 통해
	출력한다.
	 */
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+nickname);
	}
	
	/*
	자식에서 오버라이딩하여 재정의한 메서드로 고딩친구의
	간략한 정보를 출력한다.
	 */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		super.showBasicInfo();
		System.out.println("별명:"+nickname);
		System.out.println("전번:"+phone);
	}
}
//대딩친구
class UnivFriend extends Friend{
	String major; //자식쪽에서 확장한 멤버변수. 전공

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==대딩친구 (전체정보)==");
		super.showAllData();
		System.out.println("전공:"+major);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		super.showBasicInfo();
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);
	}
}

public class E10MyFriendInfoBook {
	
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력 ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력 ");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색 ");
		System.out.print("6.삭제 ");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택 >>>> ");
	}

	/*
	프로그램 전반의 흐름에 대해서만 기술하고 관련 메서드를
	호출하는 정도로만 구성한다.
	main메서드는 단지 프로그램의 시작점(Entry point)정도의 의미만 가지는게 좋다.
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//기능을 담당하는 핸들러 클래스의 객체 생성
		//초기값으로 100명의 정보를 저정할 수 있는 Friend 타입의 객체배열 생성
		FriendInfoHandler handler = new FriendInfoHandler(100); //num = 100 즉, 100명을 저장할 수 있는 크기
		
		//무한루프 조건으로 특정 입력에만 종료할 수 있는 구조를 만들어준다.
		while(true) { //true를 바꿀수 없어서 무한루프
			menuShow();
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: case 2:
				//System.out.println("고딩/대딩 친구입력");
				handler.addFriend(choice);
				break; //break문을 만나면 switch문을 탈춣한다.
			case 3:
				//System.out.println("전체정보출력");
				handler.showAllData();
				break; //break를 나오면 switch문만 나와서 while로 다시 들어가는 거임
			case 4:
				//System.out.println("간략정보출력");
				handler.showSimpleData();
				break;
			case 5:
				//System.out.println("검색");
				handler.searchInfo();
				break;
			case 6:
				//System.out.println("삭제");
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램종료");
				return; //main메서드의 종료이므로 프로그램 자체의 종료로 이어진다. //메인메서드 리턴은 프로그램 종료
			} ////switch 끝
		} ////while 끝
	} ////main 끝
} ////class끝


/*
해당 프로그램에서 기능을 담당하는 클래스를 핸들러 혹은 매니져 클래스라고 한다.
 */
class FriendInfoHandler{
	
	//멤버변수
	//친구의 정보(객체)를 저장할 부모타입의 객체배열
	private Friend[] myFriends; //프렌드 타입의 객체 배열 -> 객체를 저장할 수 있는 배열
	//실제 저장된 연락처 갯수
	private int numOfFriends; 
	
	//생성자 -> 초기화 담당
	public FriendInfoHandler(int num) {
		//num 크기의 객체배열 생성
		myFriends = new Friend[num]; //해당 객체 생성. num을 가지고 객체 크기 파악
		//최초 실행시 저장된 객체가 없으므로 0으로 초기화
		numOfFriends = 0; //처음엔 저장된 친구 0이니깐
	}
	
	//새로운 친구 연락처 추가
	public void addFriend(int choice) {
		//choice가 1이면 고딩, 2이면 대딩친구 추가
		
		//정보 입력을 위한 객체 생성
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		//기본정보입력(=연락처의 공통사항)
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		/*
		1. 친구정보를 입력받은 후
		2. 객체배열의 0번방에 객체를 저장하고
		3. numOfFriends를 1 증가시킨다. 후위증가이므로 이렇게 처리된다.
		 */
		if(choice==1) { //고딩친구 입력 후 추가
			System.out.print("별명:"); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname); //결과는 동일하나 작성방법만 다름 . 방법1 객체생성 후 후위연산통해서
			myFriends[numOfFriends++] = high; //후위연산
		}
		else if(choice==2) { //대딩친구 입력 후 추가
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[numOfFriends++] = new UnivFriend(iName, iPhone, iAddr, iMajor);//결과는 동일하나 작성방법만 다름 . 객체를 생성함과 동시에 집어넣음
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	} // end of addFriend

	/*
	친구의 정보를 출력하기 위한 멤버메서드
	1. 친구정보를 추가할때 High 또는 Univ 객체가 배열에 저장된다.
	2. 입력시 모든 객체는 Friend로 자동 형변환되어 저장된다.
	3. 정보 출력시 배열에 입력된 객체수만큼 반복하면서 각 요소를 통해 멤버메서드를 호출한다.
	4. 이때 오버라이딩된 메서드를 통해 항상 해당 객체의 정보를 출력할 수 있다.
		참조변수의 타입에 영향을 받지 않고 항상 오버라이딩된
		최하위 메소드가 호출되기 때문이다.
	 */
	
	//showAllData는 위에도 있는데 위에 오버라이딩한 메서드를 저장한 친구 숫자만큼 반복해야해서 여기서 따로 정의
	public void showAllData() { //전체정보 출력용 메서드
		for(int i=0; i< numOfFriends; i++) {
			myFriends[i].showAllData(); //오버라이딩한 자식 메서드가 나온다
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	
	public void showSimpleData() { //간략정보 출력용 메서드
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다.==");
	}
	
	public void searchInfo() {
		
		boolean isFind = false; //검색한 정보가 있는지 확인하기 위한 변수
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String serachName = scan.nextLine();
		
		//객체배열에 저장된 정보의 갯수만큼 반복
		for(int i=0; i<numOfFriends; i++) {
			/*
			검색을 위해 입력한 이름과 각 인덱스에 저장된 객체의 name변수의 
			비교를 통한 문자열 검색을 진행한다.
			 */
			if(serachName.compareTo(myFriends[i].name)==0) {
				//일치하는 이름이 있으면 정보를 출력한다.
				myFriends[i].showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다**");
				isFind = true; //찾는 정보가 있다면 true로 변경
			}
		}
		//반복문을 벗어났는데 아직도 false값이면 
		if(isFind == false) {
			System.out.println("**찾는 정보가 없습니다.**");
		}
	}//// end of searchInfo
	
	//주소록삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		/*
		배열의 요소 중 삭제된 요소의 인덱스 값을 저장할 용도의 변수.
		요소를 삭제한 후 빈자리를 채워넣을때 사용할 것임.
		배열은 인덱스이므로 초기값은 -1로 설정한다.
		
		인덱스는 0부터니까
		 */
		int deleteIndex =-1;
		
		//저장된 데이터만큼 반복
		for(int i=0; i<numOfFriends; i++) {
			//삭제할 이름이 있는지 검색
			if(deleteName.compareTo(myFriends[i].name)==0) {
				//객체를 삭제하기 위해 null값으로 변경한다
				myFriends[i] = null; //null값은 객체가 없다는 뜻. 나중에 가비지 컬렉션이 메모리를 자동으로 정리해준다.
				//삭제한 요소의 index를 저장한다.
				deleteIndex = i; //i번째를 삭제했으니 그 자리를 뒤에 아이로 땡긴다
				//전체카운트를 1 차감한다.
				numOfFriends--; //그리고 삭제한 녀석을 맨 뒤로 보냈으니 그 부분은 무시하기로 하고 배열에서 제외한다. 일단 하나씩 밖에 못 뺴니까 --
				//하나의 객체를 삭제했다면 즉시 for문 탈출
				break;
			}
		}
		if(deleteIndex == -1) {
			//검색된 데이터가 없어 삭제되지 않았다면 기존 -1을 그대로 유지한다.
			System.out.println("==삭제된 데이터가 없습니다.");
		}
		else {
			/*
			객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤 요소를 앞으로 하나씩 이동시킨다.
			numOfFriends는 앞에서 1 차감되므로 마지막 요소는 무시된다. 
			 */
			for(int i=deleteIndex; i<numOfFriends; i++) { //null값으로 구멍난 곳 메꾸는 작업
				myFriends[i] = myFriends[i+1]; //앞으로 땡기는 거임 안하면 nullException뜸
			}
			System.out.println("==데이터(" + deleteIndex + "번)가 삭제되었습니다.==");
		}
	}////end of deleteInfo
}////end of FriendInfoHandler