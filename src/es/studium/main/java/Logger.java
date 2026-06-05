package es.studium.main.java;

public class Logger {
	
	private static String logs = "";
	
	
	private static void saveLog(String text) {
		logs += text + "\n";
	}
}
