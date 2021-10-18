package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/*
게임설명 : 가위바위보 게임을 메소드를 통해 구현한다.
난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
승부를 판단하여 출력한다.
1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.

실행결과]
무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 1
사용자 : 가위, 컴퓨터 : 보
이겼습니다.

무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 4
가위바위보 할줄 모르세요? 제대로 내세요^^;

….게임진행...

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 1

….게임재시작…

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 0
게임이 종료되었습니다. 감사합니다.

….게임종료….

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 5
잘못입력하셨습니다. 재시작(1), 종료(0)중에 입력하세요…..

 */
class WrongNumberException2 extends Exception{
	public WrongNumberException2() {
		super("게임과 관련없는 숫자를 입력하지마시오");
	}
}

public class QuRockPaperScissors_exception2 {
	
	public static void main(String[] args) { 
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int gameCount = 0;

		while(true) {
			int com = random.nextInt(3) + 1;
			System.out.println("컴퓨터 : " + com);
			
			int user = 0;
			
			try {
				
				System.out.print("무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) :");
				user = scanner.nextInt();
				System.out.println("사용자 : " + user);
				
				//if(!(user== 1 || user ==2 || user ==3)) {
				if(!(user>=1 && user <=3)) {
					WrongNumberException2 wn = new WrongNumberException2();
					throw wn;
				}
			}	
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("숫자로만 입력해야 합니다.");
			}
			catch (WrongNumberException2 e) {
				System.out.println(e.getMessage());
			}
			
			if(!(user<1 || user>3)) {
				gameCount++;
				switch(user-com) {
				case 0 :
					System.out.println("비겼습니다~~"); break;
				case 2 : case -1 :
					System.out.println("ㅜㅜ 졌습니다"); break;
				case -2 : case 1 :
					System.out.println("이겼습니다!!"); break;
				}
			}
			
			if(gameCount>4) {
				System.out.print(gameCount + "번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) :");
				while(true) {
					int restatCode = scanner.nextInt();
					if(restatCode == 1) {
						gameCount = 0;
						break;
					}
					else if(restatCode == 0) {
						System.out.println("게임종료");
						return;
					}
					else {
						System.out.print("재시작(1), 종료(0) 중에 고르세요 : ");
					}
				}
			}
		}
	}
}

