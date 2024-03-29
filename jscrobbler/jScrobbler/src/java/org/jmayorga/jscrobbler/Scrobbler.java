/**

 * Copyright (C) 2007  Jose Luis Mayorga Alc�ntara

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
package org.jmayorga.jscrobbler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmayorga.jscrobbler.model.Album;
import org.jmayorga.jscrobbler.model.Artist;
import org.jmayorga.jscrobbler.model.Tag;
import org.jmayorga.jscrobbler.model.Track;
import org.xml.sax.SAXException;

public class Scrobbler {
	private static final Log log = LogFactory.getLog(Scrobbler.class);

	/**
	 * Get related artists for a given artist
	 *
	 * @param artist
	 * @return Similar artists
	 */
	public Collection<Artist> getRelatedArtists(String artist) {

		log.debug("Getting similar artists for: [" + artist + "]");

		Digester digester = new Digester();
		Collection<Artist> digestedResult = new ArrayList<Artist>();
		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ replaceSpaces(artist) + "/similar.xml");

			digester.setValidating(false);
			digester.addObjectCreate("similarartists", digestedResult
					.getClass());
			digester.addObjectCreate("similarartists/artist", Artist.class);
			digester
					.addBeanPropertySetter("similarartists/artist/name", "name");
			digester
					.addBeanPropertySetter("similarartists/artist/mbid", "mbid");
			digester.addBeanPropertySetter("similarartists/artist/match",
					"match");
			digester.addBeanPropertySetter("similarartists/artist/url", "url");
			digester.addBeanPropertySetter("similarartists/artist/image_small",
					"image_small");
			digester.addBeanPropertySetter("similarartists/artist/image",
					"image");
			digester.addBeanPropertySetter("similarartists/artist/streamable",
					"streamable");

			digester.addSetNext("similarartists/artist", "add");

			digestedResult = (Collection<Artist>) digester.parse(url);

			log.debug("Result: " + digestedResult);

		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		} catch (FileNotFoundException e) {
			log.error("Artist with name: [" + artist + "] was not found");
		} catch (IOException e) {
			log.error("IOException, ", e);
		} catch (SAXException e) {
			log.error("SAXException, ", e);
		}
		return digestedResult;
	}

	/**
	 * Gets most popular tracks of a given artist
	 *
	 * @param artist
	 * @return The most popular tracks by a given artist
	 */
	public Collection<Track> getMostKnownTracks(String artist) {

		log.debug("Getting most known tracks of: [" + artist + "]");

		Digester digester = new Digester();
		Collection<Track> digestedResult = new HashSet<Track>();

		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ replaceSpaces(artist) + "/toptracks.xml");
			digester.setValidating(false);

			digester.addObjectCreate("mostknowntracks", digestedResult
					.getClass());
			digester.addObjectCreate("mostknowntracks/track", Track.class);
			digester
					.addBeanPropertySetter("mostknowntracks/track/name", "name");
			digester
					.addBeanPropertySetter("mostknowntracks/track/mbid", "mbid");
			digester.addBeanPropertySetter("mostknowntracks/track/reach",
					"reach");
			digester.addBeanPropertySetter("mostknowntracks/track/url", "url");
			digester.addSetNext("mostknowntracks/track", "add");

			digestedResult = (Collection<Track>) digester.parse(url);
			log.debug("Result: " + digestedResult);

		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		} catch (FileNotFoundException e) {
			log.error("Artist with name: [" + artist + "] was not found");
		} catch (IOException e) {
			log.error("IOException, ", e);
		} catch (SAXException e) {
			log.error("SAXException, ", e);
		}
		return digestedResult;
	}

	/**
	 * Gets The most popular albums by a given artist
	 *
	 * @param artist
	 * @return The most popular albums by a given artist
	 */
	public Collection<Album> getTopAlbums(String artist) {
		log.debug("Getting top albums of: [" + artist + "]");

		Digester digester = new Digester();
		Collection<Album> digestedResult = new HashSet<Album>();
		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ replaceSpaces(artist) + "/topalbums.xml");
			digester.setValidating(false);

			digester.addObjectCreate("topalbums", digestedResult.getClass());
			digester.addObjectCreate("topalbums/album", Album.class);
			digester.addBeanPropertySetter("topalbums/album/name", "name");
			digester.addBeanPropertySetter("topalbums/album/mbid", "mbid");
			digester.addBeanPropertySetter("topalbums/album/reach", "reach");
			digester.addBeanPropertySetter("topalbums/album/url", "url");
			digester.addSetNext("topalbums/album", "add");

			digestedResult = (Collection<Album>) digester.parse(url);
			log.debug("Result: " + digestedResult);

		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		} catch (FileNotFoundException e) {
			log.error("Artist with name: [" + artist + "] was not found");
		} catch (IOException e) {
			log.error("IOException, ", e);
		} catch (SAXException e) {
			log.error("SAXException, ", e);
		}

		return digestedResult;

	}

	/**
	 * Gets the most popular tags of a track
	 *
	 * @param artist
	 * @param track
	 * @return The most popular tags applied to a given track
	 */
	public Collection<Tag> getTopTrackTags(String artist, String track) {
		log.debug("Getting top tags of: Artist - [" + artist + "], Track - ["
				+ track + "]");

		track = track.replaceAll(" ", "+");
		URL url = null;
		try {
			url = new URL("http://ws.audioscrobbler.com/1.0/track/"
					+ replaceSpaces(artist) + "/" + replaceSpaces(track)
					+ "/toptags.xml");
		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		}
		return getTopTags(url);
	}

	/**
	 * Gets he most popular tags applied to a given artist
	 *
	 * @param artist
	 * @return the most popular tags applied to a given artist
	 */
	public Collection<Tag> getTopArtistTags(String artist) {
		log.debug("Getting top tags of: [" + artist + "]");

		URL url = null;
		try {
			url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ replaceSpaces(artist) + "/toptags.xml");
		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		}
		return getTopTags(url);
	}

	/**
	 * Gets top tags of a given artist name
	 *
	 * @param artist
	 * @return
	 */
	private Collection<Tag> getTopTags(URL url) {

		Collection<Tag> tags = new HashSet<Tag>();

		Digester digester = new Digester();

		try {

			digester.setValidating(false);

			digester.addObjectCreate("toptags", tags.getClass());
			digester.addObjectCreate("toptags/tag", Tag.class);
			digester.addBeanPropertySetter("toptags/tag/name", "name");
			digester.addBeanPropertySetter("toptags/tag/count", "count");
			digester.addBeanPropertySetter("toptags/tag/url", "url");
			digester.addSetNext("toptags/tag", "add");

			tags = (Collection<Tag>) digester.parse(url);
			log.debug("Result: " + tags);

		} catch (MalformedURLException e) {
			log.error("Malformed URL, ", e);
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException, ", e);
		} catch (IOException e) {
			log.error("IOException, ", e);
		} catch (SAXException e) {
			log.error("SAXException, ", e);
		}

		return tags;
	}

	private String replaceSpaces(String s) {
		return s.replace(" ", "+");
	}
}
