/**
 * Created by ASUS on 2017/01/18.
 */
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoServer {

    public static final int ECHO_PORT = 10007;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(ECHO_PORT);
            System.out.println("EchoServer started (port=" + serverSocket.getLocalPort() + ")");
            socket = serverSocket.accept();
            System.out.println("Connected" + socket.getRemoteSocketAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ( (line = in.readLine()) != null) {
                System.out.println("Receive: " + line);
                out.println(line);
                System.out.println("Send: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e){}
                }
            }
        }
