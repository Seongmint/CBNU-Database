import java.util.*;
import java.sql.*;
public class teacher{
	public void excute() {
	
		try{ 
			Scanner sc =new Scanner(System.in);			
			System.out.println("t_RRN : ");
			String t_RRN= sc.next();
			System.out.println("t_name : ");
			String t_name = sc.next();
			System.out.println("t_age : ");
			String t_age = sc.next();
			System.out.println("t_phone : ");
			String t_phone = sc.next();
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			String sql ="INSERT INTO teacher VALUES (?, ?,?,?)";
			
			PreparedStatement pstm =null;
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1,t_RRN);
				pstm.setString(2,t_name);
				pstm.setString(3,t_age);
				pstm.setString(4,t_phone);
				
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