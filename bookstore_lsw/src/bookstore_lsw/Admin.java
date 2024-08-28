package bookstore_lsw;

import java.util.List;
import java.util.Scanner;

public class Admin {
	// 도서 관리: 도서 조회, 추가, 수정, 삭제
    public static void manageBooks() {
    	Scanner scanner = new Scanner(System.in);
    	while(true) {
    		System.out.println("\n=== 도서 관리 페이지 ===");
    		System.out.println("1. 도서 목록 보기");
    		System.out.println("2. 도서 추가");
    		System.out.println("3. 도서 수정");
    		System.out.println("4. 도서 삭제");
    		System.out.println("5. 돌아가기");
    		System.out.print("선택: ");
    		int choice = scanner.nextInt();
    		scanner.nextLine();
		
			if (choice == 1) {
				List<Book> books = Book.getBooks();
				for (Book book : books) {
					System.out.println(book.getIndex() + ":" + book.getTitle());
				}
			} else if (choice == 2) { // 제목 저자 출판사 가격 소개
				System.out.println("제목: ");
				String title = scanner.nextLine();
				System.out.println("저자: ");
				String author = scanner.nextLine();
				System.out.println("출판사: ");
				String company = scanner.nextLine();
				System.out.println("가격: ");
				int price = scanner.nextInt();
				scanner.nextLine();
				System.out.println("소개: ");
				String preview = scanner.nextLine();

				Book.addBook(title, author, company, price, preview);
				System.out.println("도서가 추가되었습니다.");

			} else if (choice == 3) {
				System.out.println("수정할 도서의 인덱스: ");
				int index = scanner.nextInt();
				scanner.nextLine();
				System.out.println("제목: ");
				String title = scanner.nextLine();
				System.out.println("저자: ");
				String author = scanner.nextLine();
				System.out.println("출판사: ");
				String company = scanner.nextLine();
				System.out.println("가격: ");
				int price = scanner.nextInt();
				scanner.nextLine();
				System.out.println("소개: ");
				String preview = scanner.nextLine();

				Book.updateBook(index, title, author, company, price, preview);
				System.out.println("도서가 수정되었습니다.");

			} else if (choice == 4) {
				System.out.println("삭제할 도서의 인덱스: ");
				int index = scanner.nextInt();
				scanner.nextLine();
				Book.deleteBook(index);
				System.out.println("도서가 삭제되었습니다.");

			} else if (choice == 5) {
				break; // 돌아가기
			} else {
				System.out.println("잘못된 선택입니다");
			}
    
    	/*
    	 * 1. 도서 목록 보기
    	 * 2. 도서 추가
    	 * 3. 도서 수정
    	 * 4. 도서 삭제
    	 * 5. 돌아가기
    	 * 입력 받으면서 각 기능을 수행할 수 있도록 구현
    	 * switch 문 보다는 if-else 문이 구현이 더 용이함
    	 */
    	}
    	
    }
    
    // 회원 관리: 회원 조회, 수정, 삭제
    public static void manageAccounts() {
    	while(true) {
    		Scanner scanner = new Scanner(System.in);
        	System.out.println("\n=== 회원 관리 페이지 ===");
    		System.out.println("1. 회원 목록 보기");
    		System.out.println("2. 회원 정보 수정");
    		System.out.println("3. 회원 삭제");
    		System.out.println("4. 돌아가기");
    		System.out.print("선택: ");
    		int choice = scanner.nextInt();
    		scanner.nextLine();
    		
    		if(choice==1) {
    			List<Account> accounts = Account.getAllAccounts();
    			for(Account account : accounts) {
					System.out.println(account.getIndex() + " " + account.getId() + " " + account.getName());
    			}
    			
    		}else if(choice==2) {
    			System.out.println("수정할 회원의 인덱스: ");
    			int index = scanner.nextInt();
    			scanner.nextLine();
    			
    			System.out.println("새 이름: ");
    			String newName = scanner.nextLine();
    			System.out.println("새 비밀번호: ");
    			String newPassword = scanner.nextLine();
    			
    			
    			List<Account> accounts = Account.getAllAccounts();
    			if(index >=0 && index < accounts.size()) {
    				Account account = accounts.get(index);
    				account = new Account(index, newName, account.getId(),newPassword);
    				DBUtil.update("account", index, index +" "+newName+" "+account.getId() +" "+newPassword);
    			} else {
    				System.out.println("잘못된 인덱스이비다.");
    			}
    			
    			System.out.println("회원 정보가 수정되었습니다.");
    		}else if(choice==3) {
    			System.out.println("삭제할 회원의 인덱스: ");
    			int index = scanner.nextInt();
    			scanner.nextLine();
    			
    			DBUtil.delete("account", index);
    			System.out.println("회원이 삭제되었습니다.");
    		}else {
    			System.out.println("잘못된 선택입니다.");
    		}
        }
    	/*
    	 * 1. 회원 목록 보기
    	 * 2. 회원 정보 수정
    	 * 3. 회원 삭제
    	 * 4. 돌아가기
    	 * 수정이나 삭제 시에는 무조건 삭제하는 것이 아닌
    	 * 해당 데이터가 존재하는지 확인 후 삭제해야 함
    	 * 조건문을 걸지 않을 경우 이상한 데이터가 삭제됨
    	 */
    }
    
    // 주문 관리: 주문 조회, 수정, 삭제
    public static void manageOrders() {
    	while(true) {
    		Scanner scanner = new Scanner(System.in);
        	System.out.println("\n=== 주문 관리 페이지 ===");
    		System.out.println("1. 주문 목록 보기");
    		System.out.println("2. 주문 정보 수정");
    		System.out.println("3. 주문 삭제");
    		System.out.println("4. 돌아가기");
    		System.out.print("선택: ");
    		
    		int choice = scanner.nextInt();
    		scanner.nextLine();
    		
    		if(choice==1) {
    			List<Order> orders = Order.getAllOrders();
    			
    			for(Order order : orders) {
    				System.out.println(order.getIndex()+" "+order.getAddress());
    			}
    		}
        }
    	/*
    	 * 1. 주문 목록 보기
    	 * 2. 주문 정보 수정
    	 * 3. 주문 삭제
    	 * 4. 돌아가기
    	 */
    	
    }
}
