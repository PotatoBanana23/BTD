import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class SuperMonkey {
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	private int r = 20; 

	public SuperMonkey(int x, int y) {
		img = getImage("/imgs/superMonkey.png"); //load the image for Tree
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
		tx.scale(0.14, 0.14);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.35, 0.35);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = SuperMonkey.class.getResource(path);
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
