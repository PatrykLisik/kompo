package gui.util;

import java.awt.Component;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import dataLayer.DataService;
import logicLayer.BinaryImporter;
import logicLayer.BinarySaver;
import logicLayer.Importer;
import logicLayer.LogicLayerException;
import logicLayer.LogicLayerFactory;
import logicLayer.LogicLayerImpl;
import logicLayer.OpenOfficeSaver;
import logicLayer.Saver;
import logicLayer.XMLImporter;
import logicLayer.XMLSaver;

/**
 * The Class SerializationHelper.
 * 
 * @author dwojcik
 */
public class SerializationHelper{
	
	private static class OperationLogic{
		Importer importer;
		Saver saver;
		String fileExtension;
		public OperationLogic(Importer importer, Saver saver, String fileExtension) {
			super();
			this.importer = importer;
			this.saver = saver;
			this.fileExtension=fileExtension;
		}
		public String getFileExtension() {
			return fileExtension;
		}
		
	}
	
	private static Map<FileFilter, OperationLogic> operators = new HashMap<>();
	
	static {
		FileFilter xmlFilter = new FileNameExtensionFilter("XML File", "xml");
		operators.put(xmlFilter, new OperationLogic(new XMLImporter(), new XMLSaver(),"xml"));
		FileFilter binaryFilter = new FileNameExtensionFilter("Binary data", "bin");
		operators.put(binaryFilter, new OperationLogic(new BinaryImporter(), new BinarySaver(),"bin"));
		FileFilter openOfficeFilter = new FileNameExtensionFilter("OpenOffice", "odt");
		operators.put(openOfficeFilter, new OperationLogic(null, new OpenOfficeSaver(),"odt"));
	}
	
	/**
	 * Load calendar.
	 *
	 * @param parent the parent
	 * @param defaultVal the default val
	 * @return the data service
	 */
	public static Optional<LogicLayerImpl> loadCalendar(Component parent) {
		JFileChooser fChooser = prepareFileChooser();
		int option = fChooser.showOpenDialog(parent);
		if(option != JFileChooser.APPROVE_OPTION) {
			return Optional.empty();
		}
		File selectedFile = fChooser.getSelectedFile();
		FileFilter selectedFilter = fChooser.getFileFilter();
		
		Importer importer = operators.get(selectedFilter).importer;
		try {
			return Optional.of(LogicLayerFactory.getLogicLayerNoSQL(selectedFile.getAbsolutePath(), importer));
		} catch (LogicLayerException | NullPointerException e ) {
			e.printStackTrace();
			 JOptionPane.showMessageDialog(parent, "Blad deserializacji", 
					 "Error: Nie udalo sie wczytac danych do pliku.", JOptionPane.ERROR_MESSAGE);
			 return Optional.empty();
		}
	}
	
	/**
	 * Save calendar.
	 *
	 * @param parent the parent
	 * @param service the service
	 */
	public static void saveCalendar(Component parent, LogicLayerImpl logicLayer) {
		JFileChooser fChooser = prepareFileChooser();
		int option =fChooser.showSaveDialog(parent);
		if(option != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File selectedFile = fChooser.getSelectedFile();
		FileFilter selectedFilter = fChooser.getFileFilter();
		
		OperationLogic operation =  operators.get(selectedFilter);
		Saver saver = operation.saver;
		try {
			String fileName= selectedFile.getAbsolutePath()+"."+operation.getFileExtension();
			logicLayer.save(fileName, saver);
		} catch (LogicLayerException e) {
			e.printStackTrace();
			 JOptionPane.showMessageDialog(parent, "Blad serializacji", 
					 "Error: Nie udalo sie zapisac danych do pliku.", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	private static JFileChooser prepareFileChooser() {
		JFileChooser fChooser = new JFileChooser();
		fChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fChooser.setAcceptAllFileFilterUsed(false);
		operators.keySet().stream().forEach(a->fChooser.addChoosableFileFilter(a));
		return fChooser;
	}

}
