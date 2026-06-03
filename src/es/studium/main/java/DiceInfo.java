package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DiceInfo extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;

	ImageIcon icoDices = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/dices.png"));
	Image icoDicesRedim = icoDices.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoDicesR = new ImageIcon(icoDicesRedim);
	JLabel lblIconDice = new JLabel(icoDicesR);
	
	JLabel oneDot = new JLabel(".", JLabel.CENTER);
	JLabel twoDot = new JLabel("..", JLabel.CENTER);
	JLabel threeDot = new JLabel("...", JLabel.CENTER);

	JLabel resultDice = new JLabel("", JLabel.CENTER);
	public DiceInfo(JFrame mainFrame, int resultRollingDice) {
		super(mainFrame, "Rolling dices...");
		
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
