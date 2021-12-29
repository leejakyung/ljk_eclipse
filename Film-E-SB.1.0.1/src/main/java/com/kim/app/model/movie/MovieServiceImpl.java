package com.kim.app.model.movie;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.model.page.PageVO;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService{
	

	HashMap<String, String> mpkMap = new HashMap<String, String>(){{
		   put("액션", "AC");
		   put("애니메이션", "AN");
		   put("멜로/로맨스", "RO");
		   put("드라마", "DR");
		   put("다큐멘터리", "DC");
	}};
	

	@Autowired
	private MybatisMovieDAO movieDAO;
	
	ArrayList<MovieVO> datas=null;
	MovieVO data = null;
	
	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo) {
		datas = movieDAO.selectAllm(vo);
		for(int i=0;i < datas.size(); i++) { // 어레이리스트의 갯수 만큼 돌리겠다
			if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());				
			}
		}
		
		return datas;
	}

	public ArrayList<MovieVO> m_selectDB_all(PageVO vo) {
		datas= movieDAO.selectAll(vo);
		for(int i=0;i < datas.size(); i++) { // 어레이리스트의 갯수 만큼 돌리겠다
			if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());				
			}
		}
		return datas;
	}

	public MovieVO m_selectDB_rand() {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieVO m_selectDB_one(MovieVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean m_insertDB(MovieMultiVO vo) {
		
		String mpkStr = null;   //   mpk 받
		String mpkType = null;   //  'AC'1001  mpk 앞에 들어갈 글자 
		
		int mpkInt = 0;  
		int max = 0;
		boolean isNew = true;
		
		datas = movieDAO.mpk();
		
		for(int i = 0; i< datas.size(); i++) {
			mpkStr = datas.get(i).getMpk().substring(2);
			mpkInt = Integer.parseInt(mpkStr);            //인트로 변환
			if(mpkInt > max){
				max = mpkInt;
			}                              //1 증가
			isNew = false; 		
		}
		
		if(isNew) {            //rs 가 null 일경우
			mpkInt = 1001;         //mpk를 1001로 저장
		}

		if(mpkMap.containsKey(vo.getMtype())) {
			mpkType = mpkMap.get(vo.getMtype());
		}else {
			mpkType = "EX";
			vo.setMtype("ETC");
		}

		max++;         
		mpkStr = mpkType + max;                     // AC + 1001
		vo.setMpk(mpkStr);      
		
		return movieDAO.insert(vo)>0;
	}

	public Boolean m_updateDB(MovieMultiVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean m_deleteDB(MovieMultiVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
 