/**
 * 
 */
package logicLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import dataLayer.DataService;

/**
 * Implementation of saver which uses Xstream to save data in XML format 
 * @author plisik
 *
 */
public class XMLSaver implements Saver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.Saver#save(java.lang.String, dataLayer.DataService)
	 */
	@Override
	public void save(String filename, DataService data) {
		XStream xstream = new XStream(new StaxDriver());
		try {
			xstream.toXML(data,new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
