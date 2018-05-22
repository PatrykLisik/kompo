package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.util.StateContainer;
import gui.widget.Calendar;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Calendar calendar = new Calendar();
		StateContainer container = new StateContainer();
		calendar.setStateContainer(container);
		container.setDate(java.util.Calendar.getInstance());
		frame.getContentPane().add(calendar);
	}

}
