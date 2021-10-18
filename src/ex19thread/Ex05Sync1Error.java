package ex19thread;

//2개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti{
	int num;
	public SumMulti() {
		num=0; //생성자 0으로 초기화
	}
	
	//매개변수로 전달되는 n을 멤버변수 num에 누적해서 더함
	public void addNum(int n) {
		num+=n; 
	}
	public int getNum() {
		return num; //private가 아니라 getNum 굳이 안해도 됨
	}
}

class MultiAdderThread extends Thread{
	SumMulti sumInst; //상속이아닌 composition구성관계 //위의 공유객체를 멤버변수로 선언
	int start, end;
	
	public MultiAdderThread(SumMulti sum, int s, int e) {
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

public class Ex05Sync1Error {

	public static void main(String[] args) {
		
		//공유객체로 사용할 객체 생성(하나만 생성) //공유할거라서 하나만 생성해야 한다. 그래서 위에서 sumInst = new sumMulti()를 쓰지 않는다.
		SumMulti s =new SumMulti();
		MultiAdderThread mat1 = new MultiAdderThread(s, 1, 5000);
		MultiAdderThread mat2 = new MultiAdderThread(s, 5001, 10000);
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
