package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SquareInfo extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnClose = new JButton("Close");

	public SquareInfo(JFrame mainFrame, Square property) {

		super(mainFrame, property.getName(), true);

		setSize(300, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(0, 50));
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
		panelTitle.setBorder(BorderFactory.createCompoundBorder(line, padding));

		if (property.getColor() != null && !property.getColor().isEmpty()) {
			panelTitle.setBackground(Color.decode(property.getColor()));
		} else {
			panelTitle.setBackground(Color.LIGHT_GRAY);
		}

		JLabel lblTitle = new JLabel(property.getName().toUpperCase(), JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		panelTitle.add(lblTitle);

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		panelInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel lblPrice = new JLabel("Buying price: " + property.getPrice() + " €");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfo.add(lblPrice);
		panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblRent = new JLabel("Rent pay: " + property.getRent() + " €");
		lblRent.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRent.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfo.add(lblRent);
		panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));

		if (property.getType().equals("PROPIEDAD")) {
			JLabel lblHouses = new JLabel("Houses: " + property.getHouses());
			lblHouses.setFont(new Font("Arial", Font.PLAIN, 14));
			lblHouses.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblHouses);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));

			JLabel lblHotel = new JLabel();
			if (property.hasHotel()) {
				lblHotel.setText("Hotel: Has hotel");
			}
			else {
				lblHotel.setText("Hotel: No hotel");
			}
			lblHotel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblHotel.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblHotel);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));
		}
		
		if (property.getType().equals("ESTACION")) {
			JLabel lblRent2 = new JLabel("Rent with 2: " + (property.getRent()*2) + " €");
			lblRent2.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRent2.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblRent2);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));
			JLabel lblRent3 = new JLabel("Rent with 3: " + (property.getRent()*2)*2 + " €");
			lblRent3.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRent3.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblRent3);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));
			JLabel lblRent4 = new JLabel("Rent with 4: " + ((property.getRent()*2)*2)*2 + " €");
			lblRent4.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRent4.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblRent4);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));
		}
		
		if (property.getType().equals("SERVICIO")) {
			lblRent.setText("Rent pay: "  + "Dices result * 4");
			JLabel lblRent2 = new JLabel("Rent pay: "  + "Dices result * 10");
			lblRent2.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRent2.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelInfo.add(lblRent2);
			panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));
		}
		
		JLabel lblOwner = new JLabel();

		if (property.getOwner() == null) {
			lblOwner.setText("Owner: None");
		} else {

			lblOwner.setText("Owner: " + property.getOwner());
		}

		lblOwner.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOwner.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfo.add(lblOwner);
		panelInfo.add(Box.createRigidArea(new Dimension(0, 15)));


		btnClose.setFont(new Font("Arial", Font.BOLD, 12));
		btnClose.addActionListener(this);

		JPanel panelButton = new JPanel();
		panelButton.add(btnClose);

		add(panelTitle, BorderLayout.NORTH);
		add(panelInfo, BorderLayout.CENTER);
		add(panelButton, BorderLayout.SOUTH);
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