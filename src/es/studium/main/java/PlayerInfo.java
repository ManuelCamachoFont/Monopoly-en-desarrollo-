package es.studium.main.java;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		JScrollPane scroll = new JScrollPane(panelProperties, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
