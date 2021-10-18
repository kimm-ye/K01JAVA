package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 1byte씩 읽어서 저장하는 것보다 1kb(1024byte)씩 읽을수 있는 버퍼(buffer)를 
 이용하므로 복사속도가 훨씬 빨라진다.
 스트림 혹은 네트워크를 통해 파일을 전송할때 버퍼를 사용하는 이유는
 이런 속도차 때문이다.
 */
public class E02ByteBufferFileCopy {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("src/ex20io/apache-tomcat-9.0.54.zip");
			OutputStream out = new FileOutputStream("src/ex20io/apache-tomcat-9.0.54_copy2.zip");
			
			int copyByte = 0;
			int readLen;
			
			//1kbyte씩 읽어서 저장하기 위한 버퍼 생성(byte배열)
			//1024짜리 배열을 만들면 손수레처럼 한번에 1024만큼 실어서 퍼다 나르니까 빠르다
			byte buffer[] = new byte[1024];
			
			while(true) {
				//1kbyte씩 파일을 읽어서 저장
				readLen = in.read(buffer);
				if(readLen == -1) { //파일의 끝까지 읽으면 -1을 반환하므로 반복문을 탈출한다.
					break;
				}
				/*
				읽어온 내용을 파일에 입력한다. 버퍼에 저장된 데이터를
				인덱스 0의 위치에서 readLen의 크기만큼 전송한다.
				 */
				/*
				write(string, [offset], [length], [encoding])
					: 버퍼에 데이터를 출력합니다. (출력데이터, 시작위치, 출력할 바이트 수 ,인코딩)
					옵션을 특별히 지정해주지 않는경우 기본값으로 데이터를 모두 버퍼에 출력합니다. 인코딩 기본값은 'utf8'입니다.
				 */
				out.write(buffer, 0, readLen); //버퍼에 저장된 데이터를 0부터 시작해서 readLen까지
				copyByte += readLen;
			}
			
			if(in!=null) in.close();
			if(out!=null) out.close();
			
			System.out.println("복사된 파일크기:" + copyByte + "byte");
			System.out.println("복사된 파일크기:" + (copyByte/1024) + "Kbyte");
			System.out.println("복사된 파일크기:" + (copyByte/(1024*1024)) + "Mbyte");
		}
		catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch (IOException e) {
			System.out.println("IO작업중 예외가 발생되었습니다.");
		}
		catch (Exception e) {
			System.out.println("알수없는 예외가 발생되었습니다.");
		}
	}

}
