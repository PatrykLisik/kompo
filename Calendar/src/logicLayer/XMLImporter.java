/**
 * 
 */
package logicLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import dataLayer.DataService;

/**
 * Importer implementation based on Xstrem which imports files saved in XML format 
 * @author plisik
 *
 */
public class XMLImporter implements Importer {

	/* (non-Javadoc)
	 * @see logicLayer.Importer#importData(java.lang.String)
	 */
	@Override
	public DataService importData(String fileName) {
		XStream xstream = new XStream(new StaxDriver());
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		DataService data = (DataService)xstream.fromXML(fileIn);
		return data;
	}

}
