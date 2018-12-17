package Vectors;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MouseBasic extends JPanel implements ActionListener
{
	//when you put the timer start the timer
	Timer t = new Timer(5,this);
	//when you put the point remember of catching the exception
	Point p =new Point(); 
	int x1,y1;
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("Vectors");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new MouseBasic());
	}
	public void paintComponent(Graphics g)
	{
		//it cleans the screen
		super.paintComponent(g);
		
		try {
			x1=p.x;
			y1=p.y;
		} catch (NullPointerException e) {
			
		}
		
		
		g.drawString(Integer.toString(x1), 350, 250);
		g.drawString(Integer.toString(y1),350 , 260);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		p=this.getMousePosition();
		this.repaint();
	}
	
}