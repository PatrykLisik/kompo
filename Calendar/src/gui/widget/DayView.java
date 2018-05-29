package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import dataLayer.Event;

import javax.swing.JList;
import java.awt.GridLayout;

public class DayView extends JPanel implements MouseListener{
	private JLabel lblDaynum;
	public JPanel eventsList;
	private Calendar representedDate;

	/**
	 * Create the panel.
	 */
	public DayView() {
		setBorder(new LineBorder(new Color(180, 180, 180), 2));
		setBackground(SystemColor.inactiveCaption);
		addMouseListener(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblDaynum = new JLabel("DayNum");
		lblDaynum.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDaynum = new GridBagConstraints();
		gbc_lblDaynum.insets = new Insets(0, 0, 5, 0);
		gbc_lblDaynum.anchor = GridBagConstraints.WEST;
		gbc_lblDaynum.gridx = 0;
		gbc_lblDaynum.gridy = 0;
		add(lblDaynum, gbc_lblDaynum);
		
		eventsList = new JPanel();
		eventsList.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_eventsList = new GridBagConstraints();
		gbc_eventsList.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventsList.gridx = 0;
		gbc_eventsList.gridy = 1;
		add(eventsList, gbc_eventsList);
		eventsList.setLayout(new BoxLayout(eventsList, BoxLayout.Y_AXIS));

	}

	public void setDayNum(int dayNumber) {
		lblDaynum.setText(Integer.toString(dayNumber));
	}
	
	public int getDayNum() {
		return Integer.parseInt(lblDaynum.getText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(SystemColor.activeCaption);	
		eventsList.setBackground(SystemColor.activeCaption);
	}
	

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(SystemColor.inactiveCaption);		
		eventsList.setBackground(SystemColor.inactiveCaption);
	}

	public Calendar getRepresentedDate() {
		return this.representedDate;
	}

	public void setRepresentedDate(Calendar dateClone) {
		this.representedDate = dateClone;
	}

}
