package Payment;

import Database.*;

public class Invoice {

	private String InvoiceID;
	private int Date;
	private String Address;
	private String DescOfWork;
	private int Items;
	private double Total;
	SQL_InvoiceHelper sql_helper;

	public Invoice(){}

	public String getInvoiceID(){
		return InvoiceID;
	}

	public void setInvoiceID(String InvoiceID){
		this.InvoiceID = InvoiceID;
	}

	public int Date(){
		return Date;
	}

	public void setDate(int Date){
		this.Date = Date;
	}

	public String Address(){
		return Address;
	}

	public void setAddress(String Address){
		this.Address = Address;
	}

	public String DescOfWork(){
		return DescOfWork;
	}

	public void setDescOfWork(String DescOfWork){
		this.DescOfWork = DescOfWork;
	}

	public int Items(){
		return Items;
	}

	public void setItems(int Items){
		this.Items = Items;
	}

	public double Total(){
		return Total;
	}

	public void setTotal(double Total){
		this.Total = Total;
	}
}