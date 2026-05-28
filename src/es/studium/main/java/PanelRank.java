package es.studium.main.java;

import java.awt.BorderLayout;
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
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelRank extends JPanel{

	JPanel panelNorth = new JPanel();
	JLabel rankTitle = new JLabel("Ranking");

	JPanel panelCenter = new JPanel();
	
	// Panel Money
	JPanel panelMoney = new JPanel();
	JLabel lblMoney = new JLabel("€");
	JLabel lblMoneyName1 = new JLabel("Placeholder 1");
	JLabel lblMoneyAmount1 = new JLabel("2200€");
	JLabel lblMoneyName2 = new JLabel("Placeholder 2");
	JLabel lblMoneyAmount2 = new JLabel("2200€");
	JLabel lblMoneyName3 = new JLabel("Placeholder 3");
	JLabel lblMoneyAmount3 = new JLabel("2200€");
	JLabel lblMoneyName4 = new JLabel("Placeholder 4");
	JLabel lblMoneyAmount4 = new JLabel("2200€");
	JLabel lblMoneyName5 = new JLabel("Placeholder 5");
	JLabel lblMoneyAmount5 = new JLabel("2200€");
	
	// Panel Properties
	JPanel panelProperties = new JPanel();
	// Change icon
	JLabel lblHouses = new JLabel("Houses");
	JLabel lblHotels = new JLabel("Hotel");
	JLabel lblPropertiesName1 = new JLabel ("Placeholder 1");
	JLabel lblHouses1 = new JLabel("12");
	JLabel lblHotels1 = new JLabel("4");
	JLabel lblPropertiesName2 = new JLabel ("Placeholder 2");
	JLabel lblHouses2 = new JLabel("12");
	JLabel lblHotels2 = new JLabel("4");
	JLabel lblPropertiesName3 = new JLabel ("Placeholder 3");
	JLabel lblHouses3 = new JLabel("12");
	JLabel lblHotels3 = new JLabel("4");
	JLabel lblPropertiesName4 = new JLabel ("Placeholder 4");
	JLabel lblHouses4 = new JLabel("12");
	JLabel lblHotels4 = new JLabel("4");
	JLabel lblPropertiesName5 = new JLabel ("Placeholder 5");
	JLabel lblHouses5 = new JLabel("12");
	JLabel lblHotels5 = new JLabel("4");
	
	JSplitPane divider = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelMoney, panelProperties);

	JPanel panelSouth = new JPanel();
	ImageIcon icoBack = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/back.png"));
	Image icoBackRedim = icoBack.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoBackR = new ImageIcon(icoBackRedim);
	JButton btnBack = new JButton("Back", icoBackR);

	GridBagLayout gridbagM = new GridBagLayout();
	GridBagConstraints gbcM = new GridBagConstraints();
	
	GridBagLayout gridbagP = new GridBagLayout();
	GridBagConstraints gbcP = new GridBagConstraints();

	SpringLayout spring = new SpringLayout();

	public PanelRank() {
		setLayout(new BorderLayout());

		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(40, 0, 0, 0));
		rankTitle.setFont(new Font("Cooper Black", 1, 62));
		rankTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(rankTitle);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setBorder(new EmptyBorder(20, 20, 20, 20));
		divider.setDividerLocation(270);
		divider.setEnabled(false);
		
		// Money Panel
		panelMoney.setLayout(gridbagM);
		gbcM.insets = new Insets (10, 10, 10, 10);
		gbcM.gridx = 1;
		gbcM.gridy = 0;
		panelMoney.add(lblMoney, gbcM);
		
		gbcM.gridx = 0;
		gbcM.gridy = 1;
		panelMoney.add(lblMoneyName1, gbcM);
		
		gbcM.gridx = 1;
		panelMoney.add(lblMoneyAmount1, gbcM);
		
		gbcM.gridx = 0;
		gbcM.gridy = 2;
		panelMoney.add(lblMoneyName2, gbcM);
		
		gbcM.gridx = 1;
		panelMoney.add(lblMoneyAmount2, gbcM);
		
		gbcM.gridx = 0;
		gbcM.gridy = 3;
		panelMoney.add(lblMoneyName3, gbcM);
		
		gbcM.gridx = 1;
		panelMoney.add(lblMoneyAmount3, gbcM);
		
		gbcM.gridx = 0;
		gbcM.gridy = 4;
		panelMoney.add(lblMoneyName4, gbcM);
		
		gbcM.gridx = 1;
		panelMoney.add(lblMoneyAmount4, gbcM);
		
		gbcM.gridx = 0;
		gbcM.gridy = 5;
		panelMoney.add(lblMoneyName5, gbcM);
		
		gbcM.gridx = 1;
		panelMoney.add(lblMoneyAmount5, gbcM);
		
		
		// Properties Panel
		panelProperties.setLayout(gridbagP);
		gbcP.insets = new Insets (10, 10, 10, 10);
		gbcP.gridx = 1;
		gbcP.gridy = 0;
		panelProperties.add(lblHouses, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 1;
		panelProperties.add(lblPropertiesName1, gbcP);
		
		gbcP.gridx = 1;
		panelProperties.add(lblHouses1, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels1, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 2;
		panelProperties.add(lblPropertiesName2, gbcP);
		
		gbcP.gridx = 1;
		panelProperties.add(lblHouses2, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels2, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 3;
		panelProperties.add(lblPropertiesName3, gbcP);
		
		gbcP.gridx = 1;
		panelProperties.add(lblHouses3, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels3, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 4;
		panelProperties.add(lblPropertiesName4, gbcP);
		
		gbcP.gridx = 1;
		panelProperties.add(lblHouses4, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels4, gbcP);
		
		gbcP.gridx = 0;
		gbcP.gridy = 5;
		panelProperties.add(lblPropertiesName5, gbcP);
		
		gbcP.gridx = 1;
		panelProperties.add(lblHouses5, gbcP);
		
		gbcP.gridx = 2;
		panelProperties.add(lblHotels5, gbcP);
		
		
		panelCenter.add(divider, BorderLayout.CENTER);
		add(panelCenter, BorderLayout.CENTER);

		// South Panel
		panelSouth.setLayout(spring);

		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnBack);
		spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

		add(panelSouth, BorderLayout.PAGE_END);
	}
}


// LIMIT 5 query for the rank