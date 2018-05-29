package gui.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import dataLayer.DataService;
import javafx.stage.FileChooser;
import logicLayer.BinaryImporter;
import logicLayer.BinarySaver;
import logicLayer.Importer;
import logicLayer.LogicLayerException;
import logicLayer.OpenOfficeSaver;
import logicLayer.Saver;
import logicLayer.XMLImporter;
import logicLayer.XMLSaver;

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
		public Importer getImporter() {
			return importer;
		}
		public Saver getSaver() {
			return saver;
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
	
	public static DataService loadCalendar(Component parent,DataService defaultVal) {
		JFileChooser fChooser = prepareFileChooser();
		int option = fChooser.showOpenDialog(parent);
		if(option != JFileChooser.APPROVE_OPTION) {
			return defaultVal;
		}
		File selectedFile = fChooser.getSelectedFile();
		FileFilter selectedFilter = fChooser.getFileFilter();
		
		Importer importer = operators.get(selectedFilter).importer;
		try {
			return importer.importData(selectedFile.getAbsolutePath());
		} catch (LogicLayerException | NullPointerException e ) {
			e.printStackTrace();
			 JOptionPane.showMessageDialog(parent, "B³¹d deserializacji", 
					 "Error: Nie uda³o siê wczytaæ danych do pliku.", JOptionPane.ERROR_MESSAGE);
			return defaultVal;
		}
	}
	
	public static void saveCalendar(Component parent, DataService service) {
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
			saver.save(selectedFile.getAbsolutePath()+"."+operation.getFileExtension(), service);
		} catch (LogicLayerException e) {
			e.printStackTrace();
			 JOptionPane.showMessageDialog(parent, "B³¹d serializacji", 
					 "Error: Nie uda³o siê zapisaæ danych do pliku.", JOptionPane.ERROR_MESSAGE);
			
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
