package d2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class miaosha {
    public static void main(String[] args) throws ParseException {

        String jia = "2020年11月11日 0:03:47";
        String pi = "2020年11月11日 0:10:11";

        String startTime = "2020年11月11日 00:00:00";
        String endTime = "2020年11月11日 00:10:00";
        SimpleDateFormat sld = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date st = sld.parse(startTime);
        Date et = sld.parse(endTime);
        Date t1 = sld.parse(jia);

        Date d = new Date();
        System.out.println(t1);
    }


}
