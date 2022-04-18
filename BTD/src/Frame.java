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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
	Map b = new Map(0, 0);

	DartMonkey d = new DartMonkey(50, 400); 
	ArrayList<Shooting> temp = new ArrayList<Shooting>(); 	
	boolean tempB = false; 
	ArrayList<Bloon> testBloons = new ArrayList<Bloon>(); 
	boolean bloonPaintCheck = false; 

	Lives l = new Lives(800, 70);
	Money m = new Money(800, 110);
	int lives = 100;
	int money = 650;
	int round = 0;

	
	public void paint(Graphics g) {
		

		
		super.paintComponent(g);
		
		b.paint(g);

		d.paint(g);
			
		
		if(tempB == true) {
			for(int i = 0; i < temp.size(); i++) {
				(temp.get(i)).paint(g); 
			}
		}
		
		

		
			for (int i = 0; i < testBloons.size(); i++) {
				(testBloons.get(i)).paint(g);
			}
			
		

		Color brown = new Color(153, 102, 0);
		g.setColor(brown);
		g.fillRect(775, 50, 190, 100);
		g.fillRect(775, 175, 190, 500);
		l.paint(g);
		m.paint(g);
		g.setColor(Color.white);
		Font fontScore2 = new Font("Helvetica", Font.BOLD, 21);
		g.setFont(fontScore2);
		g.drawString(":   " + lives, 825, 87);
		g.drawString(":   " + money, 825, 130);
		g.setColor(Color.black);
		g.drawRect(785, 185, 80, 80);
		g.drawRect(875, 185, 80, 80);
		g.drawRect(785, 275, 80, 80);
		g.drawRect(875, 275, 80, 80);
		g.drawRect(785, 365, 80, 80);

		
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
		Timer t = new Timer(7, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		temp.add(new Shooting(d.getX(), d.getY(), 2, 2)); 
		tempB = true; 
		testBloons.add(new Bloon(1)); 
		testBloons.add(new Bloon(2));
		testBloons.add(new Bloon(2.5));
		testBloons.add(new Bloon(1.75));
	}
	
	
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub

		if (Math.abs(testBloons.get(0).getX() - d.getX()) <= d.getR()
				&& Math.abs(testBloons.get(0).getY() - d.getY()) <= d.getR()) {
			
			//getting distance
			double dX = testBloons.get(0).getX() - d.getX();
			double dY = testBloons.get(0).getY() - d.getY();
			
			//finding length w/ Pythagorean Theorem 
			double length = (int) (Math.sqrt(dX * dX + dY * dY));
			
			//scaling distance for speed calculation
			dX /= length;
			dY /= length;
			double tempSpeedX = dX * 5;
			double tempSpeedY = dY * 5;

			//adding bullet shooting towards bloon to list
			temp.add(new Shooting(d.getX(), d.getY(), tempSpeedX, tempSpeedY));
			
			//scanning for dart hitting bloon
			if (temp.size() > 0) {
				for (int i = 0; i < temp.size(); i++) {
					for (int j = 0; j < testBloons.size(); j++) {
						if (Math.abs(temp.get(i).getX() - testBloons.get(j).getX()) <= d.getR()
								&& Math.abs(temp.get(i).getY() - testBloons.get(j).getY()) <= d.getR()
								&& !(testBloons.get(j).getImageName().equals("/imgs/poppedBloon.png"))) {
							testBloons.get(j).changePicture("/imgs/poppedBloon.png");
							break;
							// delay(25);
							// long time1 = System.currentTimeMillis();
						}
						/*
						 * int c = 0; while(c < 2147483647) { c++; }
						 * System.out.println("Time loop took: " + (System.currentTimeMillis() -
						 * time1));
						 */
					}
				}
			}

		}

		// for detecting the monkeys you want to buy, will edit what it does later

		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 185 && m.getY() < 265) {
			System.out.println("dart monkey");
		}
		if (m.getX() > 875 && m.getX() < 955 && m.getY() > 185 && m.getY() < 265) {
			System.out.println("tack shooter");
		}
		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 275 && m.getY() < 355) {
			System.out.println("ice monkey");
		}
		if (m.getX() > 875 && m.getX() < 955 && m.getY() > 275 && m.getY() < 355) {
			System.out.println("cannon");
		}
		if (m.getX() > 785 && m.getX() < 865 && m.getY() > 365 && m.getY() < 445) {
			System.out.println("super monkey");
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
		System.out.println("x: " + testBloons.get(0).getX());
		System.out.println("y: " + testBloons.get(0).getY());
		
		
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
