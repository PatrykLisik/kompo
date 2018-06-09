package gui.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;
import dataLayer.Event;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



/**
 * The Class EventCreator.
 * 
 * @author dwojcik
 * 
 */
@SuppressWarnings("serial")
public class EventCreator extends JDialog implements ActionListener{
	private JTextField eventNameField;
	private String returnCommand;
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private JButton okButton;
	
	/** The Constant CANCEL_OPTION. */
	public static final String CANCEL_OPTION = "Cancel";
	
	/** The Constant OK_OPTION. */
	public static final String OK_OPTION = "OK";
	private GridBagConstraints gbc_eventNameLbl;
	private GridBagConstraints gbc_eventStartLbl;
	private GridBagConstraints gbc_windowTitleLbl;
	private GridBagConstraints gbc_eventEndLbl;
	
	/**
	 * Instantiates a new event creator.
	 *
	 * @param data the data
	 * @param windowTitle the window title
	 */
	public EventCreator(Event data, String windowTitle) {
		this();
		this.eventNameField.setText(data.getName());
		this.startDateChooser.setDate(data.getStart());
		this.endDateChooser.setDate(data.getEnd());
		setTitle(windowTitle);
	}
	
	/**
	 * Instantiates a new event creator.
	 */
	public EventCreator() {
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Dodawanie wydarzenia");
		setBounds(100, 100, 467, 197);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		Label windowTitleLbl = new Label("WYDARZENIE");
		gbc_windowTitleLbl = new GridBagConstraints();
		gbc_windowTitleLbl.gridwidth = 3;
		gbc_windowTitleLbl.insets = new Insets(0, 0, 5, 0);
		gbc_windowTitleLbl.gridx = 0;
		gbc_windowTitleLbl.gridy = 0;
		getContentPane().add(windowTitleLbl, gbc_windowTitleLbl);
		
		
		Label eventNameLbl = new Label("Nazwa wydarzenia");
		gbc_eventNameLbl = new GridBagConstraints();
		gbc_eventNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc_eventNameLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventNameLbl.gridx = 0;
		gbc_eventNameLbl.gridy = 1;
		getContentPane().add(eventNameLbl, gbc_eventNameLbl);
		
		
		eventNameField = new JTextField();
		eventNameField.setName("Event Name");
		GridBagConstraints gbc_eventNameField_1 = new GridBagConstraints();
		gbc_eventNameField_1.gridwidth = 2;
		gbc_eventNameField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventNameField_1.insets = new Insets(0, 0, 5, 0);
		gbc_eventNameField_1.gridx = 1;
		gbc_eventNameField_1.gridy = 1;
		getContentPane().add(eventNameField, gbc_eventNameField_1);
		eventNameField.setColumns(10);
		
		Label eventStartLbl = new Label("Data rozpocz\u0119cia");
		gbc_eventStartLbl = new GridBagConstraints();
		gbc_eventStartLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventStartLbl.insets = new Insets(0, 0, 5, 5);
		gbc_eventStartLbl.gridx = 0;
		gbc_eventStartLbl.gridy = 2;
		getContentPane().add(eventStartLbl, gbc_eventStartLbl);
		
		startDateChooser = new JDateChooser();
		GridBagConstraints gbc_startDateChooser_1 = new GridBagConstraints();
		gbc_startDateChooser_1.gridwidth = 2;
		gbc_startDateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDateChooser_1.insets = new Insets(0, 0, 5, 0);
		gbc_startDateChooser_1.gridx = 1;
		gbc_startDateChooser_1.gridy = 2;
		getContentPane().add(startDateChooser, gbc_startDateChooser_1);
		
		Label eventEndLbl = new Label("Data zako\u0144czenia");
		gbc_eventEndLbl = new GridBagConstraints();
		gbc_eventEndLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventEndLbl.insets = new Insets(0, 0, 5, 5);
		gbc_eventEndLbl.gridx = 0;
		gbc_eventEndLbl.gridy = 3;
		getContentPane().add(eventEndLbl, gbc_eventEndLbl);
		
		JButton cancelButton = new JButton("Anuluj");
		cancelButton.addActionListener(this);
		
		endDateChooser = new JDateChooser();
		GridBagConstraints gbc_endDateChooser_1 = new GridBagConstraints();
		gbc_endDateChooser_1.gridwidth = 2;
		gbc_endDateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDateChooser_1.insets = new Insets(0, 0, 5, 0);
		gbc_endDateChooser_1.gridx = 1;
		gbc_endDateChooser_1.gridy = 3;
		getContentPane().add(endDateChooser, gbc_endDateChooser_1);
		


		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setActionCommand(OK_OPTION);
		GridBagConstraints gbc_okButton_1_1 = new GridBagConstraints();
		gbc_okButton_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_okButton_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_okButton_1_1.gridx = 1;
		gbc_okButton_1_1.gridy = 5;
		getContentPane().add(okButton, gbc_okButton_1_1);
		cancelButton.setActionCommand(CANCEL_OPTION);
		GridBagConstraints gbc_cancelButton_1 = new GridBagConstraints();
		gbc_cancelButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelButton_1.gridx = 2;
		gbc_cancelButton_1.gridy = 5;
		getContentPane().add(cancelButton, gbc_cancelButton_1);
		
	}
	

	/* 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == CANCEL_OPTION || validateFields()) {
			this.returnCommand = e.getActionCommand();
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "Nalezy wypelnic wszystkie pola", 
					 "Error: Brak wypelnionego pola", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validateFields() {
		return !getName().isEmpty() && getStartDate() != null && getEndDate()!=null;
	}


	/**
	 * Gets the return command.
	 *
	 * @return the return command
	 */
	public String getReturnCommand() {
		return returnCommand;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#getName()
	 */
	public String getName() {
		return eventNameField.getText();
	} 
	
	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDateChooser.getDate();
	}
	
	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDateChooser.getDate();
	}


	/**
	 * Sets the editable.
	 *
	 * @param b the new editable
	 */
	public void setEditable(boolean b) {
		eventNameField.setEditable(b);
		startDateChooser.setEnabled(b);
		endDateChooser.setEnabled(b);
		okButton.setVisible(b);
	}

}
