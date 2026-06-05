package es.studium.main.java;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	
	private static List<LogEntry> logs = new ArrayList<>();
	
	public static class LogEntry {
        String text;
        Color color;
        public LogEntry(String text, Color color) {
            this.text = text;
            this.color = color;
        }
    }
	
	public static void saveLog(String text, Color color) {
		logs.add(new LogEntry(text, color));
	}
	
	public static List<LogEntry> readAndEmpty() {
        List<LogEntry> aux = new ArrayList<>(logs);
        logs.clear();
        return aux;
    }
}
