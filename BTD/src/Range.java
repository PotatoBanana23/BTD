import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Range {
	private int x, y;
	private int rangeType;
	private AffineTransform tx;

	public Range(boolean DartMonkey, boolean TackShooter, boolean IceMonkey, boolean Cannon, boolean SuperMonkey, int x, int y) {
		if (DartMonkey == true) {
			this.x = x;
			this.y = y;
			rangeType = 1;
		}
		if (TackShooter == true) {
			this.x = x;
			this.y = y;
			rangeType = 2;
		}
		if (IceMonkey == true) {
			this.x = x;
			this.y = y;
			rangeType = 3;
		}
		if (Cannon == true) {
			this.x = x;
			this.y = y;
			rangeType = 4;
		}
		if (SuperMonkey == true) {
			this.x = x;
			this.y = y;
			rangeType = 5;
		}
	}

	public Range(int x, int y) {
		this.x = x;
		this.y = y;

		tx = AffineTransform.getTranslateInstance(x, y);
		//init(x, y); 				//initialize the location of the image
									//use your variables
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		if (rangeType == 1) {
			g.drawOval((x + 25) - 250, (y + 25) - 250, 500, 500);
		}
		if (rangeType == 2) {
			g.drawOval((x + 35) - 100, (y + 35) - 100, 200, 200);
		}
		if (rangeType == 3) {
			
		}
		if (rangeType == 4) {
			g.drawOval((x + 30) - 250, (y + 30) - 250, 500, 500);
		}
		if (rangeType == 5) {
			
		}
		//update();
	}

	/*private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.5, 0.5);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 0.5);
	}*/
}
