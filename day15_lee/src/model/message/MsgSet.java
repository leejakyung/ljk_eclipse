package model.message;

import java.util.ArrayList;

public class MsgSet {
	private MessageVO m; // 게시글 1개 
	private ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>(); // 댓글 여러개  -> 1:n 관계
	public MessageVO getM() {
		return m;
	}
	public void setM(MessageVO m) {
		this.m = m;
	}
	public ArrayList<ReplyVO> getRlist() {
		return rlist;
	}
	public void setRlist(ArrayList<ReplyVO> rlist) {
		this.rlist = rlist;
	}
	@Override
	public String toString() {
		return "MsgSet [m=" + m + ", rlist=" + rlist + "]";
	}
}
