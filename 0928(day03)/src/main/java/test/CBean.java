package test;

import java.util.List;
import java.util.Map;

public class CBean { // 컬렉션빈 실습
	
	//private List<String> list; //컬렉션 친구들은 제네릭을 같이 쓰는 경우가 많음!
	// 컬렉션을 썼는데 제네릭이 없이 쓰고 있다면 이론만 설명할 가능성이 높음 
	// 제네릭을 안썼다면 경계할 것!

	private Map<String,String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	/*public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	*/
}
