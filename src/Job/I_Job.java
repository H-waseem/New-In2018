package Job;

public interface I_Job {

	/**
	 * 
	 * @param jobNo
	 */
	abstract boolean addJob(int jobNo);

	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param email
	 */
	abstract void addCustomer(String name, String address, String phone, String email);

	/**
	 * 
	 * @param bayNo
	 */
	abstract boolean addBay(int bayNo);

	/**
	 * 
	 * @param jobNo
	 */
	abstract Job getJob(int jobNo);

	/**
	 * 
	 * @param email
	 */
	abstract Customer getCustomer(String email);

	/**
	 * 
	 * @param email
	 */
	abstract bookingHistory getHistory(String email);

	/**
	 * 
	 * @param email
	 * @param bookingID
	 */
	abstract boolean isPaid(String email, long bookingID);

	/**
	 * 
	 * @param amount
	 */
	abstract void makePayment(double amount);

	/**
	 * 
	 * @param amount
	 * @param date
	 * @param cardDigits
	 */
	abstract void makeCardPayment(double amount, String date, String cardDigits);

	/**
	 * 
	 * @param email
	 */
	abstract void removeCustomer(String email);

	static void impl_I_Booking() {

	}

}