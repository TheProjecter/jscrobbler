/** 
 * <p>Título: </p> 
 * <p>Archivo: Scrobbler.java</p> 
 * <p>Descripcion: </p> 
 * <p>Copyright: Copyright (c) 2007</p> 
 * @author José Luis Mayorga/Certum Jun 8, 2007 
 * @version  
 */
package org.jmayorga.jscrobbler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmayorga.jscrobbler.model.Artist;
import org.jmayorga.jscrobbler.model.MostKnownTracks;
import org.jmayorga.jscrobbler.model.SimilarArtists;
import org.jmayorga.jscrobbler.model.Track;
import org.xml.sax.SAXException;

public class Scrobbler {
  private static final Log log = LogFactory.getLog(Scrobbler.class);

  /**
   * Descripción:
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    // Get current time
    long start = System.currentTimeMillis();
    Scrobbler scrobbler = new Scrobbler();
    Collection<Artist> artists = scrobbler.getSimilarArtists("Sylver");
    int trackCount = 0;
    for (Iterator iter = artists.iterator(); iter.hasNext();)
    {
      Artist element = (Artist) iter.next();
      log.debug("Artist Match: [" + element.getMatch() + "]");
      if (element.getMatch() > 88)
      {
        MostKnownTracks knownTracks = scrobbler.getMostKnownTracks(element
            .getName().trim().replace(' ', '+').replaceAll("&", "%26"));
        if (null != knownTracks)
        {
          trackCount += knownTracks.getTracks().size();
        }
      }
    }
    log.debug("Total Similar Artists: [" + artists.size() + "]");

    log.debug("Total Tracks: [" + trackCount + "]");
    // Get elapsed time in seconds
    float elapsedTimeSec = (System.currentTimeMillis() - start) / 1000F;
    log.debug("Elapsed Time: [" + elapsedTimeSec + "] seconds");
  }

  public Collection<Artist> getSimilarArtists(String artist)
  {
    Collection<Artist> similarArtists = null;
    log.debug("Starting");

    Digester digester = new Digester();
    SimilarArtists digestedResult = null;
    try
    {
      URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/" + artist
          + "/similar.xml");

      digester.setValidating(false);
      digester.addObjectCreate("similarartists", SimilarArtists.class);
      digester.addSetProperties("similarartists");
      digester.addObjectCreate("similarartists/artist", Artist.class);
      digester.addBeanPropertySetter("similarartists/artist/name", "name");
      digester.addBeanPropertySetter("similarartists/artist/mbid", "mbid");
      digester.addBeanPropertySetter("similarartists/artist/match", "match");
      digester.addBeanPropertySetter("similarartists/artist/url", "url");
      digester.addBeanPropertySetter("similarartists/artist/image_small",
          "image_small");
      digester.addBeanPropertySetter("similarartists/artist/image", "image");
      digester.addBeanPropertySetter("similarartists/artist/streamable",
          "streamable");

      digester.addSetNext("similarartists/artist", "addArtist");

      digestedResult = (SimilarArtists) digester.parse(url);
      similarArtists = digestedResult.getRelatedArtists();
      log.debug("Result: " + digestedResult);

    }
    catch (MalformedURLException e)
    {
      log.error("Malformed URL, ", e);
    }
    catch (FileNotFoundException e)
    {
      log.error("Artist with name: [" + artist + "] was not found");
    }
    catch (IOException e)
    {
      log.error("IOException, ", e);
    }
    catch (SAXException e)
    {
      log.error("SAXException, ", e);
    }
    return similarArtists;
  }

  public MostKnownTracks getMostKnownTracks(String artist)
  {
    log.debug("Starting");

    Digester digester = new Digester();
    MostKnownTracks digestedResult = null;
    try
    {
      URL url = new URL("http://ws.audioscrobbler.com/1.0/artist/" + artist
          + "/toptracks.xml");
      digester.setValidating(false);

      digester.addObjectCreate("mostknowntracks", MostKnownTracks.class);
      digester.addSetProperties("mostknowntracks");
      digester.addObjectCreate("mostknowntracks/track", Track.class);
      digester.addBeanPropertySetter("mostknowntracks/track/name", "name");
      digester.addBeanPropertySetter("mostknowntracks/track/mbid", "mbid");
      digester.addBeanPropertySetter("mostknowntracks/track/reach", "reach");
      digester.addBeanPropertySetter("mostknowntracks/track/url", "url");
      digester.addSetNext("mostknowntracks/track", "addTrack");

      digestedResult = (MostKnownTracks) digester.parse(url);
      log.debug("Result: " + digestedResult);

    }
    catch (MalformedURLException e)
    {
      log.error("Malformed URL, ", e);
    }
    catch (FileNotFoundException e)
    {
      log.error("Artist with name: [" + artist + "] was not found");
    }
    catch (IOException e)
    {
      log.error("IOException, ", e);
    }
    catch (SAXException e)
    {
      log.error("SAXException, ", e);
    }
    return digestedResult;
  }
}
