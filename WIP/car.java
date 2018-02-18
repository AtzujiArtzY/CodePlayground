
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

class car extends JPanel {
    public BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
    public Graphics2D g3 = buffer.createGraphics();
	public static void main(String[] args) {
		car m = new car();
        JFrame f =  new JFrame();   
        f.add(m);   
        f.setTitle("Country Road Car"); 
        f.setSize(600,600);   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		Color cBody = new Color(239,65,54);
		Color cTrim = new Color(190,30,45);
		Color gray = new Color(64,64,64);

		//Car Front windows
		g.setColor(gray);
			int x[] = {265,275,289,299,308,317,322,294,255};
			int y[] = {270,273,279,285,290,297,302,305,273};
			g.fillPolygon(x,y,x.length);
		//Breaklight
			g.setColor(Color.RED);
			int x5[] = {113,117,110,104,103,103,108,111};
			int y5[] = {292,294,319,319,317,311,298,293};
			g.fillPolygon(x5,y5,x5.length);
		//cBottom
			g.setColor(gray);
			int x7[] = {113,153,330,365,375,106};
			int y7[] = {333,327,325,340,372,372};
			g.fillPolygon(x7,y7,x7.length);
		//Car body
			g.setColor(cBody);
			int x1[] = {382,381,369,368,365,360,351,339,333,322,315,311,310,165,164,162,156,147,133,123,115,111,109,108,104, 99, 102, 123, 116, 266, 259, 265, 275, 283, 290, 295, 322, 380};
			int y1[] = {370,370,373,366,355,347,342,339,340,344,351,360,370,370,364,355,346,341,339,341,348,354,362,369,372,338, 327, 276, 270, 270, 272, 275, 281, 288, 296, 304, 301, 337};
			g.fillPolygon(x1,y1,x1.length);
			g.fillArc(117, 262, 145, 20, 0, 180);
			g.fillArc(230, 301, 150, 70, 0, 100);
		//Windows
			g.setColor(gray);
			int x2[] = {211,230,245,256,266,276,283,287,209};
			int y2[] = {270,271,273,277,282,291,299,305,305};
			g.fillPolygon(x2,y2,x2.length);
			int x3[] = {136,131,205,208,155};
			int y3[] = {282,305,305,270,273};
			g.fillPolygon(x3,y3,x3.length);
		//Headlight
			g.setColor(Color.WHITE);
			int x4[] = {357,362,367,371,373,376,373,370,361,356,352,350,350,351,352};
			int y4[] = {313,317,320,323,327,332,335,336,333,330,325,320,317,315,314};
			g.fillPolygon(x4,y4,x4.length);
		//cTrim
			g.setColor(cTrim);
			int x6[] = {383,381,369,368,365,360,351,339,333,322,315,311,310,165,164,162,156,147,133,123,115,111,109,108,109,101, 98,105,107,111,115,120,126,136,145,151,156,162,166,170,173,300,302,305,308,312,317,323,329,335,343,350,358,364,369,374};
			int y6[] = {353,370,373,366,355,347,342,339,340,344,351,360,370,370,364,355,346,341,339,341,348,354,362,369,374,372,353,352,346,341,336,333,330,328,328,330,334,339,346,354,364,364,357,349,343,338,333,330,328,328,329,330,334,339,344,352};
			g.fillPolygon(x6,y6,x6.length);
	//Wheel
			drawC(g,135,366,23,54,54,54);
			drawC(g,135,366,18,255,255,255);
			drawC(g,135,366,16,82,84,88);
			g.setColor(Color.WHITE);
			int x8[] = {137,138,147,149,141,153,153,141,149,147,138,137,134,133,124,122,130,118,118,130,122,124,133,134};
			int y8[] = {348,361,352,354,364,364,367,368,378,379,371,383,384,371,380,378,368,367,365,364,354,352,361,348};
			g.fillPolygon(x8,y8,x8.length);
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
	private void plot (Graphics g, int x, int y) {
    	g.fillRect(x, y, 2, 2);
    }
    public void drawC(Graphics g, int x, int y, int radius, int R, int G, int B) {
    	Color myColor = new Color(R,G,B);
		g.setColor(myColor);
		for (int i=0; i <= radius; i++) {
			midpointCircle(g,x,y,i);
		}
    }
}
