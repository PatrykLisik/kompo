package gui.widget;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Month;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

import gui.popup.ContactCreator;
import gui.util.StateContainer;

public class Calendar extends JPanel implements ActionListener, ChangeListener{

	private JTextField txtMiesiac;
	private MonthView monthView;
	private JPanel calendar;
	private JTabbedPane tabbedPane;
	private JPanel contacts;
	private ContactsView contactsView;
	private JSpinner spinner;
	private StateContainer stateContainer;
	private static final String NEXT_MONTH = "NM";
	private static final String PREV_MONTH = "PM";

	/**
	 * Create the frame.
	 */
	public Calendar() {
		java.util.Calendar date = java.util.Calendar.getInstance();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {90, 0};
		gbl_contentPane.rowHeights = new int[] {20, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Panel.background"));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		add(tabbedPane, gbc_tabbedPane);
		
		calendar = new JPanel();
		calendar.setBackground(UIManager.getColor("Panel.background"));
		tabbedPane.addTab("Kalendarz", null, calendar, null);
		tabbedPane.setBackgroundAt(0, UIManager.getColor("Panel.background"));
		GridBagLayout gbl_calendar = new GridBagLayout();
		gbl_calendar.columnWidths = new int[] {90, 186, 63, 90, 0};
		gbl_calendar.rowHeights = new int[]{20, 49, 0};
		gbl_calendar.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_calendar.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		calendar.setLayout(gbl_calendar);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setActionCommand(PREV_MONTH);
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		calendar.add(btnNewButton, gbc_btnNewButton);
		
		txtMiesiac = new JTextField();
		txtMiesiac.setEditable(false);
		GridBagConstraints gbc_txtMiesiac = new GridBagConstraints();
		gbc_txtMiesiac.fill = GridBagConstraints.BOTH;
		gbc_txtMiesiac.insets = new Insets(0, 0, 5, 5);
		gbc_txtMiesiac.gridx = 1;
		gbc_txtMiesiac.gridy = 0;
		String monthName = new SimpleDateFormat("MMM").format(date.getTime());
		calendar.add(txtMiesiac, gbc_txtMiesiac);
		txtMiesiac.setHorizontalAlignment(SwingConstants.CENTER);
		txtMiesiac.setText(monthName);
		txtMiesiac.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1526162400000L), null, null, java.util.Calendar.YEAR));
		spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy"));
		spinner.addChangeListener(this);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 0;
		calendar.add(spinner, gbc_spinner);
		
		JButton btnNewButton_1 = new JButton("->");
		btnNewButton_1.setActionCommand(NEXT_MONTH);
		btnNewButton_1.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		calendar.add(btnNewButton_1, gbc_btnNewButton_1);
		
		monthView = new MonthView();
		GridBagConstraints gbc_monthView = new GridBagConstraints();
		gbc_monthView.fill = GridBagConstraints.BOTH;
		gbc_monthView.gridwidth = 4;
		gbc_monthView.gridx = 0;
		gbc_monthView.gridy = 1;
		calendar.add(monthView, gbc_monthView);
		
		
		contacts = new JPanel();
		tabbedPane.addTab("Kontakty", null, contacts, null);
		GridBagLayout gbl_contacts = new GridBagLayout();
		gbl_contacts.columnWidths = new int[]{0, 0};
		gbl_contacts.rowHeights = new int[]{0, 0};
		gbl_contacts.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contacts.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contacts.setLayout(gbl_contacts);
		
		contactsView = new ContactsView();
		GridBagConstraints gbc_contactsView = new GridBagConstraints();
		gbc_contactsView.fill = GridBagConstraints.BOTH;
		gbc_contactsView.gridx = 0;
		gbc_contactsView.gridy = 0;
		contacts.add(contactsView, gbc_contactsView);
	}

	public void setStateContainer(StateContainer state) {
		if(stateContainer!=null) {
			stateContainer.unregisterDateChaned(this);
		}
		this.stateContainer=state;
		stateContainer.addDateChangedListener(this);
		contactsView.setStateContainer(state);
		monthView.setStateContainer(state);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case NEXT_MONTH: stateContainer.changeMonth(1);break;
			case PREV_MONTH: stateContainer.changeMonth(-1);break;
			case StateContainer.DATE_CHANGED_COMMAND: reloadView();break;
		}
		
	}

	private void reloadView() {
		java.util.Calendar date = stateContainer.getDate();
		String nextMonth = new SimpleDateFormat("MMMMMMMMMM").format(date.getTime());
		txtMiesiac.setText(nextMonth);	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == spinner) {
			stateContainer.changeYearTo((Date) spinner.getValue());
		}
	}
}
