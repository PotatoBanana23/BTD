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

	Bloon bloon = new Bloon(1);
	Bloon bloon3 = new Bloon(9.5);
	Bloon bloon4 = new Bloon(9); 
	Bloon bloon5 = new Bloon(10);
	
	
	
	

	Lives l = new Lives(800, 70);
	Money m = new Money(800, 110);
	int lives = 100;
	int money = 650;
	int round = 0;

	
	public void paint(Graphics g) {
		super.paintComponent(g);
		b.paint(g);

		bloon.paint(g);
		bloon3.paint(g);
		bloon4.paint(g);
		bloon5.paint(g);

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
		
		//for detecting the monkeys you want to buy, will edit what it does later
		
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
