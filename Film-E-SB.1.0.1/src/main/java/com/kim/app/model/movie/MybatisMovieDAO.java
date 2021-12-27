package com.kim.app.model.movie;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kim.app.model.page.PageVO;

@Mapper
public interface MybatisMovieDAO {
	public ArrayList<MovieVO> selectAllm(PageVO vo);
}
