public class StockLevelReport extends Report {

	private int initialStockLevel;
	private double initialCost;
	private int used;
	private int delivery;
	private int newStockLevel;
	private double stockCost;
	private int lowLevelThreshold;

	public boolean produceSLP() {
		// TODO - implement StockLevelReport.produceSLP
		throw new UnsupportedOperationException();
	}

	public int getUsed() {
		return this.used;
	}

	/**
	 * 
	 * @param used
	 */
	public void setUsed(int used) {
		this.used = used;
	}

	public int getDelivery() {
		return this.delivery;
	}

	/**
	 * 
	 * @param delivery
	 */
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

}