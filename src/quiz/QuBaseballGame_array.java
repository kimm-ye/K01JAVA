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
public class QuBaseballGame_array {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int[] com = new int[3];
		int[] user = new int[3];
		
		int strike =0, ball =0, gameCount=0, randomCnt=0;
	
		while(true) {
			
			while(true) {
				boolean reTry = true;
				randomCnt++;
				
				for(int i=0; i<com.length; i++) {
					com[i] = random.nextInt(100) % 9 +1;
				}
				for(int i=0; i<com.length; i++) {
					int j = i+1; //컴퓨터 인덱스가 0일때 j는 0다음인 1로 넘어가게 하고
					if(j ==com.length) j=0; //만약 1이 마지막 인덱스에 오면 0으로 없애버리고
					if(com[i]==com[j]) { //만약 둘이 같으면 중복이 되어버리니까 false반환
						reTry = false;
					}
				}
				
				if(reTry==true) break; //만족할만한 난수가 나왔단 소리니까 break로 while문 탈출
			}
			System.out.println(randomCnt+"회:"+ com[0]+" "+com[1]+" "+com[2]);
			
			while(true) {
				System.out.println("3개의정수를 입력하세요(1~9)");
				System.out.print("스페이스로 구분하시고 마지막에 Enter를 눌러주세요:");
				
				for(int i=0; i<user.length; i++) {
					user[i] = scanner.nextInt();
				}
				gameCount++; //for문을 나온다는 건 한번의 게임을 입력했다는 뜻이니까 게임 카운트를 올린다. 
				
				for(int i=0; i<com.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[i] == user[j]) {
							if(i==j) {
								strike++;
							}
							else {
								ball++;
							}
						}
					}
				}
				if(strike==3) {
					System.out.println("3스트라이크 게임종료");
					System.out.println(gameCount+"번만에 맞추셨습니다.");
					break;
				}
				else {
					if(strike ==0 && ball ==0) {
						System.out.println("아웃");
					}
					else {
						System.out.printf("%d스트라이크, %d볼\n", strike, ball);
					}
					//3번 스트라이크 일때는 상관없지만 아웃이나 스트라이크, 볼은 갯수 초기화해주어야하니까
					strike=0;
					ball=0;
				}
			}	
			System.out.println("한게임 더 하시겠습니까?(0:종료,1:재시작)");
			int restart = scanner.nextInt();
			if(restart==0) {
				System.out.println("\n==게임이 종료되었습니다.==\n");
				System.exit(0);
			}
			else if(restart==1) {
				strike=0;
				ball=0;
				gameCount=0;
				randomCnt=0;
				System.out.println("\n==게임을 재시작합니다.==\n");
			}
		}
	}
}
