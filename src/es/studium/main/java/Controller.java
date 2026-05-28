package es.studium.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource().equals(v.getPanelHome().btnGame)) {
			v.showPanel("START");
		}
		else if (e.getSource().equals(v.getPanelHome().btnOptions)) {
			v.showPanel("OPTIONS");
		}
		else if (e.getSource().equals(v.getPanelStart().choPlayers)) {
			m.hidePlayers();
			m.showPlayers();
		}
		else if (e.getSource().equals(v.getPanelStart().btnBack)) {
			v.showPanel("HOME");
		}
		else if (e.getSource().equals(v.getPanelStart().btnPlay)) {
			m.savePlayers();
			v.showPanel("BOARD");
		}
		else if (e.getSource().equals(v.getPanelOptions().btnBack)) {
			v.previousPanel();
		}
		else if (e.getSource().equals(v.getPanelOptions().btnConfirm)) {
			m.saveSettings();
		}
		
		
	}

}
