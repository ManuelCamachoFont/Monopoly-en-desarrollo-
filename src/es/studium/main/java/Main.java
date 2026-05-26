package es.studium.main.java;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		MainView mv = new MainView();
		new Controller (model, mv);

	}

}
