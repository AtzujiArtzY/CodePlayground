import java.awt.*;
import javax.swing.*;
import java.util.*;

class cg5 extends JPanel implements Runnable {
	public static void main(String[] args) {
		cg5 m = new cg5();
		JFrame f = new JFrame();
		f.add(m);
		f.setTitle("Country Road Car");
		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		(new Thread(m)).start();
	}
	public double move = 0;
	public double smove = 0;
	public double mmove = 0;
	public double wheelRotate = 0;
	public int count = 0;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Color
			Color gc0 = new Color(246,243,169);
			Color gc1 = new Color(224,201,149);
			Color gc2 = new Color(126,153,172);
			Color gc3 = new Color(64,112,176);
			Color gc4 = new Color(24,64,125);
			Color gc5 = new Color(11,25,60);
			Color darker = new Color(30,30,30,120);
			Color darkest = new Color(30,30,30,210);
			Color mountain = new Color(150,117,126);
			Color mountain1 = new Color(194,181,155);
			Color fGreen = new Color(73,104,31);
			Color gGreen = new Color(208,216,42);
			Color road = new Color(92,91,98);
			Color sRoad = new Color(68,69,77);
			Color cLight = new Color(255,250,203,127);
			Color rBrown = new Color(193,109,52);
			Color rLBrown = new Color(255,170,100);
			Color rDGreen = new Color(169,201,39);
		//SKY
			GradientPaint skyColor = new GradientPaint(179,254,gc0, 179,0,gc1,true);
			if (count>400&&count<780) { //Evening
				skyColor = new GradientPaint(179,254,gc2, 179,0,gc3,true);
			}
			if (count>=780) { //Night
				skyColor = new GradientPaint(179,254,gc4, 179,0,gc5,true);
			}
			g2.setPaint(skyColor);
			g2.fillRect(0, 0, 600, 280);
		//Sun
			double sun = smove;
			g2.translate(-sun,sun);
			drawC(g,179,254,63,255,213,99);
			g2.translate(sun,-sun);
		//Moon
			double moon = mmove;
			g2.translate(-moon,-sun);
			moon(g);
			g2.translate(moon,sun);
		//Cloud
			g2.translate(-sun,0);
			cloud(g);
			g2.translate(sun,0);
		//Mountain-Praew
			g.setColor(mountain);
			int xm[] = {29, 74, 96,117,152,158,193,209,216,222,227,261,262,273,283,289,298,309,340,381,413,451,470,486,502,530,551,564,579,600,600,340,0,0};
			int ym[] = {205,208,263,254,254,254,259,245,248,243,239,235,260,248,248,259,257,275,281,276,235,253,255,254,258,245,253,244,252,244,281,281,281,221 };
			g.fillPolygon(xm,ym,xm.length);
			g.setColor(mountain1);
			int xm1[] = {  0, 29,  0};
			int ym1[] = {198,205,221};
			g.fillPolygon(xm1,ym1,xm1.length);
			int xm2[] = { 74, 93,102,117, 96};
			int ym2[] = {208,233,234,254,263};
			g.fillPolygon(xm2,ym2,xm2.length);
			int xm3[] = {209,216,222};
			int ym3[] = {245,248,243};
			g.fillPolygon(xm3,ym3,xm3.length);
			int xm4[] = {261,262,273};
			int ym4[] = {235,260,248};
			g.fillPolygon(xm4,ym4,xm4.length);
			int xm5[] = {283,289,298};
			int ym5[] = {248,259,257         };
			g.fillPolygon(xm5,ym5,xm5.length);
		//Road
			g2.setColor(road);
			g2.fillRect(0,325,600,108);
			//Road strip
				double roadM = move;
				g2.translate(-roadM*10,0);
				roadStrip(g);
				g2.translate(roadM*10,0);
			g2.setColor(sRoad);
			g2.fillRect(0,389,80,8);
			g2.fillRect(0,409,316,12);
		//Grass Upper
			g.setColor(gGreen);
			g2.fillRect(0,280,600,45);
		//Forest
			g.setColor(fGreen);
			int xf1[] = {  0, 11, 23, 34, 40,186,191,196,200,205,229,  0};
			int yf1[] = {267,224,277,238,278,278,260,277,266,278,278,290};
			g.fillPolygon(xf1,yf1,xf1.length);
			int xf2[] = {447,470,475,479,484,490,558,565,575,588,600,600};
			int yf2[] = {278,277,265,276,260,277,278,237,276,224,267,290};
			g.fillPolygon(xf2,yf2,xf2.length);
		//Lower road
			g.setColor(rLBrown);
			int xr1[] = {  0,600,600,0};
			int yr1[] = {433,433,479,515};
			g.fillPolygon(xr1,yr1,xr1.length);
			g.setColor(rBrown);
			g2.fillRect(0,433,600,15);
			g.setColor(gGreen);
			int xr2[] = {  0,600,600,113,0};
			int yr2[] = {515,479,509,600,600};
			g.fillPolygon(xr2,yr2,xr2.length);
			g.setColor(rDGreen);
			int xr3[] = {113,600,600};
			int yr3[] = {600,509,600};
			g.fillPolygon(xr3,yr3,xr3.length);
		//Daytime Fillter
			if (count>400&&count<780) {
				g2.setColor(darker);
				g2.fillRect(-10,-10,610,610);
			}
			if (count>=780) {
				g2.setColor(darkest);
				g2.fillRect(-10,-10,610,610);
			}
		//Add Car Night light
			if (count>=780) { //Night
				g.setColor(cLight);
				int xcl[] = {329,600,600,344};
				int ycl[] = {346,308,425,362};
				g.fillPolygon(xcl,ycl,xcl.length);
			}
		//Draw Car
			double wheelRotate1 = wheelRotate ;
			g2.translate(-20,30); //Move car
			car(g);
			//Draw back wheel
				g2.rotate(wheelRotate1, 135, 366);
				wheel1(g); 
				g2.rotate(-wheelRotate1, 135, 366);
			//Draw front wheel
				g2.rotate(wheelRotate1, 338, 366);
				wheel2(g); 
				g2.rotate(-wheelRotate1, 338,366);
			g2.translate(20,-30); 
	}
	void roadStrip(Graphics g) {
		g.setColor(Color.YELLOW);
		for (int i=0; i<=300; i++) {
			g.fillRect(100*i,374,60,10);
		}
	}
	void car(Graphics g) {
		Color cBody = new Color(239,65,54);
		Color cTrim = new Color(190,30,45);
		Color sWin = new Color(245,143,91);
		Color hLight = new Color(52,93,101);
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
			g.setColor(hLight);
			int xh[] = {354,355,358,360,362,363,363,359,355,353,352,353};
			int yh[] = {316,318,321,325,329,332,335,333,328,325,321,319};
			g.fillPolygon(xh,yh,xh.length);
		//cTrim
			g.setColor(cTrim);
			int x6[] = {383,381,369,368,365,360,351,339,333,322,315,311,310,165,164,162,156,147,133,123,115,111,109,108,109,101, 98,105,107,111,115,120,126,136,145,151,156,162,166,170,173,300,302,305,308,312,317,323,329,335,343,350,358,364,369,374};
			int y6[] = {353,370,373,366,355,347,342,339,340,344,351,360,370,370,364,355,346,341,339,341,348,354,362,369,374,372,353,352,346,341,336,333,330,328,328,330,334,339,346,354,364,364,357,349,343,338,333,330,328,328,329,330,334,339,344,352};
			g.fillPolygon(x6,y6,x6.length);
		//Side Window
			g.setColor(sWin);
			int x8[] = {273,277,279,281,281,280,277,275,274,273,272,271,271,272};
			int y8[] = {296,298,299,301,302,305,307,308,308,307,305,302,302,298};
			g.fillPolygon(x8,y8,x8.length);
		//Handel
			g.setColor(gray);
			int x9[] = {229,210,210,210,210,211,228,229,229,229};
			int y9[] = {315,315,314,313,313,312,312,312,313,314};
			g.fillPolygon(x9,y9,x9.length);
			g.translate(-30,0);
			g.fillPolygon(x9,y9,x9.length);
			g.translate(30,0);
	}
	void cloud(Graphics g) {
		drawC(g,14,199,21, 255,255,255);
		drawC(g,44,185,31, 255,255,255);
		drawC(g,78,194,24, 255,255,255);
		drawC(g,106,199,21, 255,255,255);
		drawC(g,130,206,13, 255,255,255);
		drawC(g,333,141,15, 255,255,255);
		drawC(g,357,130,23, 255,255,255);
		drawC(g,380,141,15, 255,255,255);
		drawC(g,680,84,18, 255,255,255);
		drawC(g,714,73,33, 255,255,255);
		drawC(g,756,60,43, 255,255,255);
		drawC(g,792,75,34, 255,255,255);
		drawC(g,826,84,18, 255,255,255);
	}
	void wheel1(Graphics g) {
		drawC(g,135,366,23,54,54,54);
		drawC(g,135,366,18,255,255,255);
		drawC(g,135,366,16,82,84,88);
		g.setColor(Color.WHITE);
		int xw[] = {137,138,147,149,141,153,153,141,149,147,138,137,134,133,124,122,130,118,118,130,122,124,133,134};
		int yw[] = {348,361,352,354,364,364,367,368,378,379,371,383,384,371,380,378,368,367,365,364,354,352,361,348};
		g.fillPolygon(xw,yw,xw.length);
	}
	void wheel2(Graphics g) {
		drawC(g,338,366,23,54,54,54);
		drawC(g,338,366,18,255,255,255);
		drawC(g,338,366,16,82,84,88);
		g.setColor(Color.WHITE);
		int xw[] = {340,341,350,352,344,356,356,344,352,350,341,340,337,336,327,325,333,321,321,333,325,327,336,337};
		int yw[] = {348,361,352,354,364,364,367,368,378,379,371,383,384,371,380,378,368,367,365,364,354,352,361,348};
		g.fillPolygon(xw,yw,xw.length);
	}
	void moon(Graphics g) {
		drawC(g,539,343,38, 208,209,209);
		drawC(g,539,341,36, 228,229,229);
		drawC(g,539,338,34, 250,251,251);
		drawC(g,550,314,3, 189,189,189);
		drawC(g,551,314,3, 224,224,224);
		drawC(g,531,326,2, 189,189,189);
		drawC(g,532,327,2, 224,224,224);
		drawC(g,518,326,4, 189,189,189);
		drawC(g,519,327,4, 224,224,224);
		drawC(g,519,337,2, 189,189,189);
		drawC(g,520,338,2, 224,224,224);
		drawC(g,527,369,3, 189,189,189);
		drawC(g,528,370,3, 224,224,224);
		drawC(g,535,361,4, 189,189,189);
		drawC(g,536,363,4, 224,224,224);
		drawC(g,542,353,3, 189,189,189);
		drawC(g,543,353,3, 224,224,224);
		drawC(g,549,368,5, 189,189,189);
		drawC(g,549,370,5, 224,224,224);
		drawC(g,564,343,7, 189,189,189);
		drawC(g,565,343,7, 224,224,224);
		drawC(g,568,329,2, 189,189,189);
		drawC(g,569,330,2, 224,224,224);
	}
	public void run() {
		double lastTime = System.currentTimeMillis();
		double currentTime, elapsedTime;
		double startTime = System.currentTimeMillis();
		while (true) {
			currentTime = System.currentTimeMillis();
			elapsedTime = currentTime - lastTime;
		//TODO: update logics
		//Display
			move += 50.0 * elapsedTime / 1000;
			smove += 7.0 * elapsedTime / 1000;
			mmove += 1.0 * elapsedTime / 1000;
			wheelRotate += 7.0 * elapsedTime / 1000;
			count++;
			repaint();
			lastTime = currentTime;
		//take a little nap: 60fps
			try {
				Thread.sleep(1000/60);
			}
			catch (InterruptedException e) {
				System.err.println(e);
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