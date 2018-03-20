class lab7_1 {
	public static void main(String[] args){
		int a[][] = {{5,6,7},{4,8,9}};
		int b[][] = {{6,4},{5,7},{1,1}};
		MyData matA = new MyData(a);
		MyData matB = new MyData(b);
		int matC_r = matA.data.length;
		int matC_c = matB.data[0].length; //Answer
		MyData matC = new MyData(matC_r,matC_c);
		//
		Runnable runnerC = new Child(matC_r , matC_c , matA , matB , matC);
		Thread childThread = new Thread(runnerC);
		childThread.start();
		try {childThread.join();} catch (InterruptedException ie) { }
		System.out.println("Worker done");

		matC.show();
		

	}

}    
class Child extends Thread{
	int row,col;
	MyData datA,datB,datC;
	Child(int processing_row, int processing_col, MyData a, MyData b, MyData c) {
		row = processing_row; 
		col = processing_col;
		datA = a; 
		datB = b; 
		datC = c;
	}
	public void run(){
		int sum = 0;

		for(int i=0; i< datA.data.length ; i++)
		{

			for(int j =0; j < datA.data.length ; j++)
			{

				for (int k = 0; k < datB.data.length; k++) 
				{

						datC.data[i][j] += datA.data[i][k] * datB.data[k][j];
				}
			}
		}
	}

}

class MyData{
	int[][] data;
	MyData(int r, int c) {data = new int[r][c];}
	MyData(int[][] a) {data = a;}
	void show() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}