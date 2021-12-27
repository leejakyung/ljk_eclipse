package com.kim.app.model.movie;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.model.page.PageVO;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MybatisMovieDAO movieDAO;
	
	ArrayList<MovieVO> datas=null;
	
	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo) {
		datas = movieDAO.selectAllm(vo);
		for(int i=0;i < datas.size(); i++) { // 어레이리스트의 갯수 만큼 돌리겠다
			if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());				
			}
		}
		
		return datas;
	}

}
 