package org.oa.md.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

        @SerializedName("id")
	private final long id;
        
        @SerializedName("orderStatus")
	private String orderStatus;
        
        @SerializedName("orderDate")
	private final String orderDate;
        
        @SerializedName("managerName")
	private final String managerName;
        
        @SerializedName("customer")
	private final String customer;
        
        @SerializedName("shippingAddress")
	private final String shippingAddress;
        
        @SerializedName("price")
	private final int price;

        @Expose
	private Album albumId;

	public Order(long id, String orderStatus, String orderDate,
			String managerName, String customer, String shippingAddress,
			int price) {
		this.id = id;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.managerName = managerName;
		this.customer = customer;
		this.shippingAddress = shippingAddress;
		this.price = price;
	}
        
        public Order(String orderStatus, String orderDate,
			String managerName, String customer, String shippingAddress,
			int price) {
		this.id = 0;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.managerName = managerName;
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

	public String getOrderDate() {
		return orderDate;
	}

	public String getManagerName() {
		return managerName;
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
				+ managerName + ", customer: " + customer
				+ ", shippingAddress: " + shippingAddress + ", price: " + price
				+ "]";
	}

	
}
