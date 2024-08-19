package bookstore_lsw;

import java.util.*;

public class Order {
	private int index;
    private int bookIndex;
    private int accountIndex;
    private int amount;
    private int totalPrice;
    private String address;

    public Order(int index, int bookIndex, int accountIndex, int amount, int totalPrice, String address) {
        this.index = index;
        this.bookIndex = bookIndex;
        this.accountIndex = accountIndex;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.address = address;
    }

    public int getIndex() { return index; }
    public int getBookIndex() { return bookIndex; }
    public int getAccountIndex() { return accountIndex; }
    public int getAmount() { return amount; }
    public int getTotalPrice() { return totalPrice; }
    public String getAddress() { return address; }
    
    public static int getNextOrderIndex() {
    	/*
    	 * getNextAccountIndex의 내용과 동일함
    	 * 자료형의 주의하기, getAllOrders 로 가져오면 됨
    	 */
    	int null_data = 0;
    	return null_data;
    }
    
    public static void addOrder(Order order) {
    	/*
    	 * addBook 과 같은 원리
    	 * 중복 설명 생략
    	 */
    }
    
    public static List<Order> getAllOrders() {
    	/*
    	 * DB에서 모든 데이터를 가져오기
    	 * 중복 설명 생략
    	 */
    	List<Order> null_data = null;
    	return null_data;
    }
    
    public static List<Order> getOrders(int accountIndex) {
    	/*
    	 * getAccounts 와 같은 원리
    	 * 구현해도 쓰는 곳이 없어서 구현하지 않아도 됨
    	 * 형식상 존재하는 함수
    	 */
    	List<Order> orders = null;
    	return orders;
    }
    
}
