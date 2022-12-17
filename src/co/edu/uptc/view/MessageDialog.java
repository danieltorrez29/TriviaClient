package co.edu.uptc.view;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * MessageDialog class
 * 
 * @author Daniel Torres
 */

public class MessageDialog extends JDialog {

	/**
	 * Serial version UID constant
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * confirmMessageDialog void method
	 * 
	 * @param frame
	 * @param message
	 */

	public static void confirmMessageDialog(JFrame frame, String message) {
		JOptionPane.showConfirmDialog(frame, message, "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("resources/images/checked.png"));
	}

	/**
	 * 
	 * erroMessageDialog void method
	 * 
	 * @param frame
	 * @param message
	 */

	public static void errorMessageDialog(JFrame frame, String message) {
		JOptionPane.showConfirmDialog(frame, message, "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("resources/images/error.png"));
	}

}
