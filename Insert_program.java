import java.util.*;
import java.sql.*;
public class Insert_program{
	public void excute() {
	
		try{ 
			Scanner sc =new Scanner(System.in);			
			System.out.println("프로그램_no : ");
			String program_no = sc.next();
			System.out.println("프로그램_name : ");
			String program_name = sc.next();
			System.out.println("price:");
			String price = sc.next();
			System.out.println("start_date:");
			String start = sc.next();
			System.out.println("time:");
			String time = sc.next();
			System.out.println("t_RRN:");
			String t_RRN = sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			String sql ="INSERT INTO program VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstm =null;
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1,program_no);
				pstm.setString(2,program_name);
				pstm.setString(3,price);
				pstm.setString(4,start);
				pstm.setString(5,time);
				pstm.setString(6,t_RRN);
				
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