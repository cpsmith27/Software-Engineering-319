package lab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.format.TextStyle;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HelloWorldSwing2 extends JFrame {

	private JPanel contentPane;
	private static JTextField txtHelloWorldSwing;
	private static int displaySize=  8; 
	private static int displayStyle;
	private static JLabel lblHelloWorld = new JLabel("Hello world!");
	private static JButton btnShow = new JButton("Show!");
	private static JButton btnExit = new JButton("Exit");
	private static JLabel lblText = new JLabel("Text:");
	private static JComboBox<String> comboBox = new JComboBox();
	private static JRadioButton rdbtnItalic = new JRadioButton("Italic");
	private static JRadioButton rdbtnBoldItalic = new JRadioButton("Bold Italic");
	private static JRadioButton rdbtnPlain = new JRadioButton("Plain");
	private static JRadioButton rdbtnNewRadioButton = new JRadioButton("Bold");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					HelloWorldSwing2 frame = new HelloWorldSwing2();
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
	public HelloWorldSwing2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblText.setBounds(0, 6, 32, 50);
		contentPane.add(lblText);
		
		txtHelloWorldSwing = new JTextField();
		txtHelloWorldSwing.setText("Hello World ");
		txtHelloWorldSwing.setToolTipText("");
		txtHelloWorldSwing.setBounds(56, 18, 176, 26);
		contentPane.add(txtHelloWorldSwing);
		txtHelloWorldSwing.setColumns(10);
		
		
		
		// set up the combo box
		
		
		comboBox.addItem("Tiny");
		comboBox.addItem("Small");
		comboBox.addItem("Medium");
		comboBox.addItem("Large");
		
		
		comboBox.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent event) {
	    		  if (event.getStateChange() == ItemEvent.SELECTED) {
	    	          Object item = event.getItem();
	    	         
	    	          switch ((String)item) {
	    	          
	    	          case "Tiny":
	    	        	  displaySize = 8;
	    	        	  lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
	    	        	  break;
	    	          case "Small":
	    	        	  displaySize = 12;
	    	        	  lblHelloWorld .setFont(new Font("Arial", displayStyle, displaySize));
	    	        	  break;
	    	          case "Medium":
	    	        	  displaySize = 20;
	    	        	  lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
	    	        	  break;
	    	          case "Large":
	    	        	  displaySize = 28;
	    	        	  lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
	    	        	  break;
	    	          }
	    	          
				
			}
			}

			});
		
		
		
		
		comboBox.setToolTipText("");
		comboBox.setBounds(240, 6, 104, 50);
		contentPane.add(comboBox);
		
		
		
		rdbtnPlain.setBounds(0, 55, 200, 50);
		contentPane.add(rdbtnPlain);
		
		
		 rdbtnPlain.addActionListener(new ActionListener() {
		  		@Override
		  		public void actionPerformed(ActionEvent e) {
		  			displayStyle = Font.PLAIN;
		  			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
		  		}
		      });
		      
		     
		
		
		
		rdbtnNewRadioButton.setBounds(0, 90, 200, 50);
		contentPane.add(rdbtnNewRadioButton);
		
	
		 rdbtnNewRadioButton.addActionListener(new ActionListener() {
	    		@Override
	    		public void actionPerformed(ActionEvent e) {
	    			displayStyle = Font.BOLD;
	    			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
	    		}
	        });
	      
	    
		
		
		 
		rdbtnItalic.setBounds(0, 129, 200, 50);
		contentPane.add(rdbtnItalic);
	
		
		  rdbtnItalic.addActionListener(new ActionListener() {
	    		@Override
	    		public void actionPerformed(ActionEvent e) {
	    			displayStyle = Font.ITALIC;
	    			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
	    		}
	        });
	      
	      
		
		rdbtnBoldItalic.setBounds(0, 170, 200, 50);
		contentPane.add(rdbtnBoldItalic);
		
	
		rdbtnBoldItalic.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			displayStyle = Font.BOLD | Font.ITALIC;
    			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
    		}
        });
		
		
		
		btnShow.setBounds(97, 232, 117, 29);
		contentPane.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lblHelloWorld.getForeground() == Color.BLACK) {
					lblHelloWorld.setForeground(Color.RED);
				} else {
					lblHelloWorld.setForeground(Color.BLACK);
				}
			}
	      });
		
		
		btnExit.setBounds(277, 232, 117, 29);
		contentPane.add(btnExit);
		  btnExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
		      });
		
		
		lblHelloWorld.setBounds(173, 129, 200, 50);
		contentPane.add(lblHelloWorld);
		
		
		txtHelloWorldSwing.getDocument().addDocumentListener(new DocumentListener() {
	    	  public void changedUpdate(DocumentEvent e) {
	    		  update();
	    	  }
	    	  
	    	  public void removeUpdate(DocumentEvent e) {
	    		  update();
	    	  }
	    	  
	    	  public void insertUpdate(DocumentEvent e) {
	    		  update();
	    	  }
	    	  
	    	  public void update() {
	    		  lblHelloWorld.setText(txtHelloWorldSwing.getText());
	    	  }
	      });
		
		}
		
	
	/*

static void setupListeners() {
	btnShow.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (lblHelloWorld.getForeground() == Color.BLACK) {
				lblHelloWorld.setForeground(Color.RED);
			} else {
				lblHelloWorld.setForeground(Color.BLACK);
			}
		}
    });
    
    btnExit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
    });
          
    ((DocumentEvent) lblText).getDocument().addDocumentListener(new DocumentListener() {
  	  public void changedUpdate(DocumentEvent e) {
  		  update();
  	  }
  	  
  	  public void removeUpdate(DocumentEvent e) {
  		  update();
  	  }
  	  
  	  public void insertUpdate(DocumentEvent e) {
  		  update();
  	  }
  	  
  	  public void update() {
  		  lblHelloWorld.setText(txtHelloWorldSwing.getText());
  	  }
    });
    
    comboBox.addItemListener(new ItemListener() {
  	  @Override
  	  public void itemStateChanged(ItemEvent event) {
  		  if (event.getStateChange() == ItemEvent.SELECTED) {
  	          Object item = event.getItem();
  	          switch ((String)item) {
  	          case "Tiny":
  	        	  displaySize = 8;
  	        	  lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  	        	  break;
  	          case "Small":
  	        	  displaySize = 12;
  	        	lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  	        	  break;
  	          case "Medium":
  	        	  displaySize = 20;
  	        	lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  	        	  break;
  	          case "Large":
  	        	  displaySize = 28;
  	        	lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  	        	  break;
  	          }
  	      }
  	  }     
    });
    
    rdbtnPlain.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			displayStyle = Font.PLAIN;
			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
		}
    });
    
    rdbtnNewRadioButton.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			displayStyle = Font.BOLD;
  			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  		}
      });
    
    rdbtnItalic.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			displayStyle = Font.ITALIC;
  			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  		}
      });
    
    rdbtnBoldItalic.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			displayStyle = Font.BOLD | Font.ITALIC;
  			lblHelloWorld.setFont(new Font("Arial", displayStyle, displaySize));
  		}
      });
      
}
*/
}


