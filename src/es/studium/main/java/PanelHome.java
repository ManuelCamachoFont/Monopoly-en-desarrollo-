package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelHome extends JPanel{

	JPanel panelNorth = new JPanel();
	JLabel mainTitle = new JLabel("Monopoly");
	
	JPanel panelCenter = new JPanel();
	JButton btnGame = new JButton ("New Game");
	JButton btnExit = new JButton ("Exit");
	

	JPanel panelSouth = new JPanel();
	ImageIcon icoOptions = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/options.png"));
	Image icoOptRedim = icoOptions.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoOptionsR = new ImageIcon(icoOptRedim);
	JButton btnOptions = new JButton("Options", icoOptionsR);
	
	
	ImageIcon icoHelp = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/help.png"));
	Image icoHelpRedim = icoHelp.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoHelpR = new ImageIcon(icoHelpRedim);
    JButton btnHelp = new JButton("Help", icoHelpR);
	
    ImageIcon icoRank = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/ranking.png"));
	Image icoRankRedim = icoRank.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoRankR = new ImageIcon(icoRankRedim);
	JButton btnRank = new JButton("Ranking", icoRankR);
	

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	SpringLayout spring = new SpringLayout();
	
	
	public PanelHome() {
		setLayout(new BorderLayout());
		
		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(80, 0, 0, 0));
		mainTitle.setFont(new Font("Cooper Black", 1, 62));
		mainTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(mainTitle);
		add(panelNorth, BorderLayout.NORTH);
		
		// Center Panel
		panelCenter.setLayout(gridbag);
		btnGame.setFont(new Font("Cooper Black", 0, 24));
		btnGame.setPreferredSize(new Dimension(200, 80));
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCenter.add(btnGame, gbc);
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridy = 1;
		btnExit.setFont(new Font("Cooper Black", 0, 24));
		btnExit.setPreferredSize(new Dimension(200, 80));
		panelCenter.add(btnExit, gbc);
		
		add(panelCenter, BorderLayout.CENTER);
		
		// South Panel
		panelSouth.setLayout(spring);
		
		btnOptions.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOptions.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnOptions);
		spring.putConstraint(SpringLayout.WEST, btnOptions, 10, SpringLayout.WEST, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnOptions, 10, SpringLayout.NORTH, panelSouth);
        spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnOptions);

        btnHelp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHelp.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnHelp);
        spring.putConstraint(SpringLayout.WEST, btnHelp, 10, SpringLayout.EAST, btnOptions);
        spring.putConstraint(SpringLayout.NORTH, btnHelp, 10, SpringLayout.NORTH, panelSouth);

        btnRank.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRank.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnRank);
        spring.putConstraint(SpringLayout.EAST, btnRank, -10, SpringLayout.EAST, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnRank, 10, SpringLayout.NORTH, panelSouth);
        
        add(panelSouth, BorderLayout.PAGE_END);
		

	}

}

