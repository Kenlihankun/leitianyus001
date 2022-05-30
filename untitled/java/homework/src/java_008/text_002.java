package java_008;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class text_002 {
    public static void main(String[] args) {
        File file = new File("homework\\src\\java_008\\speech.txt");
        try (InputStream in = new FileInputStream(file);){
            byte[] buffer = new byte[1];
            int a;
            int count=0;
            System.out.print("文本内容：");
        while ((a = in.read(buffer))!=-1){
            count+=1;
            System.out.print(new String(buffer));
        }
            System.out.println();
            System.out.println("统计结果："+file.getName()+"文件中有"+count+"个字节");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
