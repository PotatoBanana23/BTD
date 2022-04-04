import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bloon{
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	private double speed;

	public Bloon(int x, int y, double speed) {
		img = getImage("/imgs/redBloon.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		this.speed = speed;

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void move() {
		for (int i = 0; i < 140; i += speed) {
			x += speed;
		} 
	}
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		if (x < 140 && y == 350) {
			x += speed;
		}
		
		if (y > 170 && x > 135 && x < 145) {
			y -= speed;
		}
		
		if (x < 330 && y > 165 && y < 175) {
			x += speed;
		}
		
		if (y < 550 && x > 325 && x < 335) {
			y += speed;
		}
		
		if (x < 90 && y > 545 && y < 555) {
			x -= speed;
		}
		//move();
		
//		if (y > 170 && x == 140) {
//			y -= speed;
//		} else if (y < 170){
//			y = 170;
//		}
//		
//		if (x < 330 && y == 170) {
//			x += speed;
//		}else if (x > 330) {
//			x = 330;
//		}
		
		
//		else if (y > 170) {
//			y -= speed;
//		} else if (x < 330) {
//			x += speed;
//		} else if (x >= 330 && y < 550) {
//			y += speed;
//		} else if (x > 90) {
//			x -= speed;
//		} else if (y < 690) {
//			y += speed;
//		}
		
		//x += speedX;
		//y += speedY;
		update();

	}
	//getters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	//setters for speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.4, 0.4);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.8, .8);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Bloon.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	

}
