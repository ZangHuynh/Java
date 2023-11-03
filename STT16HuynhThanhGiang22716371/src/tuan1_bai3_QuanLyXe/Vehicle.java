package tuan1_bai3_QuanLyXe;

public class Vehicle {
	private String ownerName;
	private String vehicleName;
	private int capacity;
	private float price;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) throws Exception {
		if(capacity > 0)
			this.capacity = capacity;
		else throw new Exception("Capacity cann't be negative number");
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) throws Exception {
		if(price > 0)
			this.price = price;
		else throw new Exception("Price cann't be negative number");
	}
	
	public Vehicle(String ownerName, String vehicleName, int capacity, float price) {
		super();
		this.ownerName = ownerName;
		this.vehicleName = vehicleName;
		this.capacity = capacity;
		this.price = price;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double vehicleTax() {
		double vtax=0;
		if(capacity <= 100) vtax = getPrice()*0.01;
		if(capacity > 100 && capacity<=200) vtax = getPrice()*0.03;
		if(capacity > 200) vtax = getPrice()*0.05;
		return vtax;
	}

	@Override
	public String toString() {
		String str = String.format("%20s %15s %12d %20.2f %15.2f",getOwnerName(),getVehicleName(),getCapacity(),getPrice(),vehicleTax()); 
		return str;
	}

	public void printTax() {
		System.out.printf("%20s %15s %12d %20.2f %15.2f \n",getOwnerName(),getVehicleName(),getCapacity(),getPrice(),vehicleTax());
	}
}
