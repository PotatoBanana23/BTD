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
	private boolean beenShot; 
	private String color;
	private double delay;


	public Bloon(double speed, String fileName, String color) {
		this.fileName = fileName;
		img = getImage(fileName);
		this.color = color;
		x = 0;
		y = 350;
		this.speed = speed;
		beenShot = false;
		delay = 0.5;

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		fileName = newFileName; 
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void pop() {
		if (color.equals("red")) {
			changePicture("/imgs/poppedBloon.png");
			setBeenShot(true);
			setColor("popped");
			
		} else if (color.equals("blue")) {
			setColor("red");
			speed = 1;
			fileName = "/imgs/redBloon.png";
			setSpeed(speed);
			changePicture(fileName);
			
		} else if (color.equals("green")) {
			setColor("blue");
			speed = 2;
			fileName = "/imgs/blueBloon.png";
			setSpeed(speed);
			changePicture(fileName);

			
		} else if (color.equals("yellow")) {
			speed = 3;
			fileName = "/imgs/greenBloon.png";
			setColor("green");
			setSpeed(speed);
			changePicture(fileName);
			
		} else if (color.equals("pink")) {
			speed = 4;
			fileName = "/imgs/yellowBloon.png";
			setSpeed(speed);
			changePicture(fileName);
			setColor("yellow");
			
		}
	}
	
	public void move() {
		for (int i = 0; i < 140; i += speed) {
			x += speed;
		} 
	}
	
	public void delay() {
		if (delay >= 1.000) {
			
		}
	}
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		//bloon speed and fileName
//		if (color.equals("red")) {
//			fileName = "/imgs/redBloon.png";
//			changePicture(fileName);
//		} else if (color.equals("blue")) {
//			fileName = "/imgs/blueBloon.png";
//			changePicture(fileName);
//		} else if (color.equals("green")) {
//			fileName = "/imgs/greenBloon.png";
//			changePicture(fileName);
//		} else if (color.equals("yellow")) {
//			fileName = "/imgs/yellowBloon.png";
//			changePicture(fileName);
//		} else if (color.equals("pink")) {
//			fileName = "/imgs/pinkBloon.png";
//			changePicture(fileName);
//		} else if (color.equals("popped")) {
//			setSpeed(0);
//			fileName = "/imgs/poppedBloon.png";
//			changePicture(fileName);
//		}
		
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
		if (y <= 100 && y > -50 && x > 410-(speed+1) && x < 410+(speed+1)) {
			y -= speed;
		}
		
		
		
		delay += 0.05;

		update();

	}
	//getters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	//setters for speed
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String getImageName() {
		return fileName; 
	}
	
	public boolean getBeenShot() {
		return beenShot;
	}
	

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getDelay() {
		return delay;
	}
	

	public void setBeenShot(boolean beenShot) {
		this.beenShot = beenShot;
	}

	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.7, 0.7);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.7, 0.7);
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


