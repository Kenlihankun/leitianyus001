package heima_6;

import java.util.Scanner;

public class mark {
    public static void main(String[] args) {
        int[] score = new int[6];
        Scanner r = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            System.out.print("请输入分数：");
            score[i] = (int) r.nextInt();
        }

    }

    
}
