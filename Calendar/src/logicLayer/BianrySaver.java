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
 * @author plisik
 *
 */
public class BianrySaver implements Saver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.Saver#save(java.lang.String, dataLayer.DataService)
	 */
	@Override
	public void save(String filename, DataService data) {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(filename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unexpected exception" + e.getMessage());
		} finally {
			try {
				out.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Unexpected exception" + e.getMessage());
			}

		}

	}
}
