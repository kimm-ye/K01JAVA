package ex21jdbc.shopping;

import java.sql.Statement;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl {

	public SelectShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			Statement stmt = con.createStatement();
			
			String searchStr = scanValue("검색할상품명");
			
			String sql = "SELECT g_idx, goods_name, "
			+ " to_char(goods_price,'9,999,000'), "
			+ " regidate, p_code"
			+ " FROM sh_goods WHERE goods_name LIKE '%" + searchStr +"%' "
			+ "	ORDER BY g_idx DESC ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int g_idx = rs.getInt(1);
				String goods_name = rs.getString(2);
				String goods_price = rs.getString(3);
				String regidate = rs.getString(4);
				int p_code = rs.getInt(5);
				System.out.printf("%d %s %s %s %d ", g_idx, goods_name, goods_price,regidate,p_code );
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new SelectShop().execute();
	}

}
