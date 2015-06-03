package org.oa.tp;

import java.util.ArrayList;
import java.util.List;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Album;
import org.oa.tp.data.AudioTrack;
import org.oa.tp.data.Author;
import org.oa.tp.data.Genre;

public class Main {

	public static void main(String[] args) {

		DaoFacade facade = new DaoFacade();
			
		List<Album> albums = facade.getAlbumDao().loadAll();
		List<Genre> genres = facade.getGenreDao().loadAll();
		List<Author> authors = facade.getAuthorDao().loadAll();
		List<AudioTrack> audioTracks = facade.getAudioTrackDao().loadAll();
		
//		Author changed = authors.get(4);
//		changed.setFirstName("Vladimor");
//		changed.setLastName("Gochkov");
//		changed.setAge(38);
//		changed.setGender("male");
//		facade.getAuthorDao().update(changed);
		
		
		for (Album album : albums) {
			System.out.println(album);
		}
		System.out.println("--------------");
				
		for (Genre g : genres) {
			System.out.println(g);
		}
		System.out.println("--------------");
		
		for (Author a : authors) {
			System.out.println(a);
		}
		System.out.println("--------------");
		
		for (AudioTrack audioTrack : audioTracks) {
			System.out.println(audioTrack);
		}
		
		facade.closeConnection();
	}

}
