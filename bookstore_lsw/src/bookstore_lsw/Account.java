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
    
    public int getIndex() { return index; }
    public String getName() { return name; }
    public String getId() { return id; }
    public String getPassword() { return password; }
    
    // 회원 가입 함수
    public static Account signUp() {
    	 Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.print("이름을 입력하세요: ");
    	    String name = scanner.nextLine();
    	    
    	    System.out.print("ID를 입력하세요: ");
    	    String id = scanner.nextLine();
    	    
    	    System.out.print("비밀번호를 입력하세요: ");
    	    String password = scanner.nextLine();
    	/*
    	 * 사용자의 이름, ID, PW를 Scanner 로 입력 받음
    	 * 기존 데이터 다음 인덱스를 가져옴
    	 * 회원 정보를 저장함 (다음 인덱스, 이름, ID, PW)
    	 * 저장된 정보를 addAccount 로 보냄 (DB 추가용)
    	 * 추가된 회원의 정보를 반환
    	 */
    	Account null_data = null;
    	return null_data;
    }
    
    // 로그인 함수
    public static Account login() {
    	/*
    	 * 사용자의 ID, PW를 Scanner 로 입력 받음
    	 * 아래 authenticate() 함수를 호출하여 회원정보가 일치하는지 확인
    	 * 회원 정보가 존재하는 경우, 해당 유저의 데이터를 반환함
    	 * 없는 경우 null 반환
    	 */
    	Account null_data = null;
    	return null_data;
    }
    
    // 로그인 인증
    private static Account authenticate(String id, String password) {
    	/*
    	 * getAllAccounts() 함수를 호출하여 모든 사용자의 데이터를 가져옴
    	 * for-each 문으로 가져온 정보와 맞는지 확인함
    	 * 맞는 경우 해당 데이터(for-each 요소)를 반환함 
    	 * 없는 경우 null 반환
    	 */
    	Account null_data = null;
    	return null_data;
    }
    
    // 관리자용 : 모든 회원 정보 반환
    public static List<Account> getAllAccounts() {
    	/*
    	 * 모든 회원 정보를 리스트에 담아서 반환
    	 */
    	List<Account> null_data = null;
    	return null_data;
    }
    
    // 회원가입용 : 가장 마지막 회원 번호 +1 반환
    private static int getNextAccountIndex() {
    	/*
    	 * DB 에서 가져온 데이터의 size 를 반환하여 인덱스를 넘김
    	 * 인덱스는 0번부터 시작하기 때문에 size 만 반환하면 자동으로 마지막 회원번호 +1 이 됨
    	 */
    	int null_data = 0;
    	return null_data;
    }
    
    // 가입한 회원 정보 추가
    private static void addAccount(Account account) {
    	/*
    	 * 위 signUp 함수를 통해 생성된 데이터를 가져와서
    	 * DBUtil 에 있는 create 함수를 호출하여 DB에 저장함
    	 * 단, 저장 시 Account 클래스가 아닌 String 형으로 형변환을 해야 함
    	 */
    	
    }
    
    // 사용자 도서 목록 보기 및 선택 후 주문 기능
    public void browseAndOrder() {
    	/*
    	 * 도서 목록을 불러와 모든 도서 정보를 나열함
    	 * 입력을 통해 해당 책의 인덱스 번호를 입력받으면 상세 정보를 출력하고
    	 * 주문 여부를 물어봄, 주문 시 수량과 주소를 입력받아
    	 * order 로 보냄
    	 * 반복해서 구매할 수 있도록 전체 while 문 활용
    	 */
    }
    

}
