package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class PlayerInfo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton btnClose = new JButton("Close");

	public PlayerInfo(JFrame mainFrame, Player player, Map<Integer, Square> squares) {
		
		super(mainFrame, player.getName(), true);
		
		setSize(600, 420);
		setLocationRelativeTo(null);
		setResizable(false);

		BackgroundPanel backgroundPanel = new BackgroundPanel("Sky.png");
		backgroundPanel.setLayout(new BorderLayout(20, 20));
		backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setContentPane(backgroundPanel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setOpaque(false);
		leftPanel.setPreferredSize(new Dimension(150, 0));
		
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		
		JLabel lblPlayer = new JLabel(player.getName(), JLabel.CENTER);
		lblPlayer.setFont(lblPlayer.getFont().deriveFont(1, 20f));
		lblPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JLabel lblIconPlayer = new JLabel();
		lblIconPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		leftPanel.add(lblPlayer);
		int id = player.getId();
		switch(id) {
		case 1:
			Utilities.setIco(lblIconPlayer, "dog.png", 50, 50);
			break;
		case 2:
			Utilities.setIco(lblIconPlayer, "iron.png", 50, 50);
			break;
		case 3:
			Utilities.setIco(lblIconPlayer, "boots.png", 50, 50);
			break;
		case 4:
			Utilities.setIco(lblIconPlayer, "thimble.png", 50, 50);
			break;
		}
		leftPanel.add(lblIconPlayer);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		
		JLabel lblMoney = new JLabel(player.getMoney() + " €");
		lblMoney.setFont(lblMoney.getFont().deriveFont(20f));
		lblMoney.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblIconMoney = new JLabel();
		lblIconMoney.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		leftPanel.add(lblMoney);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		Utilities.setIco(lblIconMoney, "money.png", 50, 50);
		leftPanel.add(lblIconMoney);
		

		JPanel panelProperties = new JPanel();
		panelProperties.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panelProperties.setOpaque(false);
		
		JScrollPane scroll = new JScrollPane(panelProperties, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(null);
		
		ArrayList<Square> properties = player.getProperties();
		if (properties == null || properties.isEmpty()) {
			JLabel propertiesInfo = new JLabel ("Player has no properties", JLabel.CENTER);
			propertiesInfo.setFont(propertiesInfo.getFont().deriveFont(1, 20f));
			panelProperties.add(propertiesInfo, BorderLayout.CENTER);
		}
		else {
			for (Square property : properties) {
				JPanel panelProperty = new JPanel();
				panelProperty.setPreferredSize(new Dimension(150, 180));
				panelProperty.setLayout(new BorderLayout());
				JPanel panelTitle = new JPanel();
				panelTitle.setPreferredSize(new Dimension(150, 20));
				Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
				Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
				panelTitle.setBorder(BorderFactory.createCompoundBorder(line, padding));

				if (property.getColor() != null && !property.getColor().isEmpty()) {
					panelTitle.setBackground(Color.decode(property.getColor()));
				} else {
					panelTitle.setBackground(Color.LIGHT_GRAY);
				}

				JLabel lblTitle = new JLabel(property.getName().toUpperCase(), JLabel.CENTER);
				lblTitle.setFont(new Font("Arial", Font.BOLD, 8));
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
				
				panelProperty.add(panelTitle, BorderLayout.NORTH);
				panelProperty.add(panelInfo, BorderLayout.CENTER);
				panelProperties.setOpaque(false);
				panelProperties.add(panelProperty);
				
			}
		}
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		southPanel.setOpaque(false);
		
		JPanel panelPosition = new JPanel();
		JLabel lblPositionTitle = new JLabel("Actual position:");
		lblPositionTitle.setFont(lblPositionTitle.getFont().deriveFont(1, 20f));
		Square currentSquare = squares.get(player.getPosition());
		JLabel lblPosition = new JLabel(currentSquare.getName());
		lblPosition.setFont(lblPosition.getFont().deriveFont(1, 20f));
		panelPosition.setLayout(new FlowLayout());
		panelPosition.add(lblPositionTitle);
		panelPosition.add(lblPosition);
		panelPosition.setBounds(360, 250, 100, 100);
		panelPosition.setOpaque(false);
		southPanel.add(panelPosition);
		southPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClose.setPreferredSize(new Dimension(100, 30));
		btnClose.setMaximumSize(new Dimension(100, 30));
		btnClose.addActionListener(this);
		southPanel.add(btnClose);
		
		backgroundPanel.add(leftPanel, BorderLayout.WEST);
		backgroundPanel.add(scroll, BorderLayout.CENTER);
		backgroundPanel.add(southPanel, BorderLayout.SOUTH);
		
		this.revalidate();
		this.repaint();
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
