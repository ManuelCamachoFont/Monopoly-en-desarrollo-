package es.Studium.Monopoly;

public class Principal
{

	public static void main(String[] args)
	{
		MainWindow mainWindow = new MainWindow();
		Modelo modelo = new Modelo();
		new Controlador(mainWindow, modelo);

	}

}
