package com.kim.app.model.movie;

import java.util.ArrayList;

import com.kim.app.model.page.PageVO;


public interface MovieService {
	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo); 
}
