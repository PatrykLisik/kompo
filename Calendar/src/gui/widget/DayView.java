package gui.widget;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class DayView extends JPanel {
	private JLabel lblDaynum;

	/**
	 * Create the panel.
	 */
	public DayView() {
		setBorder(new LineBorder(new Color(180, 180, 180), 2));
		setBackground(SystemColor.inactiveCaption);
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
		
		JPanel taskListPanel = new JPanel();
		taskListPanel.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_taskListPanel = new GridBagConstraints();
		gbc_taskListPanel.fill = GridBagConstraints.BOTH;
		gbc_taskListPanel.gridx = 0;
		gbc_taskListPanel.gridy = 1;
		add(taskListPanel, gbc_taskListPanel);
		taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

	}

	public void setDayNum(int dayNumber) {
		lblDaynum.setText(Integer.toString(dayNumber));
	}

}
