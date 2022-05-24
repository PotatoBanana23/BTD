import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
	ArrayList<Bloon> testBloons = new ArrayList<Bloon>(); 
	boolean bloonPaintCheck = false; 
	
	//objects and variables for towers
	Map map = new Map(0, 0);
	GameOver gameOver = new GameOver(100, 100);
	
	SuperMonkey s = new SuperMonkey(500, 510); 
	TackShooter ts = new TackShooter(120, 590);
	IceMonkey i = new IceMonkey(575, 590);
	Cannon cannon = new Cannon(200, 300);
	ArrayList<Shooting> temp = new ArrayList<Shooting>();
	ArrayList<Shooting> sMonkeyBullets = new ArrayList<Shooting>();
	ArrayList<TackShooting> tacks = new ArrayList<TackShooting>();
	ArrayList<CannonShooting> bombs = new ArrayList<CannonShooting>();
	ArrayList<DartMonkey> dartMs = new ArrayList<DartMonkey>();
	boolean tempB = false;
	boolean sMonkeyBulletsB = false; 
	Music musicOn = new Music(915, 700);
	Sound soundOn = new Sound(865, 700);
	Music musicOff = new Music();
	Sound soundOff = new Sound();
	int musicCount = 0;
	int soundCount = 0;

	Music sweep = new Music("btdTheme.wav", true);
	Music sweep2 = new Music("bloonPop.wav", false);


	//shop and lives and money
	DartMonkey dShop = new DartMonkey(785, 160);
	TackShooter tsShop = new TackShooter(878, 163);
	IceMonkey iShop = new IceMonkey(788, 245);
	Cannon cShop = new Cannon(875, 250);
	SuperMonkey sShop = new SuperMonkey(785, 340);
	Lives l = new Lives(800, 45);
	Money m = new Money(800, 85);
	int lives = 100;
	int money = 650;
	int round = 0;
	DartMonkey d = new DartMonkey(50, 400);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		map.paint(g);
		d.paint(g);
		//d2.paint(g); 
		ts.paint(g);
		i.paint(g);
		cannon.paint(g);
		s.paint(g);
		dartMs.add(d);
		for (int i = 0; i < dartMs.size(); i++) {
			dartMs.get(i).paint(g);
		}


		if(tempB == true) {
			for(int i = 0; i < temp.size(); i++) {
				(temp.get(i)).paint(g); 
			}
		}
		
		if(sMonkeyBulletsB == true) {
			for(int i = 0; i < sMonkeyBullets.size(); i++) {
				(sMonkeyBullets.get(i)).paint(g); 
			}

		}
		
			for (int i = 0; i < testBloons.size(); i++) {
				(testBloons.get(i)).paint(g);
				if (testBloons.get(i).getSpeed() == 0) {
					if (testBloons.get(i).getImageName() == "/imgs/redBloon.png") {
						testBloons.get(i).setSpeed(1);
					} else if (testBloons.get(i).getImageName() == "/imgs/blueBloon.png") {
						testBloons.get(i).setSpeed(2);
					} else if (testBloons.get(i).getImageName() == "/imgs/greenBloon.png") {
						testBloons.get(i).setSpeed(3);
					} else if (testBloons.get(i).getImageName() == "/imgs/yellowBloon.png") {
						testBloons.get(i).setSpeed(4);
					} else {
						testBloons.get(i).setSpeed(5);
					}
				}
				if (testBloons.get(i).getY() < -40 && lives > 0) {
					if (testBloons.get(i).getImageName() == "/imgs/pinkBloon.png") {
						testBloons.remove(i);
						i--;
						lives -= 5;
					} else if (testBloons.get(i).getImageName() == "/imgs/yellowBloon.png") {
						testBloons.remove(i);
						i--;
						lives -= 4;
					} else if (testBloons.get(i).getImageName() == "/imgs/greenBloon.png") {
						testBloons.remove(i);
						i--;
						lives -= 3;
					} else if (testBloons.get(i).getImageName() == "/imgs/blueBloon.png") {
						testBloons.remove(i);
						i--;
						lives -= 2;
					} else {
						testBloons.remove(i);
						i--;
						lives--;
					}
				}
			}
			
			for (int i = 0; i < bombs.size(); i++) {
				bombs.get(i).paint(g);
				if (bombs.get(i).getXSize() > 0.505) {
					bombs.remove(i);
				}
			}
		
		for(int i = 0; i < tacks.size(); i++) {
			(tacks.get(i)).paint(g); 
		}

		Color lightBrown = new Color(153, 102, 0);
		Color brown = new Color(102, 51, 0);
		g.setColor(lightBrown);
		g.fillRect(745, 0, 250, 800);
		g.setColor(brown);
		g.fillRect(775, 25, 190, 100);
		g.fillRect(775, 150, 190, 600);
		l.paint(g);
		m.paint(g);
		g.setColor(Color.white);
		Font fontScore2 = new Font("Helvetica", Font.BOLD, 21);
		g.setFont(fontScore2);
		g.drawString(":   " + lives, 825, 62);
		g.drawString(":   " + money, 825, 105);
		g.setColor(Color.black);
		g.drawRect(785, 160, 80, 80);
		g.drawRect(875, 160, 80, 80);
		g.drawRect(785, 250, 80, 80);
		g.drawRect(875, 250, 80, 80);
		g.drawRect(785, 340, 80, 80);
		dShop.paint(g);
		tsShop.paint(g);
		iShop.paint(g);
		cShop.paint(g);
		sShop.paint(g);
		if (musicCount % 2 == 0) {
			musicOn.paint(g);
		} else {
			musicOff.paint(g);
		}
		if (soundCount % 2 == 0) {
			soundOn.paint(g);
		} else {
			soundOff.paint(g);
		}
		
		if (lives <= 0) {
			gameOver.paint(g);
			lives = 0;
		}
		
		for (int i = 0 ; i < testBloons.size(); i++) {
			if(testBloons.get(i).getImageName().equals("/imgs/poppedBloon.png")) {
				testBloons.get(i).setBeenShot(true);
				testBloons.remove(i); 
				i--;
			}
		}
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("BTD5");
		f.setSize(new Dimension(1000, 800));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(5, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		sweep.play();
		//temp.add(new Shooting(d.getX(), d.getY(), 2, 2));
		tempB = true; 
		//sMonkeyBullets.add(new Shooting(s.getX(), s.getY(), 2, 2)); 
		sMonkeyBulletsB = true; 
		
		//adding balloons
		
		//30 red balloons
		int red = 0;
		while (red < 1000) {
			Bloon newBalloon;
			int randNumber = (int) (Math.random()*10) +1;
			if (randNumber == 1) {
				newBalloon = new RedBloon();
			} else if (randNumber == 2) {
				newBalloon = new BlueBloon();
			} else if(randNumber <= 4) {
				newBalloon = new GreenBloon();
			} else if (randNumber <= 7) {
				newBalloon = new YellowBloon();
			} else {
				newBalloon = new PinkBloon();
			}
			
			testBloons.add(newBalloon);
			System.out.println("added");
			
			while (newBalloon.getDelay() < 1.0) {
				if (newBalloon.getDelay() > 0.9) {
					//System.out.println("breaked");
				}
				if (newBalloon.getImageName().equals("/imgs/poppedBloon.png")) {
					break;
				}
			}
			System.out.println("newBalloon" + red);
			red++;
		}
		

		
//		for (int i = 0; i < 30; i++) {
//			Bloon newBalloon;
//			int randNumber = (int) Math.random()*10 +1;
//			if (randNumber == 1) {
//				newBalloon = new RedBloon();
//			} else if (randNumber == 2) {
//				newBalloon = new BlueBloon();
//			} else if(randNumber <= 4) {
//				newBalloon = new GreenBloon();
//			} else if (randNumber <= 7) {
//				newBalloon = new YellowBloon();
//			} else {
//				newBalloon = new PinkBloon();
//			}
//			
//			while (newBalloon.getDelay() < 1.0) {
//				if (newBalloon.getDelay() > 0.9) {
//					break;
//				}
//			}
//			
//			testBloons.add(newBalloon);
//		}
		
	}
	

	//public void createShotDartMonkey(DartMonkey d) {


	//public void createShotDartMonkey(DartMonkey d) {
	
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		
		/** START OF DART MONKEY SHOOTING **/

		double dMonkeyBulletSpeedX = 0;
		double dMonkeyBulletSpeedY = 0;

		int dartRandom = (int) (Math.random() * 10) + 1;
		if (dartRandom <= 2) {
			for (int j = 0; j < dartMs.size(); j++) {
				int dMBullets = 0;
				for (int k = 0; k < testBloons.size(); k++) {

					DartMonkey d = dartMs.get(j);

					int xDist = Math.abs(testBloons.get(k).getX() - d.getX());
					int yDist = Math.abs(testBloons.get(k).getY() - d.getY());
					int dist = (int) Math.sqrt((xDist * xDist) + (yDist * yDist));

					if (dist <= d.getR()) {
						// getting distance
						double dX = testBloons.get(k).getX() - d.getX();
						double dY = testBloons.get(k).getY() - d.getY();

						// finding length w/ Pythagorean Theorem
						double length = (int) (Math.sqrt((dX * dX) + (dY * dY)));

						// scaling distance for speed calculation
						dX /= length;
						dY /= length;
						dMonkeyBulletSpeedX = dX * 5;
						dMonkeyBulletSpeedY = dY * 5;

						// adding bullet shooting towards bloon to list

						if (testBloons.get(k).getBeenShot() == false && dMBullets < 1) {
							temp.add(new Shooting(d.getX(), d.getY(), dMonkeyBulletSpeedX, dMonkeyBulletSpeedY));
							dMBullets++;
						}

						// scanning for dart hitting bloon
						if (temp.size() > 0) {
							for (int i = 0; i < temp.size(); i++) {
								for (int p = 0; p < testBloons.size(); p++) {
									int xDif = temp.get(i).getX() - testBloons.get(p).getX();
									int yDif = temp.get(i).getY() - testBloons.get(p).getY();
									dist = (int) Math.sqrt((xDif * xDif) + (yDif * yDif));
									System.out.println("DIST OF BLOON BULLET: " + dist);
									if (dist <= testBloons.get(j).getRadius()
											&& !(testBloons.get(p).getImageName().equals("/imgs/poppedBloon.png"))) {
										money++;
										testBloons.get(p).pop();
										if (testBloons.get(p).getColor().equals("popped")) {
											testBloons.get(p).setBeenShot(true);
											testBloons.remove(p);
										}
										break;
									}
								}
							}
						}

					}
				}
				break;
			}
		}

		/** END OF DART MONKEY SHOOTING **/
		
		//start tack shooter shooting
		for(int k = 0; k < testBloons.size(); k++) {
			if (Math.abs(testBloons.get(k).getX() - (ts.getX()) + 35) <= ts.getR() && Math.abs(testBloons.get(k).getY() - (ts.getY() + 35)) <= ts.getR()) {
				//adding bullet shooting towards bloon to list
				for (int i = 1; i <= 8; i++) {
					tacks.add(new TackShooting(ts.getX() + 35, ts.getY() + 37, 3, 3, i));
				}

				//scanning for dart hitting bloon
				if (tacks.size() > 0) {
					for (int i = 0; i < tacks.size(); i++) {
						boolean tackWillPop = true;
						for (int j = 0; j < testBloons.size(); j++) {
							if (Math.abs(tacks.get(i).getX() - testBloons.get(j).getX()) <= ts.getR() && Math.abs(tacks.get(i).getY() - testBloons.get(j).getY()) <= ts.getR() 
									&& !(testBloons.get(j).getImageName().equals("/imgs/poppedBloon.png") && tackWillPop == true)) {
								testBloons.get(j).pop();
								tackWillPop = false;
								money++; //will also edit to support multiple layer pops
								if(testBloons.get(j).getColor().equals("popped")) {
									testBloons.get(j).setBeenShot(true);
									testBloons.remove(j); 
									j--;
								}
								break;
								// delay(25);
								// long time1 = System.currentTimeMillis();
							}
						}
					}
				}
			}
		}
		//end tack shooter shooting
		
		//all for CANNON SHOOTING
		double bombSpeedX = 0;
		double bombSpeedY = 0; 
		
		int cannonRandom = (int) (Math.random()*10) + 1;
		if (cannonRandom <= 2) {
			
			//getting distance
			double cannonDistanceX = testBloons.get(0).getX() - cannon.getX();
			double cannonDistanceY = testBloons.get(0).getY() - cannon.getY();
			

			//finding length w/ Pythagorean Theorem 
			double length = (int) (Math.sqrt(cannonDistanceX * cannonDistanceX + cannonDistanceY * cannonDistanceY));
			
			//scaling distance for speed calculation
			cannonDistanceX /= length;
			cannonDistanceY /= length;
			bombSpeedX = cannonDistanceX * 5;
			bombSpeedY = cannonDistanceY * 5;

			//adding bullet shooting towards bloon to list
			bombs.add(new CannonShooting(cannon.getX(), cannon.getY(), bombSpeedX, bombSpeedY, "/imgs/cannonball.png"));
			
			//scanning for cannon hitting bloon
			if (bombs.size() > 0) {
				for (int i = 0; i < bombs.size(); i++) {
					for (int j = 0; j < testBloons.size(); j++) {
						if (Math.abs(bombs.get(i).getX() - testBloons.get(j).getX()) <= cannon.getR()
								&& Math.abs(bombs.get(i).getY() - testBloons.get(j).getY()) <= cannon.getR()
								&& !(testBloons.get(j).getImageName().equals("/imgs/poppedBloon.png"))) {
							money++;
							//testBloons.get(j).changePicture("/imgs/poppedBloon.png");
							testBloons.get(j).pop();
							//testBloons.get(j).setBeenShot(true);
							
							if(testBloons.get(j).getColor().equals("popped")) {
								testBloons.get(j).setBeenShot(true);
								testBloons.remove(j); 
							}
				
							
						}
						
						
					}
					int index = bombs.size()-1;
					int x = bombs.get(index).getX();
					int y = bombs.get(index).getY();
					bombs.remove(index);
					CannonShooting temp = new CannonShooting(x-50, y-50, 0, 0, "/imgs/cannonExplosion.png");
					bombs.add(index,temp);
					bombs.get(index).setExploded();
				}
			}
		}
			
		
		
		
		// BULLET TRACKING FOR SUPERMONKEY
		double sMonkeyBulletSpeedX = 0;
		double sMonkeyBulletSpeedY = 0;
		int superMonkeyBullets = 0;
		// int k = 2;

		int superRandom = (int) (Math.random() * 10) + 1;
		if (superRandom <= 5) {
			int size = testBloons.size();
			// while(size > 0) {
			for (int k = 0; k < testBloons.size(); k++) {

				int xDist = Math.abs(testBloons.get(k).getX() - s.getX());
				int yDist = Math.abs(testBloons.get(k).getY() - s.getY());
				int dist = (int) Math.sqrt((xDist * xDist) + (yDist * yDist));

				/*
				 * if (Math.abs(testBloons.get(k).getX() - s.getX()) <= s.getR() &&
				 * Math.abs(testBloons.get(k).getY() - s.getY()) <= s.getR()) {
				 */

				if (dist <= s.getR()) {
					// getting distance
					double dX = testBloons.get(k).getX() - s.getX();
					double dY = testBloons.get(k).getY() - s.getY();

					// finding length w/ Pythagorean Theorem
					double sLength = (int) (Math.sqrt((dX * dX) + (dY * dY)));

					// scaling distance for speed calculation
					dX /= sLength;
					dY /= sLength;
					sMonkeyBulletSpeedX = dX * 10;
					sMonkeyBulletSpeedY = dY * 10;

					// adding bullet shooting towards bloon to list

					if (testBloons.get(k).getBeenShot() == false && superMonkeyBullets < 1) {
						sMonkeyBullets.add(new Shooting(s.getX(), s.getY(), sMonkeyBulletSpeedX, sMonkeyBulletSpeedY));
						superMonkeyBullets++;
					}

					// scanning for dart hitting bloon
					boolean bullet = true;
					if (sMonkeyBullets.size() > 0) {
						for (int i = 0; i < sMonkeyBullets.size(); i++) {
							for (int j = 0; j < testBloons.size(); j++) {
								if (Math.abs(sMonkeyBullets.get(i).getX() - testBloons.get(j).getX()) <= s.getR()
										&& Math.abs(sMonkeyBullets.get(i).getY() - testBloons.get(j).getY()) <= s.getR()
										&& !(testBloons.get(j).getImageName().equals("/imgs/poppedBloon.png"))) {
									money++;
									// testBloons.get(j).changePicture("/imgs/poppedBloon.png");
									// testBloons.get(j).setBeenShot(true);

									/// TRYING TO MERGE

									// testBloons.get(j).changePicture("/imgs/poppedBloon.png");
									testBloons.get(j).pop();
									if (testBloons.get(j).getColor().equals("popped")) {
										testBloons.get(j).setBeenShot(true);
										testBloons.remove(j);
									}
									break;
									// delay(25);
									// long time1 = System.currentTimeMillis();
								}
							}
						}
					}
				}
			}
		}

			 
		// for detecting the monkeys you want to buy, will edit what it does later


	

	



		/*for (int i = 1; i <= 8; i++) {
			tacks.add(new TackShooting(ts.getX() + 35, ts.getY() + 37, 3, 3, i));
		}
		*/
		
		

	
	
		
	/*	double angle = Math.atan2(m.getY() - d.getY(), m.getX() - d.getX());
		
		double speed = 5;
		double dX = speed * Math.cos(angle);
		double dY = speed * Math.sin(angle);
		
		temp.add(new Shooting(d.getX(), d.getY(), dX, -1*dY)); 
	*/


