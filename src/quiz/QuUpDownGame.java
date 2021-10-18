package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class NumberRangeException extends Exception{
	public NumberRangeException() {
		super("1~100까지만 ^^"); //이건 메세지만 나오게 하는거니까 밑에 catch문에서 e.getMessage로 출력할 수 있도록 한다.
	}
}

public class QuUpDownGame {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int gameCount = 0;
		
		int com = random.nextInt(99) + 1; //1~100까지 난수 생성
		System.out.println("com:" + com);
		
		while(true) {
			try {
				System.out.print("1~100까지 숫자 중에 입력하세요 :");
				int user = scanner.nextInt(); //사용자가 입력
				
				//시도
				if(!(user > 0 && user <101)) {
					try {
						NumberRangeException numberRange = new NumberRangeException();
						throw numberRange;
					}
					catch (NumberRangeException e) {
						System.out.println(e.getMessage());
					}
				}
				else if (com > user) {
					System.out.println("업");
					gameCount++;
				}
				else if(com < user) {
					System.out.println("다운");
					gameCount++;
				}
				else if(com == user) {
					System.out.println("정답~!");
				}
				
				if(gameCount>6 || com == user) {
					System.out.print(gameCount + "번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) :");
					while(true) {
						int restartCode = scanner.nextInt();
						if(restartCode ==1) {
							gameCount =0;
							break;
						}
						else if(restartCode ==0) {
							System.out.println("게임종료");
							return;
						}
						else {
							System.out.print("재시작(1), 종료(0) 중에 고르세요 : ");
						}
					}
				}
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("문자 입력하면 안댐!");
			} 
		}	
	}	
}
