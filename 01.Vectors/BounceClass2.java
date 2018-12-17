package Vectors;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BounceClass2 extends JPanel implements ActionListener
{
	Timer t = new Timer(5,this);
	Mover2 m = new Mover2();
	Mover2 m2 = new Mover2();
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new BounceClass2());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		m.checkEdges();
		m2.checkEdges();
		m.location.add(m.velocity);
		m2.location.add(m.velocity);
		g.fillOval(m.location.x,m.location.y , 30, 30);
		g.fillOval(m2.location.x,m2.location.y , 30, 30);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
class Mover2{
P3Vector location ;
P3Vector velocity;
	Mover2()
	{
		location = new P3Vector((int)(Math.random()*100),(int)(Math.random()*100));
		velocity = new P3Vector(2,3);
	}
	void checkEdges()
	{
		if(location.x<0||location.x>600)
		{
			location.x=0;
		}
		if(location.y<0||location.y>500)
		{
			location.y=0;
		}
	}

}
class P3Vector
{
	int x;
	int y;
	P3Vector(int x_,int y_)
	{
		x=x_;
		y=y_;
	}
	
	void add(P3Vector v)
	{
		x=x+v.x;
		y=y+v.y;
	}
}