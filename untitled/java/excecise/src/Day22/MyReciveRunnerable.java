package Day22;

import java.io.*;
import java.net.Socket;

public class MyReciveRunnerable implements Runnable {
    private Socket socket;
    public MyReciveRunnerable (Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg=buffer.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+":"+msg);
            }
        } catch (Exception e) {
            System.out.println("服务端踢走了你");
            e.printStackTrace();
        }

    }
}
