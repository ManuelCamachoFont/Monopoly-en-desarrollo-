package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelOptions extends BackgroundPanel{

	JPanel panelNorth = new JPanel();
	JLabel optionsTitle = new JLabel("Options");

	JPanel panelCenter = new JPanel();
	JLabel lblSound = new JLabel("Sound");
	CheckboxGroup chkSound = new CheckboxGroup();
	Checkbox chkOn = new Checkbox("On", true, chkSound);
	Checkbox chkOff = new Checkbox("Off", false, chkSound);
	
	JLabel lblText = new JLabel("Text");
	CheckboxGroup chkTextF = new CheckboxGroup();
	Checkbox chkF1 = new Checkbox("Micro 5", false, chkTextF);
	Checkbox chkF2 = new Checkbox("Pixel Operator", true, chkTextF);
	
	JLabel lblTheme = new JLabel("Theme");
	CheckboxGroup chkBoard = new CheckboxGroup();
	Checkbox chkBg1 = new Checkbox("Forest", false, chkBoard);
	Checkbox chkBg2 = new Checkbox("Sky", true, chkBoard);

	JPanel panelSouth = new JPanel();
	ImageIcon icoBack = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/back.png"));
	Image icoBackRedim = icoBack.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoBackR = new ImageIcon(icoBackRedim);
	JButton btnBack = new JButton("Back", icoBackR);


	ImageIcon icoConfirm = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/confirm.png"));
	Image icoConfirmRedim = icoConfirm.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoConfirmR = new ImageIcon(icoConfirmRedim);
	JButton btnConfirm = new JButton("Confirm", icoConfirmR);

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	SpringLayout spring = new SpringLayout();

	public PanelOptions() {
		super("home_background.png");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension (800, 800));

		 Border coloredBorder = BorderFactory.createLineBorder(colorForeground, 3);
			Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
			Border compoundBorder = BorderFactory.createCompoundBorder(coloredBorder, padding);
			
		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(80, 0, 0, 0));
		setTitleStyle(optionsTitle);
		optionsTitle.setOpaque(true);
		optionsTitle.setBackground(colorBackground);
		optionsTitle.setBorder(compoundBorder);
		panelNorth.add(optionsTitle);
		panelNorth.setOpaque(false);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(gridbag);
		panelCenter.setBackground(colorBackground);
		panelCenter.setBorder(compoundBorder);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 20, 20);
		
		// Sound
		lblSound.setForeground(colorForeground);
		lblSound.setFont(getFont().deriveFont(40f));
		panelCenter.add(lblSound, gbc);
		gbc.gridx = 1;
		chkOn.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkOn, gbc);
		gbc.gridx = 2;
		chkOff.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkOff, gbc);
		
		// Text
		gbc.gridx = 0;
		gbc.gridy = 1;
		lblText.setFont(getFont().deriveFont(40f));
		lblText.setForeground(colorForeground);
		panelCenter.add(lblText, gbc);
		gbc.gridx = 1;
		chkF1.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkF1, gbc);
		gbc.gridx = 2;
		chkF2.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkF2, gbc);
		
		// Board
		gbc.gridx = 0;
		gbc.gridy = 2;
		lblTheme.setForeground(colorForeground);
		lblTheme.setFont(getFont().deriveFont(40f));
		panelCenter.add(lblTheme, gbc);
		gbc.gridx = 1;
		chkBg1.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkBg1, gbc);
		gbc.gridx = 2;
		chkBg2.setFont(getFont().deriveFont(24f));
		panelCenter.add(chkBg2, gbc);
		gbc.gridwidth = 1;

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

		setButtonStyle(btnConfirm);
		btnConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfirm.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnConfirm);
		spring.putConstraint(SpringLayout.EAST, btnConfirm, -10, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnConfirm, 10, SpringLayout.NORTH, panelSouth);

		panelSouth.setOpaque(false);
		add(panelSouth, BorderLayout.PAGE_END);

	}
}

