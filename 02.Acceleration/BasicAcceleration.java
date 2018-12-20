package Vectors.acceleration;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class BasicAcceleration extends JPanel implements ActionListener
{
	Timer t = new Timer(5,this);
	 static Mover[] m = new Mover[1];
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new BasicAcceleration());
		
		// most important method initialization of mover object
		for(int i =0;i<m.length;i++)
		m[i] = new Mover();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<m.length;i++){
			
			m[i].checkEdges();
			g.fillOval((int)(m[i].location.x),(int)(m[i].location.y), 50, 50);
			//g.drawLine((int)(m[i].location.x), (int)(m[i].location.y),(int)(m[i].location.x)+10,(int)(m[i].location.y)-10);
			m[i].location.add(m[i].velocity);
			m[i].velocity.limit(5);
			m[i].velocity.add(m[i].acceleration);
		}
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
class Mover{
PVector location ;
PVector velocity;
PVector acceleration;
	Mover()
	{
		location = new PVector((int)(Math.random()*600),(int)(Math.random()*500));
		velocity = new PVector(0,0);
		acceleration = new PVector(-0.001,0.01);
	}
	void checkEdges() {

	    if (location.x > 600) {
	      location.x = 0;
	    } 
	    else if (location.x < 0) {
	      location.x = 600;
	    }

	    if (location.y > 500) {
	      location.y = 0;
	    } 
	    else if (location.y < 0) {
	      location.y = 500;
	    }
	}
}
class PVector
{
//this is the best thing i've ever created remember

	double x;
	double y;
	 PVector(double x_,double y_)
	{
		x=x_;
		y=y_;
	}
	void add(PVector v)
	{
		x=x+v.x;
		y=y+v.y;
	}
	void sub(PVector v)
	{
		x=x-v.x;
		y=y-v.y;
	}
	void mult(double n)
	{
		x= x*n;
		y= y*n;
	}
	static PVector sub(PVector v1,PVector v2)
	{
		PVector v3 =new PVector(v1.x-v2.x,v1.y-v2.y);
		return v3;
	}
	void div(double d)
	{
		x=x/d;
		y=y/d;
	}
	double mag(){
		return Math.sqrt(x*x+y*y);
	}
	void limit(double l)
	{
		if(x>=l)
		{
			x=l;
		}
		if(y>=l)
		{
			y=l;
		}
	}

	void normalize(){
		double m = this.mag();
		if(m!=0)
		{
			this.div(m);
		}
		
	}

}