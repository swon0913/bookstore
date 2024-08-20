package bookstore_lsw;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * ! 프로그램 개발 전 필독 !
		 * 개발이 어렵긴 하지만 본인이 안하면 결국 손해보는 것은 본인임
		 * 결국 하다보면 기능을 구현할 수 있음
		 * 어렵거나 모르겠는 부분은 계속 고민해보거나
		 * 어렵다고 생각하는 부분은 하나씩 나눠서 해보는 것을 추천함
		 * 아마 어렵다고 느끼는 가장 큰 원인이
		 * 데이터가 전달되는 방식에 대한 이해가 부족할 가능성이 큼
		 * 그 능력을 기른다는 생각으로 해줬으면 좋겠음
		 * 최대한 도움을 주겠지만 결국 해내는 것은 본인이라는 것을 잊지 마셈
		 */
		
		while (true) {
			
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 관리자 로그인");
			System.out.println("4. 종료");
			/*
			 * 1. 회원가입
			 * 2. 로그인
			 * 3. 관리자 로그인
			 * 4. 종료
			 */
			int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
			
			if (choice == 1) {
				Account newAccount = Account.signUp();
				if(newAccount != null) {
					System.out.println("회원가입이 완료되었습니다.");
				}else {
					System.out.println("회원가입에 실패했습니다.");
				}
				/*
				 * 회원 클래스 불러오기 Account newAccount
				 * Account -> signUp() 함수 불러오기
				 * if (회원가입 시) { 로그인 이동 알림 }
				 */
			}
			else if (choice == 2) {
				Account account = Account.login();
				if(account != null) {
					System.out.println("로그인 성공");
					account.browseAndOrder();
				}else {
					System.out.println("로그인 실패 ID또는 패스워드가 잘못 되었습니다.");
				}
				/*
				 * 회원 클래스 불러오기 Account account
				 * Account -> login() 함수 불러오기
				 * if (로그인 시) {
				 * 	로그인 성공 알림
				 *	account -> browseAndOrder() 함수 호출
				 * } else { 로그인 실패 알림 }
				 */
			}
			else if (choice == 3) {
				/*
				 * 관리자 로그인
				 */
				System.out.print("관리자 ID: ");
                String adminId = scanner.nextLine();
                System.out.print("비밀번호: ");
                String adminPassword = scanner.nextLine();
                
                String admin_id = "admin";
                String admin_pw = "admin";
                
                if (adminId.equals(admin_id) && adminPassword.equals(admin_pw)) {
                	/*
                	 * 관리자 로그인 성공 시
                	 */
                	while (true) {
                		System.out.println("1. 도서 관리");
                		System.out.println("2. 회원 관리");
                		System.out.println("3. 주문 관리");
                		System.out.println("4. 로그아웃");
                		/*
                		 * 1. 도서 관리
                		 * 2. 회원 관리
                		 * 3. 주문 관리
                		 * 4. 로그아웃
                		 */
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (adminChoice == 1) {
                        	Admin.manageBooks();
                        	/*
                        	 * Admin -> manageBooks() 호출
                        	 */
                        } else if (adminChoice == 2) {
                        	Admin.manageAccounts();
                        	/*
                        	 * Admin -> manageAccounts() 호출
                        	 */
                        } else if (adminChoice == 3) {
                        	Admin.manageOrders();
                        	/*
                        	 * Admin -> manageOrders() 호출
                        	 */
                        } else if (adminChoice == 4) {
                            break; // 로그아웃
                        } else {
                            System.out.println("잘못된 선택입니다.");
                        }
                    }
                }
                else {
                    System.out.println("관리자 로그인 실패.");
                }
				
			}
			else if (choice == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
        scanner.close();
	}

}
