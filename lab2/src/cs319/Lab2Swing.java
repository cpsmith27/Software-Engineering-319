package cs319;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

public class Lab2Swing extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2Swing frame = new Lab2Swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Lab2Swing() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 438, 266);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("List", null, panel_1, null);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 405, 175);
		panel_1.add(scrollPane);
		
		JList<String> list = new JList<String>();
		list.setSelectionBackground(Color.YELLOW);
		list.setModel(new DataModel());
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompanyDialog dialog = new NewCompanyDialog(list);
				dialog.setVisible(true);
			}
		});
		btnNewButton.setBounds(71, 185, 117, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				DataModel newDM;
				try {
					newDM = new DataModel();
					newDM.removeFromFile(index);
					list.setModel(newDM);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(227, 185, 117, 29);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tree", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 6, 405, 175);
		panel_2.add(scrollPane_1);
		
		JTree tree = new JTree();
		DefaultTreeModel treeModel = new DefaultTreeModel(new AnimalsTree());
		tree.setModel(treeModel);
		scrollPane_1.setViewportView(tree);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node != null) {
					NewNodeDialog dialog = new NewNodeDialog(node, treeModel);
					dialog.setVisible(true);
				} else {
					NewNodeDialog dialog = new NewNodeDialog((DefaultMutableTreeNode) treeModel.getRoot(), treeModel);
					dialog.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(71, 185, 117, 29);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node != null) {
					if (node == treeModel.getRoot()) {
						treeModel.setRoot(null);
					} else {
						treeModel.removeNodeFromParent(node);
					}
				}
			}
		});
		btnNewButton_3.setBounds(227, 185, 117, 29);
		panel_2.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Table", null, panel, null);
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
