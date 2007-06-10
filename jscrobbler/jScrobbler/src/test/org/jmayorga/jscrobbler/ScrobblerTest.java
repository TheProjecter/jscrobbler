package org.jmayorga.jscrobbler;

import java.util.Collection;

import junit.framework.TestCase;

import org.jmayorga.jscrobbler.model.Album;
import org.jmayorga.jscrobbler.model.Artist;
import org.jmayorga.jscrobbler.model.Tag;
import org.jmayorga.jscrobbler.model.Track;

public class ScrobblerTest extends TestCase {
	Scrobbler scrobbler;

	@Override
	protected void setUp() throws Exception {
		scrobbler = new Scrobbler();
		super.setUp();
	}

	public void testGetSimilarArtists() {
		Collection<Artist> artists = scrobbler.getSimilarArtists("Sylver");
		assertNotNull("Result must not be null", artists);
	}

	public void testGetMostKnownTracks() {
		Collection<Track> knownTracks = scrobbler.getMostKnownTracks("Sylver");
		assertNotNull("Result must not be null", knownTracks);
	}

	public void testGetTopAlbums() {
		Collection<Album> topAlbums = scrobbler.getTopAlbums("Sylver");
		assertNotNull("Result must not be null", topAlbums);
	}

	public void testGetTopTags() {
		Collection<Tag> tags = scrobbler.getTopTags("Sylver");
		assertNotNull("Result must not be null", tags);
	}

}
