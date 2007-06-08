/**
 * @author José Luis Mayorga Jun 8, 2007
 * @version
 */
package org.jmayorga.jscrobbler.model;

public class Artist
{

  private String name;

  private String mbid;

  private Double match;

  private String url;

  private String image_small;

  private String image;

  private String streamable;

  /**
   * @return Returns the image.
   */
  public String getImage()
  {
    return image;
  }

  /**
   * @param image The image to set.
   */
  public void setImage( String image )
  {
    this.image = image;
  }

  /**
   * @return Returns the image_small.
   */
  public String getImage_small()
  {
    return image_small;
  }

  /**
   * @param image_small The image_small to set.
   */
  public void setImage_small( String image_small )
  {
    this.image_small = image_small;
  }

  /**
   * @return Returns the match.
   */
  public Double getMatch()
  {
    return match;
  }

  /**
   * @param match The match to set.
   */
  public void setMatch( Double match )
  {
    this.match = match;
  }

  /**
   * @return Returns the mbid.
   */
  public String getMbid()
  {
    return mbid;
  }

  /**
   * @param mbid The mbid to set.
   */
  public void setMbid( String mbid )
  {
    this.mbid = mbid;
  }

  /**
   * @return Returns the name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name The name to set.
   */
  public void setName( String name )
  {
    this.name = name;
  }

  /**
   * @return Returns the streamable.
   */
  public String getStreamable()
  {
    return streamable;
  }

  /**
   * @param streamable The streamable to set.
   */
  public void setStreamable( String streamable )
  {
    this.streamable = streamable;
  }

  /**
   * @return Returns the url.
   */
  public String getUrl()
  {
    return url;
  }

  /**
   * @param url The url to set.
   */
  public void setUrl( String url )
  {
    this.url = url;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    String eol = System.getProperty( "line.separator" );
    StringBuffer buffer = new StringBuffer();
    buffer.append( "Name: " )
        .append( name )
        .append( eol );
    return buffer.toString();
  }

}
