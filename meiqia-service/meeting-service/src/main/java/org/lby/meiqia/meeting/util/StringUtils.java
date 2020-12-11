package org.lby.meiqia.meeting.util;

public final class StringUtils {
    public static boolean isEmpty(String str){
        return str==null||"".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
