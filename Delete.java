import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Delete{
	public void excute() {
		try{
			Scanner sc2 = new Scanner(System.in);
			System.out.print("원하는 쿼리를 입력하세요: ");
			String pstmt2 =sc2.nextLine(); //String형 입력 및 반환 (개행을 기준으로 한 줄을 읽음)
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			//사용자로부터 입력받기
			Statement stmt2=con.createStatement(); 
			int rs2=stmt2.executeUpdate(pstmt2); 
			
		
			PreparedStatement pstm2 = null;
			
			try {
				if(rs2>0) {
					System.out.println("삭제 실패");
					
				}else {
					System.out.println("삭제 성공");
				}
			}catch (Exception e) {
                System.out.println(e);
            } finally {
            	if (pstm2 != null) {
                    pstm2.close();
                }
                
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println();
			System.out.print("사유 : " + e.getMessage());
        }
    }
}