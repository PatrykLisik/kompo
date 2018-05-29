/**
 * 
 */
package logicLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import dataLayer.DataService;

/**
 * Binary serializer - save  
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
	public DataService importData(String fileName) throws LogicLayerException {
		DataService data = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			data = (DataService) in.readObject();
		} catch (IOException i) {
			throw new LogicLayerException("File not found");
			//i.printStackTrace();
		} catch (ClassNotFoundException c) {
			throw new LogicLayerException("DataService class not found");
			//c.printStackTrace();
		}finally {
			if(fileIn!=null)
				try {
					fileIn.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return data;
	}

}
