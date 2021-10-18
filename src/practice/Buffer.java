package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Friend implements Serializable{
	String name;
	String phone;
	String addr;
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showAllData() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phone);
		System.out.println("주소:" + addr);
	}
	public void showBasicInfo() {}
}

//고딩
class HighFriend extends Friend{
	String nickname;

	public HighFriend(String name, String phone, String addr, String nickName) {
		super(name, phone, addr);
		this.nickname = nickName;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+nickname);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		super.showBasicInfo();
		System.out.println("별명:"+nickname);
		System.out.println("전번:"+phone);
	}
}

//대딩
class UnivFriend extends Friend{
	String major;

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

public class Buffer {

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
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		while(true) {
			menuShow();
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break; 
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				handler.saveFriendInfo();
				
				System.out.println("프로그램종료");
				return; 
			}
		}
	}
}	

class FriendInfoHandler{
	ArrayList<Friend> lists;

	public FriendInfoHandler(int num) {
		lists = new ArrayList<Friend>();
		
		readFriendInfo();
	}
	
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(choice == 1) {
			System.out.print("별명:"); iNickname = scan.nextLine();
			lists.add(new HighFriend(iName, iPhone, iAddr, iNickname));
		}
		else if(choice ==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			lists.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	public void showAllData() {
		for(Friend fr : lists) {
			fr.showAllData();
		}
	}
	public void showSimpleData() {
		for(Friend fr : lists) {
			fr.showBasicInfo();
		}
	}
	
	public void searchInfo() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String serachName = scan.nextLine();
		
		Iterator<Friend> itr = lists.iterator();
		while(itr.hasNext()) {
			Friend fr = itr.next();
			if(serachName.compareTo(fr.name)==0) {
				fr.showAllData();
				isFind = true;
				System.out.println("**귀하가 요청하는 정보를 찾았습니다**");
			}
		}
		if(isFind ==false) {
			System.out.println("**찾는 정보가 없습니다.**");
		}
	}
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(Friend fr : lists) {
			if(deleteName.compareTo(fr.name)==0) {
				lists.remove(fr);
				deleteIndex = 1;
				break;
			}
		}
		if(deleteIndex == -1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			System.out.println("==데이터가 삭제되었습니다==");
		}
	}
	public void saveFriendInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ser.txt"));
			
			for(Friend fr : lists) {
				out.writeObject(fr);
			}
		}
		catch (Exception e) {
			System.out.println("친구 정보 직렬화시 예외발생");
		}
	}
	public void readFriendInfo() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ser.txt"));
			
			while(true) {
				Friend fr = (Friend) in.readObject();
				lists.add(fr);
				if(fr == null) break;
			}
		}
		catch (Exception e) {
			System.out.println("더 이상 읽을 객체가 없습니다.");
		}
		System.out.println("친구 정보가 복원되었습니다.");
	}
}
