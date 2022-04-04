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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Map b = new Map(0, 0);
	Lives l = new Lives(800, 70);
	Money m = new Money(800, 110);
	int lives = 100;
	int money = 650;
	
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		b.paint(g);
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
	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println("x: " + m.getX());
		System.out.println("y: " + m.getY());
		
		/*for detecting the money you want to buy, will edit and stuff later
		 * 
		 * if (e.getX() >= s.getX() + 5 && e.getX() <= s.getX() + 55 && e.getY() >= s.getY() + 25 && e.getY() <= s.getY() + 70) {
		    store++;
		}
		if (score > 100 && e.getX() >= upgrade[1].getX() && e.getX() <= upgrade[1].getX() + 75 && e.getY() >= upgrade[1].getY() && e.getY() <= upgrade[1].getY() + 75) {
			score -= 100;
			count2++;
				
		}
		if (score > 1000 && e.getX() >= upgrade[2].getX() && e.getX() <= upgrade[2].getX() + 75 && e.getY() >= upgrade[2].getY() && e.getY() <= upgrade[2].getY() + 75) {
			score -= 1000;
			count3++;
		}
		if (score > 10000 && e.getX() >= upgrade[3].getX() && e.getX() <= upgrade[3].getX() + 75 && e.getY() >= upgrade[3].getY() && e.getY() <= upgrade[3].getY() + 75) {
			score -= 10000;
			count4++;
		}
		if (score > 100000 && e.getX() >= upgrade[4].getX() && e.getX() <= upgrade[4].getX() + 75 && e.getY() >= upgrade[4].getY() && e.getY() <= upgrade[4].getY() + 75) {
			score -= 100000;
			count5++;
		}
		if (store % 2 == 1) {
			for (int i = 0; i < space.length; i++) {
				if (e.getX() >= space[i].getX() && e.getX() <= space[i].getX() + 150 && e.getY() >= space[i].getY() && e.getY() <= space[i].getY() + 150) {
			        System.out.print("test");
			    }
			}
		}*/
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

}
