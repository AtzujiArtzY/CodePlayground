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
		Color myBG = new Color(247,255,176);
		f.setBackground(myBG);
	}
	public void paintComponent(Graphics g) {
		midpointEllipse(g,100,100,50,50);
	}
	public void bresenhamLine (Graphics g,int x1, int y1, int x2, int y2) {
    	int x = x1, y = y1;
    	int dx = x2 - x1;
    	int dy = y2 - y1;
    	int D = 2 * dy - dx;
    	if (x1 != x2) {
    		for (; x <= x2 ; x++) {
    		plot(g,x,y);
	    		if (D >= 0) {
	    			y++;
	    			D = D - 2 * dx;
	    		}
	    		D = D + 2 * dy;
	    	}
    	}
    	else {
    		D = 2 * dx - dy;
    		for (; y <= y2 ; y++) {
    		plot(g,x,y);
	    		if (D >= 0) {
	    			x++;
	    			D = D - 2 * dy;
	    		}
    			D = D + 2 * dx;
    		}
    	}
    }
    public void midpointCircle(Graphics g,int xc, int yc, int r) {
		int x = 0;
		int y = r;
		int Dx = 2 * x;
		int Dy = 2 * y;
		int D = 1 - r;
		while (x <= y) {
			plot(g, x+xc, y+yc);
			plot(g, y+xc, x+yc);
			plot(g, y+xc,-x+yc);
			plot(g, x+xc,-y+yc);
			plot(g,-x+xc,-y+yc);
			plot(g,-y+xc,-x+yc);
			plot(g,-y+xc, x+yc);
			plot(g,-x+xc, y+yc);
			x++;
			Dx += 2;
			D = D + Dx + 1;
			if (D >= 0) {
				y--;
				Dy -= 2;
				D = D - Dy;
			}
		}
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
	private void plot (Graphics g, int x, int y) {
		g.fillRect(x, y, 2, 2);
	}
	public void fillP(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int R, int G, int B) {
		int x[] = {x1, x2, x3};
		int y[] = {y1, y2, y3};
		Color myColor = new Color(R,G,B);
		g.setColor(myColor);
		g.fillPolygon(x,y,3);
	}
	public void fillC(Graphics g, int x, int y, int radius, int R, int G, int B) {
		Color myColor = new Color(R,G,B);
		g.setColor(myColor);
		for (int i=0; i <= radius; i++) {
			midpointCircle(g,x,y,i);
		}
	}
	public void fillE(Graphics g, int x, int y, int radius1,int radius2, int R, int G, int B) {
		Color myColor = new Color(R,G,B);
		g.setColor(myColor);
		for (int i=0; i <= radius1; i++) {
			for (int j=0; j<= radius2 ; j++) {
				midpointEllipse(g,x,y,j,i);
				//if (i==radius1 || j==radius2) break;
			}
		}
	}
}