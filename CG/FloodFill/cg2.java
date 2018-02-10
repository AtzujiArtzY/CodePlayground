import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

class cg2 extends JPanel {
    public BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
    public Graphics2D g3 = buffer.createGraphics();
	public static void main(String[] args) {
		cg2 m = new cg2();
        JFrame f =  new JFrame();   
        f.add(m);   
        f.setTitle("LowPoly"); 
        f.setSize(600,600);   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true);
	}
	public void paintComponent(Graphics g) {
	//Color
		Color myColor0 = new Color(  0, 255,  0);
		Color myColor2 = new Color( 42, 171, 168);
		Color myColor3 = new Color(123,  97, 232);
		Color myColor4 = new Color(242,   0, 100);
	//PolyTest
        //Poly
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        // g.setColor(Color.WHITE);
        // g.fillRect(0, 0, 600, 600);
        g.setColor(Color.RED);
        int xPoly[] = {150, 250, 325, 375, 400, 275, 100};
        int yPoly[] = {150, 100, 125, 225, 325, 375, 300};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g.drawPolygon(poly);
        buffer = floodFill(g,buffer, 200, 150, Color.BLACK, Color.GREEN);
        g.drawImage(buffer, 0, 0, null);
    }
    public BufferedImage floodFill (Graphics g,BufferedImage m,int x,int y, Color target_colour, Color replacement_colour) {
        Queue Q = new Queue();
        paint(g,x, y, replacement_colour);
        Q.Enqueue(x);
        Q.Enqueue(y);
        int current_x, current_y;
        while (!Q.isEmpty()) {
            current_x = Q.Dequeue();
            current_y = Q.Dequeue();
            System.out.println("Current RGB = "+getRGB(current_x-3,current_y));
            if (getRGB(current_x,(current_y-1)).equals(target_colour)) {
                paint(g,x, y-1, replacement_colour);
                Q.Enqueue(current_x);
                Q.Enqueue(current_y-1);
                System.out.println("Paint South");
            }
            if (getRGB(current_x,current_y+1).equals(target_colour)) {
                paint(g,x, y+1, replacement_colour);
                Q.Enqueue(current_x);
                Q.Enqueue(current_y+1);
                System.out.println("Paint North");
            }
            if (getRGB(current_x-1,current_y).equals(target_colour)) {
                paint(g,x-1, y, replacement_colour);
                Q.Enqueue(current_x-1);
                Q.Enqueue(current_y);
                System.out.println("Paint Left");
            }
            if (getRGB(current_x+1,current_y).equals(target_colour)) {
                paint(g,x+1, y, replacement_colour);
                Q.Enqueue(current_x+1);
                Q.Enqueue(current_y);
                System.out.println("Paint Right");
            }
        }
        System.out.println("-------------Done-------------");
        return buffer;
    }
    public Color getRGB(int x,int y) {
        Color mycolor = new Color(buffer.getRGB(x, y));
        int red = mycolor.getRed();
        int green = mycolor.getGreen();
        int blue = mycolor.getBlue();
        Color myRGB = new Color(red,green,blue);
        return myRGB;
    }
    public void paint (Graphics g,int x, int y, Color myColor) { 
        g.setColor(myColor);
        g.fillRect(x,y,2,2);
        System.out.println("Painted :"+" "+x+","+y+"||"+getRGB(x,y));
    }
}
class Queue{
    public Node first, last;
    public Queue(int data){
        first = new Node(data);
        last = first;
    }
    public Queue(){
        first = null;
        last = first;
    }
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void Enqueue(int d){
        if(this.isEmpty()) first = last = new Node(d);
        else{
            last.next = new Node(d);
            last = last.next;
        }
    }
    public int Dequeue(){
        int d = first.data;
        first = first.next;
        return d;
    }

}