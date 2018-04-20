/**
 * 
 */
package logicLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import dataLayer.DataService;

/**
 * @author plisik
 *
 */
public class BinaryImporter implements Importer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.Importer#importData(java.lang.String)
	 */
	@Override
	public DataService importData(String fileName) {
		DataService data = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			data = (DataService) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("DataService class not found");
			c.printStackTrace();
		}
		System.out.println("DataService restore");
		return data;
	}

}
