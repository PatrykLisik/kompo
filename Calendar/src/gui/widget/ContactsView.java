package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import dataLayer.Person;
import gui.popup.ContactCreator;
import gui.util.StateContainer;

import java.awt.SystemColor;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;


// TODO: Auto-generated Javadoc
/**
 * 
 * A class that is responsible for a contacts view. 
 * 
 * @author dwojcik
 *
 */

public class ContactsView extends JPanel implements ActionListener{

	private static final String REMOVE_CONTACT = "RC";
	private static final String ADD_CONTACT = "AC";
	private JList<Person> contactsList;
	private StateContainer stateContainer;


	/**
	 * Instantiates a new contacts view.
	 */
	public ContactsView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		contactsList = new JList<Person>();
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
		btnDodajKontakt.setActionCommand(ADD_CONTACT);
		btnDodajKontakt.addActionListener(this);
		GridBagConstraints gbc_btnDodajKontakt = new GridBagConstraints();
		gbc_btnDodajKontakt.anchor = GridBagConstraints.EAST;
		gbc_btnDodajKontakt.insets = new Insets(0, 0, 0, 5);
		gbc_btnDodajKontakt.gridx = 0;
		gbc_btnDodajKontakt.gridy = 1;
		add(btnDodajKontakt, gbc_btnDodajKontakt);

		JButton btnUsuKontakt = new JButton("Usu\u0144 kontakt");
		btnUsuKontakt.setActionCommand(REMOVE_CONTACT);
		btnUsuKontakt.addActionListener(this);
		GridBagConstraints gbc_btnUsuKontakt = new GridBagConstraints();
		gbc_btnUsuKontakt.gridx = 1;
		gbc_btnUsuKontakt.gridy = 1;
		add(btnUsuKontakt, gbc_btnUsuKontakt);

	}

	/**
	 * Sets the state container.
	 *
	 * @param state the new state container
	 */
	public void setStateContainer(StateContainer state) {
		this.stateContainer=state;
		updateContacts();
	}
	
	/**
	 * Update all contact. 
	 */

	public void updateContacts() {
		DefaultListModel<Person> listModel = new DefaultListModel<Person>();
		Map<Integer, Person> map = stateContainer.getLogic().getAllPersons();
		for(Entry<Integer, Person> p:map.entrySet()) {
			listModel.addElement(p.getValue());
		}
		contactsList.setModel(listModel);
	}
	
	/**
	 * Delete selected contact. 
	 * If none has been selected return error message.
	 * Update contacts.
	 */

	public void onDeleteContact() {
		int index = contactsList.getSelectedIndex();
		if(index <0) {
			 JOptionPane.showMessageDialog(this, "Nie wybrano kontaktu do usuniecia", 
					 "Error: Brak zaznaczonego kontaktu", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Person p = contactsList.getModel().getElementAt(index);
		stateContainer.getLogic().deletePerson(p);
		updateContacts();
	}

	/**
	 * Create action after OK button clicked. 
	 * The method create Person and update contacts.
	 */
	public void onAddContact() {
		ContactCreator contactCreator = new ContactCreator();
		contactCreator.setVisible(true);
		if(contactCreator.getReturnCommand() != null && 
				contactCreator.getReturnCommand().equals(ContactCreator.OK_OPTION)) {
			stateContainer.getLogic().createPerson(contactCreator.getFirstname(),contactCreator.getLastname());
			this.updateContacts();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case ADD_CONTACT: onAddContact();break;
		case REMOVE_CONTACT: onDeleteContact();break;
		}
	}
}
