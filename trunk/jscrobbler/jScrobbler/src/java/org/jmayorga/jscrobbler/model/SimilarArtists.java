/** 
 * <p>Título: </p> 
 * <p>Archivo: SimilarArtists.java</p> 
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

public class SimilarArtists {
  private String artist;

  private Collection<Artist> relatedArtists = new ArrayList<Artist>();

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
    buffer.append("Source Artist: ").append(artist).append(eol);
    for (Iterator iter = relatedArtists.iterator(); iter.hasNext();)
    {
      Artist element = (Artist) iter.next();
      buffer.append("Artist: ").append(element);

    }
    return buffer.toString();
  }

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
   * @return Returns the relatedArtists.
   */
  public Collection<Artist> getRelatedArtists()
  {
    return Collections.unmodifiableCollection(relatedArtists);
  }

  /**
   * @param relatedArtists The relatedArtists to set.
   */
  public void setRelatedArtists(Collection<Artist> relatedArtists)
  {
    this.relatedArtists = relatedArtists;
  }

  public void addArtist(Artist artist)
  {
    this.relatedArtists.add(artist);
  }

  public void removeArtist(Artist artist)
  {
    this.relatedArtists.remove(artist);
  }
}
