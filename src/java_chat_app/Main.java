package java_chat_app;

public class Main {

	public static void main(String[] args) {

		Thread t1 = new Thread(new ChatServer());

		System.out.println("Main: Avvio del server...");
		t1.start();
	
	}

}
