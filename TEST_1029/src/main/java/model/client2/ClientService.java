package model.client2;

public interface ClientService {
	boolean insert(Client2VO vo);
	boolean update(Client2VO vo);
	boolean delete(Client2VO vo);
	/*boolean checkID(String userID);
	boolean checkEmail(String email);
	Client2VO SelectOne(Client2VO vo);
	boolean UpdatePW(Client2VO vo) ;*/
	Client2VO login(Client2VO vo);
}
