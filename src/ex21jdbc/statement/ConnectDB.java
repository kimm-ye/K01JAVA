package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//객체생성이 목적이 아닌 상속의 목적으로 정의한 추상클래스
public abstract class ConnectDB {
	
	/*
	멤버변수 : 상속받은 하위클래스에서 접근을 허용하기 위해
		접근지정자는 protected로 선언함.
	 */
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	
	//생성자1 : 인지가 없는 기본 생성자
	public ConnectDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kosmo","1234");
			System.out.println("오라클 DB 연결성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알수없는 예외발생");
		}
	}
	
	//생성자2 : 인자가 있는 생성자
	public ConnectDB(String id, String pw) {
			try {
				Class.forName("oracle.jdbc.OracleDriver"); 
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pw);
				System.out.println("오라클 DB 연결성공");
			}
			catch (ClassNotFoundException e) {
				System.out.println("오라클 드라이버 로딩 실패");
				e.printStackTrace();
			}
			catch (SQLException e) {
				System.out.println("DB 연결 실패");
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("알수없는 예외발생");
			}
		}
	
	//상속을 해야해서 public으로 가야함
	public void close() { 
		try {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			if(rs != null) rs.close();
			
			System.out.println("DB자원반납완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}//end of close
	/*
	상속관계에서 오버라이딩을 목적으로 생성한 추상메서드
	하위 클래스에서 각 목적에 따라 재정의한다.
	 */
	abstract void execute();
}
