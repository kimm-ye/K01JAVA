package ex21jdbc.shopping;

import java.util.InputMismatchException;
import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class EditDelShop2 extends IConnectImpl{

	public EditDelShop2() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		
		Scanner scanner = new Scanner(System.in);

		while(true) {
			try {
				System.out.print("수정은 1번, 삭제는 2번을 눌러주세요 : ");
				int choice = scanner.nextInt();
				if(choice == 1) {
					String sql = "UPDATE sh_goods SET goods_name=?, goods_price=?, p_code=? "
						+ "	WHERE g_idx=?";
				
					psmt = con.prepareStatement(sql);
					psmt.setString(4, scanValue("수정할 상품일련번호"));
					psmt.setString(1, scanValue("상품명"));
					psmt.setString(2, scanValue("가격"));
					psmt.setString(3, scanValue("상품코드"));
					
					int affected = psmt.executeUpdate();
					System.out.println(affected + "행이 업데이트 되었습니다.");
				}
				else if(choice ==2) {
					String sql = "DELETE FROM sh_goods WHERE g_idx=? ";
					psmt = con.prepareStatement(sql);
					psmt.setString(1, scanValue("삭제할 상품일련번호"));
					System.out.println(psmt.executeUpdate() + "행이 삭제 되었습니다.");
				}
				else {
					System.out.println("1(수정)과 2(삭제)만 입력해주세요");
				}
			}	
			catch (Exception e) {
				e.printStackTrace();
			}
			while(true) {
				try {
					System.out.print("계속하시려면 1번, 종료는 2번을 눌러주세요 : ");
					int exitCode = scanner.nextInt();
					if(exitCode==2) {
						break;
					}
					else {
						System.out.println("똑바로 입력하세요");
					}
				}
				catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("문자는 안댐");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new EditDelShop2().execute();
	}
}
