package es.studium.main.java;

import java.util.Map;

import javax.swing.JFrame;

public class DialogsInfo {

	private JFrame mainFrame;
	private Map<Integer, Square> squares;

	public DialogsInfo(JFrame mainFrame, Map<Integer, Square> squares) {
		this.mainFrame = mainFrame;
		this.squares = squares;
	}

	public void showPropertyInfo(Square property) {
		if (property == null) 
		{
			return;
		}
		SquareInfo dialog = new SquareInfo(mainFrame, property);
		dialog.setVisible(true);
	}

	public void showPlayerInfo(Player player) {
		if (player == null) {
			return;
		}
		PlayerInfo dialog = new PlayerInfo(mainFrame, player, this.squares);
		dialog.setVisible(true);
	}

	public void showDiceInfo(int result) {
		DiceInfo dialog = new DiceInfo(mainFrame, result);
		dialog.setVisible(true);
	}
}
