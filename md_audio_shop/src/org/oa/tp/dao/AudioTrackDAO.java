package org.oa.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.oa.tp.data.Album;
import org.oa.tp.data.AudioTrack;

public class AudioTrackDAO implements AbstractDAO<AudioTrack>{

	List<AudioTrack> audioTracks = new ArrayList<AudioTrack>();
	Connection connection;
	Statement statement;
	
	
	
	
	public AudioTrackDAO(Connection connection,	Statement statement) {
		this.connection = connection;
		this.statement = statement;
		String query = "CREATE TABLE IF NOT EXISTS `audio_track` (" +
				"`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT," + 
				"`name` varchar(100) DEFAULT NULL," + 
				"`author_id` INT DEFAULT NULL," +
				"`duration` TIME DEFAULT NULL," +
				"`price` INT DEFAULT NULL," +
				"`genre_id` INT DEFAULT NULL," + 
				"PRIMARY KEY (`id`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AudioTrack> loadAll() {
		List<AudioTrack> audioTracks = new ArrayList<AudioTrack>();
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM audio_track;");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int authorId = resultSet.getInt("author_id");
				Time duration = resultSet.getTime("duration");
				int price = resultSet.getInt("price");
				int genreId = resultSet.getInt("genre_id");
				audioTracks.add(new AudioTrack(id, name, authorId, duration, price, genreId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return audioTracks;
	}

	@Override
	public AudioTrack findById(long objectId) {
		AudioTrack audioTrack = null;
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM audio_track WHERE id=" + objectId + ";");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int authorId = resultSet.getInt("author_id");
				Time duration = resultSet.getTime("duration");
				int price = resultSet.getInt("price");
				int genre_id = resultSet.getInt("genre_id");
				audioTrack = new AudioTrack(id, name, authorId, duration, price, genre_id);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return audioTrack;
	}

	@Override
	public boolean delete(long id) {
		try {
			statement.executeUpdate("DELETE FROM audio_track WHERE id=" + id + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(AudioTrack changed) {
		try {
			statement.executeUpdate("UPDATE audio_track SET name='" + changed.getName() + 
					"',author_id='" + changed.getAuthorId() +
					"',duration='" + changed.getDuration() + 
					"',genre_id='" + changed.getGenreId() +
					"',price='" + changed.getPrice() + 					
					"' WHERE id= " + changed.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(AudioTrack item) {
		try {
			statement.executeUpdate("INSERT INTO audio_track " + 
					" (name, author_id, duration, genre_id, price)" + 
					" VALUES ('" + item.getName() + "','" + item.getAuthorId() + "','" +
					item.getDuration() + "','" + item.getGenreId() + "','" +
					item.getPrice() + "');"	);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<AudioTrack> collection) {
		String sqlQuery = "INSERT INTO audio_track" + " (name, author_id, duration, genre_id, price)" + 
							"VALUES ( ? , ? , ? , ? , ?);";
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			for (AudioTrack audioTrack : collection) {
				statement.setString(1, audioTrack.getName());
				statement.setInt(2, (int) audioTrack.getAuthorId());
				statement.setTime(3, audioTrack.getDuration());
				statement.setInt(4, (int) audioTrack.getGenreId());
				statement.setInt(5, audioTrack.getPrice());
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
