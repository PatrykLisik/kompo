package gui.widget;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dataLayer.Event;
import gui.popup.EventCreator;
import gui.util.StateContainer;

public class EventView extends JPanel implements ActionListener, MouseListener {
	private static final String EVENT_DETAILS_WINDOW_TITLE = "Szczegó³y wydarzenia";
	private static final String DELETE_EVENT = "EVENT_DELETE";
	private static final String DETAILS_EVENT = "EVENT_DETAILS";
	JLabel lblEventName;
	Event representedEvent;
	private StateContainer stateContainer;
	
	/**
	 * Create the panel.
	 */
	public EventView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
		lblEventName = new JLabel("Event name");
		lblEventName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEventName = new GridBagConstraints();
		gbc_lblEventName.anchor = GridBagConstraints.EAST;
		gbc_lblEventName.gridx = 0;
		gbc_lblEventName.gridy = 0;
		add(lblEventName, gbc_lblEventName);
		
		JPopupMenu popup= new JPopupMenu();
		JMenuItem deleteMenuItem = new JMenuItem("Usuñ");
		deleteMenuItem.setActionCommand(DELETE_EVENT);
		deleteMenuItem.addActionListener(this);
		
		JMenuItem detailsMenuItem = new JMenuItem("Szczegó³y");
		detailsMenuItem.setActionCommand(DETAILS_EVENT);
		detailsMenuItem.addActionListener(this);
		
		popup.add(deleteMenuItem);
		popup.add(detailsMenuItem);
		setComponentPopupMenu(popup);
		lblEventName.setComponentPopupMenu(popup);
		
		addMouseListener(this);
		lblEventName.addMouseListener(this);
	}
	
	public void setName(String text) {
		this.lblEventName.setText(text);
	}

	public Event getRepresentedEvent() {
		return representedEvent;
	}

	public void setRepresentedEvent(Event representedEvent) {
		this.representedEvent = representedEvent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case DELETE_EVENT: deleteEvent();break;
		case DETAILS_EVENT: detailsEvent();break;
		}
	}

	private void deleteEvent() {
		stateContainer.getLogic().deleteEvent(representedEvent);
		stateContainer.changeEvents();
	}

	private void detailsEvent() {
		EventCreator eventCreator = new EventCreator(representedEvent,EVENT_DETAILS_WINDOW_TITLE);
		eventCreator.setEditable(false);
		eventCreator.setVisible(true);			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(BorderFactory.createEmptyBorder());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setStateContainer(StateContainer stateContainer) {
		this.stateContainer = stateContainer;
	}
	

}
