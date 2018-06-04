package gui.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

/**
 * The Class InfoView.
 * 
 * @author dwojcik
 * 
 */
public class InfoView extends JDialog{
	
	private static InfoView INSTANCE = new InfoView();
	
	public static void makeVisible(boolean flag) {
		INSTANCE.setVisible(flag);
	}

	/**
	 * Instantiates a new info view.
	 */
	private InfoView() {
		setResizable(false);
		setSize(350,260);
		setAlwaysOnTop(true);
		setTitle("Calendar - informacje");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.columnWidths = new int[] {55, 242, 0};
		gridBagLayout.rowHeights = new int[] {52, 29, 33, 28, 0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCalendar = new JLabel("Calendar 1.0");
		GridBagConstraints gbc_lblCalendar = new GridBagConstraints();
		gbc_lblCalendar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCalendar.insets = new Insets(0, 0, 5, 0);
		gbc_lblCalendar.gridx = 1;
		gbc_lblCalendar.gridy = 0;
		getContentPane().add(lblCalendar, gbc_lblCalendar);
		
		JLabel lblNewLabel = new JLabel("2018-06-04");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Copyright (c) 2018 plisik dwojcik");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblCalendarJestProgramem = new JLabel("Calendar jest programem darmowym.");
		GridBagConstraints gbc_lblCalendarJestProgramem = new GridBagConstraints();
		gbc_lblCalendarJestProgramem.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCalendarJestProgramem.gridx = 1;
		gbc_lblCalendarJestProgramem.gridy = 3;
		getContentPane().add(lblCalendarJestProgramem, gbc_lblCalendarJestProgramem);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
