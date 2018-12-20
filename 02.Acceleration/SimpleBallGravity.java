package Vectors.acceleration;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//motion101 (velocity and random acceleration)

public class SimpleBallGravity extends JPanel implements ActionListener,KeyListener
{
	Timer t = new Timer(5,this);
	Random gen =new Random();
	static double x,y,xvel;
	static double yvel=1;
	static double gravity=1;
	public static void main(String[] args)
	{
		JFrame jf =new JFrame("Ball Reflector");
		jf.setSize(900,600);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new SimpleBallGravity());
		jf.setVisible(true);
		jf.addKeyListener(new SimpleBallGravity());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		Ellipse2D.Double ellipse  = new Ellipse2D.Double(x, y, 48, 48);
		g2.fill(ellipse);
		t.start();	
		
		//saftey 
		
		if(x>=800|| x<=0)
		{
			xvel=xvel*-1;
			
			if(x>800){
				x=800;
			}
			if(x<0){
				x=0;
			}
		}
		if(y>500||y<0)
		{
			yvel=yvel*-0.8;
			
			
			if(y>510){
				y=500;
			}
			if(y<0){
				y=0;
			}
		}
		else{
			yvel+=gravity;
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		x+=xvel;
		y+=yvel;

		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
//		if(i==e.VK_UP)
//		{
//			xvel=0;
//			yvel=-2;
//		}
//		if(i==e.VK_DOWN)
//		{
//			xvel=0;
//			yvel=3;
//		}
//		if(i==e.VK_RIGHT)
//		{
//			xvel=2;
//			yvel=0;
//		}
//		if(i==e.VK_LEFT)
//		{
//			xvel=-2;
//			yvel=0;
//		}
//		
	}
	public void keyReleased(KeyEvent e) {
		
		
	}
}


  