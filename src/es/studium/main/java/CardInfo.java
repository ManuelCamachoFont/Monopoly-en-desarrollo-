package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardInfo extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnClose = new JButton("Close");

	public CardInfo(JFrame mainFrame, Card cards) {
		super(mainFrame, cards.getType(), true);
		setSize(400, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		JPanel panelInfo = new JPanel(new BorderLayout());
		
		
		add(panelInfo, BorderLayout.CENTER);
		
		
		JPanel panelButton = new JPanel(new BorderLayout());
		btnClose.addActionListener(this);
		panelButton.add(btnClose, BorderLayout.CENTER);
		
		add(panelButton, BorderLayout.SOUTH);
		
	}
	
	public static void drawCard(JFrame mainFrame, Card cards) {
		CardInfo dialog = new CardInfo(mainFrame, cards);
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClose)) {
			dispose();
		}
		
	}
}
