package es.studium.main.java;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogsManager
{

	private JFrame mainFrame;
	private Map<Integer, Square> squares;

	private JDialog jailDialog;

	public DialogsManager(JFrame mainFrame, Map<Integer, Square> squares) {
		this.mainFrame = mainFrame;
		this.squares = squares;
	}

	public void showPropertyInfo(Square property)
	{
		if (property == null) {
			return;
		}
		SquareInfo dialog = new SquareInfo(mainFrame, property);
		dialog.showInfo();
	}
	
	public void showCardInfo(Card card)
	{
		if (card == null) {
			return;
		}
		CardInfo dialog = new CardInfo(mainFrame, card);
		dialog.showInfo();
	}

	public void showPlayerInfo(Player player)
	{
		if (player == null) {
			return;
		}
		PlayerInfo dialog = new PlayerInfo(mainFrame, player, this.squares);
		dialog.showInfo();
	}

	public void showDiceInfo(int[] result, String playerName) {
		DiceInfo dialog = new DiceInfo(mainFrame, result, playerName);
		dialog.showInfo();
	}

	public JailInfo prepareJailInfo(Player player)
	{
		if (this.jailDialog != null) {
			this.jailDialog.dispose();
		}
		JailInfo dialog = new JailInfo(mainFrame, player);
		this.jailDialog = dialog;
		return dialog;
	}

	public void showJailInfo()
	{
		if (this.jailDialog != null) {
			this.jailDialog.setVisible(true);
		}
	}

	public void hideDialogsInfo()
	{
		if (jailDialog != null) {
			jailDialog.setVisible(false);
	        jailDialog.dispose();
	        jailDialog = null;
		}
	}
}
