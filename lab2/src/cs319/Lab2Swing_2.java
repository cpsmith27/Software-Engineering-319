package cs319;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;

import java.awt.CardLayout;

import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Lab2Swing_2 extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> arr= new ArrayList<String>();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
	private JPanel panel_2 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2Swing_2 frame = new Lab2Swing_2();
					frame.setVisible(true);
					frame.reading_files();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lab2Swing_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// create tabs
		tabbedPane.setBounds(6, 6, 438, 266);
		contentPane.add(tabbedPane);
		
		// adding the lis tab
		tabbedPane.addTab("List", null, panel_2, null);
		
		panel_2.add(scrollPane);
		
		// adding the Tree panel to the tab
		tabbedPane.addTab("Tree", null, panel_1, null);
		
		//setting up the main panel 
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		tabbedPane.addTab("Table", null, panel, null);
			
	}
	
	public void reading_files() throws FileNotFoundException{
		
		DataModel data= new DataModel();
		
		arr=data.readfiles("/Users/christophersmith/workspace/lab2/src/cs319/companies.txt");
		int size = arr.size();
		String[] companies=  new String[size];
				
			for (int i=0;i<size;i++){
				
				companies[i]=arr.get(i);
				System.out.println(companies[i]);
			}
		JList <String>myList = new JList<String>(companies);
		
		scrollPane = new JScrollPane(myList);
		
	}
	
}
