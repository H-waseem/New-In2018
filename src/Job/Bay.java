package Job;

import Database.*;

public class Bay {

	private int bayNo;
	private boolean status;
	private boolean type;
	SQL_BayHelper sql_helper;

	public boolean isAvailable() {
		// TODO - implement Bay.isAvailable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bayNo
	 */
	public boolean reserve(int bayNo) {
		// TODO - implement Bay.reserve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bayNo
	 */
	public boolean release(int bayNo) {
		// TODO - implement Bay.release
		throw new UnsupportedOperationException();
	}

	public int getBayNo() {
		return this.bayNo;
	}

	/**
	 * 
	 * @param bayNo
	 */
	public void setBayNo(int bayNo) {
		this.bayNo = bayNo;
	}

	public boolean getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(boolean type) {
		this.type = type;
	}

}