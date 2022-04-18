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
	private String fileName; 

	public Bloon(double speed) {
		fileName = "/imgs/redBloon.png";
		img = getImage("/imgs/redBloon.png"); //load the image for Tree
		x = 0;
		y = 350;
		this.speed = speed;

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		fileName = newFileName; 
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
		
		
		//bloon movement
		if (x < 140 && x >= 0 && y == 350) {
			x += speed;
		}
		
		if (y > 170 && y <= 350 && x > 140-(speed+1) && x < 140+speed+1) {
			y -= speed;
		}
		
		if (x < 330 && x >= 130 && y > 170-(speed+1) && y < 170+(speed+1)) {
			x += speed;
		}
		
		if (y < 550 && y >= 160 && x > 330-(speed+1) && x < 330+(speed+1)) {
			y += speed;
		}
		
		if (x > 90 && x <= 340 && y > 550-(speed+1) && y < 550+(speed+1)) {
			x -= speed;
		}
		if (y < 690 && y >= 520 && x > 90-(speed+1) && x < 90+(speed+1)) {
			y += speed;
		}
		if (x < 670 && x >= 80 && y > 690-(speed+1) && y < 690+(speed+1)) {
			x += speed;
		}
		if (y > 480 && y <= 700 && x > 670-(speed+1) && x < 670+(speed+1)) {
			y -= speed;
		}
		if (x <= 680 && x > 490 && y > 480-(speed+1) && y < 480+(speed+1)) {
			x -= speed;
		}
		if (y <= 500 && y > 290 && x > 490-(speed+1) && x < 490+(speed+1)) {
			y -= speed;
		}
		if (x < 680 && x >= 480 && y > 290-(speed+1) && y < 290+(speed+1)) {
			x += speed;
		}
		if (y <= 300 && y > 90 && x > 680-(speed+1) && x < 680+(speed+1)) {
			y -= speed;
		}
		if (x <= 690 && x > 410 && y > 90-(speed+1) && y < 90+(speed+1)) {
			x -= speed;
		}
		if (y <= 100 && y > -20 && x > 410-(speed+1) && x < 410+(speed+1)) {
			y -= speed;
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
	
	public String getImageName() {
		return fileName; 
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.75, 0.75);
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
