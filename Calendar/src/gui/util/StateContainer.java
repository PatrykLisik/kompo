package gui.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dataLayer.Person;
import logicLayer.LogicLayer;
import logicLayer.LogicLayerNoSQL;

public class StateContainer {
	
	public static final String DATE_CHANGED_COMMAND = "DATE_CHANGED";
	private LogicLayer logicLayer;
	private java.util.Calendar date;
	private List<ActionListener> dateChangeListener = new ArrayList<>();

	public StateContainer(LogicLayer logicLayer) {
		super();
		this.logicLayer = logicLayer;
		this.date = java.util.Calendar.getInstance();
	}
	
	//TODO: Remove
	public StateContainer() {
		super();
		this.logicLayer = new LogicLayerNoSQL();
		this.date = java.util.Calendar.getInstance();
	}
	
	public LogicLayer getLogic() {
		return logicLayer;
	}
	
	private void triggerDateChanged() {
		ActionEvent event = new ActionEvent(this, 0, DATE_CHANGED_COMMAND);
		for(ActionListener l:this.dateChangeListener) {
			l.actionPerformed(event);
		}
	}

	public void addDateChangedListener(ActionListener listener) {
		this.dateChangeListener.add(listener);
	}

	public void changeMonth(int monthShift) {
		if(date != null) {
			date.add(java.util.Calendar.MONTH, monthShift);
			triggerDateChanged();
		}
	}

	public java.util.Calendar getDate() {
		return (Calendar) date.clone();
	}

	public void unregisterDateChaned(ActionListener listener) {
		this.dateChangeListener.remove(listener);
	}

	public void setDate(Calendar instance) {
		date= instance;
		triggerDateChanged();	
	}

	public void changeYearTo(Date value) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		int year = calendar.get(Calendar.YEAR);
		date.set(java.util.Calendar.YEAR, year);		
		triggerDateChanged();	
	}
}
