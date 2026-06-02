package es.studium.main.java;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class SoundOption {

	private static Clip music;
	
	public static void musicLoop(JFrame mainFrame, String source) {

        try {
        	URL urlSound = SoundOption.class.getResource(source);
        	if (urlSound == null) {
                System.out.println("Error file not found: " + source);
                return;
            }
            AudioFileFormat aff = AudioSystem.getAudioFileFormat(urlSound);
            AudioInputStream ais = AudioSystem.getAudioInputStream(urlSound);
            AudioFormat af = aff.getFormat();
            
            DataLine.Info info = new DataLine.Info(
                Clip.class,
                ais.getFormat(), 
                ((int) ais.getFrameLength() * af.getFrameSize())
            );
            
            music = (Clip) AudioSystem.getLine(info);
            music.open(ais);
            music.loop(Clip.LOOP_CONTINUOUSLY);

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
