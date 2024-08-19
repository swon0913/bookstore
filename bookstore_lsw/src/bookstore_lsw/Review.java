package bookstore_lsw;

import java.util.List;

public class Review {
	private int index;
    private int bookIndex;
    private int accountIndex;
    private int starPoint;
    private String nick;
    private String comment;

    public Review(int index, int bookIndex, int accountIndex, int starPoint, String nick, String comment) {
        this.index = index;
        this.bookIndex = bookIndex;
        this.accountIndex = accountIndex;
        this.starPoint = starPoint;
        this.nick = nick;
        this.comment = comment;
    }

    public int getIndex() { return index; }
    public int getBookIndex() { return bookIndex; }
    public int getAccountIndex() { return accountIndex; }
    public int getStarPoint() { return starPoint; }
    public String getNick() { return nick; }
    public String getComment() { return comment; }
    
    public static List<Review> getReviewsByBook(int bookIndex) {
    	/*
    	 * 모든 리뷰를 불러와서 List 로 변환 후
    	 * 가져온 bookIndex 와 동일한 내용의 리뷰만 반환함
    	 */
    	List<Review> null_data = null;
    	return null_data;
    }
    
    public static void addReview(int bookIndex, int accountIndex, int starPoint, String nick, String comment) {
    	/*
    	 * 리뷰 정보를 가져와서 추가하는 기능
    	 * Main 에서 리뷰 작성 기능을 추가하지 않았기 때문에
    	 * 구현하지 않아도 무방함
    	 * 형식상 존재하는 함수
    	 */
    }
    
    public static void deleteReview(int index) {
    	/*
    	 * 관리자가 리뷰를 삭제하는 기능
    	 * 중복 설명 생략
    	 */
    }
}
