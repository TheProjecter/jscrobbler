package org.jmayorga.jscrobbler.model;

import java.awt.Image;
import java.util.Collection;

public class Album {

	private String name;

	private String mbid;

	private String reach;

	private String url;

	private Image image;

	private Collection<Track> tracks;

	public Collection<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		this.tracks.add(track);
	}

	public void removeTrack(Track track) {
		this.tracks.remove(track);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReach() {
		return reach;
	}

	public void setReach(String reach) {
		this.reach = reach;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Album: ").append(name);
		return buffer.toString();
	}

}
