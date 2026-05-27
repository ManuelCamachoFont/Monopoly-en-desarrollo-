package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainView {

	JFrame mainWindow = new JFrame("MONOPOLY");
	JLabel mainTitle = new JLabel("Monopoly");
	
	JButton btnGame = new JButton ("New Game");
	JButton btnExit = new JButton ("Exit");
	

	JPanel panelButtons = new JPanel(new FlowLayout());
	ImageIcon icoOptions = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/options.png"));
	Image icoRedimension = icoOptions.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon icoOptionsR = new ImageIcon(icoRedimension);
	JButton btnOptions = new JButton("Options", icoOptionsR);
	
	JButton btnHelp = new JButton("Help");
	
	JButton btnRank = new JButton("Ranking");
	
	
	public MainView() {
		mainWindow.setSize(600, 600);
		mainWindow.setLayout(new BorderLayout());
		
		mainWindow.add(mainTitle, BorderLayout.NORTH);
		
		mainWindow.add(btnGame, BorderLayout.CENTER);
		mainWindow.add(btnExit, BorderLayout.CENTER);
		
		
		btnOptions.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOptions.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		panelButtons.add(btnOptions);
		panelButtons.add(btnHelp);
		panelButtons.add(btnRank);
		mainWindow.add(panelButtons, BorderLayout.PAGE_END);
		
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new MainView();
	}

}

