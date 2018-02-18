import java.util.*;
import java.io.*;
import java.lang.*;
class drawInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int count = 0;
		int x =0;
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"))) {
			while (x >= 0) {
				count++;
				System.out.println("-----------Circle---------------"+count+" ");
				System.out.print("X :");   x = sc.nextInt();
				System.out.print("  Y :"); int y = sc.nextInt();
				System.out.print("    R :");   int rad = sc.nextInt();
				System.out.println("---Color---");
				System.out.print("R:");   int r = sc.nextInt();
				System.out.print(" G:");  int g = sc.nextInt();
				System.out.print("  B:"); int b = sc.nextInt();
				System.out.println();
				//Write
				writer.write("\t\tdraw(g,"+x+","+y+","+rad+", "+r+","+g+","+b+");");
				writer.write(System.getProperty("line.separator"));
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}