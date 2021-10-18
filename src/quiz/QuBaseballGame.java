package quiz;

import java.util.Random;
import java.util.Scanner;

/*
게임설명 : 야구게임을 메소드를 이용하여 구현한다.
1.중복되지 않는 3개의 정수를 생성한다.(1~9)
2.사용자는 3개의 숫자를 입력한다.
3.생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
4.숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
5.숫자는 맞지만 위치가 틀렸다면 ball 로 판정한다.
6.숫자3개가 모두 일치하지 않으면  out 으로 판정한다.
7.3 strike 가 되면 게임은 종료된다.
8.시도한 횟수를 표시한다.
9.계속할지 종료할지 여부를 물어보고 다음 진행을 한다.

위 문제의 변수들은 아래와 같이 생성하여 구현해본다.
   int com1, com2, com3;
   int user1, user2, user3;
아니면 
   int[] com = new int[3];
   int[] user = new int[3];
와 같이 배열을 사용해도 된다.

 */
public class QuBaseballGame {

public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int com1, com2, com3;
		int user1, user2, user3;
		
		int randomCnt = 0;
		int gameCnt = 0;
		int strikeCnt=0, ballCnt = 0;
		
		while(true) {
			while(true) {
				randomCnt++;
				com1 = random.nextInt(100) % 9 + 1;
				com2 = random.nextInt(100) % 9 + 1;
				com3 = random.nextInt(100) % 9 + 1;
				
				if(!(com1==com2 || com2 == com3 || com1 == com3)) break;
			}
			System.out.println(randomCnt+"회"+com1+" "+com2+" "+com3 );
			
			while(true) {
				System.out.println("3개의정수를 입력하세요(1~9)");
				System.out.println("스페이스로 구분하시고 마지막에 Enter를 눌러주세요");
				
				user1 = scanner.nextInt();
				user2 = scanner.nextInt();
				user3 = scanner.nextInt();
				
				gameCnt++;
				
				if(com1==user1) strikeCnt++;
				if(com2==user2) strikeCnt++;
				if(com3==user3) strikeCnt++;
				
				if(com1==user2 || com1==user3) ballCnt++;
				if(com2==user1 || com2==user3) ballCnt++;
				if(com3==user1 || com3==user2) ballCnt++;
				
				if(strikeCnt==3) {
					System.out.println("3스트라이크 게임종료");
					System.out.println(gameCnt +"번 만에 맞췄다");
					break;
				}
				else {
					if(strikeCnt==0 && ballCnt==0) {
						System.out.println("아웃");
					}
					else {
						System.out.printf("%d스트라이크, %d볼\n", strikeCnt,ballCnt);
						strikeCnt =0;
						ballCnt=0;
					}
				}
			}
			
			System.out.println("한게임더? 0종료 1재시작");
			int restart = scanner.nextInt();
			if(restart==0) {
				System.out.println("게임종료");
				System.exit(0);
			}
			else if(restart == 1) {
				strikeCnt=0;
				ballCnt=0;
				gameCnt=0;
				System.out.println("재시작");
			}
		}
	}
}
