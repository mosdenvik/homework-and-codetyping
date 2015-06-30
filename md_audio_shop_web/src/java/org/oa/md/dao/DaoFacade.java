package org.oa.md.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

import org.oa.md.data.Album;
import org.oa.md.data.AudioTrack;
import org.oa.md.data.Author;
import org.oa.md.data.Genre;
import org.oa.md.data.Order;


public class DaoFacade {

	private Connection connection;
	private Statement statement;

	private final AlbumDAO albumDao;
	private final GenreDAO genreDao;
	private final AuthorDAO authorDao;
	private final AudioTrackDAO audioTrackDao;
	private final OrderDAO orderDao;
	
	private static String username = "root";
	private static String password = "toor";
	private static String URL = "jdbc:mysql://localhost:3306/audio_shop";
	
	public DaoFacade(ServletContext context) {
		String driveName = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driveName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("Connection Successful !\n");
		}
		if (connection == null) {
			System.exit(1);
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		albumDao = new AlbumDAO(statement, connection);
		genreDao = new GenreDAO(statement,connection);
		authorDao = new AuthorDAO(connection, statement);
		audioTrackDao = new AudioTrackDAO(connection, statement);
		orderDao = new OrderDAO(statement, connection);
	}

	public AbstractDAO<Album> getAlbumDao() {
		return albumDao;
	}

	public AbstractDAO<Genre> getGenreDao() {
		return genreDao;
	}
	
	public AbstractDAO<Author> getAuthorDao() {
		return authorDao;
	}

	public AbstractDAO<AudioTrack> getAudioTrackDao() {
		return audioTrackDao;
	}

	public AbstractDAO<Order> getOrderDao(){
		return orderDao;
	}
	
	
	public void closeConnection() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
