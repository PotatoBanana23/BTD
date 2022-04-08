import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class CannonShooting {
	private int x, y;
	private double vX, vY; 
	private Image img; 	
	private AffineTransform tx;
	private double xSize, ySize;
	private boolean exploded;

	public CannonShooting(int x, int y, double vX, double vY, String fileName) {
		img = getImage(fileName); //load the image for Tree
		this.x = x;
		this.y = y;
		this.vX = vX;
		this.vY = vY;
		xSize = 0.5;
		ySize = 0.5;
		exploded = false;

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
		x += vX; 
		y += vY;
		if (exploded) {
			xSize += 0.0003;
			ySize += 0.0003;
		}
		update(xSize, ySize);
		

	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public double getXSize() {
		return xSize;
	}
	
	public double getYSize() {
		return ySize;
	}
	
	public void setExploded() {
		exploded = true;
	}
	
	public void update(double xSize, double ySize) {
		tx.setToTranslation(x, y);
		tx.scale(xSize, ySize);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.2, 0.2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = CannonShooting.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
