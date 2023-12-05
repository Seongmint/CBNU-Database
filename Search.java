import java.util.*;
import java.sql.*;

public class Search{
	public void excute() {
	
		try{ 
			Scanner sc3 = new Scanner(System.in);
			System.out.print("원하는 쿼리를 입력하세요 : ");
			
			String pstmt3 = sc3.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			//사용자로부터 입력받기
			Statement stmt3=con.createStatement(); 
			ResultSet rs3=stmt3.executeQuery(pstmt3); 
			ResultSetMetaData rs3md = rs3.getMetaData();
			
			//칼럼명 가져오기
			int count = rs3md.getColumnCount();
			System.out.println("-----------------------------------------------------");
			for(int i=1; i<=count; i++) {
				System.out.print(" | "+rs3md.getColumnName(i));
			}
			System.out.println();
			System.out.println("-----------------------------------------------------");
			
			//칼럼값 가져오기
			while(rs3.next()) {
				for(int i=1; i<=count; i++) 
					System.out.print(rs3.getObject(i)+"\t\t");
				System.out.println();
				
			}
				
			
			con.close(); 
			}catch(Exception e){ System.out.println(e);
			System.out.println();
			System.out.print("사유 : " + e.getMessage());}
		
	}
}