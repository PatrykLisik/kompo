/**
 * 
 */
package logicLayer;

import dataLayer.DataService;

/**
 * Interface that abstract out importing from different formats and APIs
 * Corresponding {@link logicLayer.Importer} and {@link logicLayer.Saver}  implementation should be compatible 
 * @author plisik
 *
 */
public interface Importer {
	public abstract DataService importData(String fileName) throws LogicLayerException; 

}
