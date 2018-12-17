package Vectors;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MultipleBalls extends JPanel implements ActionListener
{
	Timer t = new Timer(5,this);
	 static Mover3[] m = new Mover3[10];
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new MultipleBalls());
		
		// most important method initialization of mover object
		for(int i =0;i<m.length;i++)
		m[i] = new Mover3();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<m.length;i++){
			
			m[i].checkEdges();
			g.fillOval(m[i].location.x,m[i].location.y , 30, 30);
			m[i].location.add(m[i].velocity);
		}
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
class Mover3{
PVector4 location ;
PVector4 velocity;
	Mover3()
	{
		location = new PVector4((int)(Math.random()*600),(int)(Math.random()*500));
		velocity = new PVector4(((int)(Math.random()*3))+1,((int)(Math.random()*3))+1);
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
class PVector4
{
	int x;
	int y;
	PVector4(int x_,int y_)
	{
		x=x_;
		y=y_;
	}
	
	void add(PVector4 v)
	{
		x=x+v.x;
		y=y+v.y;
	}
}
