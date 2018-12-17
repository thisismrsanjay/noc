package Vectors;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BounceSimple extends JPanel implements ActionListener
{
	int x =0;
	int y =0;
	int xSpeed =2;
	int ySpeed =2;
	Timer t = new Timer(5,this);
	public static void main(String[] args) {
		JFrame jf =new JFrame("IT RUNS");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new BounceSimple());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(x,y,100,100);
		x+=xSpeed;
		y+=ySpeed;
		if(x>550||x<0)
		{
			xSpeed= xSpeed*-1;
		}
		if(y>450||y<0)
		{
			ySpeed=ySpeed*-1;
		}
		t.start();
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
}