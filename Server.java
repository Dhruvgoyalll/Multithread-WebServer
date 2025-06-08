
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

class Server {

    public Consumer<Socket> getConsumer() {
        return (clinetSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clinetSocket.getOutputStream());
                toClient.println("Hello from server");
                toClient.flush();
                toClient.close();
                clinetSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            int port = 9876;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            serverSocket.setSoTimeout(100000);

            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + acceptedSocket.getInetAddress());
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
