package org.oa.md.data;

import java.sql.Time;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioTrack {
	
	@SerializedName("id")
	private final long id;
	
	@SerializedName("name")
	private final String name;
	
	@SerializedName("authorId")
	private final long authorId;
	
	@SerializedName("duration")
	private final Time duration;
	
	@SerializedName("price")
	private int price;
	
	@SerializedName("genreId")
	private final long genreId;
	
	@Expose
	private Author author;
	
	@Expose
	private Album album;
	
	
	public AudioTrack(long id, String name, long authorId, Time duration, int price, long genreId) {
		this.id = id;
		this.name = name;
		this.authorId = authorId;
		this.duration = duration;
		this.price = price;
		this.genreId = genreId;
	}

        public AudioTrack(String name, long authorId, Time duration, int price, long genreId) {
		this.id = 0;
		this.name = name;
		this.authorId = authorId;
		this.duration = duration;
		this.price = price;
		this.genreId = genreId;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getGenreId() {
		return genreId;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getAuthorId() {
		return authorId;
	}
	public Time getDuration() {
		return duration;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
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
		AudioTrack other = (AudioTrack) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AudioTrack [id: " + id + ", name: " + name + ", authorId: " + authorId
				+ ", duration: " + duration + ", price: " + price + ", genreId: "
				+ genreId + ", author: " + author + ", album: " + album + "]";
	}
	
	
	
	

}
