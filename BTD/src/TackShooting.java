import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class TackShooting {
	private int x, y;
	private double vX, vY; 
	private Image img;
	private AffineTransform tx;
	private int val;
	private int r = 120; 

	public TackShooting(int x, int y, double vX, double vY, int val) {
		//val is for the tack number starting from the one going bottom right bc that is unchanged image
		img = getImage("/imgs/tack.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		double equalizer = (int) (Math.sqrt(vX*vX + vY*vY));
		if (val == 1) {
			this.vX = vX;
			this.vY = vY; 
		}
		if (val == 2) {
			this.vX = 0;
			this.vY = equalizer; 
		}
		if (val == 3) {
			this.vX = -vX;
			this.vY = vY; 
		}
		if (val == 4) {
			this.vX = -equalizer;
			this.vY = 0; 
		}
		if (val == 5) {
			this.vX = -vX;
			this.vY = -vY; 
		}
		if (val == 6) {
			this.vX = 0;
			this.vY = -equalizer; 
		}
		if (val == 7) {
			this.vX = vX;
			this.vY = -vY; 
		}
		if (val == 8) {
			this.vX = equalizer;
			this.vY = 0; 
		}
		this.val = val;
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
		if (val == 2) {
			tx.rotate(Math.PI / 4);
		}
		if (val == 3) {
			tx.rotate(Math.PI / 2);
		}
		if (val == 4) {
			tx.rotate(3 * Math.PI / 4);
		}
		if (val == 5) {
			tx.rotate(Math.PI);
		}
		if (val == 6) {
			tx.rotate(5 * Math.PI / 4);
		}
		if (val == 7) {
			tx.rotate(3 * Math.PI / 2);
		}
		if (val == 8) {
			tx.rotate(7 * Math.PI / 4);
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		x += vX; 
		y += vY; 
		update();

	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1, 1);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.05, 0.05);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = TackShooting.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y; 
	}
	
	public int getR() {
		return r; 
	}
}