package java_008;

public class text_001 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Letter());
        thread.start();
    }

}

