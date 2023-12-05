import java.util.*;
import java.sql.*;
public class priority_order{
	public void excute() {
	
		try{ 
			Scanner sc =new Scanner(System.in);			
			System.out.println("등급 : ");
			String grade = sc.next();
			System.out.println("우대순위 : ");
			String priority = sc.next();
		
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			String sql ="INSERT INTO priority_order VALUES (?, ?)";
			
			PreparedStatement pstm =null;
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1,grade);
				pstm.setString(2,priority);
				
				int res = pstm.executeUpdate(); //sql문이 수행되었는지 실패했는지 확인하기 위한 변수, res이다. 
				if(res>0) {
					System.out.println("입력 성공");
					
				}else {
					System.out.println("입력 실패");
				}
			}catch (Exception e) {
                System.out.println(e);
            } finally {
            	if (pstm !=null) {
                    pstm.close();
                }
                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}