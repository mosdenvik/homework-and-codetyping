package org.oa.md.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.oa.md.data.Order;

public class OrderDAO implements AbstractDAO<Order>{

	
	private Set<Order> items = new HashSet<>();
	private Statement statement;
	private Connection connection;
	
	
	public OrderDAO(Statement statement, Connection connection) {
		this.statement = statement;
		this.connection = connection;
		String query = "CREATE TABLE IF NOT EXISTS `order` (" + 
				"`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT," + 
				"`order_status` VARCHAR(50) DEFAULT NULL," +
				"`order_date` VARCHAR(50) DEFAULT NULL," +
				"`manager_name` VARCHAR(50) DEFAULT NULL," +
				"`customer` VARCHAR(200) DEFAULT NULL," +
				"`shipping_address` VARCHAR(200) DEFAULT NULL," +
				"`price` INT DEFAULT NULL," +
				"PRIMARY KEY (`id`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Order> loadAll() {
		List<Order> orders = new ArrayList<Order>();
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `order`;");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String orderStatus = resultSet.getString("order_status");
				String orderDate = resultSet.getString("order_date");
				String managerName = resultSet.getString("manager_name");
				String customer = resultSet.getString("customer");
				String shippingAddress = resultSet.getString("shipping_address");
				int price = resultSet.getInt("price");
				orders.add(new Order(id, orderStatus, orderDate, managerName, customer, shippingAddress, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order findById(long objectId) {
		Order order = null;
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `order` WHERE id=" + objectId + ";");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String orderStatus = resultSet.getString("order_status");
				String orderDate = resultSet.getString("order_date");
				String managerName = resultSet.getString("manager_name");
				String customer = resultSet.getString("customer");
				String shippingAddress = resultSet.getString("shipping_address");
				int price = resultSet.getInt("price");
				order = new Order(id, orderStatus, orderDate, managerName, customer, shippingAddress, price);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public boolean delete(long id) {
		try {
			statement.executeUpdate("DELETE FROM `order` WHERE id=" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
        }

	@Override
	public boolean update(Order changed) {
		try {
			statement.executeUpdate("UPDATE order SET order_status='" + changed.getOrderStatus() + 
					"',order_date='" + changed.getOrderDate() +
					"',manager_name='" + changed.getManagerName() + 
					"',customer='" + changed.getCustomer() +
					"',shippingAddress='" + changed.getShippingAddress() +
					"',price='" + changed.getPrice() + 					
					"' WHERE id= " + changed.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(Order item) {
		try {
			statement.executeUpdate("INSERT INTO `order` " + 
					" (order_status, order_date, manager_name, customer, shipping_address, price)" + 
					" VALUES ('" + item.getOrderStatus() + "','" + item.getOrderDate() + "','" +
                                item.getManagerName() + "','" + item.getCustomer() + "','" + item.getShippingAddress() + 
                                "','" + item.getPrice() + "');"	);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
        


	@Override
	public boolean addAll(Collection<Order> collection) {
		String sqlQuery = "INSERT INTO order" + " (order_status, order_date, manager_name, customer, shipping_address, price)" + 
				"VALUES ( ? , ? , ? , ? , ? , ? );";
		try {
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		for (Order order : collection) {
			statement.setString(1, order.getOrderStatus());
			statement.setString(2, order.getOrderDate());
			statement.setString(3, order.getManagerName());
			statement.setString(4, order.getCustomer());
			statement.setString(5, order.getShippingAddress());
			statement.setInt(6, order.getPrice());
			statement.executeUpdate();
		}
		connection.commit();
		connection.setAutoCommit(true);
		statement.close();
		} catch (SQLException e) {
		try {
			connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
		}
		return false;
			}
			
	

	
	

}
