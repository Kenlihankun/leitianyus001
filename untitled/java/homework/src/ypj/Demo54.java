package ypj;

import java.nio.channels.ScatteringByteChannel;

public class Demo54 {
    public static void main(String[] args) {
        new cat("黑猫").CatchMouseByCat();//建立类并抓老鼠
        new cat("白猫").CatchMouseByCat();
        new cat("黄猫").CatchMouseByCat();

    }
}

class cat{//猫类
    String tYPE;

    public cat() {
    }

    public void CatchMouseByCat(){
        System.out.println(tYPE+"抓老鼠");
    }

    public cat(String tYPE) {
        this.tYPE = tYPE;
    }

    public String gettYPE() {
        return tYPE;
    }

    public void settYPE(String tYPE) {
        this.tYPE = tYPE;
    }
}
