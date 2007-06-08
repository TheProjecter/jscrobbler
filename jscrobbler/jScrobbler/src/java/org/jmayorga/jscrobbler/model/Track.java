/**
 * @author José Luis Mayorga Jun 8, 2007
 * @version
 */
package org.jmayorga.jscrobbler.model;

public class Track
{

  private String name;

  private String mbid;

  private String reach;

  private String url;

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
   * @return Returns the reach.
   */
  public String getReach()
  {
    return reach;
  }

  /**
   * @param reach The reach to set.
   */
  public void setReach( String reach )
  {
    this.reach = reach;
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
