package ex17collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

/*
사용자로부터 이름을 입력받아 그 이름으로 검색해서 인덱스 위치(indexOf사용)를 알아내서 
해당 인덱스로 그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를 출력하여라.

샘플코드]
public static void main(String[] args) {
	
	//ArrayList<Student> list = new ArrayList<Student>();
	LinkedList<Student> list = new LinkedList<Student>();
	
	//저장할 객체 생성
	Student st1 = new Student("가길동", 10, "2018");
	Student st2 = new Student("나길동", 20, "2017");
	Student st3 = new Student("다길동", 30, "2016");
	Student st4 = new Student("마길동", 40, "2015");
	
	//객체 추가(컬렉션에 저장)
	list.add(st1);
	list.add(st2);
	list.add(st3);
	list.add(st4);
		
	//1.검색할 이름을 입력받음
		
	//2.확장for문으로 컬렉션 전체를 접근
		
	//3.검색결과 유/무에 따라 
	//검색결과 있을때…검색된 데이터 삭제
	//검색결과 없을때...검색결과가 없다고 출력

	//4.전체정보 출력
}
실행결과]
검색할 이름을 입력하세요:가길동
오버라이딩 한 equals() 호출됨:가길동
[검색되었습니다]
[삭제후 정보출력]
이름:나길동, 나이:20, 학번:2017
이름:다길동, 나이:30, 학번:2016
이름:마길동, 나이:40, 학번:2015
 */
//public class QuArrayList {

//	public static void main(String[] args) {
//		//ArrayList<Student> list = new ArrayList<Student>();
//		LinkedList<Student> list = new LinkedList<Student>();
//		
//		//저장할 객체 생성
//		Student st1 = new Student("가길동", 10, "2018");
//		Student st2 = new Student("나길동", 20, "2017");
//		Student st3 = new Student("다길동", 30, "2016");
//		Student st4 = new Student("마길동", 40, "2015");
//		
//		//객체 추가(컬렉션에 저장)
//		list.add(st1);
//		list.add(st2);
//		list.add(st3);
//		list.add(st4);
//		
//		//1.검색할 이름을 입력받음
//		while(true) {
//			System.out.print("검색할 이름을 입력하세요:");
//			Scanner scanner = new Scanner(System.in);
//			String inputName = scanner.nextLine();
//			int index = -1; //값이 없으면 -1이 나오니까 
//			
//			//2.확장for문으로 컬렉션 전체를 접근
//			for(Student st : list) {
//				if(st.getName().equals(inputName)) {
//					index= list.indexOf(st);
//				}
//			}
//			//3.검색결과 유/무에 따라 
//			//검색결과 있을때…검색된 데이터 삭제
//			//검색결과 없을때...검색결과가 없다고 출력
//			if(!(index==-1)) {
//				System.out.println("해당 데이터를 삭제합니다.");
//				list.remove(index);
//				
//				//4.전체정보 출력
//				System.out.println("[삭제후 정보출력]");
//				for(Student st : list) {
//					st.showInfo();
//				}
//			} 
//			else {
//				System.out.println("검색 되지 않습니다.");
//			}
//		}	
//	}
//}

public class QuArrayList {
	public static void main(String[] args) {
		
		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
			
		//1.검색할 이름을 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력:");
		String deleteName = scanner.nextLine();
		
			
		//2.확장for문으로 컬렉션 전체를 접근
		
		//컬렉션의 인덱스는 항상 0부터 시작이므로 초기값은 -1로 해주는게 좋다.
		int index = -1;
		for(Student st : list) { //스튜던트 객체를 꺼낼거고, 꺼내야 하는 대상은 컬렉션 list라는 이름으로 되어 있음 // st는 이름
			//멤버변수 name은 private멤버이므로 getter를 통해서 접근
			if(deleteName.equals(st.getName())) {
				index =list.indexOf(st); 
			}
		}
		//3.검색결과 유/무에 따라 
		if(index==-1) {
			//검색결과 없을때...검색결과가 없다고 출력
			System.out.println("검색 결과가 없습니다.");
		}
		else {
			//검색결과 있을때…검색된 데이터 삭제
			list.remove(index).showInfo();
			/*
			컬렉션에 저장된 객체를 인덱스를 통해 삭제하면 삭제된 객체 자체를
			반환하므로 멤버메서드를 바로 호출할 수 있다.
			 */
		}
		
		//4.전체정보 출력
		System.out.println("삭제 후 전체정보 출력");
		for(Student st : list) { //student를 list에서 하나씩 꺼낸다는 의미
			System.out.println(st); //toString 을 Student에서 만들면 getInfo메소드쓰지 않고 데이터를 가져올 수 있다
			//System.out.println(st.getInfo()); //위와 동일한 결과를 가져올 수 있다.
			/*
			참조변수를 그대로 print()해야하는 경우라면 toString()메서드를 
			적절히 오버라이딩해야한다.
			 */
		}
	}

}