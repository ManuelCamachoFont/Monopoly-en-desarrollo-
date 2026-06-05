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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelOptions extends BackgroundPanel{

	JPanel panelNorth = new JPanel();
	JLabel optionsTitle = new JLabel("Options");

	JPanel panelCenter = new JPanel();
	JLabel lblSound = new JLabel("Sound");
	CheckboxGroup chkSound = new CheckboxGroup();
	Checkbox chk0 = new Checkbox("0%", false, chkSound);
	Checkbox chk25 = new Checkbox("25%", false, chkSound);
	Checkbox chk75 = new Checkbox("75%", false, chkSound);
	Checkbox chk100 = new Checkbox("100%", false, chkSound);
	
	JLabel lblText = new JLabel("Text");
	CheckboxGroup chkTextC = new CheckboxGroup();
	Checkbox chkRed = new Checkbox("Red", false, chkTextC);
	Checkbox chkGreen = new Checkbox("Green", false, chkTextC);
	CheckboxGroup chkTextF = new CheckboxGroup();
	Checkbox chkF1 = new Checkbox("Courier New", false, chkTextF);
	Checkbox chkF2 = new Checkbox("Pixel Operator", false, chkTextF);
	
	JLabel lblBoard = new JLabel("Board");
	CheckboxGroup chkBoard = new CheckboxGroup();
	Checkbox chkBg1 = new Checkbox("Forest", false, chkBoard);
	Checkbox chkBg2 = new Checkbox("Sky", false, chkBoard);

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
		super("Sky.png");
		setLayout(new BorderLayout());

		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(80, 0, 0, 0));
		optionsTitle.setFont(new Font("Cooper Black", 1, 62));
		optionsTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(optionsTitle);
		panelNorth.setOpaque(false);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(gridbag);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 20, 20);
		
		// Sound
		panelCenter.add(lblSound, gbc);
		gbc.gridx = 1;
		panelCenter.add(chk0, gbc);
		gbc.gridx = 2;
		panelCenter.add(chk25, gbc);
		gbc.gridx = 3;
		panelCenter.add(chk75, gbc);
		gbc.gridx = 4;
		panelCenter.add(chk100, gbc);
		
		// Text
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelCenter.add(lblText, gbc);
		gbc.gridx = 1;
		panelCenter.add(chkGreen, gbc);
		gbc.gridx = 2;
		panelCenter.add(chkRed, gbc);
		gbc.gridx = 3;
		panelCenter.add(chkF1, gbc);
		gbc.gridx = 4;
		panelCenter.add(chkF2, gbc);
		
		// Board
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCenter.add(lblBoard, gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		panelCenter.add(chkBg1, gbc);
		gbc.gridx = 3;
		panelCenter.add(chkBg2, gbc);
		gbc.gridwidth = 1;

		panelCenter.setOpaque(false);
		add(panelCenter, BorderLayout.CENTER);

		// South Panel
		panelSouth.setLayout(spring);

		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnBack);
		spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

		btnConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfirm.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnConfirm);
		spring.putConstraint(SpringLayout.EAST, btnConfirm, -10, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnConfirm, 10, SpringLayout.NORTH, panelSouth);

		panelSouth.setOpaque(false);
		add(panelSouth, BorderLayout.PAGE_END);

	}
}

