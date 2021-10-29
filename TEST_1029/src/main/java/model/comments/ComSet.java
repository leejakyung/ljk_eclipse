package model.comments;

public class ComSet {
	private CommentsVO m; // 게시글 1개 

	public CommentsVO getM() {
		return m;
	}
	public void setM(CommentsVO m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "MsgSet [m=" + m + "]";
	}
	
}
