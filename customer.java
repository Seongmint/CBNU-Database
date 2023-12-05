import java.util.*;
import java.sql.*;
public class customer{
	public void excute() {
	
		try{ 
			Scanner sc =new Scanner(System.in);			
			System.out.println("회원_no : ");
			String customer_no = sc.next();
			System.out.println("회원_name : ");
			String customer_name = sc.next();
			System.out.println("회원_age:");
			String customer_age = sc.next();
			System.out.println("회원_phone:");
			String customer_phone = sc.next();
			System.out.println("납부여부:");
			String pay = sc.next();
			System.out.println("등급:");
			String grade = sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			String sql ="INSERT INTO customer VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstm =null;
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1,customer_no);
				pstm.setString(2,customer_name);
				pstm.setString(3,customer_age);
				pstm.setString(4,customer_phone);
				pstm.setString(5,pay);
				pstm.setString(6,grade);
				
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