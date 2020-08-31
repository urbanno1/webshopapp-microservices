package shop.order.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Order {
	@Id
	private String ordernumber;
	private Date date;
	private String status;
	private Customer customer;

	private ArrayList<OrderLine> orderlineList = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernumber, Date date, String status) {
		super();
		this.ordernumber = ordernumber;
		this.date = date;
		this.status = status;
	}


	private double getTotalPrice() {
		double totalPrice = 0.0;
		for (OrderLine oline : orderlineList) {
			totalPrice=totalPrice+(oline.getProduct().getPrice() * oline.getQuantity());
		}
		return totalPrice;
	}
	
	public void addOrderLine(OrderLine oline) {
		orderlineList.add(oline);		
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<OrderLine> getOrderlineList() {
		return orderlineList;
	}

	public void setOrderlineList(ArrayList<OrderLine> orderlineList) {
		this.orderlineList = orderlineList;
	}

	public void confirm() {
		status="confirmed";		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
