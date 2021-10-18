package ex17collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;

/*
HashSet컬렉션
	: Set계열의 인터페이스를 구현한 컬렉션으로
	-객체가 순서 없이 저장된다.
	-객체의 중복저장을 기본적으로 허용하지 않는다.
	단, 기본클래스가 아닌 새롭게 정의한 클래스라면
	hashCode(), equals()를 적절히 오버라이딩하여 정의해야한다. //Set(객체1, 객체2...)일때 객체1과 객체2 ... 이 같은지 비교
	-List가 배열의 성격이라면 Set은 집합의 성격을 가진다.
 */
public class Ex04HashSet1 {

	public static void main(String[] args) {
		
		/*
		1]set컬렉션 생성 : 현재 Object를 기반으로 한 Set컬렉션이므로 다 받을 수 있음
		 */
		HashSet<Object> set = new HashSet<Object>();
		
		//2]다양한 객체 생성
		String strObject1 = "JAVA";  //String은 그냥 이렇게 써도 됨
		String strObject2 = new String("KOSMO99기");
		Date dateObject = new Date();
		int number = 100; //정수타입은 컬렉션에 저장시 Integer객체로 Boxing된다. //원래 기본자료형은 객체생성이 되지 않으므로 들어가지 않아 Wrapper클래스의 도움을 받아야한다. (자동으로 Boxing됨)
		Teacher teacher = new Teacher("김봉두", 55, "체육");
		
		/*
		3]객체저장
			: add()메서드를 통해 저장되고, 문제가 없다면 true가 반환된다.
		 */
		System.out.println(set.add(strObject1)); //true //참조값 넣으면 true / false반환?ㅣ
		set.add(strObject2);
		set.add(dateObject);
		set.add(number);
		set.add(teacher);
		
		/*
		4]저장된 객체수 얻기
		 */
		System.out.println("[중복저장전 객체수]:" + set.size()); //5개
		
		/*
		5-1]기본클래스형 객체 중복저장
			: 기본 클래스인 경우 별도의 오버라이딩이 없어도 중복이 제거된다.
			따라서 아래의 경우 false가 반환된다.
		 */
		System.out.println(set.add(strObject2)? "저장성공" : "저장실패");  //중복저장 실패
		System.out.println("[중복(String)저장후 객체수]:"+ set.size()); //5개
		
		
		/*
		5-2]개발자가 정의한 객체 중복저장
			: 사용자정의 클래스인 경우 hashCode, equals메서드를 
			오버라이딩하지 않으면 중복저장이 허용된다.
			아래의 경우 저장에 성공하여 true가 반환된다.
		 */
		Teacher teacher2 = new Teacher("김봉두", 55, "체육");
		System.out.println(set.add(teacher2)? "성공" : "실패"); //성공
		System.out.println("[중복(teacher2)저장후 객체수]:" + set.size()); //6개
		
		/*
		6]이터레이터를 통한 저장된 객체 출력
			: 순서없이 저장되므로 출력의 순서도 정할 수 없다.
		 */
		Iterator itr = set.iterator(); //이터레이터 객체 생성 및 준비
		while(itr.hasNext()) { //추출할 객체가 있는지 확인 후
			Object object = itr.next(); //추출
			
			/*
			Set에 저장된 모든 객체는 Object형으로 업캐스팅되므로
			사용시에는 다운캐스팅 하는 것이 좋다. (기본클래스는 제외)
			 */
			if(object instanceof String) {
				System.out.println("String타입:" + object); //기본클래스
			}
			else if(object instanceof Date) {
				System.out.println("Date타입:" + object); //기본클래스
			}
			else if(object instanceof Integer) {
				System.out.println("Integer타입:" + object); //기본클래스
			}
			else if(object instanceof Teacher) {
				System.out.println("Teacher타입:" + ((Teacher)object).getInfo()); //다운캐스팅
			}
			else  {
				System.out.println("넌 뭐임??");
			}
		}//end of while

		/*
		1-7]포함여부 확인
			: Set컬렉션 내에 해당 객체가 있는지만 확인한다.
			
			단, 어디에 있는지는 모름
		 */
		System.out.println(set.contains(strObject1)? "strObject1있다" : "strObject1없다");
		System.out.println(set.contains("JaVa")? "JaVa있다" : "JaVa없다");
		
		/*
		1-8]객체 삭제
			: Set은 인덱스가 없으므로 객체의 참조값을 통해서만 삭제할 수 있다.
		 */
		System.out.println(set.remove(strObject2)? "strObject2삭제성공" : "strObject2삭제실패");
		System.out.println(set.remove("Android")? "Android삭제성공" : "Android삭제실패");
		System.out.println("[삭제 후 객체수]" + set.size());
		
		/*
		1-9]전체삭제
		 */
		//set.clear();
		System.out.println("전체삭제:" + set.removeAll(set));
		System.out.println("[전체 삭제 후 객체 수]:" +set.size() );
	}
}
