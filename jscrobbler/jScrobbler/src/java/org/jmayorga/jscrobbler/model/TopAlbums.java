package org.jmayorga.jscrobbler.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TopAlbums {
	private String artist;

	private Collection<Album> albums = new ArrayList<Album>();

	public Collection<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Collection<Album> albums) {
		this.albums = albums;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addAlbum(Album album) {
		this.albums.add(album);
	}

	public void removeAlbum(Album album) {
		this.albums.remove(album);
	}

	@Override
	public String toString() {
		String eol = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		buffer.append("Artist: ").append(artist).append(eol);
		for (Iterator iter = albums.iterator(); iter.hasNext();) {
			Album element = (Album) iter.next();
			buffer.append("Album: ").append(element);

		}
		return buffer.toString();
	}

}
