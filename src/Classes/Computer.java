package Classes;

import java.util.Objects;

public class Computer {
	
	//Attributes(Fields)
	private String brand;
	private String model;
	private long SN;
	private double price;
	static int count = 0;
	
	//Constructor
	public Computer(String br, String mod, long sn, double pri) {
		this.brand = br;
		this.model = mod;
		this.SN = sn;
		this.price = pri;
		count++;
	}

	//Getter & Setter
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		SN = sN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	//getting number of created pc Method
	public static void findNumberOfCreatedComputers() {
		
		System.out.println("The number of created Computer: " + count);
		
	}
	
	
	//toString Method
	@Override
	public String toString() {
		return "brand: " + brand + " - model: " + model + " - SN: " + SN + " - price: " + price + "\n";
	}

	
	//equal Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
		
}
