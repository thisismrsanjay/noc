package Vectors;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
 *  Graphics2D g2 = (Graphics2D)g;
		g2.draw(new Rectangle2D.Double(3.234234,23.234234,234.235423,5.3223));
		g2.draw(new Ellipse2D.Double(300, 50, 50, 50));
		Ellipse2D.Double circle = new Ellipse2D.Double(300,200,60,60);
		g2.fill(circle);
 */
public class BounceClass extends JPanel implements ActionListener
{
	Timer t = new Timer(5,this);
	Mover m = new Mover();
	Mover m2 = new Mover();
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new BounceClass());
		jf.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		m.checkEdges();
		m2.checkEdges();
		m2.location.add(m2.velocity);
		m.location.add(m.velocity);
		g.fillOval(m2.location.x,m2.location.y , 30, 30);
		g.fillOval(m.location.x,m.location.y , 30, 30);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
class Mover{
P2Vector location ;
P2Vector velocity;
	Mover()
	{
		location = new P2Vector((int)(Math.random()*600),(int)(Math.random()*500));
		velocity = new P2Vector(2,3);
	}
	void checkEdges()
	{
		if(location.x<0||location.x>600)
		{
			velocity.x= velocity.x*-1;
			
		}
		if(location.y<0||location.y>500)
		{
			velocity.y=velocity.y*-1;
		}
	}

}
class P2Vector
{
	int x;
	int y;
	P2Vector(int x_,int y_)
	{
		x=x_;
		y=y_;
	}
	
	void add(P2Vector v)
	{
		x=x+v.x;
		y=y+v.y;
	}
}