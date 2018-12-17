package Vectors;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FirstBasicVector extends JPanel implements ActionListener
{
	PVector location=new PVector(100,100);
	PVector velocity=new PVector(2,3);
	
	Timer t = new Timer(5,this);
	public static void main(String[] args) {
		JFrame jf =new JFrame("IT RUNS");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new FirstBasicVector());
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.fillOval(location.x,location.y,100,100);
		location.add(velocity);
		
		if(location.x>550||location.x<0)
		{
			velocity.x=velocity.x*-1;
		}
		if(location.y>450||location.y<0)
		{
			velocity.y=velocity.y*-1;
		}
		t.start();
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
}


 class PVector
{
	 int x ;
	 int y;
	 
	 PVector(int x_,int y_)
	 {
		 x=x_;
		 y=y_;
	 }
	 void add(PVector v)
	 {
		 y=y+v.y;
		 x=x+v.x;
	 }
	
}

