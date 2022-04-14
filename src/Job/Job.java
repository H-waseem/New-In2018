package Job;

import Payment.*;
import Database.*;

public class Job {

	private int jobNo;
	private String type;
	private String status = "available";
	private I_Payment paymentLink = null;
	private int date;
	private String estimatedTime;
	private String actualTime;
	private String oldDescription;
	private String newDescription;
	private String customerName;
	SQL_JobHelper sql_helper;

	public boolean isConfirmed() {
		// TODO - implement Job.isConfirmed
		throw new UnsupportedOperationException();
	}

	public void confirm() {
		// TODO - implement Job.confirm
		throw new UnsupportedOperationException();
	}

	public void cancel() {
		// TODO - implement Job.cancel
		throw new UnsupportedOperationException();
	}

	public void saveJob() {
		// TODO - implement Job.saveJob
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void makePayment(double amount) {
		// TODO - implement Job.makePayment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 * @param date
	 * @param cardDigits
	 */
	public boolean makeCardPayment(double amount, String date, String cardDigits) {
		// TODO - implement Job.makeCardPayment
		throw new UnsupportedOperationException();
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public int getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * 
	 * @param type
	 * @param status
	 */
	public Job(String type, String status) {
		// TODO - implement Job.Job
		throw new UnsupportedOperationException();
	}

}