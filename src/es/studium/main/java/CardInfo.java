package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
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
		
		BackgroundPanel panelBackground = new BackgroundPanel("card.png");
		
		Utilities.setExactSize(this, 704, 492);
		setLocationRelativeTo(null);
		setResizable(false);
		panelBackground.setLayout(new BorderLayout());
		
		JPanel panelInfo = new JPanel(new BorderLayout());
		JTextArea description = new JTextArea();
		description.setFont(description.getFont().deriveFont(30f));
		description.setBorder(new EmptyBorder(200, 90, 90, 90));
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		description.setText(card.getText());
		description.setOpaque(false);
		panelInfo.setOpaque(false);
		panelInfo.add(description, BorderLayout.CENTER);
		panelBackground.add(panelInfo, BorderLayout.CENTER);
		
		
		JPanel panelButton = new JPanel(new BorderLayout());
		btnClose.addActionListener(this);
		panelButton.setOpaque(false);
		panelButton.add(btnClose, BorderLayout.CENTER);
		
		panelBackground.add(panelButton, BorderLayout.SOUTH);
		
		add(panelBackground);
		
	}
	
	public void showInfo() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClose)) {
			dispose();
		}
		
	}
}
