package bookstore_lsw;

import java.util.ArrayList;
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
    	List<String> reviewData = DBUtil.read("review");
    	List<Review> reviews = new ArrayList();
    	for(String data : reviewData) {
    		String[] fields = data.split(",");
    		Review review = new Review(
    		Integer.parseInt(fields[0]),
    		Integer.parseInt(fields[1]),
    		Integer.parseInt(fields[2]),
    		Integer.parseInt(fields[3]),
    		fields[4],
    		fields[5]
    		);
    		if(review.getBookIndex() == bookIndex) {
    			reviews.add(review);
    		}
    	}
    	return reviews;
    	/*
    	 * 모든 리뷰를 불러와서 List 로 변환 후
    	 * 가져온 bookIndex 와 동일한 내용의 리뷰만 반환함
    	 */
    }
    
    public static void addReview(int bookIndex, int accountIndex, int starPoint, String nick, String comment) {
    	List<String> reviews = DBUtil.read("review");
    	int index = reviews.size();
    	String newReviewData = index + "," + bookIndex + "," + accountIndex + "," + starPoint + "," + nick + "," + comment;
    	DBUtil.create("review", newReviewData);
    	/*
    	 * 리뷰 정보를 가져와서 추가하는 기능
    	 * Main 에서 리뷰 작성 기능을 추가하지 않았기 때문에
    	 * 구현하지 않아도 무방함
    	 * 형식상 존재하는 함수
    	 */
    }
    
    public static void deleteReview(int index) {
    	DBUtil.delete("review", index);
    }
}
