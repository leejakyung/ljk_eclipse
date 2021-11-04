package model.style;

import java.util.List;

public interface StyleService {
	List<StyleVO> getStyleList(StyleVO vo,int scnt);
	boolean st_insert(StyleVO vo);
	boolean st_delete(StyleVO vo);
}
