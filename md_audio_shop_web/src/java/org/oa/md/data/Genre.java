package org.oa.md.data;

import com.google.gson.annotations.SerializedName;

public class Genre {

	@SerializedName("id")
	private final long id;
	
	@SerializedName("name")
	private String name;
	
	public Genre(long id, String name) {
		this.id = id;
		this.name = name;
	}

        public Genre(String name) {
		this.id = 0;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
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
		Genre other = (Genre) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [id: " + id + ", name: " + name + "]";
	}
	
	
}
