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

public class RandomAcceleration extends JPanel implements ActionListener,KeyListener
{
	Timer t = new Timer(5,this);
	Random gen =new Random();
	static double x,y,xvel,yvel;
	static double xacc;
	static double yacc;
	static double topspeed= 6;
	public static void main(String[] args)
	{
		JFrame jf =new JFrame("Ball");
		jf.setSize(900,600);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new RandomAcceleration());
		jf.setVisible(true);
		jf.addKeyListener(new RandomAcceleration());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		Ellipse2D.Double ellipse  = new Ellipse2D.Double(x, y, 48, 48);
		g2.fill(ellipse);
		t.start();	
		
		//saftey 
		
		if(x>800)
		{
			x=0;
		}else if(x<0)
		{
			x=800;
		}
		if(y>500)
		{
			y=0;
		}else if(y<0)
		{
			y=500;
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		xacc=Math.random()*4-2;
		yacc=Math.random()*4-2;
		xvel+=xacc;
		yvel+=yacc;
		//limit in both negitive and positive
		if(xvel>6)
			xvel=6;
		else if(xvel<-6)
			xvel=-6;
		if(yvel>6)
			yvel=6;
		else if(yvel <-6)
			yvel=-6;
		//System.out.println(xvel+" "+yvel);
		y+=yvel;
		x+=xvel;
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		
	}
}


  
