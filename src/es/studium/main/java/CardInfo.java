package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class CardInfo extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnClose = new JButton("Close");

	public CardInfo(JFrame mainFrame, Card card) {
		super(mainFrame, card.getType(), true);
		setSize(400, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		JPanel panelInfo = new JPanel(new BorderLayout());
		JTextArea description = new JTextArea();
		description.setBorder(new EmptyBorder(15, 15, 15, 15));
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		description.setText(card.getText());
		panelInfo.add(description, BorderLayout.CENTER);
		add(panelInfo, BorderLayout.CENTER);
		
		
		JPanel panelButton = new JPanel(new BorderLayout());
		btnClose.addActionListener(this);
		panelButton.add(btnClose, BorderLayout.CENTER);
		
		add(panelButton, BorderLayout.SOUTH);
		
	}
	
	public static void showInfo(JFrame mainFrame, Card cards) {
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
