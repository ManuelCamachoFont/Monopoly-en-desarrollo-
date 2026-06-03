package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelHelp extends JPanel {

	JPanel panelNorth = new JPanel();
	JLabel helpTitle = new JLabel("Help");

	JPanel panelCenter = new JPanel();
	JTabbedPane tabs = new JTabbedPane();

	// Start Tab
	JScrollPane scrollHelpStart = new JScrollPane();
	JPanel panelHelpStart = new JPanel();
	JTextArea txtStart = new JTextArea();

	// Properties Tab
	JScrollPane scrollHelpProperties = new JScrollPane();
	JPanel panelHelpProperties = new JPanel();
	JTextArea txtProperties1 = new JTextArea(5, 30);
	JTextArea txtProperties2 = new JTextArea(7, 30);
	JTextArea txtProperties3 = new JTextArea(7, 30);
	ImageIcon icoProperties1 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/properties.png"));
	Image icoPropertiesRedim1 = icoProperties1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	ImageIcon icoPropertiesR1 = new ImageIcon(icoPropertiesRedim1);
	JLabel lblIcoProperties1 = new JLabel(icoPropertiesR1);


	// Square Tab
	JScrollPane scrollHelpSquares = new JScrollPane();
	JPanel panelHelpSquares = new JPanel();
	JTextArea txtSquares= new JTextArea();

	// Cards Tab
	JScrollPane scrollHelpCards = new JScrollPane();
	JPanel panelHelpCards = new JPanel();
	JTextArea txtCards1 = new JTextArea(7, 30);
	JTextArea txtCards2 = new JTextArea(5, 30);

	
	// South panel
	JPanel panelSouth = new JPanel();
	ImageIcon icoBack = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/back.png"));
	Image icoBackRedim = icoBack.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoBackR = new ImageIcon(icoBackRedim);
	JButton btnBack = new JButton("Back", icoBackR);


	ImageIcon icoMHelp = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/confirm.png"));
	Image icoMHelpRedim = icoMHelp.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoMHelpR = new ImageIcon(icoMHelpRedim);
	JButton btnMHelp = new JButton("More Help", icoMHelpR);

	GridBagLayout gridbagSt = new GridBagLayout();
	GridBagLayout gridbagP = new GridBagLayout();
	GridBagLayout gridbagSq = new GridBagLayout();
	GridBagLayout gridbagC = new GridBagLayout();

	GridBagConstraints gbcSt = new GridBagConstraints();
	GridBagConstraints gbcP = new GridBagConstraints();
	GridBagConstraints gbcSq = new GridBagConstraints();
	GridBagConstraints gbcC = new GridBagConstraints();

	SpringLayout spring = new SpringLayout();

	public PanelHelp() {
		setLayout(new BorderLayout());

		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(40, 0, 0, 0));
		helpTitle.setFont(new Font("Cooper Black", 1, 62));
		helpTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(helpTitle);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setBorder(new EmptyBorder(20, 20, 20, 20));

		// Start tab
		panelHelpStart.setLayout(gridbagSt);
		panelHelpStart.setBorder(new EmptyBorder(20, 20, 20, 20));
		gbcSt.gridx = 0;
		gbcSt.gridy = 0;
		gbcSt.insets = new Insets (10, 10, 10, 10);

		txtStart.setText("Lorem Ipsum, blablablabalabaalabaal");
		panelHelpStart.add(txtStart, gbcSt);
		scrollHelpStart.setViewportView(panelHelpStart);
		tabs.addTab("Start", scrollHelpStart);


		// Properties tab
		panelHelpProperties.setLayout(gridbagP);
		panelHelpProperties.setBackground(Color.BLACK);
		panelHelpProperties.setBorder(new EmptyBorder(20, 20, 20, 20));
		gbcP.gridx = 0;
		gbcP.gridy = 0;
		gbcP.weightx = 0.75;
		gbcP.insets = new Insets(10, 10, 10, 10);

		txtProperties1.setForeground(Color.WHITE);
		txtProperties1.setOpaque(false);
		txtProperties1.setEditable(false);
		txtProperties1.setText("\tOWNERSHIP:\n\nWhen landing on an unowned street, railroad, or utility, you can buy it from the Bank for the listed price.");
		txtProperties1.setLineWrap(true);
		txtProperties1.setWrapStyleWord(true);
		panelHelpProperties.add(txtProperties1, gbcP);
		gbcP.gridx = 1;
		gbcP.weightx = 0.25;
		panelHelpProperties.add(lblIcoProperties1, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 1;
		gbcP.weightx = 0.75;
		txtProperties2.setForeground(Color.WHITE);
		txtProperties2.setOpaque(false);
		txtProperties2.setEditable(false);
		txtProperties2.setText("\tCONSTRUCTION:\n\nHouses must be built evenly (you can't have 3 houses on one street and 1 on another in the same group). Before you can build a hotel, you need 4 houses in each property within the group.");
		txtProperties2.setLineWrap(true);
		txtProperties2.setWrapStyleWord(true);
		panelHelpProperties.add(txtProperties2, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 2;
		gbcP.weightx = 0.75;
		txtProperties3.setForeground(Color.WHITE);
		txtProperties3.setOpaque(false);
		txtProperties3.setEditable(false);
		txtProperties3.setText("\tMONOPOLY:\n\nIf you own all properties of a single color group, you have a monopoly. This allows you to build houses/hotels and doubles the base rent on unimproved properties in that group");
		txtProperties3.setLineWrap(true);
		txtProperties3.setWrapStyleWord(true);
		panelHelpProperties.add(txtProperties3, gbcP);
		
		scrollHelpProperties.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollHelpProperties.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollHelpProperties.setViewportView(panelHelpProperties);
		tabs.addTab("Properties", scrollHelpProperties);

		// Squares tab
		panelHelpSquares.setLayout(gridbagSq);
		panelHelpSquares.setBorder(new EmptyBorder(20, 20, 20, 20));
		gbcSq.gridx = 0;
		gbcSq.gridy = 0;
		gbcSq.insets = new Insets(10, 10, 10, 10);

		txtSquares.setText("Lorem Ipsum, blebleble");
		panelHelpSquares.add(txtSquares, gbcSq);
		scrollHelpSquares.setViewportView(panelHelpSquares);
		tabs.addTab("Squares", scrollHelpSquares);


		// Cards tab
		panelHelpCards.setLayout(gridbagC);
		panelHelpCards.setBackground(Color.BLACK);
		panelHelpCards.setBorder(new EmptyBorder(20, 20, 20, 20));
		gbcC.gridx = 0;
		gbcC.gridy = 0;
		gbcC.insets = new Insets(10, 10, 10, 10);

		txtCards1.setForeground(Color.WHITE);
		txtCards1.setOpaque(false);
		txtCards1.setEditable(false);
		txtCards1.setText("\tCOMMUNITY:\n\nHistorically focused on social, municipal, and financial windfalls or minor penalties.\n\n"
			    + "- Common Rewards: Bank errors in your favor, tax refunds, or collecting money from every player for birthdays. \n\n"
				+"- Common Penalties: Doctor's fees, school taxes, or insurance premiums. \n\n" 
				+"- Key Card: Contains a \"Get Out of Jail Free\" card, which can be kept until needed or traded to another player. \n");
		txtCards1.setLineWrap(true);
		txtCards1.setWrapStyleWord(true);
		panelHelpCards.add(txtCards1, gbcP);
		gbcP.gridx = 1;
		gbcP.weightx = 0.25;
		
		gbcP.gridx = 0;
		gbcP.gridy = 1;
		gbcP.weightx = 0.75;
		txtCards2.setForeground(Color.WHITE);
		txtCards2.setOpaque(false);
		txtCards2.setEditable(false);
		txtCards2.setText("\tLUCK:\n\nHistorically focused on movement, unpredictability, and high-risk/high-reward scenarios. \n\n"
				+ "- Common Movements: Commands to advance directly to specific properties (like Boardwalk or Illinois Avenue), the nearest Railroad, or directly to Jail. \n\n"
				+ "- Common Rewards/Penalties: Dividend payouts or general property repair assessments (where you must pay a specific fee per house and hotel you own). \n\n"
				+ "- Key Card: Also contains a \"Get Out of Jail Free\" card.");
		txtCards2.setLineWrap(true);
		txtCards2.setWrapStyleWord(true);
		panelHelpCards.add(txtCards2, gbcP);
		scrollHelpCards.setViewportView(panelHelpCards);
		tabs.addTab("Cards", scrollHelpCards);

		panelCenter.add(tabs, BorderLayout.CENTER);
		add(panelCenter, BorderLayout.CENTER);
		
		// South Panel
		panelSouth.setLayout(spring);

		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnBack);
		spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

		btnMHelp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMHelp.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnMHelp);
		spring.putConstraint(SpringLayout.EAST, btnMHelp, -10, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnMHelp, 10, SpringLayout.NORTH, panelSouth);

		add(panelSouth, BorderLayout.PAGE_END);
	}
}
