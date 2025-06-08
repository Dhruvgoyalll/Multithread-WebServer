
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            int port = 9876;
            try {
                InetAddress address = InetAddress.getByName("localhost");

                Socket socket = new Socket(address, port);
                System.out.println("Connected to server on port " + port);
                PrintWriter toServer = new PrintWriter(socket.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                toServer.println("Hello from client");
                toServer.flush();
                System.out.println("Server says: " + fromServer.readLine());

                socket.close();
                toServer.close();
                fromServer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        for (int i = 0; i < 100; i++) {
            try {
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
