package java_007;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class text_3 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(2014,"德国");
        map.put(2006,"意大利");
        map.put(2010,"西班牙");
        Iterator iterator = map.values().iterator();
        System.out.println("使用迭代器方式进行输出：");
        while (iterator.hasNext()){
            String s = (String) iterator.next();
            System.out.print(s+"\t");
        }
        System.out.println();
        System.out.println("使用EntrySet输出：");
        map.forEach((k,v) -> System.out.println(k+"-"+v));

    }
}
