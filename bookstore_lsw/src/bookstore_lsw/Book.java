package bookstore_lsw;

import java.util.List;

public class Book {
	private int index;
    private String title;
    private String author;
    private String company;
    private int price;
    private String preview;

    public Book(int index, String title, String author, String company, int price, String preview) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.company = company;
        this.price = price;
        this.preview = preview;
    }
    
    public int getIndex() { return index; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCompany() { return company; }
    public int getPrice() { return price; }
    public String getPreview() { return preview; }
    
    public static List<Book> getBooks() {
    	List<Book> null_data = null;
    	return null_data;
    }
    
    public static Book getBookDetails(int bookIndex) {
    	/*
    	 * DB에 저장된 모든 책의 정보를 가져온 뒤,
    	 * DB 데이터의 인덱스와 전달받은 인덱스가 같은지 확인 후
    	 * 동일한 인덱스가 있으면 그 데이터를 DB에서 가져와 반환
    	 */
    	Book null_data = null;
    	return null_data;
    }
    
    public static void addBook(String title, String author, String company, int price, String preview) {
    	/*
    	 * DB에서 Book 의 정보를 가져온 후 size() 함수를 호출하여 다음 인덱스 지정
    	 * 받은 데이터와 String 형으로 조합한 후 create
    	 */
    }
    
    public static void updateBook(int index, String title, String author, String company, int price, String preview) {
    	/*
    	 * Account 의 update 와 동일한 형식
    	 */
    }
    
    public static void deleteBook(int index) {
    	/*
    	 * Account 의 delete 와 동일한 형식
    	 */
    }
}
