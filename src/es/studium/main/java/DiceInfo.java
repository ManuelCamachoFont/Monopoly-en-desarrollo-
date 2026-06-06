package es.studium.main.java;


import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class DiceInfo extends JDialog
{
	private static final long serialVersionUID = 1L;

	JLabel lblIconDice = new JLabel();
	
	JLabel resultDice1 = new JLabel("", JLabel.CENTER);
	JLabel resultDice2 = new JLabel("", JLabel.CENTER);
	
	JLabel resultTotal = new JLabel("", JLabel.CENTER);
	

	public DiceInfo(JFrame mainFrame, int[] resultRollingDice, String playerName, String background) {
		super(mainFrame, "Rolling dices...", false);
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		BackgroundPanel container = new BackgroundPanel(background);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(Box.createRigidArea(new Dimension(0, 15)));
		
		Utilities.setIco(lblIconDice, "dices.png", 80, 80);
		lblIconDice.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(lblIconDice);
		
		container.add(Box.createRigidArea(new Dimension(0, 15)));
		
		resultDice1.setText("First dice rolled: " + resultRollingDice[0]);
		resultDice1.setFont(resultDice1.getFont().deriveFont(20f));
		resultDice1.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(resultDice1);
		
		container.add(Box.createRigidArea(new Dimension(0, 15)));
		
		resultDice2.setText("Second dice rolled: " + resultRollingDice[1]);
		resultDice2.setFont(resultDice2.getFont().deriveFont(20f));
		resultDice2.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(resultDice2);

		container.add(Box.createRigidArea(new Dimension(0, 15)));
		
		resultTotal.setText(playerName + " will move: " + (resultRollingDice[0] + resultRollingDice[1] + " steps."));
		resultTotal.setFont(resultTotal.getFont().deriveFont(20f));
		resultTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

		container.add(resultTotal);
		
		add(container);
	
	}
	
	public void showInfo() {
		this.setVisible(true);
	}

}