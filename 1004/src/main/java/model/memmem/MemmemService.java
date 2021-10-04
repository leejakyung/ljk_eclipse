package model.memmem;

import java.util.List;

public interface MemmemService {
	void insertMemmem(MemmemVO vo);
	void updateinsertMemmem(MemmemVO vo);
	void deleteMemmem(MemmemVO vo);
	MemmemVO getMem(MemmemVO vo);
	List<MemmemVO> getMemList(MemmemVO vo);
}
