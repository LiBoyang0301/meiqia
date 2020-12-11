package org.lby.meiqia.meeting.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static  String toString(Date date){
        return  new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
