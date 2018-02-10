import java.awt.*;
import javax.swing.*;
import java.util.*;
class Assignment1_59050317 extends JPanel {
	public static void main(String[] args) {
		cg m = new cg();
        JFrame f =  new JFrame();   
        f.add(m);   
        f.setTitle("Assignment1_59050317"); 
        f.setSize(600,600);   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true);
        System.out.println("~~~Pixel City~~~");
	}
	public void paintComponent(Graphics g) {
	//Color
		Color myColor1 = new Color(  0,   9,  30);
		Color myColor2 = new Color( 42, 171, 168);
		Color myColor3 = new Color(123,  97, 232);
		Color myColor4 = new Color(242,   0, 100);
		Color m1 = new Color(255, 20, 147);  //DeepPink
		Color m2 = new Color(205, 92, 92);   //IndianRed
		Color m3 = new Color(255, 192, 203); //Pink
		Color m4 = new Color(255, 240, 245); //LavenderBlush1
		Color m5 = new Color(0, 205, 0);	 //Green3
		Color m6 = new Color(240, 255, 240); //Honeydew
		Color m7 = new Color(249, 146, 2);   //C S
		Color m9 = new Color(232,232,232);   //gray91
		Color m10 = new Color(130,130,130);  //gray51
	//Night Sky
		Color bg1 = new Color(9, 4, 28);
		Color bg2 = new Color(14, 4, 52);
		Color bg3 = new Color(24,9, 81);
		Color bg4 = new Color(44, 16, 165);
		g.setColor(bg1);
		g.fillRect(0, 0, 600, 200);
		for (int i = 0; i <= 700; i=i+10) {
			for (int j = 100; j <= 199; j = j+5) {
				g.setColor(bg2);
				g.fillRect((i+j)-200, j, 5, 5);
			}
		}
		g.setColor(bg2);
		g.fillRect(0, 200, 600, 100);
		g.setColor(bg3);
		g.fillRect(0, 300, 600, 300);
		for (int i = 0; i <= 700; i=i+10) {
			for (int j = 300; j <= 399; j = j+5) {
				g.setColor(bg2);
				g.fillRect((i+j)-400, j, 5, 5);
			}
		}
		for (int i = 0; i <= 700; i=i+10) {
			for (int j = 500; j <= 599; j = j+5) {
				g.setColor(bg4);
				g.fillRect((i+j)-600, j, 5, 5);
			}
		}
	//Star
		Random rand = new Random();
		int  r1=1,r2=1;
		g.setColor(myColor3);
		for (int i = 1; i <= 85; i++) {
			r1 = rand.nextInt(600);
			r2 = rand.nextInt(400);
			g.fillRect(r1, r2, 2, 2);
		}
	//59050317 (50Y)   
		//5b (25X)
		g.setColor(m6);
		bresenhamLine(g, 25,  50,  75,  50);
		bresenhamLine(g, 25,  50,  25, 100);
		bresenhamLine(g, 25, 100,  75, 100);
		bresenhamLine(g, 75, 100,  75, 150);
		bresenhamLine(g, 25, 150,  75, 150);
		//5f
		g.setColor(m5);
		bresenhamLine(g, 28,  53,  78,  53);
		bresenhamLine(g, 28,  53,  28, 103);
		bresenhamLine(g, 28, 103,  78, 103);
		bresenhamLine(g, 78, 103,  78, 153);
		bresenhamLine(g, 28, 153,  78, 153);
		//9b (95X)
		g.setColor(m6);
		bresenhamLine(g, 95, 50, 145, 50);
		bresenhamLine(g, 95, 50,  95, 100);
		bresenhamLine(g, 95, 100, 145, 100);
		bresenhamLine(g,145, 50, 145, 150);
		bresenhamLine(g, 95, 150, 145, 150);
		//9f
		g.setColor(m5);
		bresenhamLine(g, 98, 53, 148, 53);
		bresenhamLine(g, 98, 53,  98, 103);
		bresenhamLine(g, 98, 103, 148, 103);
		bresenhamLine(g,148, 53, 148, 153);
		bresenhamLine(g, 98, 153, 148, 153);
		//0b (165X)
		g.setColor(m6);
		bresenhamLine(g,165, 50, 215, 50);
		bresenhamLine(g,165, 50, 165, 150);
		bresenhamLine(g,215, 50, 215, 150);
		bresenhamLine(g,165, 150, 215, 150);
		//0f
		g.setColor(m5);
		bresenhamLine(g,168, 53, 218, 53);
		bresenhamLine(g,168, 53, 168, 153);
		bresenhamLine(g,218, 53, 218, 153);
		bresenhamLine(g,168, 153, 218, 153);
		//5b (235X)
		g.setColor(m6);
		bresenhamLine(g,235, 50, 285, 50);
		bresenhamLine(g,235, 50, 235, 100);
		bresenhamLine(g,235, 100, 285, 100);
		bresenhamLine(g,285, 100, 285, 150);
		bresenhamLine(g,235, 150, 285, 150);
		//5f
		g.setColor(m5);
		bresenhamLine(g,238, 53, 288, 53);
		bresenhamLine(g,238, 53, 238, 103);
		bresenhamLine(g,238, 103, 288, 103);
		bresenhamLine(g,288, 103, 288, 153);
		bresenhamLine(g,238, 153, 288, 153);
		//0b (305X)
		g.setColor(m6);
		bresenhamLine(g,305, 50, 355, 50);
		bresenhamLine(g,305, 50, 305, 150);
		bresenhamLine(g,355, 50, 355, 150);
		bresenhamLine(g,305, 150, 355, 150);
		//0f
		g.setColor(m5);
		bresenhamLine(g,308, 53, 358, 53);
		bresenhamLine(g,308, 53, 308, 153);
		bresenhamLine(g,358, 53, 358, 153);
		bresenhamLine(g,308, 153, 358, 153);
		//3b (375X)
		g.setColor(m6);
		bresenhamLine(g,375, 50, 425, 50);
		bresenhamLine(g,375, 100, 425, 100);
		bresenhamLine(g,375, 150, 425, 150);
		bresenhamLine(g,425, 50, 425, 150);
		//3f
		g.setColor(m5);
		bresenhamLine(g,378, 53, 428, 53);
		bresenhamLine(g,378, 103, 428, 103);
		bresenhamLine(g,378, 153, 428, 153);
		bresenhamLine(g,428, 53, 428, 153);
		//1b (445X)
		g.setColor(m6);
		bresenhamLine(g,495, 50, 495, 150);
		//1f
		g.setColor(m5);
		bresenhamLine(g,498, 53, 498, 153);
		//7b (515X)
		g.setColor(m6);
		bresenhamLine(g,515, 50, 565, 50);
		bresenhamLine(g,565, 50, 565, 150);
		//7f
		g.setColor(m5);
		bresenhamLine(g,518, 53, 568, 53);
		bresenhamLine(g,568, 53, 568, 153);
	
	//59050346 (200Y)
		//5b (25X)
		g.setColor(m3);
		bresenhamLine(g, 25, 200,  75, 200);
		bresenhamLine(g, 25, 200,  25, 250);
		bresenhamLine(g, 25, 250,  75, 250);
		bresenhamLine(g, 75, 250,  75, 300);
		bresenhamLine(g, 25, 300,  75, 300);
		//5f
		g.setColor(m1);
		bresenhamLine(g, 28, 203,  78, 203);
		bresenhamLine(g, 28, 203,  28, 253);
		bresenhamLine(g, 28, 253,  78, 253);
		bresenhamLine(g, 78, 253,  78, 303);
		bresenhamLine(g, 28, 303,  78, 303);
		//9b (95X)
		g.setColor(m3);
		bresenhamLine(g, 95, 200, 145, 200);
		bresenhamLine(g, 95, 200,  95, 250);
		bresenhamLine(g, 95, 250, 145, 250);
		bresenhamLine(g,145, 200, 145, 300);
		bresenhamLine(g, 95, 300, 145, 300);
		//9f
		g.setColor(m1);
		bresenhamLine(g, 98, 203, 148, 203);
		bresenhamLine(g, 98, 203,  98, 253);
		bresenhamLine(g, 98, 253, 148, 253);
		bresenhamLine(g,148, 203, 148, 303);
		bresenhamLine(g, 98, 303, 148, 303);
		//0b (165X)
		g.setColor(m3);
		bresenhamLine(g,165, 200, 215, 200);
		bresenhamLine(g,165, 200, 165, 300);
		bresenhamLine(g,215, 200, 215, 300);
		bresenhamLine(g,165, 300, 215, 300);
		//0f
		g.setColor(m1);
		bresenhamLine(g,168, 203, 218, 203);
		bresenhamLine(g,168, 203, 168, 303);
		bresenhamLine(g,218, 203, 218, 303);
		bresenhamLine(g,168, 303, 218, 303);
		//5b (235X)
		g.setColor(m3);
		bresenhamLine(g,235, 200, 285, 200);
		bresenhamLine(g,235, 200, 235, 250);
		bresenhamLine(g,235, 250, 285, 250);
		bresenhamLine(g,285, 250, 285, 300);
		bresenhamLine(g,235, 300, 285, 300);
		//5f
		g.setColor(m1);
		bresenhamLine(g,238, 203, 288, 203);
		bresenhamLine(g,238, 203, 238, 253);
		bresenhamLine(g,238, 253, 288, 253);
		bresenhamLine(g,288, 253, 288, 303);
		bresenhamLine(g,238, 303, 288, 303);
		//0b (305X)
		g.setColor(m3);
		bresenhamLine(g,305, 200, 355, 200);
		bresenhamLine(g,305, 200, 305, 300);
		bresenhamLine(g,355, 200, 355, 300);
		bresenhamLine(g,305, 300, 355, 300);
		//0f
		g.setColor(m1);
		bresenhamLine(g,308, 203, 358, 203);
		bresenhamLine(g,308, 203, 308, 303);
		bresenhamLine(g,358, 203, 358, 303);
		bresenhamLine(g,308, 303, 358, 303);
		//3b (375X)
		g.setColor(m3);
		bresenhamLine(g,375, 200, 425, 200);
		bresenhamLine(g,375, 250, 425, 250);
		bresenhamLine(g,375, 300, 425, 300);
		bresenhamLine(g,425, 200, 425, 300);
		//3f
		g.setColor(m1);
		bresenhamLine(g,378, 203, 428, 203);
		bresenhamLine(g,378, 253, 428, 253);
		bresenhamLine(g,378, 303, 428, 303);
		bresenhamLine(g,428, 203, 428, 303);
		//4b (445X)
		g.setColor(m3);
		bresenhamLine(g,495, 200, 495, 300);
		bresenhamLine(g,445, 200, 445, 250);
		bresenhamLine(g,445, 250, 495, 250);
		//4f
		g.setColor(m1);
		bresenhamLine(g,498, 203, 498, 303);
		bresenhamLine(g,448, 203, 448, 253);
		bresenhamLine(g,448, 253, 498, 253);
		//6b (515X)
		g.setColor(m3);
		bresenhamLine(g,515, 200, 565, 200);
		bresenhamLine(g,515, 200, 515, 300);
		bresenhamLine(g,515, 250, 565, 250);
		bresenhamLine(g,565, 250, 565, 300);
		bresenhamLine(g,515, 300, 565, 300);
		//6f
		g.setColor(m1);
		bresenhamLine(g,518, 203, 568, 203);
		bresenhamLine(g,518, 203, 518, 303);
		bresenhamLine(g,518, 253, 568, 253);
		bresenhamLine(g,568, 253, 568, 303);
		bresenhamLine(g,518, 303, 568, 303);
	
	//City
		//Building
			g.setColor(Color.BLACK);
			g.fillRect(290, 350, 110, 300); //B4
			g.setColor(myColor1);
			g.fillRect( 0,  420, 100, 200); //B1
			g.fillRect(110, 390,  85, 300); //B2
			g.fillRect(200, 470, 200, 200); //B3
			g.fillRect(380, 400,  95, 200); //B5
			g.fillRect(500, 430,  95, 200); //B6
		//Building Light
			g.setColor(myColor4);
			//B1
				g.fillRect( 0, 419, 4, 4);
				g.fillRect(40, 419, 4, 2);
				g.fillRect(64, 419, 4, 4);
				g.fillRect(96, 419, 4, 4);
			//B2
				g.fillRect(110, 389, 4, 4);
				g.fillRect(130, 389, 4, 2);
				g.fillRect(155, 389, 4, 4);
				g.fillRect(195, 389, 4, 4);
			//B3
				g.fillRect(200, 469, 4, 4);
				g.fillRect(355, 469, 4, 4);
				g.fillRect(400, 469, 4, 4);
			//B4
				g.fillRect(290, 349, 4, 4);
				g.fillRect(320, 349, 4, 2);
				g.fillRect(370, 349, 4, 4);
				g.fillRect(400, 349, 4, 4);
			//C
				g.setColor(m7);
				bresenhamLine(g, 310, 355, 332, 355);
				bresenhamLine(g, 307, 358, 335, 358);
				bresenhamLine(g, 304, 361, 337, 361);
				bresenhamLine(g, 304, 364, 319, 364);
				bresenhamLine(g, 304, 367, 318, 367);
				bresenhamLine(g, 304, 370, 318, 370);
				bresenhamLine(g, 304, 373, 319, 373);
				bresenhamLine(g, 304, 376, 337, 376);
				bresenhamLine(g, 307, 379, 335, 379);
				bresenhamLine(g, 310, 381, 332, 381);
			//S
				bresenhamLine(g, 358, 355, 383, 355);
				bresenhamLine(g, 355, 358, 385, 358);
				bresenhamLine(g, 355, 361, 363, 361);
				bresenhamLine(g, 355, 364, 363, 364);
				bresenhamLine(g, 355, 367, 383, 367); 
				bresenhamLine(g, 358, 370, 385, 370); 
				bresenhamLine(g, 377, 373, 385, 373); 
				bresenhamLine(g, 377, 376, 385, 376); 
				bresenhamLine(g, 355, 378, 385, 378); 
				bresenhamLine(g, 357, 381, 383, 381);
			//B5
				g.fillRect(380, 399, 4, 4);
				g.fillRect(442, 399, 4, 4);
				g.fillRect(475, 399, 4, 4);
			//B6
				g.fillRect(500, 429, 4, 4);
				g.fillRect(570, 429, 4, 4);
		//Windows
			//B1
				g.setColor(Color.YELLOW);
				int r = 0;
				for (int i = 10; i <= 60; i=i+15) {
					for (int j = 430; j <= 600; j = j+21) {
						r = rand.nextInt(5);
						if (r%5==1) g.setColor(myColor1);
						g.fillRect(i, j, 9, 15);
						g.setColor(Color.YELLOW);
					}
				}
			//B2
				g.setColor(Color.WHITE);
				for (int i = 115; i <= 145; i=i+15) {
					for (int j = 400; j <= 600; j = j+25) {
						r = rand.nextInt(7);
						if (r%7==1) g.setColor(myColor1);
						g.fillRect(i, j, 9, 15);
						g.setColor(Color.WHITE);
					}
				}
			//B3
				g.setColor(Color.WHITE);
				for (int i = 205; i <= 345; i=i+25) {
					for (int j = 485; j <= 600; j = j+28) {
						r = rand.nextInt(12);
						if (r%12==1) g.setColor(myColor1);
						g.fillRect(i, j, 20, 15);
						g.setColor(Color.WHITE);
					}
				}
			//B4
				g.setColor(m10);
				for (int i = 300; i <= 370; i=i+15) {
					for (int j = 395; j <= 450; j = j+25) {
						r = rand.nextInt(12);
						if (r%12==1) g.setColor(myColor1);
						g.fillRect(i, j, 9, 15);
						g.setColor(m10);
					}
				}
			//B5
				g.setColor(Color.CYAN);
				for (int i = 385; i <= 425; i=i+20) {
					for (int j = 410; j <= 450; j = j+27) {
						r = rand.nextInt(10);
						if (r%10==1) g.setColor(myColor1);
						g.fillRect(i, j, 15, 20);
						g.setColor(Color.CYAN);
					}
				}
				for (int i = 405; i <= 430; i=i+20) {
					for (int j = 464; j <= 600; j = j+27) {
						r = rand.nextInt(10);
						if (r%10==1) g.setColor(myColor1);
						g.fillRect(i, j, 15, 20);
						g.setColor(Color.CYAN);
					}
				}
				g.fillRect(385, 464, 15, 5);
			//B6
				g.setColor(Color.YELLOW);
				for (int i = 510; i <= 560; i=i+20) {
					for (int j = 440; j <= 600; j = j+18) {
						r = rand.nextInt(8);
						if (r%8==1) g.setColor(myColor1);
						g.fillRect(i, j, 15, 10);
						g.setColor(Color.YELLOW);
					}
				}
		//Buliding Line
			g.setColor(bg3);
			g.fillRect(80, 420, 5, 200); //B1
			g.fillRect(165, 390, 4, 200); //B2
			g.fillRect(180, 390, 3, 200); //B2
			g.fillRect(390,470,6,200); //B3
			g.fillRect(370,470,3,200); //B3
			g.fillRect(460,400,3,200); //B5
			g.setColor(Color.YELLOW);
			g.fillRect(575,450,3,200); //B6
			g.fillRect(585,445,2,200); //B6
		//misc
			g.setColor(Color.WHITE);
			g.fillRect(600, 0, 1200, 1200);
			g.fillRect(0, 600, 1200, 1200);
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
    private void plot (Graphics g, int x, int y) {
    	g.fillRect(x, y, 4, 4);
    }
}