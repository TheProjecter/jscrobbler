package org.jmayorga.jscrobbler;

import java.util.Collection;

import junit.framework.TestCase;

import org.jmayorga.jscrobbler.model.Artist;
import org.jmayorga.jscrobbler.model.MostKnownTracks;
import org.jmayorga.jscrobbler.model.TopAlbums;

public class ScrobblerTest extends TestCase {
	Scrobbler scrobbler;

	@Override
	protected void setUp() throws Exception {
		scrobbler = new Scrobbler();
		super.setUp();
	}

	public void testGetSimilarArtists() {
		Collection<Artist> artists = scrobbler.getSimilarArtists("Sylver");
		assertNotNull("Artists must not be null", artists);
	}

	public void testGetMostKnownTracks() {
		MostKnownTracks knownTracks = scrobbler.getMostKnownTracks("Sylver");
		assertNotNull("MostKnownTracks must not be null", knownTracks);
	}

	public void testGetTopAlbums() {
		TopAlbums topAlbums = scrobbler.getTopAlbums("Sylver");
		assertNotNull("TopAlbums must not be null", topAlbums);
	}

}
