package org.oa.tp.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.oa.tp.data.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class GenreDAO implements AbstractDAO<Genre>{

	private Set<Genre> items = new HashSet<Genre>();
	private Statement statement;
	private Connection connection;
	
	
	public GenreDAO(Statement statement, Connection connection){
		this.statement = statement;
		this.connection = connection;
		String query = "CREATE TABLE IF NOT EXISTS `genre`  (" + 
				"`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT," +
				"`name` varchar(100) DEFAULT NULL," +
				"PRIMARY KEY (`id`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Genre> loadAll() {
		List<Genre> genresList = new ArrayList<>();
		try {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM genre;");
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				genresList.add(new Genre(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genresList;
	}

	@Override
	public Genre findById(long objectId) {
		Genre genre = null;
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM genre WHERE id=" + objectId + ";");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				genre = new Genre(id, name);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genre;
	}

	@Override
	public boolean delete(long id) {
		try {
			statement.executeUpdate("DELETE FROM genre WHERE id=" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Genre changed) {
		try {
			statement.executeUpdate("UPDATE genre SET name='" + changed.getName() + 
					"' WHERE id= " + changed.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(Genre item) {
		try {
			statement.executeUpdate("INSERT INTO genre " + 
					" (name)" + 
					" VALUES ('" + item.getName() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	@Override
	public boolean addAll(Collection<Genre> collection) {
		String sqlQuery = "INSERT INTO genre" + " (name)" + "VALUES ( ? );";
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			for (Genre genre : collection) {
				statement.setString(1, genre.getName());
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
