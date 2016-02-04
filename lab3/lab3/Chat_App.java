package lab3;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JEditorPane;


public class Chat_App extends JFrame {
	
	
	
	static private JButton btnNewButton;
	static private JPanel contentPane;
	static private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat_App frame = new Chat_App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chat_App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 48, 444, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setBounds(6, 6, 75, 39);
		panel.add(lblNewLabel);
		
		
		JLabel lblEnter = new JLabel("Enter your name:");
		lblEnter.setBounds(6, 59, 137, 16);
		panel.add(lblEnter);
		
		 btnNewButton = new JButton("Login");
		btnNewButton.setBounds(53, 218, 117, 29);
		contentPane.add(btnNewButton);
		
		
		textField.setBounds(26, 158, 188, 48);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
	public JTextField getJTextField(){
		
		
		return textField ;
		
		
	} 
	
	
}
