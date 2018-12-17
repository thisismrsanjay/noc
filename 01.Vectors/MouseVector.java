package Vectors;
//complete vector implementation 
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MouseVector extends JPanel implements ActionListener
{
	Point p = new Point();
	Timer t = new Timer(5,this);
	double xPos;
	double yPos;
	P1Vector mouse;
	P1Vector center = new P1Vector(300,250);
	public static void main(String[] args)
	{
		JFrame jf= new JFrame("vector subtraction");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(new MouseVector());
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.translate(300, 250);
		p=this.getMousePosition();
		mouse= new P1Vector(xPos,yPos);
		mouse.sub(center);
		//everyLine has it's own Job 
		//mouse.mult(0.5);
		//mouse.div(3);
		mouse.normalize();
		mouse.mult(100);
		try {
			xPos=p.x;
			yPos=p.y;
		} catch (Exception e) {
			// TODO: handle exception
		}
		g.drawLine(0, 0, (int)mouse.x,(int)mouse.y);
		g.drawString(Double.toString(mouse.mag()), -250, -210);
		g.drawString(mouse.x+"  "+mouse.y,-250,-200);
		g.fillRect(-280,-230, (int)mouse.mag(),10);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		this.repaint();
		//System.out.println(mouse.mag());
	}
}
class P1Vector
{
//this is the best thing i've ever created remember

	double x;
	double y;
	 P1Vector(double x_,double y_)
	{
		x=x_;
		y=y_;
	}
	void add(P1Vector v)
	{
		x=x+v.x;
		y=y+v.y;
	}
	void sub(P1Vector v)
	{
		x=x-v.x;
		y=y-v.y;
	}
	void mult(double n)
	{
		x= x*n;
		y= y*n;
	}
	static PVector sub(PVector v1,PVector v2)
	{
		PVector v3 =new PVector(v1.x-v2.x,v1.y-v2.y);
		return v3;
	}
	void div(double d)
	{
		x=x/d;
		y=y/d;
	}
	double mag(){
		return Math.sqrt(x*x+y*y);
	}
	void normalize(){
		double m = this.mag();
		if(m!=0)
		{
			this.div(m);
		}
		
	}

}

