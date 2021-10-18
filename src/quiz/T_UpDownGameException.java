package quiz;

import java.util.Random;
import java.util.Scanner;

public class T_UpDownGameException
{
	public static void upDownGameStart() {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int restart;
		boolean forEnd = false;//7번만에 맞추는지 확인하기 위한 변수
		
		// 무한루프안에서 사용자가 7번안에 맞추는지
		while (true) {
			// 난수생성
			int computerNum = random.nextInt(10000) % 100 + 1; // 1~100까지 랜덤으로 //1~100까지 랜덤 nextInt(100)으로 쓰고 % 안써도 되지만 이렇게 해주면 더 큰 단위로 쪼개져서 사용가능하다.
			System.out.println("컴퓨터가 생성한 난수:"+ computerNum);

			//7번의 시도를 한다. 
			for (int i = 1; i <= 7; i++) {
				int userNum = 0;
				try {
					System.out.print("1~100까지 숫자입력:");
					userNum = scan.nextInt();
				}
				catch(Exception e) {
					scan.nextLine();
					System.out.println("[예외처리]문자는 입력하면 안되용");
				}
				
				// 성공실패
				if (userNum > computerNum) {
					System.out.println("Down, 더 낮은 숫자입니다.");
				}
				else if (userNum < computerNum) {
					System.out.println("Up, 더 높은 숫자입니다.");
				}
				else {
					System.out.println("일치합니다.");
					//isSuccess = true;
					System.out.println(i+"번 안에 성공");
					System.out.println("-----------------------");
					
					forEnd = true;
					
					//for문 탈출
					break;					 
				}				
			}	
			//7번만에 맞추지 못한 경우...
			if(forEnd == false) {
				System.out.println("실패");
			}
			while(true) {
				System.out.println("-----------------------");
				System.out.println("게임재시작(1), 종료(0) ");
				System.out.print("재시작여부를 입력하세요:");
				restart = scan.nextInt();
				// 0,1 이 입력되었을때 탈출
				if (restart == 0) {
					return;
				} 
				else if (restart == 1) {
					forEnd = false;
					System.out.println("게임 재시작!");
					break;
				} 
				else {
					System.out.println("잘못입력해씸..");						
				}
			}	 
		}		
	}
	public static void main(String[] args)
	{
		upDownGameStart();
	}
}
