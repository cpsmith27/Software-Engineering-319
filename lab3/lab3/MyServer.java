// GOALS
//
// 1. to show sample Server code
// Note that the server is running on LOCALHOST (which is THIS computer) and the 
// port number associated with this server program is 4444.
// The accept() method just WAITS until some client program tries to access this server
//
// 2. to show how a thread is created to handle client request
//
package lab3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		int clientNum = 0;
		MessageHandler mh = new MessageHandler();

		try {
			serverSocket = new ServerSocket(4444);
			System.out.println(serverSocket);
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}

		while (true) {
			Socket clientSocket = null;
			try {

				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				System.out.println("Waiting for client " + (clientNum + 1)
						+ " to connect!");
				clientSocket = serverSocket.accept();

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				System.out.println("Server got connected to a client"
						+ ++clientNum);
				
				ClientHandler client = new ClientHandler(clientSocket, clientNum, mh);
				mh.addSocket(clientSocket);
				Thread t = new Thread(client);
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		}
	}
}

class ClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT
	int num; // keeps track of its number just for identifying purposes
	MessageHandler mh;

	ClientHandler(Socket s, int n, MessageHandler messageHandler) {
		this.s = s;
		num = n;
		mh = messageHandler;
	}

	public void run() {
		Scanner in;
		
		try {
			// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING
			in = new Scanner(s.getInputStream());
			
			while(true) {
				// 2. PRINT WHAT THE CLIENT SENT
				if (in.hasNextLine()) {
					mh.send(in.nextLine());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MessageHandler {
	ArrayList<Socket> sockets;
	
	MessageHandler() {
		sockets = new ArrayList<Socket>();
	}
	
	void addSocket(Socket socket) {
		sockets.add(socket);
	}
	
	void send(String message) throws IOException {
		try {
			File file = new File("/Users/christophersmith/workspace/lab3/src/lab3/chat.txt");
			FileWriter fw = new FileWriter(file);
			fw.write(message);
			fw.flush();
			fw.close();
		} catch (Error e) {
			System.out.println(e.getMessage());
		}
		
		for (Socket socket : sockets) {
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			
			out.write(message);
			out.flush();
			out.close();
		}
	}
}


