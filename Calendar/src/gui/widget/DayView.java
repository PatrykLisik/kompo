package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.border.LineBorder;
import java.awt.Color;


/**
 * The Class DayView.
 * 
 * @author dwojcik
 * 
 */
public class DayView extends JPanel implements MouseListener{
	private JLabel lblDaynum;
	
	/** The events list. */
	public JPanel eventsList;
	private Calendar representedDate;


	/**
	 * Instantiates a new day view.
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

	/**
	 * Sets the day num.
	 *
	 * @param dayNumber the new day num
	 */
	public void setDayNum(int dayNumber) {
		lblDaynum.setText(Integer.toString(dayNumber));
	}
	
	/**
	 * Gets the day num.
	 *
	 * @return the day num
	 */
	public int getDayNum() {
		return Integer.parseInt(lblDaynum.getText());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(SystemColor.activeCaption);	
		eventsList.setBackground(SystemColor.activeCaption);
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(SystemColor.inactiveCaption);		
		eventsList.setBackground(SystemColor.inactiveCaption);
	}

	/**
	 * Gets the represented date.
	 *
	 * @return the represented date
	 */
	public Calendar getRepresentedDate() {
		return this.representedDate;
	}

	/**
	 * Sets the represented date.
	 *
	 * @param dateClone the new represented date
	 */
	public void setRepresentedDate(Calendar dateClone) {
		this.representedDate = dateClone;
	}

}
