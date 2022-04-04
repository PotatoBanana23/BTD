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
	Bloon bloon = new Bloon(0, 350, 3);
	Bloon bloon2 = new Bloon(140, 350, 0);
	Bloon bloon3 = new Bloon(140, 170, 0);
	Bloon bloon4 = new Bloon(330, 170, 0);
	Bloon bloon5 = new Bloon(330, 550, 0);
	Bloon bloon6 = new Bloon(90, 550, 0);
	Bloon bloon7 = new Bloon(90, 690, 0);
	Bloon bloon8 = new Bloon(670, 690, 0);
	Bloon bloon9 = new Bloon(670, 480, 0);
	Bloon bloon10 = new Bloon(490, 480, 0);
	Bloon bloon11 = new Bloon(490, 290, 0);
	Bloon bloon12 = new Bloon(680, 290, 0);
	Bloon bloon13 = new Bloon(680, 90, 0);
	Bloon bloon14 = new Bloon(410, 90, 0);
	Bloon bloon15 = new Bloon(410, -20, 0);
	
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		b.paint(g);
		bloon.paint(g);
		//bloon.move();
//		bloon2.paint(g);
//		bloon3.paint(g);
//		bloon4.paint(g);
//		bloon5.paint(g);
		bloon6.paint(g);
		bloon7.paint(g);
		bloon8.paint(g);
		bloon9.paint(g);
		bloon10.paint(g);
		bloon15.paint(g);
		
		
	
		

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
