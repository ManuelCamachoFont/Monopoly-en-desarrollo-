package es.studium.main.java;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Controller implements ActionListener{

	private Model m;
	private View v;

	public Controller(Model model, View v) {
		this.m = model;
		this.v = v;

		// Panel Home Buttons
		this.v.getPanelHome().btnGame.addActionListener(this);
		this.v.getPanelHome().btnExit.addActionListener(this);
		this.v.getPanelHome().btnOptions.addActionListener(this);
		this.v.getPanelHome().btnHelp.addActionListener(this);
		this.v.getPanelHome().btnRank.addActionListener(this);

		// Panel Options Buttons
		this.v.getPanelOptions().btnBack.addActionListener(this);

		// Panel Start Buttons
		this.v.getPanelStart().choPlayers.addActionListener(this);
		this.v.getPanelStart().btnBack.addActionListener(this);
		this.v.getPanelStart().btnPlay.addActionListener(this);
		
		// Panel Help Buttons
		this.v.getPanelHelp().btnBack.addActionListener(this);
		this.v.getPanelHelp().btnMHelp.addActionListener(this);
		
		// Panel Ranking Buttons
		this.v.getPanelRank().btnBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Panel Home actions
		if (e.getSource().equals(v.getPanelHome().btnGame)) {
			v.showPanel("START");
		}
		else if (e.getSource().equals(v.getPanelHome().btnExit)) {
			System.exit(0);
		}
		else if (e.getSource().equals(v.getPanelHome().btnOptions)) {
			v.showPanel("OPTIONS");
		}
		else if (e.getSource().equals(v.getPanelHome().btnHelp)) {
			v.showPanel("HELP");
		}
		else if (e.getSource().equals(v.getPanelHome().btnRank)) {
			v.showPanel("RANKING");
		}
		
		// Panel Start actions
		else if (e.getSource().equals(v.getPanelStart().choPlayers)) {
			selectPlayers();
		}
		else if (e.getSource().equals(v.getPanelStart().btnBack)) {
			v.showPanel("HOME");
		}
		else if (e.getSource().equals(v.getPanelStart().btnPlay)) {
			// Check player name != Player X AND != isEmpty
			//m.addPlayer();
			v.showPanel("BOARD");
			v.getFrame().pack();
			v.getFrame().setLocationRelativeTo(null);
		}
		
		// Panel Options actions
		else if (e.getSource().equals(v.getPanelOptions().btnBack)) {
			v.previousPanel();
		}
		else if (e.getSource().equals(v.getPanelOptions().btnConfirm)) {
			m.saveSettings();
		}
		
		// Panel Help actions
		else if(e.getSource().equals(v.getPanelHelp().btnBack)){
			v.showPanel("HOME");
		}
		else if (e.getSource().equals(v.getPanelHelp().btnMHelp)) {
			// Open htlm with rules
		}
		
		// Panel Rank actions
		else if(e.getSource().equals(v.getPanelRank().btnBack)) {
			v.showPanel("HOME");
		}
		
		// Activate END GAME SCreen
		//	v.showPanel("END");
		//	v.getFrame().pack();
		//	v.getFrame().setLocationRelativeTo(null);


	}

	private void selectPlayers() {
		JComboBox<String> choPlayers = v.getPanelStart().choPlayers;
		String selection = choPlayers.getSelectedItem().toString();

		int players = 0;
		switch(selection) {
		case "2 Players":
			players = 2;
			break;
		case "3 Players":
			players = 3;
			break;
		case "4 Players":
			players = 4;
			break;
		default:
			players = 0;
			break;

		}
		m.setPlayers(players);
		
		JPanel panelPlayers = v.getPanelStart().panelPlayers;
        Component[] components = panelPlayers.getComponents();
        
        for (int i = 0; i < components.length; i++) {
            int player = (i / 2) + 1; 
            
            if (player <= m.getPlayers()) {
                components[i].setVisible(true);
            } else {
                components[i].setVisible(false);
            }
        }
        
        panelPlayers.revalidate();
        panelPlayers.repaint();
	}

}
