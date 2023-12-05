/*
 * 쿼리문 마다 다른 메소드
    1.executeQuery()
      -ResultSet 반환
	  -SELECT 에서 사용

	2.executeUpdate()
	  -해당되는 레코드의 개수를 int 값으로 반환
	  -CREATE, DROP, ALTER, INSERT, UPDATE, DELETE 에서 사용

	3.execute()
	  -executeQuery, executeUpdate 둘 다 가능
	  -boolean 값 반환
 * 
 * */



import java.util.Scanner;
import java.util.*;
import java.sql.*; 
public class Test 
{
	
	public static void main(String args[])
	{ 
		
			
			Scanner sc = new Scanner(System.in); // Scanner 객체 생성
			
			while(true) {
				System.out.println();
				System.out.println("1.삽입 2.삭제 3.검색");
				System.out.print("원하는 번호를 선택하세요 : ");
			
				String str = sc.next();
			
				switch(str) {
				case "1":
					System.out.println("삽입입니다.");
					Insert insert = new Insert();
					Insert.excute();
					break;
				case "2":
					System.out.println("삭제입니다.");
					Delete delete = new Delete();
					delete.excute();
					break;
				case "3":
					System.out.println("검색입니다.");
					Search search = new Search();
					search.excute();
					break;
				case "4":
					System.out.println("이외의 쿼리");
					other other = new other();
					other.excute();
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					System.out.println();
					break;
				}
			}
	
		}
	}