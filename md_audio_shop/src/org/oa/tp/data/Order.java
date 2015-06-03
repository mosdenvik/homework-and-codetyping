package org.oa.tp.data;

import java.sql.Date;

public class Order {

	private final long id;
	private String orderStatus;
	private final Date orderDate;
	private final String nameOfManager;
	private final String customer;
	private final String shippingAddress;
	private final int price;

	private Album albumId;

	public Order(long id, String orderStatus, Date orderDate,
			String nameOfManager, String customer, String shippingAddress,
			int price) {
		this.id = id;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.nameOfManager = nameOfManager;
		this.customer = customer;
		this.shippingAddress = shippingAddress;
		this.price = price;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getNameOfManager() {
		return nameOfManager;
	}

	public String getCustomer() {
		return customer;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id: " + id + ", orderStatus: " + orderStatus
				+ ", orderDate: " + orderDate + ", nameOfManager: "
				+ nameOfManager + ", customer: " + customer
				+ ", shippingAddress: " + shippingAddress + ", price: " + price
				+ "]";
	}

	
}
