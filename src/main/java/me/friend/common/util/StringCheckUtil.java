package me.friend.common.util;

public class StringCheckUtil {

    private StringCheckUtil(){}

    public static boolean isNull(String value) {
        if (value == null) {
            return true;
        }

        return value.trim().length() == 0;
    }
}
