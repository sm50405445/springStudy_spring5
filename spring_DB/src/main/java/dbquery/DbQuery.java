package dbquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DbQuery {

	private DataSource dataSource;
	
	public DbQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int count() throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			int result = 0;
			conn = dataSource.getConnection();
			
			String query = "select count(*) from Member";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		}catch(SQLException e) {
			throw new RuntimeException();
		}finally {
			if(conn!=null)
				conn.close();//풀에 반환
			if(rs!=null)
				rs.close();
			if(pstm!=null)
				pstm.close();
				
		}
	}
}
