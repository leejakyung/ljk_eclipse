package model;

import java.util.ArrayList;

public interface DAO {
	void insert(Object obj);
	void update(Object obj);
	void delete(Object obj);
	Object select(Object obj);
	ArrayList selectList(Object obj);
}
