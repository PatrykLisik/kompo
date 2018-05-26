package gui.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class EventCreator extends JDialog implements ActionListener{
	private JTextField eventNameField;
	private String returnCommand;
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private final JPanel contentPanel = new JPanel();
	public static final String CANCEL_OPTION = "Cancel";
	public static final String OK_OPTION = "OK";
	
	
	public EventCreator() {
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Dodawanie wydarzenia");
		setBounds(100, 100, 467, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 215, 0, 0};
		gridBagLayout.rowHeights = new int[]{45, 0, 35, 31, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		Label label_3 = new Label("WYDARZENIE");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridwidth = 4;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		getContentPane().add(label_3, gbc_label_3);
		
		Label label = new Label("Nazwa wydarzenia");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);
		
		eventNameField = new JTextField();
		eventNameField.setName("");
		GridBagConstraints gbc_eventNameField = new GridBagConstraints();
		gbc_eventNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventNameField.insets = new Insets(0, 0, 5, 5);
		gbc_eventNameField.gridx = 2;
		gbc_eventNameField.gridy = 2;
		getContentPane().add(eventNameField, gbc_eventNameField);
		eventNameField.setColumns(10);
		
		Label label_1 = new Label("Data rozpocz\u0119cia");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		getContentPane().add(label_1, gbc_label_1);
		
		
		startDateChooser = new JDateChooser();
		GridBagConstraints gbc_startDateChooser = new GridBagConstraints();
		gbc_startDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_startDateChooser.fill = GridBagConstraints.BOTH;
		gbc_startDateChooser.gridx = 2;
		gbc_startDateChooser.gridy = 3;
		getContentPane().add(startDateChooser, gbc_startDateChooser);
		
		Label label_2 = new Label("Data zako\u0144czenia");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 4;
		getContentPane().add(label_2, gbc_label_2);
		
		endDateChooser = new JDateChooser();
		GridBagConstraints gbc_endDateChooser = new GridBagConstraints();
		gbc_endDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_endDateChooser.fill = GridBagConstraints.BOTH;
		gbc_endDateChooser.gridx = 2;
		gbc_endDateChooser.gridy = 4;
		getContentPane().add(endDateChooser, gbc_endDateChooser);
		
		JButton cancelButton = new JButton("Anuluj");
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand(CANCEL_OPTION);
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.EAST;
		gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 6;
		getContentPane().add(cancelButton, gbc_cancelButton);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setActionCommand(OK_OPTION);
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.WEST;
		gbc_okButton.insets = new Insets(0, 0, 5, 0);
		gbc_okButton.gridx = 3;
		gbc_okButton.gridy = 6;
		getContentPane().add(okButton, gbc_okButton);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		this.returnCommand = e.getActionCommand();
		this.dispose();
	}
	
	public String getReturnCommand() {
		return returnCommand;
	}
	
	public String getName() {
		return eventNameField.getText();
	} 
	
	public Date getStartDate() {
		return startDateChooser.getDate();
	}
	
	public Date getEndDate() {
		return endDateChooser.getDate();
	}

}
