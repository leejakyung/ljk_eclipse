package model.member2;

import java.util.List;

public interface Member2Service {
	void insertMem(Member2VO vo);
	/*void updateinsertMem(Member2VO vo);
	void deleteMem(Member2VO vo);
	List<Member2VO> getMemList(Member2VO vo);*/
	List<Member2VO> getMem(Member2VO vo);
}
