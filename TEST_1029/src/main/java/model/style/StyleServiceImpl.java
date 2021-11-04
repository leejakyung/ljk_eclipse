package model.style;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("StyleService")
public class StyleServiceImpl implements StyleService{
	
	@Autowired
	private SpringStyleDAO styleDAO;

	@Override
	public List<StyleVO> getStyleList(StyleVO vo,int scnt) {
		return styleDAO.getStyleList(vo, scnt);
	}

	@Override
	public boolean st_insert(StyleVO vo) {
		return styleDAO.st_insert(vo);
	}

	@Override
	public boolean st_delete(StyleVO vo) {
		return styleDAO.st_delete(vo);
	}

}
