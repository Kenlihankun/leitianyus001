package Day22;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ReciveSocketDemo1 {
//192.168.159.1
    public static void main(String[] args)  {
        try {
            System.out.println("===客户端上线===");
            Socket socket = new Socket("192.168.159.1",5858);
            new Thread(new MyReciveRunnerable(socket)).start();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String msg;
            while (true){
                System.out.println("请输入：");
                msg = scanner.nextLine();
                printWriter.println(msg);
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
