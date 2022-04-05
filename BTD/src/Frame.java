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
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		b.paint(g);
		d.paint(g);
			
		
		if(tempB == true) {
			for(int i = 0; i < temp.size(); i++) {
				(temp.get(i)).paint(g); 
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
		Timer t = new Timer(7, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		temp.add(new Shooting(d.getX(), d.getY(), 2, 2)); 
		tempB = true; 
	}
	
	
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println("x: " + m.getX());
		System.out.println("y: " + m.getY());
		
		
		double dX = m.getX() - d.getX();
		double dY = m.getY() - d.getY();
		
		System.out.println("dX: " + dX); 
		System.out.println("dY: "+ dY); 
		
		System.out.println("dX squared: " + dX*dX); 
		System.out.println("dY squared: "+ dY*dY); 
		System.out.println("sqrt: "+ Math.sqrt(dX*dX + dY*dY)); 
			
		double length = (int) (Math.sqrt(dX*dX + dY*dY));
		
		System.out.println("length: " + length); 
			
		dX /= length;
		dY /= length;
		
		System.out.println("dX: " + dX); 
		System.out.println("dY: "+ dY); 
		
		double tempSpeedX = dX * 5;
		double tempSpeedY = dY * 5; 
		
		temp.add(new Shooting(d.getX(), d.getY(), tempSpeedX, tempSpeedY)); 
	
	
		
	/*	double angle = Math.atan2(m.getY() - d.getY(), m.getX() - d.getX());
		
		double speed = 5;
		double dX = speed * Math.cos(angle);
		double dY = speed * Math.sin(angle);
		
		temp.add(new Shooting(d.getX(), d.getY(), dX, -1*dY)); 
	*/
		
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
