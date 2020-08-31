package shop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document
public class Order {
	@Id
	private String ordernumber;
	private Date date;
	private String status;
	private OrderCustomer customer;

	private ArrayList<OrderLine> orderlineList = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernumber, Date date, String status) {
		super();
		this.ordernumber = ordernumber;
		this.date = date;
		this.status = status;
	}

	public void print() {
		System.out.println("Content of the order:");
		System.out.println("Ordernr :"+ordernumber+" , Date : "+date+" , Status : "+status);
		for (OrderLine oline : orderlineList) {
			System.out.println(oline.getQuantity() + " " + oline.getProduct().getProductnumber() + " "
					+ oline.getProduct().getDescription() + " " + oline.getProduct().getPrice());
		}
		System.out.println("Total price =" + getTotalPrice());
		if(customer != null)
		  System.out.println("Customername =" + customer.getFirstname()+" "+customer.getLastname());
	}

	public OrderCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(OrderCustomer customer) {
		this.customer = customer;
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
	
	

}
