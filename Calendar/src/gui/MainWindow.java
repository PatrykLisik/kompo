package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.util.StateContainer;
import gui.widget.Calendar;
import logicLayer.LogicLayerException;


/**
 * The Class MainWindow.
 * 
 * @author dwojcik
 */
public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					window.frame.setTitle("Aplikacja kalendarz");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		try {
			initialize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws LogicLayerException 
	 */
	private void initialize() throws LogicLayerException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(900, 700);
		
		Calendar calendar = new Calendar();
		StateContainer container = new StateContainer();
		calendar.setStateContainer(container);
		frame.getContentPane().add(calendar);
	}

}
