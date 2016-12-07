package java_chat_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient implements Runnable {
	private Socket soc;
	private BufferedReader reader;
	private InputStreamReader istreamr;

	@Override
	public void run() {

		try {
			// -----------Create a socket connection with a server on the localhost at port 5000
			// Note: the server must be already running
			soc = new Socket("127.0.0.1", 5000);

			// -----------Create a socket reader
			istreamr = new InputStreamReader(this.soc.getInputStream());
			reader = new BufferedReader(istreamr);

			System.out.println("ChatClient: connessione col server stabilita.");

			// -----------Read message from server
			String msg = null;
			System.out.print("ChatClient: Messaggio dal server:  ");
			msg = reader.readLine();
			System.out.println(msg);

		}
		catch (

		IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new ChatClient());
		t.start();
	}
}