/**
 * 
 */
package logicLayer;

import java.util.Arrays;

import javax.swing.table.TableModel;

import org.apache.commons.collections.MapUtils;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import dataLayer.DataService;
import dnl.utils.text.table.TextTable;

/**
 * @author plisik
 *
 */
public class OpenOfficeSaver implements Saver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.Saver#save(java.lang.String, dataLayer.DataService)
	 */

	String DataServiceToString(DataService data) {
		String out = "";
		out += "\nPERSONS \n";
		out += data.getAllPersons().toString();
		out += "\nEvents \n";
		out += data.getAllEvents();
		return out;
	}



	private String personsString(DataService data) {
		String out="";
		out += "\nPERSONS \n";
		out +=Arrays.toString(data.getAllPersons().entrySet().toArray());
		return out;
	}
	
	private String eventsString(DataService data) {
		String out="";
		out += "\nPERSONS \n";
		out +=Arrays.toString(data.getAllEvents().entrySet().toArray());
		return out;
	}

	/**
	 * Save current sate of {@link dataLayer.DataService} to OpenOfficeFile file
	 */
	@Override
	public void save(String filename, DataService data) throws LogicLayerException {

		OdfTextDocument odt;
		try {
			odt = OdfTextDocument.newTextDocument();
			odt.addText("Persons");
			odt.addText(personsString(data));
			odt.addText("Events");
			odt.addText(eventsString(data));
			odt.save(filename);
		} catch (Exception e) {
			throw new LogicLayerException(e.getMessage());

		}

	}

}
