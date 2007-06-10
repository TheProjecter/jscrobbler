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
		Collection<Artist> artists = scrobbler.getRelatedArtists("Sylver");
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

	public void testGetTopArtistTags() {
		Collection<Tag> tags = scrobbler.getTopArtistTags("Sylver");
		assertNotNull("Result must not be null", tags);
	}

	public void testGetTopTrackTags() {
		Collection<Tag> tags = scrobbler.getTopTrackTags("Sylver",
				"Dance With Loneliness");
		assertNotNull("Result must not be null", tags);

	}
}
