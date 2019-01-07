package myf.tool.myfCalc;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WndStupidCalc {

	private JFrame frame;

	private enum MyOperation {
		Null,
		Add,
		Minus,
		Multiply,
		Divide
	};
	
	private MyOperation myOperation = MyOperation.Add;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WndStupidCalc window = new WndStupidCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WndStupidCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MYF Stupid Calc - 171340236 Á—”Íˆ≠");
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextPane textPane1 = new JTextPane();
		GridBagConstraints gbc_textPane1 = new GridBagConstraints();
		gbc_textPane1.fill = GridBagConstraints.BOTH;
		gbc_textPane1.gridx = 0;
		gbc_textPane1.gridy = 0;
		gbc_textPane1.weightx = 0.2;
		gbc_textPane1.weighty = 0.5;
		panel.add(textPane1, gbc_textPane1);
		
		JLabel label1 = new JLabel();
		label1.setText("+");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.fill = GridBagConstraints.BOTH;
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 0;
		gbc_label1.weightx = 0.2;
		gbc_label1.weighty = 0.5;
		panel.add(label1, gbc_label1);
		
		JTextPane textPane2 = new JTextPane();
		GridBagConstraints gbc_textPane2 = new GridBagConstraints();
		gbc_textPane2.fill = GridBagConstraints.BOTH;
		gbc_textPane2.gridx = 2;
		gbc_textPane2.gridy = 0;
		gbc_textPane2.weightx = 0.2;
		gbc_textPane2.weighty = 0.5;
		panel.add(textPane2, gbc_textPane2);
		
		JLabel label2 = new JLabel();
		label2.setText("=");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.fill = GridBagConstraints.BOTH;
		gbc_label2.gridx = 3;
		gbc_label2.gridy = 0;
		gbc_label2.weightx = 0.2;
		gbc_label2.weighty = 0.5;
		panel.add(label2, gbc_label2);
		
		JLabel label3 = new JLabel();
		label3.setText("0.0");
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.fill = GridBagConstraints.BOTH;
		gbc_label3.gridx = 4;
		gbc_label3.gridy = 0;
		gbc_label3.weightx = 0.2;
		gbc_label3.weighty = 0.5;
		panel.add(label3, gbc_label3);
		
		JButton btn1 = new JButton();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myOperation = MyOperation.Add;
				label1.setText("+");
			}
		});
		btn1.setText("+");
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 1;
		gbc_btn1.weightx = 0.2;
		gbc_btn1.weighty = 0.5;
		panel.add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton();
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myOperation = MyOperation.Minus;
				label1.setText("-");
			}
		});
		btn2.setText("-");
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 1;
		gbc_btn2.weightx = 0.2;
		gbc_btn2.weighty = 0.5;
		panel.add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton();
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myOperation = MyOperation.Multiply;
				label1.setText("*");
			}
		});
		btn3.setText("*");
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 1;
		gbc_btn3.weightx = 0.2;
		gbc_btn3.weighty = 0.5;
		panel.add(btn3, gbc_btn3);
		
		JButton btn4 = new JButton();
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myOperation = MyOperation.Divide;
				label1.setText("/");
			}
		});
		btn4.setText("/");
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.gridx = 3;
		gbc_btn4.gridy = 1;
		gbc_btn4.weightx = 0.2;
		gbc_btn4.weighty = 0.5;
		panel.add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton();
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (myOperation) {
				case Add:
					label3.setText(String.valueOf(Double.parseDouble(textPane1.getText()) + Double.parseDouble(textPane2.getText())));
					break;
				case Minus:
					label3.setText(String.valueOf(Double.parseDouble(textPane1.getText()) - Double.parseDouble(textPane2.getText())));
					break;
				case Multiply:
					label3.setText(String.valueOf(Double.parseDouble(textPane1.getText()) * Double.parseDouble(textPane2.getText())));
					break;
				case Divide:
					label3.setText(String.valueOf(Double.parseDouble(textPane1.getText()) / Double.parseDouble(textPane2.getText())));
					break;
				default:
					break;
				}
			}
		});
		btn5.setText("=");
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.gridx = 4;
		gbc_btn5.gridy = 1;
		gbc_btn5.weightx = 0.2;
		gbc_btn5.weighty = 0.5;
		panel.add(btn5, gbc_btn5);
		
	}

}
