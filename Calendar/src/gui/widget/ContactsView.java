package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;



public class ContactsView extends JPanel {

	private JList<String> contactsList;

	/**
	 * Create the panel.
	 */
	public ContactsView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		contactsList = new JList<String>();
		contactsList.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		contactsList.setBackground(SystemColor.text);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(5, 5, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(contactsList, gbc_list);
		
		JButton btnDodajKontakt = new JButton("Dodaj kontakt");
		GridBagConstraints gbc_btnDodajKontakt = new GridBagConstraints();
		gbc_btnDodajKontakt.anchor = GridBagConstraints.EAST;
		gbc_btnDodajKontakt.insets = new Insets(0, 0, 0, 5);
		gbc_btnDodajKontakt.gridx = 0;
		gbc_btnDodajKontakt.gridy = 1;
		add(btnDodajKontakt, gbc_btnDodajKontakt);
		
		JButton btnUsuKontakt = new JButton("Usu\u0144 kontakt");
		GridBagConstraints gbc_btnUsuKontakt = new GridBagConstraints();
		gbc_btnUsuKontakt.gridx = 1;
		gbc_btnUsuKontakt.gridy = 1;
		add(btnUsuKontakt, gbc_btnUsuKontakt);
		
		//TODO: remove - for demo
		setContacts();
	}
	
	public void setContacts() {
		//TODO: Change
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Jane Doe");
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");

		contactsList.setModel(listModel);
	}

}
