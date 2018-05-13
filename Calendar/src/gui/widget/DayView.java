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

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JList;

public class DayView extends JPanel implements MouseListener{
	private JLabel lblDaynum;
	private JList taskList;

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
		
		taskList = new JList();
		taskList.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_taskList = new GridBagConstraints();
		gbc_taskList.fill = GridBagConstraints.BOTH;
		gbc_taskList.gridx = 0;
		gbc_taskList.gridy = 1;
		add(taskList, gbc_taskList);

	}

	public void setDayNum(int dayNumber) {
		lblDaynum.setText(Integer.toString(dayNumber));
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
		taskList.setBackground(SystemColor.activeCaption);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(SystemColor.inactiveCaption);		
		taskList.setBackground(SystemColor.inactiveCaption);
	}

}
