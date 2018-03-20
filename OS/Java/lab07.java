class lab7 {
	public static void main(String[] args) {
		int i = Integer.parseInt(args[0]);

		MyData data1 = new MyData(i);
		Runnable runnerC = new Child(data1);
		Thread childThread = new Thread(runnerC);
		childThread.start();
		try {childThread.join();} catch (InterruptedException ie) { }
		System.out.println("Worker done");
		data1.fromParent();		
		System.out.println("Final Answer is : " + data1.getValue());
	}
}

class Child implements Runnable{
	MyData data1Ref;
	Child(MyData md) {data1Ref = md;}
	public void run(){
		data1Ref.fromChild();
	}	
}

class MyData{
	int value;
	MyData(int v) {value = v;}
	void fromParent() {value +=5;}
	void fromChild() {value *=2; }
	int getValue() {return value;}
}