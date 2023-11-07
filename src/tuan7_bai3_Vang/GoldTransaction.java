package tuan7_bai3_Vang;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GoldTransaction extends Transaction{
	private String goldType;

	public String getGoldType() {
		return goldType;
	}

	public void setGoldType(String goldType) {
		this.goldType = goldType;
	}

	public GoldTransaction(String transCode, LocalDate transDate, double unitPrice, int quantity, String goldType) {
		super(transCode, transDate, unitPrice, quantity);
		this.goldType = goldType;
	}

	public GoldTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoldTransaction(String transCode, LocalDate transDate, double unitPrice, int quantity) {
		super(transCode, transDate, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPrice() {
		return getUnitPrice()*getQuantity();
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return super.toString()+String.format(" %-25s | %-20s |", df.format(totalPrice()), getGoldType());
	}
}