/*		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 185 && m.getY() < 265) {
			System.out.println("dart monkey");
			Buying bd = new Buying(1);
		}
		if (m.getX() > 875 && m.getX() < 955 && m.getY() > 185 && m.getY() < 265) {
			System.out.println("tack shooter");
			Buying bts = new Buying(2);
		}
		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 275 && m.getY() < 355) {
			System.out.println("ice monkey");
			Buying bi = new Buying(3);
		}
		if (m.getX() > 875 && m.getX() < 955 && m.getY() > 275 && m.getY() < 355) {
			System.out.println("cannon");
			Buying bcannon = new Buying(4);
		}
		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 365 && m.getY() < 445) {
			System.out.println("super monkey");
			Buying bs = new Buying(5);
		} */
		
		
		
		if (m.getX() >= 915 && m.getX() <= 965 && m.getY() >= 700 + 25 && m.getY() <= 750 + 25) {
			musicCount++;
			if (musicCount % 2 == 0) {
				sweep.play();
			} else {
				sweep.stop();
			}
		}
		if (m.getX() >= 865 && m.getX() <= 915 && m.getY() >= 700 + 25 && m.getY() <= 750 + 25) {
			soundCount++;
			if (soundCount % 2 == 0) {
				//sweep2.play();
			} else {
				//sweep2.stop();
			}
		}
}
	
	public static void delay(int millisec) {
		long time1 = System.currentTimeMillis(); 
		while(System.currentTimeMillis() - time1 <= millisec) {
			System.out.println("Waiting"); 
		}
	}
	
	
	
	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
		
		if (testBloons.size() > 0) {
			System.out.println("x: " + testBloons.get(0).getX());
			System.out.println("y: " + testBloons.get(0).getY());
		}
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint(); 
	}

	@Override
	public void keyPressed(KeyEvent m) {
		
		if (m.getKeyCode() == 32 && bombs.size() > 0) {
			int index = bombs.size()-1;
			int x = bombs.get(index).getX();
			int y = bombs.get(index).getY();
			bombs.remove(index);
			CannonShooting temp = new CannonShooting(x-50, y-50, 0, 0, "/imgs/cannonExplosion.png");
			bombs.add(index,temp);
			bombs.get(index).setExploded();
		}
	}
	
	public static void wait(int ms) {
		long current = System.currentTimeMillis();
		while (System.currentTimeMillis() - current < ms) {
			
		} 
	}
	
	

	@Override
	public void keyReleased(KeyEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		//temp.add(new Shooting(d.getX(), d.getY(), 2, 2)); 
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//temp.add(new Shooting(d.getX(), d.getY(), 2, 2)); 
	}

}