package org.oa.md.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.oa.md.data.Album;
import org.oa.md.data.Author;

public class AuthorDAO implements AbstractDAO<Author>{

	List<Author> items = new ArrayList<>();
	Connection connection = null;
	Statement statement = null;
	
	AuthorDAO(Connection connection, Statement statement) {
		this.connection = connection;
		this.statement = statement;
		String query = "CREATE TABLE IF NOT EXISTS `author` (" + 
				"`id` INT unsigned NOT NULL AUTO_INCREMENT," +
				"`first_name` varchar(20) DEFAULT NULL," + 
				"`last_name` varchar(50) DEFAULT NULL," + 
				"`age` INT DEFAULT NULL," + 
				"`gender` varchar(50) DEFAULT NULL," + 
				"PRIMARY KEY (`id`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Author> loadAll() {
		List<Author> authors = new ArrayList<Author>();
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM author;");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				authors.add(new Author(id, firstName, lastName, age, gender));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public Author findById(long objectId) {
		Author author = null;
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM author WHERE id=" + objectId + ";");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				author = new Author(id, firstName, lastName, age, gender);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public boolean delete(long id) {
		try {
			statement.executeUpdate("DELETE FROM author WHERE id=" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Author changed) {
		try {
			statement.executeUpdate("UPDATE author SET first_name='" + changed.getFirstName() + 
					"',last_name='" + changed.getLastName() +
					"',age='" + changed.getAge() + 
					"',gender='" + changed.getGender() +
					"' WHERE id= " + changed.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(Author item) {
		try {
			statement.executeUpdate("INSERT INTO author " + 
					" (first_name, last_name, age, gender)" + 
					" VALUES ('" + item.getFirstName() + "','" + item.getLastName() + "','" + 
					item.getAge() + "','" + item.getGender() + "');"	);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<Author> collection) {
		String sqlQuery = "INSERT INTO author" + " (first_name, last_name, age, gender)" + "VALUES ( ? , ? , ? , ?);";
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			for (Author author : collection) {
				statement.setString(1, author.getFirstName());
				statement.setString(2, author.getLastName());
				statement.setInt(3, author.getAge());
				statement.setString(4, author.getGender());
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
