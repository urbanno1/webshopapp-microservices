package shop.products.DTODomian;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StockDTO {
	int quantity;
	String locationcode;

	public StockDTO(int quantity, String locationcode) {
		super();
		this.quantity = quantity;
		this.locationcode = locationcode;
	}

	public StockDTO() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocationcode() {
		return locationcode;
	}

	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}

	public void print() {
		System.out.println("Stock quantity: "+quantity+" , location code : "+locationcode);		
	}

}
