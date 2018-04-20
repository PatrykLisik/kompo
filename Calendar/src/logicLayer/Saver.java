package logicLayer;

import dataLayer.DataService;

/**
 * Interface to abstract out  serialisation to different formats and exporting to different APIs
 * Corresponding Importer and Saver implementation should be compatible
 * @author plisik
 *
 */
public interface Saver {
	public void save(String filename,DataService data);

}
