
package es.studium.main.java;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JailInfo extends JDialog
{
	private static final long serialVersionUID = 1L;
	
	JLabel lblInfo1 = new JLabel("", JLabel.CENTER);
	JLabel lblInfo2 = new JLabel("", JLabel.CENTER);
	JLabel lblInfo3 = new JLabel("", JLabel.CENTER);
	
	JButton btnPay = new JButton("Pay fee");
	JButton btnCard = new JButton("Use card");
	
	GridBagLayout gridbag = new GridBagLayout();
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	
	public JailInfo(JFrame mainFrame, Player player) {
		super(mainFrame, "Prison", true);
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel container = new JPanel();
	
		container.setLayout(gridbag);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridwidth = 2;
		lblInfo1.setText("You are in the JAIL");
		container.add(lblInfo1, gbc);
		
		gbc.gridy = 1;
		lblInfo2.setText("You can wait " + player.getJailTurns() + " turns.");
		container.add(lblInfo2, gbc);
		
		gbc.gridy = 2;
		lblInfo3.setText("Or choice one of the next options:");
		container.add(lblInfo3, gbc);
		gbc.gridwidth = 1;
		
		btnPay.setActionCommand("JAIL_PAY");
		btnCard.setActionCommand("JAIL_CARD");
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		container.add(btnPay, gbc);
		
		gbc.gridx = 1;
		btnCard.setEnabled(false);
		
		if (player.getJailCards() > 0) {
			btnCard.setEnabled(true);
		}
		
		container.add(btnCard, gbc);
		add(container);

	}


}