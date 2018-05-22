package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSeparator;

import gui.util.StateContainer;

import javax.swing.JCheckBox;

public class MonthView extends JPanel implements ActionListener{
	
	private List<DayView> days= new ArrayList<>();
	private StateContainer stateContainer;

	/**
	 * Create the panel.
	 */
	public MonthView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 2};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 2};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMon = new JLabel("Pon");
		GridBagConstraints gbc_lblMon = new GridBagConstraints();
		gbc_lblMon.insets = new Insets(0, 0, 5, 5);
		gbc_lblMon.gridx = 0;
		gbc_lblMon.gridy = 0;
		add(lblMon, gbc_lblMon);
		
		JLabel lblWtr = new JLabel("Wtr");
		GridBagConstraints gbc_lblWtr = new GridBagConstraints();
		gbc_lblWtr.insets = new Insets(0, 0, 5, 5);
		gbc_lblWtr.gridx = 1;
		gbc_lblWtr.gridy = 0;
		add(lblWtr, gbc_lblWtr);
		
		JLabel lblrd = new JLabel("\u015Ard");
		GridBagConstraints gbc_lblrd = new GridBagConstraints();
		gbc_lblrd.insets = new Insets(0, 0, 5, 5);
		gbc_lblrd.gridx = 2;
		gbc_lblrd.gridy = 0;
		add(lblrd, gbc_lblrd);
		
		JLabel lblCzwr = new JLabel("Czwr");
		GridBagConstraints gbc_lblCzwr = new GridBagConstraints();
		gbc_lblCzwr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCzwr.gridx = 3;
		gbc_lblCzwr.gridy = 0;
		add(lblCzwr, gbc_lblCzwr);
		
		JLabel lblPt = new JLabel("Pt");
		GridBagConstraints gbc_lblPt = new GridBagConstraints();
		gbc_lblPt.insets = new Insets(0, 0, 5, 5);
		gbc_lblPt.gridx = 4;
		gbc_lblPt.gridy = 0;
		add(lblPt, gbc_lblPt);
		
		JLabel lblSob = new JLabel("Sob");
		GridBagConstraints gbc_lblSob = new GridBagConstraints();
		gbc_lblSob.insets = new Insets(0, 0, 5, 5);
		gbc_lblSob.gridx = 5;
		gbc_lblSob.gridy = 0;
		add(lblSob, gbc_lblSob);
		
		JLabel lblNiedz = new JLabel("Niedz");
		GridBagConstraints gbc_lblNiedz = new GridBagConstraints();
		gbc_lblNiedz.insets = new Insets(0, 0, 5, 5);
		gbc_lblNiedz.gridx = 6;
		gbc_lblNiedz.gridy = 0;
		add(lblNiedz, gbc_lblNiedz);
		
		java.util.Calendar date = java.util.Calendar.getInstance();
		createDays(date);
	}

	private void createDays(java.util.Calendar date) {
			
		for(DayView comp: days) {
			remove(comp);
		}
		days.clear();
		date.set(java.util.Calendar.DAY_OF_MONTH,1);
		int firstDayWeekNum = date.get(java.util.Calendar.DAY_OF_WEEK)-1;
		if(firstDayWeekNum == 0) {
			firstDayWeekNum=7;
		}
		int daysInMounth = date.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		int counter = 0;
		for(int row=0;row<6;row++) {	
			for(int col=1;col<=7;col++) {
				int posNumber= row*7+col;
				if(posNumber>=firstDayWeekNum && posNumber< daysInMounth+firstDayWeekNum) {
					DayView day = new DayView();
					
					day.setDayNum(++counter);
					days.add(day);				
					
					GridBagConstraints gridConstraint = new GridBagConstraints();
					gridConstraint.insets = new Insets(0, 0, 5, 5);
					gridConstraint.gridx = col-1;
					gridConstraint.gridy = row+1;
					gridConstraint.fill=GridBagConstraints.BOTH;
					add(day, gridConstraint);
				}
			}
		}
	}

	public void setStateContainer(StateContainer state) {
		if(stateContainer!=null) {
			stateContainer.unregisterDateChaned(this);
		}
		this.stateContainer=state;
		stateContainer.addDateChangedListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case StateContainer.DATE_CHANGED_COMMAND: createDays(stateContainer.getDate());
		}
		this.repaint();
		this.revalidate();
	}

}
