package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DiceInfo extends JDialog
{
	private static final long serialVersionUID = 1L;

	ImageIcon icoDices = new ImageIcon(getClass().getResource("/es/studium/main/resources/gif/dice-rolling.gif"));
	JLabel lblIconDice = new JLabel(icoDices);
	
	JLabel oneDot = new JLabel(".", JLabel.CENTER);
	JLabel twoDot = new JLabel("..", JLabel.CENTER);
	JLabel threeDot = new JLabel("...", JLabel.CENTER);

	JLabel resultDice = new JLabel("", JLabel.CENTER);
	public DiceInfo(JFrame mainFrame, int resultRollingDice) {
		super(mainFrame, "Rolling dices...", true);
		
		setSize(300, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		JPanel panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(0, 50));
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
		panelTitle.setBorder(BorderFactory.createCompoundBorder(line, padding));
		
		panelTitle.add(new JLabel("Throwing dices..."), JLabel.CENTER);
		add(panelTitle, BorderLayout.NORTH);
		
		oneDot.setVisible(false);
		twoDot.setVisible(false);
		threeDot.setVisible(false);
		resultDice.setVisible(false);
		
		add(lblIconDice,BorderLayout.CENTER);
		add(oneDot);
		add(twoDot);
		add(threeDot);
		resultDice.setFont(new Font("Arial", 1, 36));
		add(resultDice);
		
		setVisible(true);
	}


}