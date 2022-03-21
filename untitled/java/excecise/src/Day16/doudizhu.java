package Day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class doudizhu {
    public static List<card> AllCard= new  ArrayList<>();
    static {
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♦","♣", "♥", "♠"};
        int mum = 1;
        for (String size : sizes) {
            for (String color : colors) {
                mum+=1;
                AllCard.add(new card(size,color,mum));
            }
        }
        card c1 = new card("小王","",53);
        card c2 = new card("大王","",54);
        Collections.addAll(AllCard,c1,c2);
        System.out.println(AllCard);

    }

    public static void main(String[] args) {

        Collections.shuffle(AllCard);
        System.out.println(AllCard);
        List<card> role1 = new ArrayList<>();
        List<card> role2 = new ArrayList<>();
        List<card> role3 = new ArrayList<>();
        for (int i = 0; i < AllCard.size()-3; i+=3) {
            role1.add(AllCard.get(i));
            role2.add(AllCard.get(i+1));
            role3.add(AllCard.get(i+2));
        }
        List<card> last = AllCard.subList(AllCard.size()-3,AllCard.size());
        xipai(role1);
        xipai(role2);
        xipai(role3);
        xipai(last);
        System.out.println(role1);
        System.out.println(role2);
        System.out.println(role3);
        System.out.println(last);
    }

    public static void xipai (List<card> arr){
        Collections.sort(arr, (card o1, card o2) -> o1.getMum() - o2.getMum() );
    }
}
