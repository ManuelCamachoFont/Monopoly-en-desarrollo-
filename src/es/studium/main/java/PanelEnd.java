package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelEnd extends BackgroundPanel{

	private static final long serialVersionUID = 1L;
	JPanel panelNorth = new JPanel();
	JLabel endTitle = new JLabel("GAME END");

	JPanel panelCenter = new JPanel();
	
	JLabel lblWinner = new JLabel("WINNER:");
	JLabel lblName = new JLabel("Player");
	
	JLabel icoMoney = new JLabel();
	JLabel lblMoney = new JLabel("3000 €");
	//
	JLabel icoProperties = new JLabel();
	JPanel panelProperties = new JPanel();
	JLabel lblProperties = new JLabel("X Properties");
	JLabel lblHouses = new JLabel("Y Houses");
	JLabel lblHotels = new JLabel("Z Hotels");
	

	JPanel panelSouth = new JPanel();
	
	ImageIcon icoMenu = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/back.png"));
	Image icoMenuRedim = icoMenu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoMenuR = new ImageIcon(icoMenuRedim);
	JButton btnMenu = new JButton("Menu", icoMenuR);
	
	ImageIcon icoRank = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/ranking.png"));
	Image icoRankRedim = icoRank.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoRankR = new ImageIcon(icoRankRedim);
	JButton btnRank = new JButton("Ranking", icoRankR);
	
	ImageIcon icoPlay = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/confirm.png"));
	Image icoPlayRedim = icoPlay.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoPlayR = new ImageIcon(icoPlayRedim);
	JButton btnPlay= new JButton("Play again", icoPlayR);
	
	Dimension btnSize = new Dimension (90, 70);
	
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	SpringLayout spring = new SpringLayout();
	
	public PanelEnd() {
		super("Sky.png");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));
		
		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(60, 0, 0, 0));
		endTitle.setForeground(colorForeground);
		endTitle.setFont(getFont().deriveFont(1, 62f));
		endTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(endTitle);
		panelNorth.setOpaque(false);
		add(panelNorth, BorderLayout.NORTH);

		// Center Pantel
		panelCenter.setLayout(gridbag);
		panelCenter.setOpaque(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.CENTER;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.gridwidth = 4;
		
		lblWinner.setFont(getFont().deriveFont(1, 24f));
		panelCenter.add(lblWinner, gbc);
		
		gbc.gridy = 1;
		lblName.setFont(getFont().deriveFont(1, 40f));
		panelCenter.add(lblName, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy = 2;
		Utilities.setIco(icoMoney, "money.png", 90, 90);
		panelCenter.add(icoMoney, gbc);
		
		gbc.gridx = 1;
		lblMoney.setFont(getFont().deriveFont(1, 40F));
		panelCenter.add(lblMoney, gbc);
		
		gbc.gridx = 2;
		Utilities.setIco(icoProperties, "properties.png", 90, 90);
		panelCenter.add(icoProperties, gbc);
		
		panelProperties.setLayout(new BorderLayout());
		lblProperties.setFont(getFont().deriveFont(1, 40f));
		panelProperties.add(lblProperties, BorderLayout.NORTH);
		lblHouses.setFont(getFont().deriveFont(1, 40f));
		panelProperties.add(lblHouses, BorderLayout.CENTER);
		lblHotels.setFont(getFont().deriveFont(1, 40f));
		panelProperties.add(lblHotels, BorderLayout.SOUTH);
		
		gbc.gridx = 3;
		panelProperties.setOpaque(false);
		panelCenter.add(panelProperties, gbc);
		
		
		add(panelCenter, BorderLayout.CENTER);
		
		// South Panel
		panelSouth.setLayout(spring);
		
		setButtonStyle(btnMenu);
		btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnMenu);
		spring.putConstraint(SpringLayout.WEST, btnMenu, 30, SpringLayout.WEST, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnMenu, 10, SpringLayout.NORTH, panelSouth);

        setButtonStyle(btnRank);
        btnRank.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRank.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnRank);
        spring.putConstraint(SpringLayout.WEST, btnRank, -45, SpringLayout.HORIZONTAL_CENTER, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnRank, 10, SpringLayout.NORTH, panelSouth);

       	setButtonStyle(btnPlay);
        btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnPlay);
		spring.putConstraint(SpringLayout.EAST, btnPlay, -30, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnPlay, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 30, SpringLayout.SOUTH, btnMenu);
        panelSouth.setOpaque(false);
        add(panelSouth, BorderLayout.PAGE_END);
	}
	
	public void setWinner(String winner, int money, int properties, int houses, int hotels) {
		lblName.setText(winner);
		lblMoney.setText(money + " €");
		lblProperties.setText(properties + " Properties");
		lblHouses.setText(houses + " Houses");
		lblHotels.setText(hotels + " Hotels");
	}
}
