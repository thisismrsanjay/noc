package Vectors.acceleration;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleKeyBoard extends JPanel implements ActionListener,KeyListener
{
	//static variables are initialized only once, at the start of execution and a single 
	//copy is shared by all instances of the class
	static double x =0,y=0,velx=0,vely=0;
	Timer t = new Timer(5,this);
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame("Fast");
		jf.setSize(800,490);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(new SimpleKeyBoard());
		jf.addKeyListener(new SimpleKeyBoard());
		jf.setVisible(true);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		if(x>800)
		{
			x=0;
		}else if(x<0)
		{
			x=800;
		}
		if(y>400)
		{
			y=0;
		}else if(y<0)
		{
			y=400;
		}
		Rectangle2D.Double s = new Rectangle2D.Double(x,y,100,45);
		g2.fill(s);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		x+=velx;
		y+=vely;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code==KeyEvent.VK_UP){
			velx=0;
			vely=-3;
		}
		if(code==KeyEvent.VK_DOWN){
			velx=0;
			vely=3;
		}
		if(code==KeyEvent.VK_LEFT){
			velx=-3;
			vely=0;
		}
		if(code==KeyEvent.VK_RIGHT){
			velx=3;
			vely=0;
		}	
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
}

