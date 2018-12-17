package Vectors;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FollowLine extends JPanel implements ActionListener
{
	Point p = new Point();
	Timer t = new Timer(5,this);
	int xPos;
	int yPos;
	public static void main(String[] args)
	{
		JFrame jf= new JFrame("vector subtraction");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new FollowLine());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		p=this.getMousePosition();
		try {
			xPos=p.x;
			yPos=p.y;
		} catch (Exception e) {

		}
		g.drawLine(300, 250, xPos,yPos);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		this.repaint();
		
	}
}