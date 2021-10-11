package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}

}


// 1. extends 상속 받아서 구현
// 2. jdbcTemplate<bean>등록, 의존성주입 받아 사용
@Repository()
public class SpringBoardDAO {  
	// 끝이 서포트로 끝나면 뭔가 스프링에서 이미 구현한걸 이곳에서 쓰려고 상속받았구나라고 생각할 것!


/*	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;*/
	
	

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="select * from board where id=?";
	private final String getBoardListSQL="select * from board order by id desc";

/*	@Autowired  // <<<< !!
	public void setSuperDateSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}*/

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
		// 데이터소스를 가지고 접근함
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("jdbcTemplate으로 getBoardList");
		return jdbcTemplate.query(getBoardListSQL,new BoardRowMapper());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 getBoard");
		Object[] args= { vo.getId() };
		return jdbcTemplate.queryForObject(getBoardSQL,args,new BoardRowMapper());
	}



/*	public void insertBoard(BoardVO vo) {
		System.out.println("dao로 insert");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("dao로 update");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("dao로 delete");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("dao로 getList");
		List<BoardVO> datas=new ArrayList<BoardVO>();
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBoardListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt,rs);
		}
		return datas;
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("dao로 get");
		BoardVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
 */


}
