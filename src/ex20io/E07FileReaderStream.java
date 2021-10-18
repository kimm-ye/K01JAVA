package ex20io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class E07FileReaderStream {

	public static void main(String[] args) {
		try {
			//버퍼로 사용할 크기가 10인 char형 배열을 생성
			char[] cbuf = new char[10];
			int readCnt;
			
			//txt파일을 대상으로 문자입력 스트림을 생성
			//자바 입장에서 보면 입력을 하는 건 Write /  output이 맞는거고, 출력을 하는건 Reader /input 이지
			Reader in = new FileReader("src/ex20io/alpha.txt"); //앞에 6번 예제가 있어야 7번이 오류 없이 사용 가능
			
			//배열cbuf 앞에서부터 최대 10개의 문자를 읽어서 저장한다.
			//배열이니까 0부터
			readCnt = in.read(cbuf, 0, 10);
			
			//읽어온 갯수만큼 출력
			for(int i=0; i<readCnt; i++) {
				System.out.println(cbuf[i]);
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일없음");
		}
		catch (IOException e) {
			System.out.println("IO오류발생");
		}
	}
}
