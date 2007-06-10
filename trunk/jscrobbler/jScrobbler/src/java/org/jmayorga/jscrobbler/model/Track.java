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

public class Track {

	private String name;

	private String mbid;

	private String reach;

	private String url;

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
	 * @return Returns the reach.
	 */
	public String getReach() {
		return reach;
	}

	/**
	 * @param reach
	 *            The reach to set.
	 */
	public void setReach(String reach) {
		this.reach = reach;
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
		buffer.append("Track: ").append(name);
		return buffer.toString();
	}
}
