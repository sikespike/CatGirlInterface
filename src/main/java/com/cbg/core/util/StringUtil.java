package com.cbg.core.util;

import java.util.List;

public class StringUtil {
    public static String wrapString(String text, String token) {
        String result = token + text + token;

        return result;
    }

    public static String serializeList(List<?> list) {
        StringBuilder b = new StringBuilder();

        int size = list.size();
        int x = 0;
        for (Object o : list) {
            b.append(o.toString());

            if (x + 1 != size) {
                b.append(",");
            }
        }

        return b.toString();
    }
}
