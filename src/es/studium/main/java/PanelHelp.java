package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelHelp extends BackgroundPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	JTextArea txtProperties4 = new JTextArea(7, 40);

	JLabel lblIcoProperties1 = new JLabel();
	JLabel lblIcoProperties2 = new JLabel();
	JLabel lblIcoProperties3 = new JLabel();
	JLabel lblIcoProperties4 = new JLabel();

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
		super("home_background.png");
	    setLayout(new BorderLayout());
	    setPreferredSize(new Dimension(900, 900));
	    
	    Border coloredBorder = BorderFactory.createLineBorder(colorForeground, 3);
		Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		Border compoundBorder = BorderFactory.createCompoundBorder(coloredBorder, padding);
		

	    // North Panel
	    panelNorth.setLayout(new FlowLayout());
	    panelNorth.setBorder(new EmptyBorder(40, 0, 0, 0));
	    setTitleStyle(helpTitle);
	    helpTitle.setOpaque(true);
	    helpTitle.setBackground(colorBackground);
	    helpTitle.setBorder(compoundBorder);
	    panelNorth.add(helpTitle);
	    panelNorth.setOpaque(false);
	    add(panelNorth, BorderLayout.NORTH);

	    // Center Panel
	    panelCenter.setLayout(new BorderLayout());
	    panelCenter.setBorder(new EmptyBorder(20, 20, 20, 20));
	    tabs.setForeground(colorForeground);
	    tabs.setBackground(colorBackground);
	    tabs.setFont(getFont().deriveFont(24f));

		// Start tab
		panelHelpStart.setLayout(new GridBagLayout());
		    panelHelpStart.setBackground(colorBackground);
		    panelHelpStart.setBorder(new EmptyBorder(20, 20, 20, 20));
		    GridBagConstraints gbcStart = new GridBagConstraints();
		    gbcStart.insets = new Insets(10, 10, 10, 10);

		    addHelpRow(panelHelpStart, gbcStart, 0,
		        "\tOBJECTIVE:\n\nBe the last player remaining with money. Drive your opponents into bankruptcy by collecting rent, buying properties, and managing your finances wisely.",
		        "winner.png");
		    addHelpRow(panelHelpStart, gbcStart, 1,
		        "\tSETUP:\n\nEach player starts with 500€ and a token placed on GO. On your turn, roll both dice and move your token clockwise the number of spaces shown.",
		        "setup.jpg");
		    addHelpRow(panelHelpStart, gbcStart, 2,
		        "\tTURNS:\n\nOn each turn you must roll the dice and move. After moving, you may buy the property you landed on if it is unowned. Rolling doubles lets you take another turn, but three consecutive doubles sends you directly to Jail.",
		        "turn.png");
		    addHelpRow(panelHelpStart, gbcStart, 3,
		        "\tWINNING:\n\nThe last player who has not gone bankrupt wins the game. A player goes bankrupt when they cannot pay a debt they owe to another player or the Bank.",
		        "trophy.png");

		    scrollHelpStart.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollHelpStart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    scrollHelpStart.setViewportView(panelHelpStart);
		    tabs.addTab("Start", scrollHelpStart);


		// Properties tab
		panelHelpProperties.setLayout(new GridBagLayout());
		panelHelpProperties.setBackground(colorBackground);
		panelHelpProperties.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		addHelpRow(panelHelpProperties, gbc, 0,
		    "\tOWNERSHIP:\n\nWhen landing on an unowned street, railroad, or utility, you can buy it from the Bank for the listed price.",
		    "ownership.png");

		addHelpRow(panelHelpProperties, gbc, 1,
		    "\tCONSTRUCTION:\n\nHouses must be built evenly (you can't have 3 houses on one street and 1 on another in the same group). Before you can build a hotel, you need 4 houses in each property within the group.",
		    "properties.png");

		addHelpRow(panelHelpProperties, gbc, 2,
		    "\tMONOPOLY:\n\nIf you own all properties of a single color group, you have a monopoly. This allows you to build houses/hotels and doubles the base rent on unimproved properties in that group",
		    "monopoly.png");

		addHelpRow(panelHelpProperties, gbc, 3,
		    "\tRENT:\n\nWhen another player lands on your property, they must pay you rent. Rent increases with each house or hotel built. Railroads charge more rent the more you own (25€, 50€, 100€, 200€). Utilities charge a multiplier based on the dice roll.\"",
		    "rent.png");

		scrollHelpProperties.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollHelpProperties.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollHelpProperties.setViewportView(panelHelpProperties);
		tabs.addTab("Properties", scrollHelpProperties);
		
		// Squares tab
	    panelHelpSquares.setLayout(new GridBagLayout());
	    panelHelpSquares.setBackground(colorBackground);
	    panelHelpSquares.setBorder(new EmptyBorder(20, 20, 20, 20));
	    GridBagConstraints gbcSq = new GridBagConstraints();
	    gbcSq.insets = new Insets(10, 10, 10, 10);

	    addHelpRow(panelHelpSquares, gbcSq, 0,
	        "\tGO:\n\nEach time you pass or land on GO, collect 200€ from the Bank.",
	        "go.jpg");
	    addHelpRow(panelHelpSquares, gbcSq, 1,
	        "\tJAIL:\n\nYou are sent to Jail by landing on \"Go to Jail\", drawing a card that says so, or rolling doubles three times in a row. While in Jail you cannot move, but you can still collect rent. To get out: roll doubles, pay 50€, or use a Get Out of Jail Free card. After 3 failed attempts, you must pay 50€ and move.",
	        "prison.png");
	    addHelpRow(panelHelpSquares, gbcSq, 2,
	        "\tFREE PARKING:\n\nThis is a neutral square. Nothing happens when you land here.",
	        "park.png");
	    addHelpRow(panelHelpSquares, gbcSq, 3,
	        "\tTAX:\n\nLanding on a tax square requires an immediate payment to the Bank. No exceptions.",
	        "tax.png");
	    addHelpRow(panelHelpSquares, gbcSq, 4,
	        "\tSPECIAL:\n\nCertain squares trigger special events such as going directly to Jail or collecting a bonus. Follow the instructions on the square when you land on it.",
	        "event.png");

	    scrollHelpSquares.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollHelpSquares.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollHelpSquares.setViewportView(panelHelpSquares);
	    tabs.addTab("Squares", scrollHelpSquares);


		// Cards tab
		panelHelpCards.setLayout(new GridBagLayout());
	    panelHelpCards.setBackground(colorBackground);
	    panelHelpCards.setBorder(new EmptyBorder(20, 20, 20, 20));
	    GridBagConstraints gbcCards = new GridBagConstraints();
	    gbcCards.insets = new Insets(10, 10, 10, 10);

	    addHelpRow(panelHelpCards, gbcCards, 0,
	        "\tCOMMUNITY:\n\nHistorically focused on social, municipal, and financial windfalls or minor penalties.\n\n"
	        + "- Common Rewards: Bank errors in your favor, tax refunds, or collecting money from every player for birthdays.\n\n"
	        + "- Common Penalties: Doctor's fees, school taxes, or insurance premiums.\n\n"
	        + "- Key Card: Contains a \"Get Out of Jail Free\" card, which can be kept until needed or traded to another player.",
	        "community.png");
	    addHelpRow(panelHelpCards, gbcCards, 1,
	        "\tLUCK:\n\nHistorically focused on movement, unpredictability, and high-risk/high-reward scenarios.\n\n"
	        + "- Common Movements: Commands to advance directly to specific properties, the nearest Railroad, or directly to Jail.\n\n"
	        + "- Common Rewards/Penalties: Dividend payouts or general property repair assessments, where you pay a fee per house and hotel you own.\n\n"
	        + "- Key Card: Also contains a \"Get Out of Jail Free\" card.",
	        "luck.png");

	    scrollHelpCards.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollHelpCards.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollHelpCards.setViewportView(panelHelpCards);
	    tabs.addTab("Cards", scrollHelpCards);
		
	    // ── CENTER + SOUTH ──
	    panelCenter.add(tabs, BorderLayout.CENTER);
	    panelCenter.setOpaque(false);
	    add(panelCenter, BorderLayout.CENTER);

	    // South Panel
	    panelSouth.setLayout(spring);
	    setButtonStyle(btnBack);
	    btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
	    btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
	    panelSouth.add(btnBack);
	    spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
	    spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
	    spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

	    setButtonStyle(btnMHelp);
	    btnMHelp.setHorizontalTextPosition(SwingConstants.CENTER);
	    btnMHelp.setVerticalTextPosition(SwingConstants.BOTTOM);
	    panelSouth.add(btnMHelp);
	    spring.putConstraint(SpringLayout.EAST, btnMHelp, -10, SpringLayout.EAST, panelSouth);
	    spring.putConstraint(SpringLayout.NORTH, btnMHelp, 10, SpringLayout.NORTH, panelSouth);

	    panelSouth.setOpaque(false);
	    add(panelSouth, BorderLayout.PAGE_END);
	}
	
	private void addHelpRow(JPanel panel, GridBagConstraints gbc, int row, String text, String iconName) {
	    JTextArea txt = new JTextArea(5, 30);
	    txt.setForeground(colorForeground);
	    txt.setOpaque(false);
	    txt.setEditable(false);
	    txt.setFont(getFont().deriveFont(15f));
	    txt.setText(text);
	    txt.setLineWrap(true);
	    txt.setWrapStyleWord(true);

	    gbc.gridx = 0;
	    gbc.gridy = row;
	    gbc.weightx = 0.75;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.anchor = GridBagConstraints.NORTHWEST;
	    panel.add(txt, gbc);

	    JLabel lbl = new JLabel();
	    Utilities.setIco(lbl, iconName, 80, 80);
	    lbl.setHorizontalAlignment(SwingConstants.CENTER);

	    gbc.gridx = 1;
	    gbc.weightx = 0.25;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.anchor = GridBagConstraints.NORTH;
	    panel.add(lbl, gbc);
	}
}
