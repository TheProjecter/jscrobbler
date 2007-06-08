/** 
 * <p>Título: </p> 
 * <p>Archivo: MostKnownTracks.java</p> 
 * <p>Descripcion: </p> 
 * <p>Copyright: Copyright (c) 2007</p> 
 * @author José Luis Mayorga/Certum Jun 8, 2007 
 * @version  
 */
package org.jmayorga.jscrobbler.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MostKnownTracks {
  private String artist;

  private Collection<Track> tracks = new ArrayList<Track>();

  /**
   * @return Returns the artist.
   */
  public String getArtist()
  {
    return artist;
  }

  /**
   * @param artist The artist to set.
   */
  public void setArtist(String artist)
  {
    this.artist = artist;
  }

  /**
   * @return Returns the tracks.
   */
  public Collection<Track> getTracks()
  {
    return Collections.unmodifiableCollection(tracks);
  }

  /**
   * @param tracks The tracks to set.
   */
  public void setTracks(Collection<Track> tracks)
  {
    this.tracks = tracks;
  }

  /**
   * Descripción:
   * 
   * @param track
   */
  public void addTrack(Track track)
  {
    this.tracks.add(track);
  }

  public void removeTrack(Track track)
  {
    this.tracks.remove(track);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    String eol = System.getProperty("line.separator");
    StringBuffer buffer = new StringBuffer();
    buffer.append("Artist: ").append(artist).append(eol);
    for (Iterator iter = tracks.iterator(); iter.hasNext();)
    {
      Track element = (Track) iter.next();
      buffer.append("Track: ").append(element);

    }

    return buffer.toString();
  }
}
