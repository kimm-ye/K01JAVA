package ex12inheritance;

import java.util.Scanner;

class Friends{
	String name;  //이름
	String phone; //전화번호
	String addr;  //주소
	public Friends(String name, String phone, String addr) {
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	public void showAllData() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phone);
		System.out.println("주소:" + addr);
	}
	public void showBasicInfo() {} //abstruct로 사용할 수 있나?
	//대딩이랑 고딩이랑 나오게 하는 변수가 다르기때문에 별도로 메서드 지정안함
}

//고딩친구
class HighF extends Friends{
	String nick;

	public HighF(String name, String phone, String addr, String nick) {
		super(name, phone, addr);
		this.nick = nick;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+nick); //고딩친구는 별명이 추가로 붙으니까
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		super.showBasicInfo();
		System.out.println("별명:"+nick);
		System.out.println("전번:"+phone);
	}
}

//대딩친구
class Univ extends Friends{
	String major;

	public Univ(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==대딩친구 (전체정보)==");
		super.showAllData();
		System.out.println("전공:"+major); //대딩친구는 전공이 추가로 붙으니까
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		super.showBasicInfo();
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);
	}
}



public class E10Myfriend {

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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

	}

}

class FriendsInfoHandler{
	
	private Friends[] myFriends;
	private int numOfFriends;
	
	public FriendsInfoHandler(int num) {
		super();
		myFriends = new Friends[num];
		numOfFriends = 0;
	}
	
	public void addFriend(int inputNum) {
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNick, iMajor;
		
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(inputNum==1) {
			System.out.print("별명:"); iNick = scan.nextLine();
			myFriends[numOfFriends++] = new HighF(iName, iPhone, iAddr, iNick);
		}
		else if(inputNum==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[inputNum++] = new Univ(iName, iPhone, iAddr, iMajor);
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	public void showAllData() {
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	
	public void showSimpleData() { //간략정보 출력용 메서드
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다.==");
	}
	
	public void searchInfo(){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String serachName = scan.nextLine();
		
		boolean isFind = false;
		for(int i=0; i<numOfFriends; i++) {
			if(serachName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				isFind = true; //이렇게 안하면 출력이 안되나?
			}
			//return; //왜 이렇게 하면 대딩정보는 안나올까? return 때리는 순간 바로 끝나서 함수 호출한 곳으로 가버림
		}
		if(isFind == false) {
			System.out.println("**찾는 정보가 없습니다.**");
		}
	}
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfFriends; i++) {
			if(deleteName.compareTo(myFriends[i].name)==0) {
				myFriends[i] =null; //i번째를 삭제했고
				deleteIndex = i; 
			}
		}
	}
	
	
	
}














