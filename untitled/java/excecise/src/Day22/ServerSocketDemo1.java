package Day22;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketDemo1 {
    public static List<Socket> list = new ArrayList<Socket>();
    Socket socket;
    public static void main(String[] args) {
//192.168.159.1
        try {
            System.out.println("===服务端启动===");
            ServerSocket serverSocket = new ServerSocket(5858);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"上线了");
                list.add(socket);
                new Thread(new MyServerRunnable(socket)).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
