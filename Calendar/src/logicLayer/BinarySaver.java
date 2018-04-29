/**
 * 
 */
package logicLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import dataLayer.DataService;

/**
 * Basic binary Saver implementation based on java ObjectOutputStream 
 * @author plisik
 *
 */
public class BinarySaver implements Saver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.Saver#save(java.lang.String, dataLayer.DataService)
	 */
	@Override
	public void save(String filename, DataService data) throws LogicLayerException {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(filename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(data);

		} catch (FileNotFoundException e) {
			throw new LogicLayerException("Unable to create file");
		} catch (IOException e) {
			throw new LogicLayerException(e.getMessage());
		} catch (Exception e) {
			throw new LogicLayerException("Unexpected exception" + e.getMessage());
		} finally {
			try {
				out.close();
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				throw new LogicLayerException("Unexpected exception" + e.getMessage());
			}

		}

	}
}
