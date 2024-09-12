package bookstore_lsw;

import java.util.*;

public class Account {
	
	private int index;
    private String name;
	private String id;
	private String password;

	public Account(int index, String name, String id, String password) {
		this.index = index;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	// 회원 가입 함수
	public static Account signUp() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();

		System.out.print("ID를 입력하세요: ");
		String id = scanner.nextLine();

		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		
		int nextIndex= getNextAccountIndex();
		
		Account newAccount = new Account(nextIndex, name, id, password);
		addAccount(newAccount);
		/*
		 * 사용자의 이름, ID, PW를 Scanner 로 입력 받음 기존 데이터 다음 인덱스를 가져옴 회원 정보를 저장함 (다음 인덱스, 이름,
		 * ID, PW) 저장된 정보를 addAccount 로 보냄 (DB 추가용) 추가된 회원의 정보를 반환
		 */
		return newAccount;
	}

	// 로그인 함수
	public static Account login() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("ID를 입력하세요: ");
		String id = scanner.nextLine();

		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		
		Account LoginAccount =authenticate(id,password);
		return LoginAccount;
		/*
		 * 사용자의 ID, PW를 Scanner 로 입력 받음 아래 authenticate() 함수를 호출하여 회원정보가 일치하는지 확인 회원 정보가
		 * 존재하는 경우, 해당 유저의 데이터를 반환함 없는 경우 null 반환
		 */
	}

	// 로그인 인증
	private static Account authenticate(String id, String password) {
		List<Account> accounts = getAllAccounts();
		
		for(Account account : accounts) {
			if(account.getId().equals(id)&& account.getPassword().equals(password)) {
				return account;
			}
		}
		return null;
		/*
		 * getAllAccounts() 함수를 호출하여 모든 사용자의 데이터를 가져옴 for-each 문으로 가져온 정보와 맞는지 확인함 맞는 경우
		 * 해당 데이터(for-each 요소)를 반환함 없는 경우 null 반환
		 */
	}

	// 관리자용 : 모든 회원 정보 반환
	public static List<Account> getAllAccounts() {
		List<String> accountAllData = DBUtil.read("account");
		List<Account> accounts = new ArrayList<>();
		
		for(String data : accountAllData) {
			String[] fields = data.split(",");
			int index = Integer.parseInt(fields[0]);
			String name = fields[1];
			String id = fields[2];
			String password = fields[3];
			accounts.add(new Account(index, name,id,password));
		}
		/*
		 * 모든 회원 정보를 리스트에 담아서 반환
		 */
		return accounts;
	}
	// 회원가입용 : 가장 마지막 회원 번호 +1 반환
	private static int getNextAccountIndex() {
		List<String> existingAccount = DBUtil.read("account");
		int nextIndex = existingAccount.size();
		
		return nextIndex;
		/*
		 * DB 에서 가져온 데이터의 size 를 반환하여 인덱스를 넘김 인덱스는 0번부터 시작하기 때문에 size 만 반환하면 자동으로 마지막
		 * 회원번호 +1 이 됨
		 */
	}

	// 가입한 회원 정보 추가
	private static void addAccount(Account account) {
    	String accountData = account.getIndex() +"," +account.getName() +"," + account.getId() + "," + account.getPassword();
    	DBUtil.create("account", accountData);
    	/*
    	 * 위 signUp 함수를 통해 생성된 데이터를 가져와서
    	 * DBUtil 에 있는 create 함수를 호출하여 DB에 저장함
    	 * 단, 저장 시 Account 클래스가 아닌 String 형으로 형변환을 해야 함
    	 */
    } 
	// 사용자 도서 목록 보기 및 선택 후 주문 기능
	public void browseAndOrder() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			List<Book> bookdata = Book.getBooks();
			System.out.println("\n=== 도서 목록 ===");
			for(Book book : bookdata) {
				System.out.println(book.getIndex() +": " + book.getTitle() + "by" + book.getAuthor()+" - "+ book.getPrice()+"원");
			}
			System.out.println("도서 상세 보기 또는 주문하려면 도서 인덱스를 입력하세요. (종료하려면 -1 입력)");
			int bookIndex = scanner.nextInt();
			scanner.nextLine();
			
			if(bookIndex == -1) {
				break; // 종료
			} else if(bookIndex >=0 && bookIndex < bookdata.size()) {
				Book selectedBook = bookdata.get(bookIndex);
				System.out.println("\n=== 도서 정보 ===");
				System.out.println("제목: " + selectedBook.getTitle());
				System.out.println("저자: " + selectedBook.getAuthor());
				System.out.println("출판사: " + selectedBook.getCompany());
				System.out.println("가격: " + selectedBook.getPrice() +"원");
				System.out.println("소개: " + selectedBook.getPreview());
			
				System.out.println("\n=== 리뷰 ===");
				List<Review> reviews = Review.getReviewsByBook(bookIndex);
				for(Review review : reviews) {
					System.out.println("작성자: " + review.getNick() +"\n별점: " + review.getStarPoint());
					System.out.println("내용: "+ review.getComment());
				}
				
				System.out.println("\n이 도서를 주문하시겠습니까? (y/n)");
				String orderChoice = scanner.nextLine();
				if(orderChoice.equals("y")) {
					System.out.print("수량: ");
					int amount = scanner.nextInt();
					scanner.nextLine();
					System.out.print("배송지: ");
					String address = scanner.nextLine();
					int totalPrice = selectedBook.getPrice() * amount;
					
					//주문 저장
					Order newOrder = new Order(Order.getNextOrderIndex(), selectedBook.getIndex(), this.index, amount,
							totalPrice, address);
					Order.addOrder(newOrder);
					System.out.println("주문이 완료되었습니다.");
				}else {
					System.out.println("잘못된 인덱스입니다.");
				}
			}
			
		}
		/*
		 * 도서 목록을 불러와 모든 도서 정보를 나열함 입력을 통해 해당 책의 인덱스 번호를 입력받으면 상세 정보를 출력하고 주문 여부를 물어봄,
		 * 주문 시 수량과 주소를 입력받아 order 로 보냄 반복해서 구매할 수 있도록 전체 while 문 활용
		 */
	}
	
}