package myf.tool.myfCalc;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WndSmartCalc {

	private JFrame frame;
	private JPanel panel;
	private JPanel resultPanel;
	private JLabel resultLabel;
	private JPanel commandPanel;
	private LastOperation lastOperation = LastOperation.Null;
	private boolean resetNum = false;
	private double lastnum = 0f;
	private double nownum = 0f;
	
	private enum LastOperation {
		Null,
		Add,
		Minus,
		Multiply,
		Divide
	};
	
	private static class myColor {
		public static Color Display = new Color(23, 44, 60);
		public static Color Background = new Color(39, 72, 98);
		public static Color Button = new Color(250, 218, 141);
	
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WndSmartCalc window = new WndSmartCalc();
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
	public WndSmartCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MYF Smart Calc - 171340236 Á—”Íˆ≠");
		Container contentPane = frame.getContentPane();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		panel = new JPanel(new GridBagLayout());
		panel.setOpaque(true);
		panel.setBackground(myColor.Background);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);

		//----Content----
		
		resultPanel = new JPanel(new GridLayout(1, 1));
		resultPanel.setOpaque(false);
		resultPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_resultPanel = new GridBagConstraints();
		gbc_resultPanel.fill = GridBagConstraints.BOTH;
		gbc_resultPanel.gridx = 0;
		gbc_resultPanel.gridy = 0;
		gbc_resultPanel.weightx = 1;
		gbc_resultPanel.weighty = 0.3;
		panel.add(resultPanel, gbc_resultPanel);
		
		commandPanel = new JPanel(new GridBagLayout());
		commandPanel.setOpaque(false);
		commandPanel.setBorder(new EmptyBorder(4, 10, 10, 10));
		GridBagConstraints gbc_commandPanel = new GridBagConstraints();
		gbc_commandPanel.fill = GridBagConstraints.BOTH;
		gbc_commandPanel.gridx = 0;
		gbc_commandPanel.gridy = 1;
		gbc_commandPanel.weightx = 1;
		gbc_commandPanel.weighty = 0.7;
		panel.add(commandPanel, gbc_commandPanel);
		
		resultLabel = new JLabel();
		resultLabel.setOpaque(true);
		resultLabel.setBackground(myColor.Display);
		resultLabel.setForeground(Color.WHITE);
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		resultLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
		resultLabel.setText("0");
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.fill = GridBagConstraints.BOTH;
		gbc_resultLabel.gridx = 0;
		gbc_resultLabel.gridy = 0;
		gbc_resultLabel.weightx = 1;
		gbc_resultLabel.weighty = 1;
		resultPanel.add(resultLabel, gbc_resultLabel);
		
		JLabel brandLabel = new JLabel();
		brandLabel.setText("MYF Smart Calc");
		brandLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		brandLabel.setForeground(Color.WHITE);
		brandLabel.setBorder(new EmptyBorder(-10, 15, 0, 0));
		GridBagConstraints gbc_brandLabel = new GridBagConstraints();
		gbc_brandLabel.fill = GridBagConstraints.BOTH;
		gbc_brandLabel.gridx = 0;
		gbc_brandLabel.gridy = 0;
		gbc_brandLabel.gridwidth = 4;
		commandPanel.add(brandLabel, gbc_brandLabel);
		
		String[] clears = {"C", "D"};
		for (int i = 0; i < 2; i++) {
			JButton clearButton = new JButton();
			clearButton.setBackground(myColor.Button);
			clearButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
			clearButton.setText(clears[i]);
			clearButton.addActionListener(new ButtonListener(i - 2));
			GridBagConstraints gbc_clearButton = new GridBagConstraints();
			gbc_clearButton.fill = GridBagConstraints.BOTH;
			gbc_clearButton.gridx = 2 + i;
			gbc_clearButton.gridy = 0;
			gbc_clearButton.weightx = 0.25;
			gbc_clearButton.weighty = 0.2;
			commandPanel.add(clearButton, gbc_clearButton);
		}
	
		for (int i = 0; i < 16; i++) {
			JButton cmdButton = new JButton();
			cmdButton.setBackground(myColor.Button);
			cmdButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
			cmdButton.setText(String.valueOf(MapButtonIDToChar(i)));
			cmdButton.addActionListener(new ButtonListener(i));
			GridBagConstraints gbc_cmdButton = new GridBagConstraints();
			gbc_cmdButton.fill = GridBagConstraints.BOTH;
			int tmp = (i + 1) % 4;
			gbc_cmdButton.gridx = tmp == 0 ? 3 : tmp - 1;
			gbc_cmdButton.gridy = (i + 1 - gbc_cmdButton.gridx) / 4 + 1;
			gbc_cmdButton.weightx = 0.25;
			gbc_cmdButton.weighty = 0.2;
			commandPanel.add(cmdButton, gbc_cmdButton);
		}
		
		panel.addComponentListener(new ComponentAdapter() {
	        public void componentResized(ComponentEvent evt) {
	            resultLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, (int)(resultPanel.getHeight() / 4.2)));
	        }
		});
		
	}

	private static char MapButtonIDToChar(int id) {
		if (0 < id && id > 15) {
			return '0';
		}
		
		char[] cmds = {'7', '8', '9', '/', 
				   '4', '5', '6', '*', 
				   '1', '2', '3', '-', 
				   '0', '.', '=', '+' };
		return cmds[id];
	}
	
	private static LastOperation MapButtonIDToOperation(int id) {
		if (0 < id && id > 15) {
			return LastOperation.Null;
		}
		
		switch (id) {
		case 3:
			return LastOperation.Divide;
		case 7:
			return LastOperation.Multiply;
		case 11:
			return LastOperation.Minus;
		case 15:
			return LastOperation.Add;
		default:
			return LastOperation.Null;
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		private int m_buttonID;
		
		public ButtonListener(int buttonID) {
			m_buttonID = buttonID;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (m_buttonID == -2 ) {
				nownum = 0;
				resultLabel.setText("0");
				lastOperation = LastOperation.Null;
				resetNum = false;
				return;
			}
			if (m_buttonID == -1 ) {
				String num = resultLabel.getText();
				if (!num.equals("0")) {
					if (num.length() == 1) {
						resultLabel.setText("0");
					}
					else {
						resultLabel.setText(num.substring(0, num.length() - 1));
					}
					nownum = Double.parseDouble(resultLabel.getText());
				}
				return;
			}
			
			if (m_buttonID == 14) {
				if (lastOperation != LastOperation.Null) {
					double result;
					switch (lastOperation) {
					case Add:
						result = lastnum + nownum;
						break;
					case Minus:
						result = lastnum - nownum;
						break;
					case Multiply:
						result = lastnum * nownum;
						break;
					case Divide:
						result = lastnum / nownum;
						break;
					default:
						result = nownum;
						break;
					}
					nownum = result;
					String tmp = String.valueOf(nownum);
					if (tmp.endsWith(".0")) {
						tmp = tmp.substring(0, tmp.length() - 2);
					}
					resultLabel.setText(tmp);
				}
				return;
			}
			
			boolean isOpBtn = false;
			int[] opIDs = {3, 7, 11, 15};
			for (int i:opIDs) {
				if (m_buttonID == i) {
					isOpBtn = true;
					break;
				}
			}
			if (isOpBtn) {
				lastOperation = MapButtonIDToOperation(m_buttonID);
				resetNum = true;
				return;
			}
			
			boolean isNumBtn = false;
			int[] numIDs = {0, 1, 2, 4, 5, 6, 8, 9, 10, 12};
			for (int i:numIDs) {
				if (m_buttonID == i) {
					isNumBtn = true;
					break;
				}
			}
			if (isNumBtn) {
				int num = Integer.parseInt(String.valueOf(MapButtonIDToChar(m_buttonID)));
				String tmp = resultLabel.getText();
				if (lastOperation != LastOperation.Null && resetNum) {
					lastnum = Double.parseDouble(tmp);
					tmp = "0";
					nownum = 0;
					resetNum = false;
				}
				if (nownum == 0) {
					if (tmp.equals("0.")) {
						tmp += String.valueOf(num);
					}
					else {
						tmp = String.valueOf(num);
					}
				}
				else {
					if (tmp.equals("0")) {
						tmp = String.valueOf(num);
					}
					else {
						tmp += String.valueOf(num);
					}
				}
				nownum = Double.parseDouble(tmp);
				resultLabel.setText(tmp);
			}
			else {
				if (m_buttonID == 13) {
					String tmp = String.valueOf(nownum);
					
					if (tmp.endsWith(".0")) {
						tmp = tmp.substring(0, tmp.length() - 2);
					}
					if (!tmp.contains(".")) {
						tmp += ".";
						resultLabel.setText(tmp);
					}
				}
			}
		}
		
	}
	
}
