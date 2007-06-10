/**
 * @author José Luis Mayorga Jun 8, 2007
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
	 * Gets similar artists related to the artist passed as a parameter
	 *
	 * @param artist
	 * @return Similar artists
	 */
	public Collection<Artist> getSimilarArtists(String artist) {

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
	 * Gets most known tracks from the received artist
	 *
	 * @param artist
	 * @return
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
	 * Gets top albums from the received artist
	 *
	 * @param artist
	 * @return
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
	 *
	 * @param artist
	 * @param track
	 * @return
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
	 *
	 * @param artist
	 * @return
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
