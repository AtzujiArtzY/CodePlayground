import java.awt.*;
import javax.swing.*;
import java.util.*;

class cg4 extends JPanel {
	public static void main(String[] args) {
		cg4 m = new cg4();
		JFrame f =  new JFrame();   
		f.add(m);
		f.setTitle("59050317"); 
		f.setSize(600,600);   
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setVisible(true);
		Color myBG = new Color(0,0,0);
		f.setBackground(myBG);
	}
	public void paintComponent(Graphics g) {
		fillE(g,300,300,300,300,255,255,255);
		g.setColor(Color.BLACK);
		for (int i = 1; i <= 10; i++) {
			midpointEllipse(g,300,300,300,50*i);
			midpointEllipse(g,300,300,50*i,300);
		}

	}
	private void plot (Graphics g, int x, int y) {
		g.fillRect(x, y, 2, 2);
	}
	public void midpointEllipse(Graphics g,int xc, int yc, int a, int b) {
		int a2 = a*a, b2 = b*b;
		int twoA2 = a2 << 1, twoB2 = b2 << 1;
		//REGION 1
			int x = 0, y = b;
			int D = Math.round(b2 - a2*b + a2/4);
			int Dx = 0, Dy = twoA2*y;
			while (Dx <= Dy) {
				//plot 4 quadrants of (x, y) 
				plot(g, x+xc, y+yc);
				plot(g, x+xc,-y+yc);
				plot(g,-x+xc,-y+yc);
				plot(g,-x+xc, y+yc);
				x = x + 1;
				Dx = Dx + twoB2;
				D = D + Dx + b2;
				if (D >= 0) {
					y = y - 1;
					Dy = Dy - twoA2;
					D = D - Dy;
				}
			}
		//REGION 2
			x = a;
			y = 0;
			D = Math.round(a2 - b2*a + b2/4);
			Dx = twoB2*x;
			Dy = 0;
			while (Dx >= Dy) {
				//plot 4 quadrants of (x, y)
				plot(g, x+xc, y+yc);
				plot(g, x+xc,-y+yc);
				plot(g,-x+xc,-y+yc);
				plot(g,-x+xc, y+yc);
				y = y + 1;
				Dy = Dy + twoA2;
				D = D + Dy + a2;
				if (D >= 0) {
					x = x - 1;
					Dx = Dx - twoB2;
					D = D - Dx;
				} 
			}
	}
	public void fillE(Graphics g, int x, int y, int radius1,int radius2, int R, int G, int B) {
		Color myColor = new Color(R,G,B);
		g.setColor(myColor);
		int i=1,j=1;
		for (i=1; i <= radius1; i++) {
			midpointEllipse(g,x,y,j,i);
		}
		for (j=1; j<= radius2 ; j++) {
			midpointEllipse(g,x,y,j,i);
		}
	}
}