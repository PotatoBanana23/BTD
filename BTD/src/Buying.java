import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Buying{
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	int val = 0;

	public Buying(int num, int x, int y) {
		this.x = x;
		this.y = y;
		if (num == 1) {
			img = getImage("/imgs/dartMonkey.png");
			val = 1;
		}
		if (num == 2) {
			img = getImage("/imgs/tackShooter.png");
			val = 2;
		}
		if (num == 3) {
			img = getImage("/imgs/iceMonkey.png");
			val = 3;
		}
		if (num == 4) {
			img = getImage("/imgs/cannon.png");
			val = 4;
		}
		if (num == 5) {
			img = getImage("/imgs/superMonkey.png");
			val = 5;
		}
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
	}
	
	public int getID() {
		return val;
	}
	
	public void locationUpdate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
		if (val == 2) {
			tackUpdate();
		}
		if (val == 3) {
			iceUpdate();
		}
		if (val == 5) {
			superUpdate();
		}
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
		if (val == 2) {
			tackUpdate();
		}
		if (val == 3) {
			iceUpdate();
		}
		if (val == 5) {
			superUpdate();
		}
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1, 1);
	}
	
	private void tackUpdate() {
		tx.setToTranslation(x, y);
		tx.scale(0.75, 0.75);
	}
	
	private void iceUpdate() {
		tx.setToTranslation(x, y);
		tx.scale(0.7, 0.7);
	}
	
	private void superUpdate() {
		tx.setToTranslation(x, y);
		tx.scale(0.14, 0.14);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 0.5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Lives.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
