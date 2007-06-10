/**

 * Copyright (C) 2007  Jose Luis Mayorga Alc‡ntara

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

 * @author Jose Luis Mayorga Jun 8, 2007
 * @version
 */
package org.jmayorga.jscrobbler.model;

import java.util.Collection;

public class Artist {

	private String name;

	private String mbid;

	private Double match;

	private String url;

	private String image_small;

	private String image;

	private String streamable;

	private Collection<Album> albums;

	private Collection<Tag> tags;

	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Collection<Album> albums) {
		this.albums = albums;
	}

	public void addAlbum(Album album) {
		this.albums.add(album);
	}

	public void removeAlbum(Album album) {
		this.albums.remove(album);
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public void removeTag(Tag tag) {
		this.tags.remove(tag);
	}

	/**
	 * @return Returns the image.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            The image to set.
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return Returns the image_small.
	 */
	public String getImage_small() {
		return image_small;
	}

	/**
	 * @param image_small
	 *            The image_small to set.
	 */
	public void setImage_small(String image_small) {
		this.image_small = image_small;
	}

	/**
	 * @return Returns the match.
	 */
	public Double getMatch() {
		return match;
	}

	/**
	 * @param match
	 *            The match to set.
	 */
	public void setMatch(Double match) {
		this.match = match;
	}

	/**
	 * @return Returns the mbid.
	 */
	public String getMbid() {
		return mbid;
	}

	/**
	 * @param mbid
	 *            The mbid to set.
	 */
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the streamable.
	 */
	public String getStreamable() {
		return streamable;
	}

	/**
	 * @param streamable
	 *            The streamable to set.
	 */
	public void setStreamable(String streamable) {
		this.streamable = streamable;
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Artist: ").append(name);
		return buffer.toString();
	}
}
