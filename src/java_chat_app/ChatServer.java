package java_chat_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

	// Socket dedicato al server
	private ServerSocket ss;

	/**
	 * Stampa informazioni del ChatServer
	 */
	private void stampaInfo() {
		System.out.println("ChatServer: Server avviato e in ascolto per stabilire connessioni con client...");
		System.out.println(" ");
		System.out.println("Adesso avviare il ChatClient manualmente per farlo connettere al ChatServer.");
		System.out.println("(aprire una console e in bin dare: java -classpath '../' java_chat_app.ChatClient)");
		System.out.println(" ");
		
	}

	@Override
	public void run() {

		try {
			// ----------Create a server socket binded with the specified port
			ss = new ServerSocket(5000);

			stampaInfo();

			while (true) {
				// -----------accept socket connections from clients

				Socket clientsocket = ss.accept();
				System.out.println("ChatServer: connessione a un client stabilita");

				// -----------Print socket object obtained from client
				// connection
				System.out.println("ChatServer: " + clientsocket.toString());

				// -----------Senda a message to the client
				PrintWriter writer = new PrintWriter(clientsocket.getOutputStream());
				writer.println("Benvenuto client!");
				writer.flush();
			}
		}
		catch (IOException e) {

			System.out.println("ChatServer: errore di I/O");
			System.out.println();
			e.printStackTrace();
		}
	}
}
