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
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import dataLayer.Event;
import gui.popup.EventCreator;
import gui.util.StateContainer;


/**
 * The Class EventView.
 * 
 *  @author dwojcik
 *  
 */
public class EventView extends JPanel implements ActionListener, MouseListener {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant EVENT_DETAILS_WINDOW_TITLE. */
	private static final String EVENT_DETAILS_WINDOW_TITLE = "Szczegoly wydarzenia";
	
	/** The Constant DELETE_EVENT. */
	private static final String DELETE_EVENT = "EVENT_DELETE";
	
	/** The Constant DETAILS_EVENT. */
	private static final String DETAILS_EVENT = "EVENT_DETAILS";
	
	/** The lbl event name. */
	JLabel lblEventName;
	
	/** The represented event. */
	Event representedEvent;
	
	/** The state container. */
	private StateContainer stateContainer;
	
	/**
	 * Instantiates a new event view.
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
		JMenuItem deleteMenuItem = new JMenuItem("Usun");
		deleteMenuItem.setActionCommand(DELETE_EVENT);
		deleteMenuItem.addActionListener(this);
		
		JMenuItem detailsMenuItem = new JMenuItem("Szczegoly");
		detailsMenuItem.setActionCommand(DETAILS_EVENT);
		detailsMenuItem.addActionListener(this);
		
		popup.add(deleteMenuItem);
		popup.add(detailsMenuItem);
		setComponentPopupMenu(popup);
		lblEventName.setComponentPopupMenu(popup);
		
		addMouseListener(this);
		lblEventName.addMouseListener(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#setName(java.lang.String)
	 */
	public void setName(String text) {
		this.lblEventName.setText(text);
	}

	/**
	 * Gets the represented event.
	 *
	 * @return the represented event
	 */
	public Event getRepresentedEvent() {
		return representedEvent;
	}

	/**
	 * Sets the represented event.
	 *
	 * @param representedEvent the new represented event
	 */
	public void setRepresentedEvent(Event representedEvent) {
		this.representedEvent = representedEvent;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case DELETE_EVENT: deleteEvent();break;
		case DETAILS_EVENT: detailsEvent();break;
		}
	}

	/**
	 * Delete event.
	 */
	private void deleteEvent() {
		stateContainer.getLogic().deleteEvent(representedEvent);
		stateContainer.changeEvents();
	}

	/**
	 * Details event.
	 */
	private void detailsEvent() {
		EventCreator eventCreator = new EventCreator(representedEvent,EVENT_DETAILS_WINDOW_TITLE);
		eventCreator.setEditable(false);
		eventCreator.setVisible(true);			
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(BorderFactory.createEmptyBorder());
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

	/**
	 * Sets the state container.
	 *
	 * @param stateContainer the new state container
	 */
	public void setStateContainer(StateContainer stateContainer) {
		this.stateContainer = stateContainer;
	}
	

}
