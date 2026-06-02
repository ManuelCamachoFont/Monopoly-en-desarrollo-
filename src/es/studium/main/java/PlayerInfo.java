package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

	public PlayerInfo(JFrame mainFrame, Player player) {
		
		super(mainFrame, player.getName(), true);
		
		setSize(600, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		System.out.println("Test");
		
		setLayout(null);
		
		JLabel lblPlayer = new JLabel(player.getName());
		ImageIcon icoPlayer = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
		Image icoPlayerRedim = icoPlayer.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoPlayerR = new ImageIcon(icoPlayerRedim);
		JLabel lblIconPlayer = new JLabel(icoPlayerR);
		lblPlayer.setBounds(90, 30, 100, 40);
		add(lblPlayer);
		lblIconPlayer.setBounds(90, 80, 50, 50);
		add(lblIconPlayer);
		
		JLabel lblMoney = new JLabel(player.getMoney() + " €");
		ImageIcon icoMoney = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
		Image icoMoneyRedim = icoMoney.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoMoneyR = new ImageIcon(icoMoneyRedim);
		JLabel lblIconMoney = new JLabel(icoMoneyR);
		lblMoney.setBounds(90, 180, 100, 40);
		add(lblMoney);
		lblIconMoney.setBounds(90, 230, 50, 50);
		add(lblIconMoney);
		

		JPanel panelProperties = new JPanel();
		panelProperties.setLayout(new FlowLayout());
		JScrollPane scroll = new JScrollPane(panelProperties, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ArrayList<Square> properties = player.getProperties();
		if (properties == null || properties.isEmpty()) {
			JLabel propertiesInfo = new JLabel ("Player has no properties");
			panelProperties.add(propertiesInfo);
		}
		else {
			for (Square property : properties) {
				JPanel panelProperty = new JPanel();
				panelProperty.setPreferredSize(new Dimension(150, 180));
				panelProperty.setLayout(new BorderLayout());
				JPanel panelTitle = new JPanel();
				panelTitle.setPreferredSize(new Dimension(0, 20));
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
			}
		}
		scroll.setBounds(260, 30, 300, 200);
		add(scroll);
		
		
		JPanel panelPosition = new JPanel();
		JLabel lblPositionTitle = new JLabel("Actual position:");
		// Square hashmap
		JLabel lblPosition = new JLabel(player.getPosition() +"");
		panelPosition.setLayout(new FlowLayout());
		panelPosition.add(lblPositionTitle);
		panelPosition.add(lblPosition);
		panelPosition.setBounds(360, 250, 100, 100);
		add(panelPosition);

		btnClose.setFont(new Font("Arial", Font.BOLD, 12));
		btnClose.addActionListener(this);
		btnClose.setBounds(250, 340, 100, 30);
		add(btnClose);
		
	}
		
		public static void showInfo(JFrame mainFrame, Player player) {
			PlayerInfo dialog = new PlayerInfo(mainFrame, player);
			dialog.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnClose)) {
				dispose();
			}

		}

}
