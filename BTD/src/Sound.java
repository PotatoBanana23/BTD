import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable  {
	
	private Thread t;
	private File audioFile ;
	private AudioInputStream audioStream;
	private Clip audioClip;
	private String fn;
	private boolean loops = false;
	
	private int x, y;
	private Image img; 	
	private AffineTransform tx;

	public Sound(int x, int y) {
		img = getImage("/imgs/soundOn.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public Sound() {
		int x = 865;
		int y = 700;
		img = getImage("/imgs/soundOff.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();

	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1, 1);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Sound.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	/**
	 * Create a music object from a given file name. 
	 * The music file should be stored outside of the src folder but in the same project.
	 * 
	 * @param fileName name of file such as "backgroundmusic.wav"
	 * @param loops Set to true if you want the sound to loop continuously
	 */
	public Sound(String fileName, boolean loops) {
		fn = fileName;
		audioFile = new File(fileName);
		this.loops = loops;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, format);
	        audioClip = (Clip) AudioSystem.getLine(info);
	        
	              
	        audioClip.open(audioStream);
	        //audioClip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Stop the music
	 */
	public void stop() {
		loops = false;
		audioClip.stop();
		try {
			t.sleep(100);
			audioClip.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * Start the music. If the object was created with loops set to true then
	 * it will loop otherwise it will be played once. 
	 */
	public void play() {		
		if(loops == false) {
			audioClip.start();
		}else {
			start3();
		}
	}
	
	
	
	int count = 0;
	private void start3() {
		
	     t = new Thread (this, "run");
	     if(audioClip.isActive()==false && loops || count == 0) {
	    	 count++;
	    	 start2();
	     }
	    
	     t.start();
	}
	
	private void start() {
	     t = new Thread(this, "run");
	     t.start();
	}
	
	private void start2() {
		audioFile = new File(fn);
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, format);
	        audioClip = (Clip) AudioSystem.getLine(info);
	        audioClip.open(audioStream);
	        audioClip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// audioClip.start();
		play();
	}
	

}