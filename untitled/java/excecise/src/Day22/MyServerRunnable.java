package Day22;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyServerRunnable implements Runnable{
    private Socket socket;

    public MyServerRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg=buffer.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+":"+msg);
                sendmsg(msg);
            }

        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
            ServerSocketDemo1.list.remove(socket);
            e.printStackTrace();
        }

    }

    private void sendmsg(String msg) {
        for (Socket socket1 : ServerSocketDemo1.list) {

                try {
                    PrintWriter printWriter = new PrintWriter(this.socket.getOutputStream());
                    printWriter.println(msg);
                    printWriter.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
    }
}
