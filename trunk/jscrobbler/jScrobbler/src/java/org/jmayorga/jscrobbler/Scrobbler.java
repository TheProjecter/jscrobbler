/**
 * @author José Luis Mayorga Jun 8, 2007
 * @version
 */
package org.jmayorga.jscrobbler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmayorga.jscrobbler.model.Album;
import org.jmayorga.jscrobbler.model.Artist;
import org.jmayorga.jscrobbler.model.MostKnownTracks;
import org.jmayorga.jscrobbler.model.SimilarArtists;
import org.jmayorga.jscrobbler.model.TopAlbums;
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
		Collection<Artist> similarArtists = null;
		log.debug("Starting");

		Digester digester = new Digester();
		SimilarArtists digestedResult = null;
		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ artist + "/similar.xml");

			digester.setValidating(false);
			digester.addObjectCreate("similarartists", SimilarArtists.class);
			digester.addSetProperties("similarartists");
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

			digester.addSetNext("similarartists/artist", "addArtist");

			digestedResult = (SimilarArtists) digester.parse(url);
			similarArtists = digestedResult.getRelatedArtists();
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
		return similarArtists;
	}

	/**
	 * Gets most known tracks from the received artist
	 *
	 * @param artist
	 * @return
	 */
	public MostKnownTracks getMostKnownTracks(String artist) {
		log.debug("Starting");

		Digester digester = new Digester();
		MostKnownTracks digestedResult = null;
		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ artist + "/toptracks.xml");
			digester.setValidating(false);

			digester.addObjectCreate("mostknowntracks", MostKnownTracks.class);
			digester.addSetProperties("mostknowntracks");
			digester.addObjectCreate("mostknowntracks/track", Track.class);
			digester
					.addBeanPropertySetter("mostknowntracks/track/name", "name");
			digester
					.addBeanPropertySetter("mostknowntracks/track/mbid", "mbid");
			digester.addBeanPropertySetter("mostknowntracks/track/reach",
					"reach");
			digester.addBeanPropertySetter("mostknowntracks/track/url", "url");
			digester.addSetNext("mostknowntracks/track", "addTrack");

			digestedResult = (MostKnownTracks) digester.parse(url);
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
	public TopAlbums getTopAlbums(String artist) {

		Digester digester = new Digester();
		TopAlbums digestedResult = null;
		try {
			URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/"
					+ artist + "/topalbums.xml");
			digester.setValidating(false);

			digester.addObjectCreate("topalbums", TopAlbums.class);
			digester.addSetProperties("topalbums");
			digester.addObjectCreate("topalbums/album", Album.class);
			digester.addBeanPropertySetter("topalbums/album/name", "name");
			digester.addBeanPropertySetter("topalbums/album/mbid", "mbid");
			digester.addBeanPropertySetter("topalbums/album/reach", "reach");
			digester.addBeanPropertySetter("topalbums/album/url", "url");
			digester.addSetNext("topalbums/album", "addAlbum");

			digestedResult = (TopAlbums) digester.parse(url);
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
}
