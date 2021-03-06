package gui.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


/**
 * The Class ContactCreator.
 * 
 * @author dwojcik
 * 
 */
@SuppressWarnings("serial")
public class ContactCreator extends JDialog implements ActionListener{

	/** The Constant CANCEL_OPTION. */
	public static final String CANCEL_OPTION = "Cancel";
	
	/** The Constant OK_OPTION. */
	public static final String OK_OPTION = "OK";
	private final JPanel contentPanel = new JPanel();
	private JTextField lastnameField;
	private JTextField firstnameField;
	private String returnCommand;

	/**
	 * Create the dialog.
	 */
	public ContactCreator() {
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Dodawanie kontaktu");
		setBounds(100, 100, 250, 143);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblImie = new JLabel("Imie:");
			GridBagConstraints gbc_lblImie = new GridBagConstraints();
			gbc_lblImie.insets = new Insets(0, 0, 5, 5);
			gbc_lblImie.anchor = GridBagConstraints.EAST;
			gbc_lblImie.gridx = 0;
			gbc_lblImie.gridy = 0;
			contentPanel.add(lblImie, gbc_lblImie);
		}
		{
			firstnameField = new JTextField();
			GridBagConstraints gbc_firstnameField = new GridBagConstraints();
			gbc_firstnameField.insets = new Insets(0, 0, 5, 0);
			gbc_firstnameField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstnameField.gridx = 1;
			gbc_firstnameField.gridy = 0;
			contentPanel.add(firstnameField, gbc_firstnameField);
			firstnameField.setColumns(10);
		}
		{
			JLabel lblNazwisko = new JLabel("Nazwisko");
			GridBagConstraints gbc_lblNazwisko = new GridBagConstraints();
			gbc_lblNazwisko.insets = new Insets(0, 0, 0, 5);
			gbc_lblNazwisko.anchor = GridBagConstraints.EAST;
			gbc_lblNazwisko.gridx = 0;
			gbc_lblNazwisko.gridy = 1;
			contentPanel.add(lblNazwisko, gbc_lblNazwisko);
		}
		{
			lastnameField = new JTextField();
			GridBagConstraints gbc_lastnameField = new GridBagConstraints();
			gbc_lastnameField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lastnameField.gridx = 1;
			gbc_lastnameField.gridy = 1;
			contentPanel.add(lastnameField, gbc_lastnameField);
			lastnameField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj");
				okButton.addActionListener(this);
				okButton.setActionCommand(OK_OPTION);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand(CANCEL_OPTION);
				buttonPane.add(cancelButton);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.returnCommand = e.getActionCommand();
		this.dispose();
	}

	/**
	 * Gets the return command.
	 *
	 * @return the return command
	 */
	public String getReturnCommand() {
		return returnCommand;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstnameField.getText();
	} 
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastnameField.getText();
	}
}
