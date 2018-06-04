package gui.widget;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dataLayer.DataService;
import dataLayer.DataServiceSQL;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import gui.popup.EventCreator;
import gui.util.SerializationHelper;
import gui.util.StateContainer;
import logicLayer.LogicLayer;
import logicLayer.LogicLayerImpl;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

// TODO: Auto-generated Javadoc
/**
 * 
 * A class that implements a base calendar view. 
 * 
 * @author dwojcik
 *
 */

public class Calendar extends JPanel implements ActionListener, ChangeListener{

	private static final String SAVE_CALENDAR = "Zapisz";
	private static final String CONNECT_WITH_DATABASE = "Po\u0142\u0105cz z baz\u0105";
	private static final String LOAD_CALENDAR = "Wczytaj";
	private static final String DATA_OPTION = "Dane";
	private static final String OPTIONS_MENU = "Opcje";
	private static final String ADD_EVENT_OPTION = "Dodaj wydarzenie";
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
	private static final String ADD_EVENT = "AE";
	private JMenuBar menuBar;
	private JMenu mnOptions;
	private JMenuItem mntmDodaj;
	private JMenu mnDane;
	private JMenuItem mntmWczytaj;
	private JMenuItem mntmZapisz;
	private JMenuItem mntmPolaczZBaza;


	/**
	 * Instantiates a new calendar.
	 */
	public Calendar() {
		java.util.Calendar date = java.util.Calendar.getInstance();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		String monthName = new SimpleDateFormat("MMM").format(date.getTime());
		setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		mnOptions = new JMenu(OPTIONS_MENU);
		menuBar.add(mnOptions);
		
		mntmDodaj = new JMenuItem(ADD_EVENT_OPTION);
		mntmDodaj.addActionListener(this);
		mntmDodaj.setActionCommand(ADD_EVENT);
		mnOptions.add(mntmDodaj);
		
		mnDane = new JMenu(DATA_OPTION);
		menuBar.add(mnDane);
		
		mntmWczytaj = new JMenuItem(LOAD_CALENDAR);
		mntmWczytaj.addActionListener(a -> {
			DataService loadedService = SerializationHelper.loadCalendar(this,Calendar.this.stateContainer.getLogic().getDataService());
			LogicLayer logic = new LogicLayerImpl(loadedService);
			Calendar.this.stateContainer.setLogicLayer(logic);
			});
		mnDane.add(mntmWczytaj);
		
		mntmZapisz = new JMenuItem(SAVE_CALENDAR);
		mntmZapisz.addActionListener(a -> {
			DataService service = Calendar.this.stateContainer.getLogic().getDataService();
			SerializationHelper.saveCalendar(this, service);	
			});
		mnDane.add(mntmZapisz);
		
		mntmPolaczZBaza = new JMenuItem(CONNECT_WITH_DATABASE);
		mntmPolaczZBaza.addActionListener(a -> {
			DataService data = new DataServiceSQL();
			LogicLayer logic = new LogicLayerImpl(data);
			Calendar.this.stateContainer.setLogicLayer(logic);
			});
		mnDane.add(mntmPolaczZBaza);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Panel.background"));
		add(tabbedPane);
		
		calendar = new JPanel();
		calendar.setBackground(UIManager.getColor("Panel.background"));
		tabbedPane.addTab("Kalendarz", null, calendar, null);
		tabbedPane.setBackgroundAt(0, UIManager.getColor("Panel.background"));
		GridBagLayout gbl_calendar = new GridBagLayout();
		gbl_calendar.columnWidths = new int[] {90, 186, 63, 90, 0};
		gbl_calendar.rowHeights = new int[]{20, 0, 0, 49, 0};
		gbl_calendar.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_calendar.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		calendar.setLayout(gbl_calendar);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setActionCommand(PREV_MONTH);
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		calendar.add(btnNewButton, gbc_btnNewButton);
		
		txtMiesiac = new JTextField();
		txtMiesiac.setEditable(false);
		GridBagConstraints gbc_txtMiesiac = new GridBagConstraints();
		gbc_txtMiesiac.fill = GridBagConstraints.BOTH;
		gbc_txtMiesiac.insets = new Insets(0, 0, 5, 5);
		gbc_txtMiesiac.gridx = 1;
		gbc_txtMiesiac.gridy = 1;
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
		gbc_spinner.gridy = 1;
		calendar.add(spinner, gbc_spinner);
		
		JButton btnNewButton_1 = new JButton("->");
		btnNewButton_1.setActionCommand(NEXT_MONTH);
		btnNewButton_1.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 1;
		calendar.add(btnNewButton_1, gbc_btnNewButton_1);
		
		monthView = new MonthView();
		GridBagConstraints gbc_monthView = new GridBagConstraints();
		gbc_monthView.gridheight = 2;
		gbc_monthView.fill = GridBagConstraints.BOTH;
		gbc_monthView.gridwidth = 4;
		gbc_monthView.gridx = 0;
		gbc_monthView.gridy = 2;
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

	/**
	 * Sets the state container.
	 *
	 * @param state the new state container
	 */
	public void setStateContainer(StateContainer state) {
		if(stateContainer!=null) {
			stateContainer.unregisterDateChaned(this);
		}
		this.stateContainer=state;
		stateContainer.addDateChangedListener(this);
		stateContainer.addEventChangedListener(this);
		contactsView.setStateContainer(state);
		monthView.setStateContainer(state);
	}
	
	private void reloadView() {
		java.util.Calendar date = stateContainer.getDate();
		String nextMonth = new SimpleDateFormat("MMMMMMMMMM").format(date.getTime());
		txtMiesiac.setText(nextMonth);	
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == spinner) {
			stateContainer.changeYearTo((Date) spinner.getValue());
		}
	}
	
	/**
	 * Creates the event.
	 */
	public void createEvent() {
		EventCreator eventCreator = new EventCreator();
		eventCreator.setVisible(true);
		if(eventCreator.getReturnCommand() != null && 
				eventCreator.getReturnCommand().equals(EventCreator.OK_OPTION)) {
			stateContainer.getLogic().createEvent(eventCreator.getName(),eventCreator.getStartDate(), eventCreator.getEndDate());	
		}			
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case NEXT_MONTH: stateContainer.changeMonth(1);break;
			case PREV_MONTH: stateContainer.changeMonth(-1);break;
			case StateContainer.DATE_CHANGED_COMMAND: reloadView();break;
			case ADD_EVENT: createEvent(); stateContainer.changeEvents();break;
		}
	}
}
