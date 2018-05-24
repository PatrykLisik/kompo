/**
 * 
 */
package logicLayer;

import javax.swing.table.TableModel;

import org.odftoolkit.odfdom.doc.OdfTextDocument;

import dataLayer.DataService;
import dnl.utils.text.table.TextTable;

/**
 * @author plisik
 *
 */
public class OpenOfficeSaver implements Saver {

	/* (non-Javadoc)
	 * @see logicLayer.Saver#save(java.lang.String, dataLayer.DataService)
	 */
	@Override
	public void save(String filename, DataService data) throws LogicLayerException {
		TextTable tt= new TextTable((TableModel) data.getAllPersons());
		String out=tt.toString();
		
		OdfTextDocument odt;
		try {
			odt = OdfTextDocument.newTextDocument();
			odt.addText(out);
			odt.save(filename);
		} catch (Exception e) {
			throw new LogicLayerException(e.getMessage());
			
		}
		

	}

}
