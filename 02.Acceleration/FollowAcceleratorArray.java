package Vectors.acceleration;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FollowAcceleratorArray extends JPanel implements ActionListener
{
	Point  p = new Point();
	Timer t  = new Timer(5,this);
		
	static NewBall[] nb = new NewBall[20];
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("ARRAY");
		jf.setSize(800,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new FollowAcceleratorArray());
		for(int i=0;i<nb.length;i++)
		{
			nb[i]=new NewBall();
		}
		jf.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		p=this.getMousePosition();
		for(int i=0;i<nb.length;i++){
		try{
			nb[i].mouse.x=p.x;
			nb[i].mouse.y=p.y;
		}catch(NullPointerException e2){}
		
		PVector dir = PVector.sub( nb[i].mouse,nb[i].location);
		dir.normalize();
		dir.mult(0.1);
		nb[i].acceleration = dir;
		
		nb[i].velocity.limit(6);
		nb[i].velocity.add(nb[i].acceleration);
		nb[i].location.add(nb[i].velocity);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(nb[i].location.x,nb[i].location.y,48,48);
		
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(10.0f));
		g2.setColor(new Color(nb[i].r,nb[i].gr,nb[i].b,nb[i].a));
		
		g2.fill(ellipse);

		}
		t.start();
	}
	
	public void actionPerformed(ActionEvent e){
		
		repaint();
	}
}
class NewBall{
	PVector location;
	PVector velocity;
	PVector mouse;
	PVector acceleration;
	int r;
	int gr;
	int b;
	int a;
	NewBall(){
		location = new PVector(Math.random()*401,Math.random()*251);
		velocity = new PVector(0,0);
		mouse = new PVector(0,0);
		acceleration  = new PVector(0,0);
		r = (int)(Math.random()*255);
		gr = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
		a = (int)(Math.random()*255);
	}
}