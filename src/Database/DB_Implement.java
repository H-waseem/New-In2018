package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DB_Implement implements I_DB_Connect {

	/**
	 *
	 * @param sql
	 * @return
	 */
	public Connection connect(String sql) {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	public int write(String sql, Connection conn) {
		// TODO - implement DB_Implement.write
		throw new UnsupportedOperationException();
	}

	/**
	 *  @param sql
	 * @param conn
	 * @return
	 */
	public ResultSet read(String sql, Connection conn) {
		// TODO - implement DB_Implement.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	public void closeConn(String sql, Connection conn) {
		// TODO - implement DB_Implement.closeConn
		throw new UnsupportedOperationException();
	}

	public DB_Implement() {
		// TODO - implement DB_Implement.DB_Implement
		throw new UnsupportedOperationException();
	}

}