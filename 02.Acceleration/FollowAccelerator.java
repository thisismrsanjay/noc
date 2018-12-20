package Vectors.acceleration;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//motion101 (velocity and random acceleration)

public class FollowAccelerator extends JPanel implements ActionListener
{
	Timer t = new Timer(5,this);
	Random gen =new Random();
	
	
	Mouse m = new Mouse();
	
	
	Point p = new Point();
	public static void main(String[] args)
	{
		JFrame jf =new JFrame("Ball");
		jf.setSize(900,600);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new FollowAccelerator());
		jf.setVisible(true);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		
		m.velocity.limit(5);
		m.velocity.add(m.acceleration);
		m.location.add(m.velocity);
		p=this.getMousePosition();
		
		try{
			m.mouse.x = p.x;
			m.mouse.y= p.y;
		}catch(NullPointerException e1){}
			
		PVector dir= PVector.sub(m.mouse, m.location);
		dir.normalize();
		dir.mult(0.3);
		m.acceleration= dir;
		
		
		g2.drawString(m.mouse.y+","+m.mouse.x, 400, 200);
		Ellipse2D.Double ellipse  = new Ellipse2D.Double(m.location.x, m.location.y, 48, 48);
		g2.fill(ellipse);
		t.start();	
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
class Mouse
{
	PVector location;
	PVector velocity;
	PVector mouse;
	PVector acceleration;
	Mouse(){
		location = new PVector(400,250);
		velocity = new PVector(0,0);
		mouse = new PVector(0,0);
		acceleration = new PVector(0,0);
	}
}


//class PVector
//{
//	double x;
//	double y;
//	PVector(double x_,double y_)
//	{
//		x= x_;
//		y= y_;
//	}
//	void add(PVector v)
//	{
//		x=x+v.x;
//		y=y+v.y;
//	}
//	void limit(double l)
//	{
//		if(x>=l)
//		{
//			x=l;
//		}
//		if(y>=l)
//		{
//			y=l;
//		}
//	}
//	void mult(double n)
//	{
//		x= x*n;
//		y= y*n;
//	}
//	double mag()
//	{
//		return Math.sqrt(x*x+y*y);
//	}
//	void div(double d)
//	{
//		x=x/d;
//		y=y/d;
//	}
//	static PVector sub(PVector v1,PVector v2)
//	{
//		PVector v3 =new PVector(v1.x-v2.x,v1.y-v2.y);
//		return v3;
//	}
//	
//	void normalize(){
//		double m = this.mag();
//		if(m!=0)
//		{
//			this.div(m);
//		}
//		
//	}
//	
//}
  
