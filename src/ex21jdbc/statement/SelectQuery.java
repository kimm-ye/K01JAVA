package ex21jdbc.statement;

import java.sql.SQLException;

/*
ResultSet 클래스
	: select문 실패시 쿼리의 실행결과가 ResultSet 객체에 저장되다.
	결과로 반환된 레코드의 처음부터 마지막까지 next()메서드를 통해
	확인 후 반복 추출한다.
	-getXXX() 계열의 메서드
	오라클의 자료형이
		 number타입 : getInt()
		 char/varchar2타입 : getString() => 오라클 자료형에 상관없이
		 									모든 타입을 추출할 수 있다.
		 date타입 : getDate()
	 -인자는 select절의 순서대로 인덱스(1부터시작)를 사용하거나,
	 컬럼명을 사용할 수 있다.
 */
public class SelectQuery extends ConnectDB {

	public SelectQuery() {
		super();
	}
	
	@Override
	void execute() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT id, pass, name, regidate, "
					+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1 "
					+ " FROM member";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1); //id컬럼
				String pw = rs.getString("pass"); //컬럼명을 명시하는게 좀 더 명시적이고 순서에 따른 데이터 오기재를 방지할 수 있다.
				String name = rs.getString("name");
				
				/*
				오라클의 date타입을 getDate()로 추출하면 0000-00-00
				형태론 출력된다.
				이경우 date형 자료가 되므로 java.sql.Date클래스의 참조변수로
				저장해야 한다.
				 */
				java.sql.Date regidate = rs.getDate("regidate");
				
				/*
				오라클의 date타입을 getString()으로 추출하면
				000-00-00 00:00:00 형태로 시간까지 출력할 수 있다.
				만약 적당한 크기로 자르고 싶다면 substring()을 사용한다.
				 */
				String regidate2 = rs.getString("regidate");
				String regidate3 = rs.getString("regidate").substring(0,13);
				
				/*
				쿼리문에 사용한 별칭을 그대로 쓸수있다.
				 */
				String regidate4 = rs.getString("d1");
				
				System.out.printf("%s %s %s %s %s %s %s\n",
						id, pw, name, regidate, 
						regidate2, regidate3, regidate4);
			}
		}
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); //DB자원반납
		}
	}
	
	public static void main(String[] args) {
		SelectQuery selectSQL = new SelectQuery();
		selectSQL.execute();
		
//		new SelectQuery().execute();
	}
}
