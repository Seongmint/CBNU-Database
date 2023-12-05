import java.util.Scanner;
import java.util.*;
import java.sql.*; 
public class Insert
{
	
	public static void excute()
	{ 
		
			
			Scanner sc = new Scanner(System.in); // Scanner 객체 생성
			
			while(true) {
				System.out.println();
				System.out.println("1.program 2.program_date 3.customer 4.priority_order 5.score 6.takes 7.teacher 8.뒤로가기");
				System.out.print("삽입하고싶은 테이블 번호를 선택하세요 : ");
			
				String str = sc.next();
			
				switch(str) {
				case "1":
					System.out.println("program 테이블입니다.");
					Insert_program insert_program = new Insert_program();
					insert_program.excute();
					break;
				case "2":
					System.out.println("program_date 테이블입니다.");
					Insert_program_date insert_program_date = new Insert_program_date();
					insert_program_date.excute();
					break;
				case "3":
					System.out.println("customer 테이블입니다.");
					customer customer = new customer();
					customer.excute();
					break;
				case "4":
					System.out.println("priority_order 테이블입니다.");
					priority_order priority_order = new priority_order();
					priority_order.excute();
					break;
				case "5":
					System.out.println("score 테이블입니다.");
					score score = new score();
					score.excute();
					break;
				case "6":
					System.out.println("takes 테이블입니다.");
					takes takes = new takes();
					takes.excute();
					break;
				case "7":
					System.out.println("teacher 테이블입니다.");
					teacher teacher= new teacher();
					teacher.excute();
					break;
				case "8":
					System.out.println("뒤로가기 입니다.");
					Test test = new Test();
					test.main(null);
					break;
					
				
				default:
					System.out.println("잘못 입력하셨습니다.");
					System.out.println();
					break;
				}
			}
		
		
		
	
		}


	}