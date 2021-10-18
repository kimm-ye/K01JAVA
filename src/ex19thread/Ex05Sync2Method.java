package ex19thread;

//2개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti2{
	long num; //int범위를 넘어서 결과값이 -로 나올수 있으므로 long으로 아예 바꿔준다
	public SumMulti2() {
		num=0; //생성자 0으로 초기화
	}
	
	/*
	synchronized 선언으로 인해 정확한 결과가 나오긴 하지만 코드 실행시간이
	훨씬 더 길어지게 되는 단점이 있다.
	즉 동기화는 성능의 감소를 초래하므로 필요한 부분에 대해서만 동기화 
	처리해주는 것이 좋다.
	메서드 전체를 동기화 하는 방법과 필요한 코드만 동기화하는 두가지 방법이 있다.
	 */
	
//	//동기화방법1 : 동기화 메서드
//	synchronized public void addNum(int n) {
//		num+=n; 
//	}
	
	//동기화방법2 : 동기화 블럭 : 동기화를 시키기 위한 부분만 블럭처리 (조금 더 좋은 성능을 보임)
	public void addNum(int n) {
		synchronized(this) {
			num+=n; 
		}
	}
	public long getNum() {
		return num; //private가 아니라 getNum 굳이 안해도 됨
	}
}



class MultiAdderThread2 extends Thread{
	SumMulti2 sumInst; //상속이아닌 composition구성관계 //위의 공유객체를 멤버변수로 선언
	int start, end;
	
	public MultiAdderThread2(SumMulti2 sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	
	/*
	쓰레드를 통해 반복적인 공유객체인 sumInst의 addNum()을 호출한다.
	따라서 동시에 접근이 되는 경우가 발생하게 된ㄷ.
	동기화가 처리되지 않아 잘못된 결과가 출력될 것이다.
	 */
	@Override
	public void run() {
		for(int i=start; i<=end; i++){
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync2Method {

	public static void main(String[] args) {
		
		//공유객체로 사용할 객체 생성(하나만 생성) //공유할거라서 하나만 생성해야 한다. 그래서 위에서 sumInst = new SumMulti2()를 쓰지 않는다.
		SumMulti2 s =new SumMulti2();
		MultiAdderThread2 mat1 = new MultiAdderThread2(s, 1, 50000);
		MultiAdderThread2 mat2 = new MultiAdderThread2(s, 50001, 100000);
		mat1.start();
		mat2.start();
		
		try {
			mat1.join();
			mat2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~10000까지의 합:" + s.getNum()); //즉 값이 계속 바뀐다. 값에 동시에 접근할 수 있기 때문에 
	}
}
