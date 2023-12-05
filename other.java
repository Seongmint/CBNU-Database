import java.util.*;
import java.sql.*;

public class other{
	public void excute() {
	
		try{ 
			Scanner sc4 = new Scanner(System.in);
			System.out.print("원하는 쿼리를 입력하세요 : ");
			
			String pstmt4 = sc4.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			//사용자로부터 입력받기
			Statement stmt4=con.createStatement(); 
			ResultSet rs4=stmt4.executeQuery(pstmt4); 
			ResultSetMetaData rs4md = rs4.getMetaData();
			
			//칼럼명 가져오기
			int count = rs4md.getColumnCount();
			System.out.println("-----------------------------------------------------");
			for(int i=1; i<=count; i++) {
				System.out.print(" | "+rs4md.getColumnName(i));
			}
			System.out.println();
			System.out.println("-----------------------------------------------------");
			
			//칼럼값 가져오기
			while(rs4.next()) {
				for(int i=1; i<=count; i++) 
					System.out.print(rs4.getObject(i)+"\t");
				System.out.println();
				
			}
				
			
			con.close(); 
			}catch(Exception e){ System.out.println(e);
			System.out.println();
			System.out.print("사유 : " + e.getMessage());}
		
	}
}