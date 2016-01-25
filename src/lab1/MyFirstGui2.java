package lab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyFirstGui2 {
    static JFrame frame;
    static JPanel contentPanel, inputPanel, middlePanel, fontTypePanel, displayPanel, buttonsPanel;
    static JLabel textStyleDisplay, errorLabel;
    static JTextField textField, timerTextField;
    static JComboBox<String> comboBox;
    static JRadioButton plain, bold, italic, boldItalic;
    static ButtonGroup radioButtons;
    static JButton show, exit;
    static JCheckBox checkBox;

    static int displaySize, displayStyle, displayTime;
    static Color displayColor;
    static String text, errorMessage, emptyError;
    static boolean clearAfterTime;
    static Timer timer;

    // create function for the frame
    static JFrame createFrame() {
        JFrame frame =  new JFrame ("helloWorldSwing!");
        frame.setSize(370, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    static void initializeValues() {
        displaySize = 8;
        displayStyle = Font.PLAIN;
        displayColor = Color.BLACK;
        text = "Hello World!";
        errorMessage = "Not a valid number.";
        emptyError = "                               ";
        displayTime = -1;
        clearAfterTime = false;
    }

    static JPanel createContent() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(Box.createRigidArea(new Dimension (0, 10)));

        // Create the input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(new JLabel("Text: "));

        textField = new JTextField(text);
        inputPanel.add(textField);

        comboBox = new JComboBox<String>();
        comboBox.addItem("Tiny");
        comboBox.addItem("Small");
        comboBox.addItem("Medium");
        comboBox.addItem("Large");
        inputPanel.add(comboBox);

        checkBox = new JCheckBox();
        checkBox.setSelected(clearAfterTime);
        inputPanel.add(checkBox);

        inputPanel.add(new JLabel("clear after:"));

        timerTextField = new JTextField();
        inputPanel.add(timerTextField);

        contentPanel.add(inputPanel);

        // Construct the middle panel
        middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));

        // Construct the font type panel
        fontTypePanel = new JPanel();
        fontTypePanel.setLayout(new BoxLayout(fontTypePanel, BoxLayout.Y_AXIS));
        plain = new JRadioButton("Plain");
        bold = new JRadioButton("Bold");
        italic = new JRadioButton("Italic");
        boldItalic = new JRadioButton("Bold Italic");
        radioButtons = new ButtonGroup();
        radioButtons.add(plain);
        radioButtons.add(bold);
        radioButtons.add(italic);
        radioButtons.add(boldItalic);
        fontTypePanel.add(plain);
        fontTypePanel.add(Box.createRigidArea(new Dimension (0, 5)));
        fontTypePanel.add(bold);
        fontTypePanel.add(Box.createRigidArea(new Dimension (0, 5)));
        fontTypePanel.add(italic);
        fontTypePanel.add(Box.createRigidArea(new Dimension (0, 5)));
        fontTypePanel.add(boldItalic);

        middlePanel.add(fontTypePanel);

        // Create display panel
        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        textStyleDisplay = new JLabel(text);
        textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
        textStyleDisplay.setForeground(displayColor);
        displayPanel.add(textStyleDisplay, BorderLayout.CENTER);

        middlePanel.add(Box.createRigidArea(new Dimension (60, 0)));
        middlePanel.add(displayPanel);
        contentPanel.add(middlePanel);

        // Create buttons panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        show = new JButton("Show!");
        buttonsPanel.add(show);

        errorLabel = new JLabel(emptyError);
        buttonsPanel.add(errorLabel);

        exit = new JButton("Exit");
        buttonsPanel.add(exit);

        contentPanel.add(buttonsPanel);
        contentPanel.add(Box.createRigidArea(new Dimension (0, 10)));

        return contentPanel;
    }

    static void setupListeners() {
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clearAfterTime && displayTime > 0 && displayTime <= 10) {
                    textStyleDisplay.setText(text);
                    timer = new Timer(10000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textStyleDisplay.setText("");
                            timer.stop();
                        }
                    });
                    timer.setInitialDelay(displayTime * 1000);
                    timer.start();
                } else if (displayTime > 10 || displayTime < 1) {
                    errorLabel.setText(errorMessage);
                }
            }
        });


        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                clearAfterTime = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        timerTextField.getDocument().addDocumentListener(new DocumentListener() {
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
                try {
                    displayTime = Integer.parseInt(timerTextField.getText());
                    if (displayTime <= 10 && displayTime > 0) {
                        errorLabel.setText(emptyError);
                    }
                } catch (Exception e) {
                    displayTime = -1;
                    errorLabel.setText(errorMessage);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                text = textField.getText();
                textStyleDisplay.setText(textField.getText());
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
                            textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
                            break;
                        case "Small":
                            displaySize = 12;
                            textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
                            break;
                        case "Medium":
                            displaySize = 20;
                            textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
                            break;
                        case "Large":
                            displaySize = 28;
                            textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
                            break;
                    }
                }
            }
        });

        plain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStyle = Font.PLAIN;
                textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
            }
        });

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStyle = Font.BOLD;
                textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
            }
        });

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStyle = Font.ITALIC;
                textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
            }
        });

        boldItalic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStyle = Font.BOLD | Font.ITALIC;
                textStyleDisplay.setFont(new Font("Arial", displayStyle, displaySize));
            }
        });
    }

    public static void main(String[] args) {
        initializeValues();
        frame = createFrame();
        frame.setContentPane(createContent());
        setupListeners();

        frame.setVisible(true);
    }

}
