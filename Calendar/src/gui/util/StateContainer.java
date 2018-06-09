package gui.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import logicLayer.LogicLayerFactory;
import logicLayer.LogicLayerSQLImpl;


// TODO: Auto-generated Javadoc
/**
 * The Class StateContainer.
 * 
 * @author dwojcik
 * 
 */
public class StateContainer {
	
	/** The Constant DATE_CHANGED_COMMAND. */
	public static final String DATE_CHANGED_COMMAND = "DATE_CHANGED";
	
	/** The Constant EVENT_CHANGED_COMMAND. */
	public static final String EVENT_CHANGED_COMMAND = "EVENT_CHANGED";

	/** The Constant CONTACTS_CHANGED_COMMAND. */
	public static final String CONTACTS_CHANGED_COMMAND = "CONTACT_CHANGED";
	private LogicLayerSQLImpl logicLayer;
	private java.util.Calendar date;
	private List<ActionListener> dateChangeListener = new ArrayList<>();
	private List<ActionListener> eventChangeListener = new ArrayList<>();
	private List<ActionListener> contactsChangedListener = new ArrayList<>();

	
	/**
	 * Instantiates a new state container.
	 */
	//TODO: Remove
	public StateContainer() {
		super();
		this.logicLayer = LogicLayerFactory.getLogicLayerSQL();
		this.date = java.util.Calendar.getInstance();
	}
	
	/**
	 * Gets the logic.
	 *
	 * @return the logic
	 */
	public LogicLayerSQLImpl getLogic() {
		return logicLayer;
	}
	
	private void triggerDateChanged() {
		ActionEvent event = new ActionEvent(this, 0, DATE_CHANGED_COMMAND);
		for(ActionListener l:this.dateChangeListener) {
			l.actionPerformed(event);
		}
	}

	/**
	 * Adds the date changed listener.
	 *
	 * @param listener the listener
	 */
	public void addDateChangedListener(ActionListener listener) {
		this.dateChangeListener.add(listener);
	}

	/**
	 * Change month.
	 *
	 * @param monthShift the month shift
	 */
	public void changeMonth(int monthShift) {
		if(date != null) {
			date.add(java.util.Calendar.MONTH, monthShift);
			triggerDateChanged();
		}
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public java.util.Calendar getDate() {
		return (Calendar) date.clone();
	}

	/**
	 * Unregister date changed.
	 *
	 * @param listener the listener
	 */
	public void unregisterDateChaned(ActionListener listener) {
		this.dateChangeListener.remove(listener);
	}

	/**
	 * Sets the date.
	 *
	 * @param instance the new date
	 */
	public void setDate(Calendar instance) {
		date= instance;
		triggerDateChanged();	
	}

	/**
	 * Change year to.
	 *
	 * @param value the value
	 */
	public void changeYearTo(Date value) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		int year = calendar.get(Calendar.YEAR);
		date.set(java.util.Calendar.YEAR, year);		
		triggerDateChanged();	
	}

	/**
	 * Change events.
	 */
	public void changeEvents() {
		triggerEventChanged();		
	}
	
	/**
	 * Adds the event changed listener.
	 *
	 * @param listener the listener
	 */
	public void addEventChangedListener(ActionListener listener) {
		this.eventChangeListener.add(listener);
	}

	private void triggerEventChanged() {
		ActionEvent event = new ActionEvent(this, 0, EVENT_CHANGED_COMMAND);
		for(ActionListener l:this.eventChangeListener) {
			l.actionPerformed(event);
		}
		
	}

	/**
	 * Sets the logic layer.
	 *
	 * @param logic the new logic layer
	 */
	public void setLogicLayer(LogicLayerSQLImpl logic) {
		this.logicLayer = logic;
		//Trigger everyone
		refresh();

	}
	
	public void refresh() {
		triggerDateChanged();
		triggerEventChanged();
		triggerContactsChanged();
	}

	private void triggerContactsChanged() {
		ActionEvent event = new ActionEvent(this, 0, CONTACTS_CHANGED_COMMAND);
		for(ActionListener l:this.contactsChangedListener) {
			l.actionPerformed(event);
		}

	}

	/**
	 * Register contact changed.
	 *
	 * @param listener the listener
	 */
	public void registerContactChanged(ActionListener listener) {
		contactsChangedListener.add(listener);		
	}

	/**
	 * Unregister contact changed.
	 *
	 * @param listener the listener
	 */
	public void unregisterContactChanged(ActionListener listener) {
		contactsChangedListener.remove(listener);
	}
}
