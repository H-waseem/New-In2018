package Database;

import java.sql.Connection;
import java.sql.ResultSet;

public interface I_DB_Connect {

	/**
	 *
	 * @param sql
	 * @return
	 */
	abstract Connection connect(String sql);

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	abstract int write(String sql, Connection conn);

	/**
	 *  @param sql
	 * @param conn
	 * @return
	 */
	abstract ResultSet read(String sql, Connection conn);

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	abstract void closeConn(String sql, Connection conn);

}