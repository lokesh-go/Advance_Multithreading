import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Panchhi extends JFrame implements Runnable
{
	BufferedImage img1[];
	Toolkit tk;
	Thread t,t1;
	MediaTracker mt;
	int i,x=800,y=130;
	Panchhi()
	{
		t=new Thread(this);
		setBackground(Color.white);
		tk=Toolkit.getDefaultToolkit();
		mt=new MediaTracker(this);
		img1=new BufferedImage[8];
		try
		{
			mt.waitForAll();
			img1[0]=ImageIO.read(new File("p1.gif"));
			img1[1]=ImageIO.read(new File("p2.gif"));
			img1[2]=ImageIO.read(new File("p3.gif"));
			img1[3]=ImageIO.read(new File("p4.gif"));
			img1[4]=ImageIO.read(new File("p5.gif"));
			img1[5]=ImageIO.read(new File("p6.gif"));
			img1[6]=ImageIO.read(new File("p7.gif"));
			img1[7]=ImageIO.read(new File("p8.gif"));
			
		}
		catch (Exception e)
		{
		}
		setSize(1500,700);
		setLayout(null);
		setVisible(true);
		t.start();
	}
	public void run()
	{
		while(true)
		{
			for(i=0;i<7;i++)
			{
				x--;
				if(y>=10)
				y--;
				
				try
				{
		
					t.sleep(20);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		/*for(i=1;i<5;i++)
		{
			
			if (x>=5)
			{
				x-=1;
				y-=1;
			}*/
			g2.drawImage(img1[i],x,y,this);
		System.out.println(i);
	//	repaint();
		//}	
	}
	public static void main(String arg[])
	{
		new Panchhi();
	}
}