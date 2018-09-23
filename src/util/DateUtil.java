package util;

import java.util.Date;

public class DateUtil {
    public static int getDayDiff(Date date1,Date date2){
        int diff = (int)((date1.getTime()-date2.getTime())/(1000*60*60*24));
        return diff;
    }
}
