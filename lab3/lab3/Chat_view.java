package lab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.Color;

public class Chat_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	Chat_App chatApp = new Chat_App();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat_view frame = new Chat_view();
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
	public Chat_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("send");
		btnSend.setBounds(276, 210, 117, 29);
		
		contentPane.add(btnSend);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(6, 213, 77, 21);
		contentPane.add(lblMessage);
		
		
		textField1 = new JTextField();
		textField1.setBounds(87, 203, 165, 41);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JPanel panel = new JPanel();
	
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 188, 185);
		
	
		contentPane.add(panel);
		
	}
	
	
	
	
}
