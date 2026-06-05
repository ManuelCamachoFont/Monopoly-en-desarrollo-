package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelEnd extends BackgroundPanel{

	JPanel panelNorth = new JPanel();
	JLabel endTitle = new JLabel("END GAME");

	JPanel panelCenter = new JPanel();
	
	JLabel lblWinner = new JLabel("WINNER:");
	JLabel lblName = new JLabel();
	
	JLabel icoMoney = new JLabel();
	
	JLabel lblMoney = new JLabel();
	//
	JLabel icoProperties = new JLabel();
	
	JPanel panelProperties = new JPanel();
	

	JPanel panelSouth = new JPanel();
	
	ImageIcon icoMenu = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/ranking.png"));
	Image icoMenuRedim = icoMenu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoMenuR = new ImageIcon(icoMenuRedim);
	JButton btnMenu = new JButton("Menu", icoMenuR);
	
	ImageIcon icoRank = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/ranking.png"));
	Image icoRankRedim = icoRank.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoRankR = new ImageIcon(icoRankRedim);
	JButton btnRank = new JButton("Ranking", icoRankR);
	
	ImageIcon icoPlay = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/ranking.png"));
	Image icoPlayRedim = icoPlay.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoPlayR = new ImageIcon(icoPlayRedim);
	JButton btnPlay= new JButton("Play again", icoPlayR);
	
	Dimension btnSize = new Dimension (90, 70);
	
	SpringLayout spring = new SpringLayout();
	
	public PanelEnd() {
		super("homeb_background2.png");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));
		
		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(60, 0, 0, 0));
		endTitle.setForeground(colorForeground);
		endTitle.setFont(getFont().deriveFont(62f));
		endTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(endTitle);
		panelNorth.setOpaque(false);
		add(panelNorth, BorderLayout.NORTH);

		// South Panel
		panelSouth.setLayout(spring);
		
		btnMenu.setPreferredSize(btnSize);
		btnMenu.setFont(getFont().deriveFont(18f));
		setButtonStyle(btnMenu);
		btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnMenu);
		spring.putConstraint(SpringLayout.WEST, btnMenu, 10, SpringLayout.WEST, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnMenu, 10, SpringLayout.NORTH, panelSouth);
        spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnMenu);

        btnRank.setPreferredSize(btnSize);
        btnRank.setFont(getFont().deriveFont(18f));
        setButtonStyle(btnRank);
        btnRank.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRank.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnRank);
        spring.putConstraint(SpringLayout.WEST, btnRank, 280, SpringLayout.EAST, btnMenu);
        spring.putConstraint(SpringLayout.NORTH, btnRank, 10, SpringLayout.NORTH, panelSouth);

        btnPlay.setPreferredSize(btnSize);
        btnPlay.setFont(getFont().deriveFont(18f));
       	setButtonStyle(btnPlay);
        btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnPlay);
        spring.putConstraint(SpringLayout.EAST, btnRank, -10, SpringLayout.EAST, panelSouth);
        spring.putConstraint(SpringLayout.NORTH, btnRank, 10, SpringLayout.NORTH, panelSouth);
        panelSouth.setOpaque(false);
        add(panelSouth, BorderLayout.PAGE_END);
	}
}
